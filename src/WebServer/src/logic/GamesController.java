/**
 * 
 */
package logic;

import java.util.ArrayList;
import java.util.List;

import model.Game;
import ProductLine.GameAlreadyExistsException;
import ProductLine.GameType;

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

	public Game joinGame(String game, String player) {
		Game currentGame = searchGame(game);
		if (currentGame.getPlayers().size() < currentGame.getMaxPlayers()){
			for(String auxPlayer : currentGame.getPlayers())
				UsersController.getInstance().searchSession(auxPlayer).getCallback().userJoinGame(game,player);
			currentGame.addPlayer(player);
		}
		return currentGame;
		// TODO throw new FullGameException
	}

	public void createGame(String gameName,String creator, GameType type)
			throws GameAlreadyExistsException {
		Game game = new Game(gameName,creator,type);
		if (games.contains(game))
			throw new GameAlreadyExistsException();
		games.add(game);
	}

	public List<ProductLine.Game> listGames(String user) {
		List<ProductLine.Game> list = new ArrayList<ProductLine.Game>();
		for (Game game : games) {
			if (game.getPlayers().contains(user) || !game.isStarted())
				list.add(game);
		}
		return list;
	}

	public Game searchGame(String game) {
		for (Game auxGame : games)
			if (auxGame.getName().equalsIgnoreCase(game))
				return auxGame;
		return null;
	}

	public void deleteGame(String game, String creator) {
		Game currentGame = searchGame(game);
		for (String player : currentGame.getPlayers())
			if (!player.equalsIgnoreCase(creator))
				UsersController.getInstance().searchSession(player)
						.getCallback().kickedFromGame(game);
		games.remove(searchGame(game));
	}

	public void kickPlayer(String game, String player) {
		Game currentGame = searchGame(game);
		currentGame.getPlayers().remove(player);
		UsersController.getInstance().searchSession(player).getCallback().kickedFromGame(game);
	}

}
