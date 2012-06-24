/**
 * 
 */
package logic;

import java.util.ArrayList;
import java.util.List;

import model.Game;
import model.Session;
import ProductLine.Filter;
import ProductLine.FullGameException;
import ProductLine.GameAlreadyExistsException;
import ProductLine.GameType;
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
	public Game joinGame(String game, String player) throws FullGameException {
		Game currentGame = searchGame(game);
		if (currentGame.addPlayer(player)) {
			for (Slot slot : currentGame.getSlots()) {
				if (!slot.getPlayer().equals(player)
						&& slot.getType().equals(SlotState.Human))
					UsersManager.getInstance().searchSession(slot.getPlayer())
							.getCallback().userJoinGame(game, player);
			}
			return currentGame;
		}
		throw new FullGameException();
	}

	/**
	 * Removes an user from a game
	 * 
	 * @param game
	 *            Game to leave
	 * @param player
	 *            Player who leaves the game
	 **/
	public void leaveGame(String game, String player) {
		Game currentGame = searchGame(game);
		currentGame.removePlayer(player);
		for (Slot slot : currentGame.getSlots()) {
			if (slot.getType().equals(SlotState.Human)) {
				Session userSession = UsersManager.getInstance().searchSession(
						slot.getPlayer());
				userSession.getCallback().userLeaveGame(game, player);
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
			} /*else if (gamesFilter.getGamesFilter().size() == 0
					&& gamesFilter.getPlayersFilter().size() > 0) {
				for (Players players : gamesFilter.getPlayersFilter()) {
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
			} */else {
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
				new Thread(){
					public void run(){
						UsersManager.getInstance().searchSession(slot.getPlayer())
						.getCallback().kickedFromGame(game);
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
	public void changeSlotState(String gameName, int slot, SlotState state) {
		final Game game = searchGame(gameName);
		Slot gameSlot = game.getSlot(slot);
		if (gameSlot.getType().equals(SlotState.Human)) {
			final String player = gameSlot.getPlayer();
			new Thread() {
				public void run() {
					UsersManager.getInstance().searchSession(player)
							.getCallback().kickedFromGame(game.getName());
				}
			}.start();
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
}
