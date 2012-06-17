/**
 * 
 */
package logic;

import java.util.ArrayList;
import java.util.List;

import model.Game;
import model.Session;
import ProductLine.FullGameException;
import ProductLine.GameAlreadyExistsException;
import ProductLine.GameType;
import ProductLine.PlayerType;
import ProductLine.Slot;

/**
 * @author Juan
 * 
 */
public class GamesController {

	public static GamesController controller;
	private List<Game> games;

	private GamesController() {
		games = new ArrayList<Game>();
	}

	public static GamesController getInstance() {
		if (controller == null) {
			controller = new GamesController();
		}

		return controller;
	}

	public void createGame(String gameName,String creator, GameType type)
			throws GameAlreadyExistsException {
		Game game = new Game(gameName,creator,type);
		if (games.contains(game))
			throw new GameAlreadyExistsException();
		games.add(game);
	}
	
	public Game joinGame(String game, String player) throws FullGameException {
		Game currentGame = searchGame(game);
		if(currentGame.addPlayer(player)){
			for(Slot slot : currentGame.getSlots()){
				if(!slot.getPlayer().equals(player) && slot.getType().equals(PlayerType.Human))
					UsersController.getInstance().searchSession(slot.getPlayer()).getCallback().userJoinGame(game,player);
			}
			return currentGame;
		}
		throw new FullGameException();
	}
	
	public void leaveGame(String game, String player) {
		Game currentGame = searchGame(game);
		currentGame.removePlayer(player);
		for(Slot slot : currentGame.getSlots()){
			if(slot.getType().equals(PlayerType.Human)){
				Session userSession = UsersController.getInstance().searchSession(slot.getPlayer());
				userSession.getCallback().userLeaveGame(game, player);
			}
		}
		
	}

	public List<ProductLine.Game> listGames(String user) {
		List<ProductLine.Game> list = new ArrayList<ProductLine.Game>();
		for (Game game : games) {
			for(Slot slot : game.getSlots()){
				if (slot.getPlayer().equalsIgnoreCase(user) || !game.isStarted()){
					list.add(game);
					break;
				}
			}
		}
		return list;
	}

	public void deleteGame(String game, String creator) {
		Game currentGame = searchGame(game);
		for (Slot slot : currentGame.getSlots())
			if (!slot.getPlayer().equalsIgnoreCase(creator) && slot.getType().equals(PlayerType.Human))
				UsersController.getInstance().searchSession(slot.getPlayer())
						.getCallback().kickedFromGame(game);
		games.remove(searchGame(game));
	}

	public void kickPlayer(String game, String player) {
	/*	Game currentGame = searchGame(game);
		currentGame.getPlayers().remove(player);
		UsersController.getInstance().searchSession(player).getCallback().kickedFromGame(game);*/
	}

	public Game searchGame(String game) {
		for (Game auxGame : games)
			if (auxGame.getName().equalsIgnoreCase(game))
				return auxGame;
		return null;
	}
}
