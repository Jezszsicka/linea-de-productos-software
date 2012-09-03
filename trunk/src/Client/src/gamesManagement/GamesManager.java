package gamesManagement;

import java.util.Hashtable;
import java.util.List;

import model.Filter;
import model.Game;
import model.Session;
import rankings.IRankings;
import ProductLine.FullGameException;
import ProductLine.GameAlreadyExistsException;
import ProductLine.GameType;
import ProductLine.NotEnoughPlayersException;
import ProductLine.Slot;
import ProductLine.SlotState;
import checkers.Checkers;
import chess.Chess;
import connect4.Connect4;
import exceptions.WrongInputException;

public class GamesManager implements IGames {
	private IRankings rankings;
	private Hashtable<String, Game> games;

	public GamesManager(IRankings rankings) {
		this.rankings = rankings;
		games = new Hashtable<String, Game>();
	}

	/** Lists the games to join **/
	@Override
	public List<ProductLine.Game> listGames(String game, Filter filter) {
		Session session = Session.getInstance();
		return session.getProxy().listGames(session.getUser().getUsername(),
				game, filter);
	}

	/**
	 * Creates a new game
	 * 
	 * @param gameName
	 *            Name for the game
	 * @param type
	 *            Type of the game
	 * @throws GameAlreadyExistsException
	 * @throws WrongInputException
	 **/
	@Override
	public Game createGame(String gameName, GameType type)
			throws GameAlreadyExistsException, WrongInputException {
		Session session = Session.getInstance();

		if (gameName.isEmpty())
			throw new WrongInputException("Name is empty",
					"Please, introduce a name for the game");
		String username = session.getUser().getUsername();
		Session.getInstance().getProxy().createGame(gameName, username, type);
		Game game = new Game(gameName, username, type);
		switch (type) {
		case Checkers:
			Checkers.initBoard(game.getBoard());
			break;
		case Chess:
			Chess.initBoard(game.getBoard());
			break;
		case Connect4:
			Connect4.initBoard(game.getBoard());
			break;
		case Goose:
			break;
		case Ludo:
			break;
		}
		games.put(gameName, game);
		return game;
	}

	/**
	 * Joins to a game
	 * 
	 * @param gameName
	 *            Name of the game to join
	 * @throws FullGameException
	 *             The game is full
	 **/
	@Override
	public Game joinGame(String gameName) throws FullGameException {
		Session session = Session.getInstance();

		Game game = (Game) session.getProxy().joinGame(gameName,
				session.getUser().getUsername());
		switch (game.getTypeGame()) {
		case Checkers:
			Checkers.initBoard(game.getBoard());
			break;
		case Chess:
			Chess.initBoard(game.getBoard());
			break;
		case Connect4:
			Connect4.initBoard(game.getBoard());
		case Goose:
			break;
		case Ludo:
			break;
		}

		games.put(gameName, game);
		return game;

	}

	/**
	 * Deletes a created game by the user
	 * 
	 * @param gameName
	 *            Name of the game to be deleted
	 * **/
	@Override
	public void deleteGame(String gameName) {
		Session session = Session.getInstance();
		session.getProxy()
				.deleteGame(gameName, session.getUser().getUsername());
		games.remove(gameName);
	}

	/**
	 * Leaves a game
	 * 
	 * @param game
	 *            Name of the game to leave
	 **/
	@Override
	public void leaveGame(String gameName) {
		Session session = Session.getInstance();

		session.getProxy().leaveGame(gameName, session.getUser().getUsername());
		Game game = searchGame(gameName);

		if (game.isStarted()) {
			rankings.addLostGame(session.getUser().getUsername(),game.getTypeGame());
		}

	}

	/**
	 * An user joins a game that you're playing
	 * 
	 * @param game
	 *            Name of the game
	 * @param Player
	 *            that joins the game
	 **/
	@Override
	public void userJoinGame(String game, String player) {
		searchGame(game).addPlayer(player);
	}

	/**
	 * An user leaves a game that you're playing
	 * 
	 * @param gameName
	 *            Name of the game
	 * @param player
	 *            Player that leaves the game
	 **/
	@Override
	public void userLeaveGame(String gameName, String player) {
		Game game = searchGame(gameName);
		if (game.isStarted()) {
			if (game.players() <= 1) {
				games.remove(gameName);
			} else {
				game.removePlayer(player);
			}
		} else {
			game.removePlayer(player);
		}
	}

	/**
	 * Changes a slot state of a game
	 * 
	 * @param gameName
	 *            Name of the game
	 * @param slot
	 *            Number of the slot to be changed
	 * @param slotState
	 *            New state for the slot
	 **/
	@Override
	public void changeSlotState(String gameName, int slot, SlotState slotState) {
		Session session = Session.getInstance();
		session.getProxy().changeSlotState(gameName, slot, slotState);
		Game game = searchGame(gameName);
		game.setSlot(slot, new Slot("", slotState));
	}

	/**
	 * Notification: An slot state has been changed by the owner of the game
	 * 
	 * @param gameName
	 *            Name of the game
	 * @param slot
	 *            Number of the slot that has been changed
	 * @param New
	 *            state for the slot
	 **/
	@Override
	public void slotStateChanged(String gameName, int slot, SlotState state) {
		Game game = searchGame(gameName);
		game.setSlot(slot, new Slot("", state));
	}

	/**
	 * Start a game that you have created
	 * 
	 * @param gameName
	 *            Name of the game
	 * @throws NotEnoughPlayersException
	 **/
	@Override
	public void startGame(String gameName) throws NotEnoughPlayersException {
		Session session = Session.getInstance();

		Game game = searchGame(gameName);
		if (game.players() > 1) {
			session.getProxy().startGame(gameName);
		} else {
			throw new NotEnoughPlayersException();
		}
	}

	/*
	 * public void gameStarted(String gameName) { Game game =
	 * searchGame(gameName); game.setStarted(true); }
	 */

	/**
	 * Update the board of a game
	 * 
	 * @param gameName
	 *            Name of the game
	 **/
	@Override
	public void updateGame(String gameName) {
		Session session = Session.getInstance();
		Game game = searchGame(gameName);
		int nextTurn = game.getTurn();
		String player = session.getUser().getUsername();
		session.getProxy().updateGame(gameName, player, nextTurn,
				game.getBoard());
	}

	@Override
	public void updateDiceGame(String gameName, int fromSquare, int dice,
			int piece) {
		Session session = Session.getInstance();
		Game game = searchGame(gameName);
		int nextTurn = game.getTurn();
		String player = session.getUser().getUsername();
		session.getProxy().updateDiceGame(gameName, player, nextTurn,
				game.getBoard(), fromSquare, dice, piece);
	}

	/**
	 * Notification: The board of a game has been updated
	 * 
	 * @param gameName
	 *            Name of the game
	 * @param board
	 *            The updated board of the game
	 **/
	@Override
	public void gameUpdated(String gameName, int[][] board) {
		Game game = searchGame(gameName);
		game.setBoard(board);
	}

	@Override
	public void gameUpdated(String gameName, int turn, int[][] board) {
		Game game = searchGame(gameName);
		game.setBoard(board);
		game.setTurn(turn);
	}

	/**
	 * A game has finished
	 * 
	 * @param gameName
	 *            Name of the game
	 * @param winnerPlayer
	 *            Name of the winner player
	 * **/
	@Override
	public void finishGame(String gameName, String winnerPlayer) {
		Session session = Session.getInstance();
		Game game = searchGame(gameName);

		for (Slot slot : game.getSlots()) {
			if (slot.getType() == SlotState.Human) {
				if (!slot.getPlayer().equalsIgnoreCase(winnerPlayer)) {
					rankings.addLostGame(slot.getPlayer(), game.getTypeGame());
				} else {
					rankings.addWonGame(slot.getPlayer(), game.getTypeGame());
				}
			}
		}

		games.remove(gameName);
		session.getProxy().finishGame(gameName, winnerPlayer);
	}

	/**
	 * Notification: A game has finished
	 * 
	 * @game Name of the game
	 **/
	@Override
	public void finishGame(String gameName) {
		Session session = Session.getInstance();
		Game game = searchGame(gameName);

		rankings.addLostGame(session.getUser().getUsername(), game.getTypeGame());

		games.remove(game);
	}

	/**
	 * Search a game by its name
	 * 
	 * @param game
	 *            Name of the game to search
	 * @return The found game
	 **/
	@Override
	public Game searchGame(String game) {
		return games.get(game);
	}

}
