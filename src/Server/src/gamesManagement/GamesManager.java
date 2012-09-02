package gamesManagement;

import java.util.ArrayList;
import java.util.List;

import persistence.UserDAO;

import model.Game;
import model.Session;
import model.Sessions;
import model.User;
import ProductLine.FullGameException;
import ProductLine.GameAlreadyExistsException;
import ProductLine.GameType;
import ProductLine.Ranking;
import ProductLine.Slot;
import ProductLine.SlotState;

public class GamesManager implements IGames {
	private List<Game> games;

	public GamesManager() {
		games = new ArrayList<Game>();
	}

	@Override
	public void createGame(String gameName, String creator, GameType type)
			throws GameAlreadyExistsException {
		Game game = new Game(gameName, creator, type);
		if (games.contains(game))
			throw new GameAlreadyExistsException();
		games.add(game);

	}

	@Override
	public Game joinGame(final String game, final String player)
			throws FullGameException {
		Game currentGame = searchGame(game);
		if (currentGame.addPlayer(player)) {
			for (final Slot slot : currentGame.getSlots()) {
				if (!slot.getPlayer().equals(player)
						&& slot.getType().equals(SlotState.Human)) {
					new Thread() {
						public void run() {
							Sessions.getInstance().getSession(slot.getPlayer())
									.getCallback().userJoinGame(game, player);
						}
					}.start();
				}
			}
			return currentGame;
		}

		throw new FullGameException();
	}

	@Override
	public void leaveGame(final String gameName, final String player) {
		final Game game = searchGame(gameName);
		game.removePlayer(player);
		new Thread() {
			public void run() {

				for (Slot slot : game.getSlots()) {
					if (slot.getType().equals(SlotState.Human)) {
						Session userSession = Sessions.getInstance()
								.getSession(slot.getPlayer());
						userSession.getCallback().userLeaveGame(gameName,
								player);
						if (game.players() <= 1) {
							for (Ranking ranking : userSession.getUser()
									.getRankings()) {
								if (ranking.getGame() == game.getTypeGame()) {
									int wonGames = ranking.getWonGames();
									ranking.setWonGames(++wonGames);
									break;
								}
							}

							UserDAO userDAO = UserDAO.getDAO();
							userDAO.update(userSession.getUser());
						}

					}
				}

				if (game.isStarted()) {

					User leaveUser = Sessions.getInstance().getSession(player)
							.getUser();
					for (Ranking ranking : leaveUser.getRankings()) {
						if (ranking.getGame() == game.getTypeGame()) {
							int lostGames = ranking.getLostGames();
							ranking.setLostGames(++lostGames);
							break;
						}
					}

					UserDAO userDAO = UserDAO.getDAO();
					userDAO.update(leaveUser);

					if (game.players() <= 1) {
						games.remove(game);
					}

				}

			}
		}.start();

	}

	public Game searchGame(String game) {
		for (Game auxGame : games)
			if (auxGame.getName().equalsIgnoreCase(game))
				return auxGame;
		return null;
	}

	@Override
	public List<ProductLine.Game> listGames(String user) {
		List<ProductLine.Game> list = new ArrayList<ProductLine.Game>();
		for (Game game : games) {
			boolean toList = true;
			if (!game.isStarted()) {
				for (Slot slot : game.getSlots()) {
					if (slot.getPlayer().equalsIgnoreCase(user)) {
						toList = false;
						break;
					}
				}
			} else
				toList = false;

			if (toList)
				list.add(game);
		}
		return list;
	}

	@Override
	public void deleteGame(final String game, String creator) {
		Game currentGame = searchGame(game);
		for (final Slot slot : currentGame.getSlots())
			if (!slot.getPlayer().equalsIgnoreCase(creator)
					&& slot.getType().equals(SlotState.Human))
				new Thread() {
					public void run() {
						Sessions.getInstance().getSession(slot.getPlayer())
								.getCallback().kickedFromGame(game);
					}
				}.start();

		games.remove(searchGame(game));

	}

	@Override
	public void changeSlotState(String gameName, final int slot,
			final SlotState state) {
		final Game game = searchGame(gameName);
		Slot changedSlot = game.getSlot(slot);
		final String changedSlotPlayer = changedSlot.getPlayer();
		final Sessions sessions = Sessions.getInstance();

		if (changedSlot.getType() == SlotState.Human) {
			for (Slot gameSlot : game.getSlots()) {
				final String slotPlayer = gameSlot.getPlayer();
				// Kick the player from game
				if (slotPlayer.equalsIgnoreCase(changedSlotPlayer)) {
					new Thread() {
						public void run() {
							Session userSession = sessions
									.getSession(changedSlotPlayer);
							userSession.getCallback().kickedFromGame(
									game.getName());
						}
					}.start();
				} else {
					//
					if (gameSlot.getType() == SlotState.Human
							&& !slotPlayer.equalsIgnoreCase(changedSlotPlayer)
							&& !slotPlayer.equalsIgnoreCase(game.getSlot(0)
									.getPlayer())) {
						new Thread() {
							public void run() {
								Session userSession = sessions
										.getSession(slotPlayer);
								userSession.getCallback().userLeaveGame(
										game.getName(), changedSlotPlayer);
							}
						}.start();
					}
				}
			}

		} else {

			for (Slot gameSlot : game.getSlots()) {
				final String slotPlayer = gameSlot.getPlayer();
				if (gameSlot.getType() == SlotState.Human
						&& !slotPlayer.equalsIgnoreCase(game.getSlot(0)
								.getPlayer())) {
					new Thread() {
						public void run() {
							Session userSession = sessions
									.getSession(slotPlayer);
							userSession.getCallback().slotStateChanged(
									game.getName(), slot, state);
						}
					}.start();
				}
			}
		}
		game.setSlot(slot, new Slot(new String(), state));

	}

	@Override
	public void startGame(final String gameName) {
		final Game game = searchGame(gameName);
		game.setStarted(true);
		new Thread() {
			public void run() {
				List<Slot> slots = game.getSlots();
				for (int i = 1; i < slots.size(); i++) {
					Slot slot = slots.get(i);
					if (slot.getType() == SlotState.Human) {
						Session playerSession = Sessions.getInstance()
								.getSession(slot.getPlayer());
						playerSession.getCallback().gameStarted(gameName);
					}
				}
			}
		}.start();

	}

	@Override
	public void updateGame(String gameName, String player, int nextTurn,
			int[][] board) {
		Game game = searchGame(gameName);
		Sessions sessions = Sessions.getInstance();
		switch (game.getTypeGame()) {
		case Checkers:
			game.setBoard(board);
			game.changeTurn();
			String checkersTurn = game.getSlot(nextTurn).getPlayer();
			Session session = sessions.getSession(checkersTurn);

			if (player.equalsIgnoreCase(session.getUser().getName())) {

				int updateUser = game.getTurn();
				checkersTurn = game.getSlot(updateUser).getPlayer();
				session = sessions.getSession(checkersTurn);
				game.changeTurn();
			}

			session.getCallback().gameUpdated(gameName, nextTurn, board);
			break;
		case Chess:
		case Connect4:
			game.setBoard(board);
			String turn = game.getSlot(nextTurn).getPlayer();
			Session turnSession = sessions.getSession(turn);
			turnSession.getCallback().gameUpdated(gameName, nextTurn, board);
			break;
		default:
			System.out.println("Llamada erronea");
			break;
		}

	}

	@Override
	public void updateDiceGame(String gameName, String player, int nextTurn,
			int[][] board, int fromSquare, int dice, int movedPiece) {
		Game game = searchGame(gameName);
		game.setBoard(board);
		for (Slot slot : game.getSlots()) {
			if (!slot.getPlayer().equalsIgnoreCase(player)
					&& slot.getType() == SlotState.Human) {
				Session slotSession = Sessions.getInstance().getSession(
						slot.getPlayer());
				slotSession.getCallback().diceGameUpdated(gameName, nextTurn,
						board, fromSquare, dice, movedPiece);
			}
		}

	}

	@Override
	public void finishGame(String gameName, String winnerPlayer) {
		Game game = searchGame(gameName);
		Sessions sessions = Sessions.getInstance();
		switch (game.getTypeGame()) {
		case Checkers:
		case Chess:
		case Connect4:
			String looserPlayer;

			if (game.getSlot(0).getPlayer().equalsIgnoreCase(winnerPlayer)) {
				looserPlayer = game.getSlot(1).getPlayer();
			} else {
				looserPlayer = game.getSlot(0).getPlayer();
			}

			Session looserSession = sessions.getSession(looserPlayer);
			looserSession.getCallback().gameFinished(gameName);

			User winnerUser = sessions.getSession(winnerPlayer).getUser();
			User looserUser = looserSession.getUser();

			for (Ranking ranking : winnerUser.getRankings()) {
				if (ranking.getGame() == game.getTypeGame()) {
					int wonGames = ranking.getWonGames();
					ranking.setWonGames(++wonGames);
					break;
				}
			}

			for (Ranking ranking : looserUser.getRankings()) {
				if (ranking.getGame() == game.getTypeGame()) {
					int lostGames = ranking.getLostGames();
					ranking.setLostGames(++lostGames);
					break;
				}
			}

			UserDAO userDAO = UserDAO.getDAO();
			userDAO.update(winnerUser);
			userDAO.update(looserUser);

			break;
		case Goose:
		case Ludo:

			// TODO ganador en juego de mas de 2 jugadores
			break;
		}

		games.remove(game);

	}

	@Override
	public Game getGame(String gameName) {
		for (Game game : games)
			if (game.getName().equalsIgnoreCase(gameName))
				return game;
		return null;
	}
}
