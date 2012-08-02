/**
 * 
 */
package logic;

import java.util.ArrayList;
import java.util.List;

import model.Game;
import model.Session;
import model.User;
import ProductLine.Filter;
import ProductLine.FullGameException;
import ProductLine.GameAlreadyExistsException;
import ProductLine.GameType;
import ProductLine.Ranking;
import ProductLine.Slot;
import ProductLine.SlotState;

/**
 * @author Juan Yáñez García-Catalán
 * 
 */
public class GamesManager {

	/** The only GamesController instance **/
	public static GamesManager controller;
	/** The list of created games **/
	private List<Game> games;

	/** Constructor for the GamesController **/
	private GamesManager() {
		games = new ArrayList<Game>();
	}

	/**
	 * Returns the GamesController instance
	 * 
	 * @return The only GamesController instance
	 **/
	public static GamesManager getInstance() {
		if (controller == null) {
			controller = new GamesManager();
		}

		return controller;
	}

	/**
	 * Creates a new game
	 * 
	 * @param gameName
	 *            Name for the game
	 * @param creator
	 *            User who create the game
	 * @param type
	 *            Type of the game
	 * **/
	public void createGame(String gameName, String creator, GameType type)
			throws GameAlreadyExistsException {
		Game game = new Game(gameName, creator, type);
		if (games.contains(game))
			throw new GameAlreadyExistsException();
		games.add(game);
	}

	/**
	 * Joins a user to a game
	 * 
	 * @param game
	 *            Game to join
	 * @param player
	 *            User that joins
	 * @throws FullGameException
	 *             Game is full
	 **/
	public Game joinGame(final String game, final String player)
			throws FullGameException {
		Game currentGame = searchGame(game);
		if (currentGame.addPlayer(player)) {
			for (final Slot slot : currentGame.getSlots()) {
				if (!slot.getPlayer().equals(player)
						&& slot.getType().equals(SlotState.Human)) {
					new Thread() {
						public void run() {
							UsersManager.getInstance()
									.searchSession(slot.getPlayer())
									.getCallback().userJoinGame(game, player);
						}
					}.start();
				}
			}
			return currentGame;
		}
		throw new FullGameException();
	}

	/**
	 * Removes an user from a game
	 * 
	 * @param gameName
	 *            Game to leave
	 * @param player
	 *            Player who leaves the game
	 **/
	public void leaveGame(String gameName, String player) {
		Game game = searchGame(gameName);
		game.removePlayer(player);
		for (Slot slot : game.getSlots()) {
			if (slot.getType().equals(SlotState.Human)) {
				Session userSession = UsersManager.getInstance().searchSession(
						slot.getPlayer());
				userSession.getCallback().userLeaveGame(gameName, player);
			}
		}

		// TODO Comportamiento según el juego
		if (game.isStarted()) {
			switch (game.getTypeGame()) {
			case Checkers:
			case Chess:
			case Connect4:
				games.remove(game);
				break;
			case Goose:
			case Ludo:
				// TODO avisar al resto de jugadores que alguien deja el juego y
				// si solo queda uno darlo como ganador y borrar el juego
				break;
			}

		}

	}

	/**
	 * Returns the list the games for an user to join
	 * 
	 * @param user
	 *            User that wants to list the games
	 * @param gamesFilter
	 * @param gameName
	 * @return A list of games to join
	 **/
	public List<ProductLine.Game> listGames(String user, String gameName,
			Filter gamesFilter) {

		List<ProductLine.Game> list = new ArrayList<ProductLine.Game>();
		for (Game game : games) {
			boolean toList = true;
			// Only game filters
			if (gamesFilter.getGamesFilter().size() > 0
					&& gamesFilter.getPlayersFilter().size() == 0) {
				for (GameType gameType : gamesFilter.getGamesFilter()) {
					if (!game.isStarted() && game.getName().contains(gameName)
							&& game.getTypeGame().equals(gameType)) {
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
				// TODO
			} /*
			 * else if (gamesFilter.getGamesFilter().size() == 0 &&
			 * gamesFilter.getPlayersFilter().size() > 0) { for (Players players
			 * : gamesFilter.getPlayersFilter()) { if (!game.isStarted() &&
			 * game.getName().contains(gameName)) { for (Slot slot :
			 * game.getSlots()) { if (slot.getPlayer().equalsIgnoreCase(user)) {
			 * toList = false; break; } } } else toList = false;
			 * 
			 * if (toList) list.add(game); } }
			 */else {
				// No filter
				if (gamesFilter.getGamesFilter().size() == 0
						&& gamesFilter.getPlayersFilter().size() == 0) {
					if (!game.isStarted() && game.getName().contains(gameName)) {
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
			}

		}
		return list;
	}

	/**
	 * Deletes a game
	 * 
	 * @param game
	 *            Game to delete
	 * @param creator
	 *            Creator user of the game
	 * **/
	public void deleteGame(final String game, String creator) {
		Game currentGame = searchGame(game);
		for (final Slot slot : currentGame.getSlots())
			if (!slot.getPlayer().equalsIgnoreCase(creator)
					&& slot.getType().equals(SlotState.Human))
				new Thread() {
					public void run() {
						UsersManager.getInstance()
								.searchSession(slot.getPlayer()).getCallback()
								.kickedFromGame(game);
					}
				}.start();

		games.remove(searchGame(game));
	}

	public void kickPlayer(String game, String player) {
		/*
		 * Game currentGame = searchGame(game);
		 * currentGame.getPlayers().remove(player);
		 * UsersController.getInstance()
		 * .searchSession(player).getCallback().kickedFromGame(game);
		 */
	}

	/**
	 * Changes the state of a game slot
	 * 
	 * @param gameName
	 *            Game to change
	 * @param slot
	 *            Index of the slot to change
	 * @param state
	 *            new State for the slot
	 **/
	public void changeSlotState(String gameName, final int slot,
			final SlotState state) {
		final Game game = searchGame(gameName);
		Slot changedSlot = game.getSlot(slot);
		final String changedSlotPlayer = changedSlot.getPlayer();

		if (changedSlot.getType() == SlotState.Human) {
			for (Slot gameSlot : game.getSlots()) {
				final String slotPlayer = gameSlot.getPlayer();
				// Kick the player from game
				if (slotPlayer.equalsIgnoreCase(changedSlotPlayer)) {
					new Thread() {
						public void run() {
							Session userSession = UsersManager.getInstance()
									.searchSession(changedSlotPlayer);
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
								Session userSession = UsersManager
										.getInstance()
										.searchSession(slotPlayer);
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
							Session userSession = UsersManager.getInstance()
									.searchSession(slotPlayer);
							userSession.getCallback().slotStateChanged(
									game.getName(), slot, state);
						}
					}.start();
				}
			}
		}
		game.setSlot(slot, new Slot("", state));
	}

	/**
	 * Returns the game identified by its name
	 * 
	 * @param game
	 *            Game to search
	 * @return The searched game or null if nothing is found
	 * @see Game
	 **/
	public Game searchGame(String game) {
		for (Game auxGame : games)
			if (auxGame.getName().equalsIgnoreCase(game))
				return auxGame;
		return null;
	}

	public void startGame(String gameName) {
		Game game = searchGame(gameName);
		game.setStarted(true);
		List<Slot> slots = game.getSlots();
		for (int i = 1; i < slots.size(); i++) {
			Slot slot = slots.get(i);
			if (slot.getType() == SlotState.Human) {
				Session playerSession = UsersManager.getInstance()
						.searchSession(slot.getPlayer());
				playerSession.getCallback().gameStarted(gameName);
			}
		}

	}

	public void updateGame(String gameName, String player, int nextTurn,
			int[][] board) {
		// TODO Auto-generated method stub
		Game game = searchGame(gameName);
		switch (game.getTypeGame()) {
		case Checkers:
			game.setBoard(board);
			game.changeTurn();
			String checkersTurn = game.getSlot(nextTurn).getPlayer();
			Session session = UsersManager.getInstance().searchSession(
					checkersTurn);
			
			if (player.equalsIgnoreCase(session.getUser().getName())) {
				
				int updateUser = game.getTurn();
				checkersTurn = game.getSlot(updateUser).getPlayer();
				session = UsersManager.getInstance()
						.searchSession(checkersTurn);
				game.changeTurn();
			}

			session.getCallback().gameUpdated(gameName, nextTurn, board);
			break;
		case Chess:
		case Connect4:
		case Goose:
		case Ludo:
			game.setBoard(board);
			String turn = game.getSlot(nextTurn).getPlayer();
			Session turnSession = UsersManager.getInstance()
					.searchSession(turn);
			turnSession.getCallback().gameUpdated(gameName, nextTurn, board);
			break;
		}

	}

	public void updateDiceGame(String gameName, String player, int nextTurn,
			int[][] board, int fromSquare,int dice, int movedPiece) {
		
		Game game = searchGame(gameName);
		game.setBoard(board);
		for(Slot slot : game.getSlots()){
			if(!slot.getPlayer().equalsIgnoreCase(player) && slot.getType()== SlotState.Human){
				Session slotSession = UsersManager.getInstance().searchSession(slot.getPlayer());
				slotSession.getCallback().diceGameUpdated(gameName,nextTurn,board,fromSquare,dice,movedPiece);
			}
		}
	}
	
	public void finishGame(String gameName, String winnerPlayer) {
		Game game = searchGame(gameName);
		switch(game.getTypeGame()){
		case Checkers:
		case Chess:
		case Connect4:
		String looserPlayer;
			
		if(game.getSlot(0).getPlayer().equalsIgnoreCase(winnerPlayer)){
			looserPlayer = game.getSlot(1).getPlayer();
		}else{
			looserPlayer = game.getSlot(0).getPlayer();
		}
		
		Session looserSession = UsersManager.getInstance().searchSession(looserPlayer);
		looserSession.getCallback().gameFinished(gameName);
		
		User winnerUser = UsersManager.getInstance().searchSession(winnerPlayer).getUser();
		User looserUser = looserSession.getUser();
		
		for(Ranking ranking : winnerUser.getRankings()){
			if(ranking.getGame() == game.getTypeGame()){
				int wonGames = ranking.getWonGames(); 
				ranking.setWonGames(++wonGames);
				break;
			}
		}
		
		for(Ranking ranking : looserUser.getRankings()){
			if(ranking.getGame() == game.getTypeGame()){
				int lostGames = ranking.getLostGames(); 
				ranking.setLostGames(++lostGames);
				break;
			}
		}
		
		UsersManager.getInstance().saveUser(winnerUser);
		UsersManager.getInstance().saveUser(looserUser);
		
			break;
		case Goose:
		case Ludo:
			
			//TODO ganador en juego de mas de 2 jugadores
			break;
		}
		
		games.remove(game);
	}

}
