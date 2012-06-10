package logic;

import java.util.Hashtable;

import ProductLine.GameAlreadyExistsException;
import ProductLine.GameType;
import ProductLine.UserNotLoggedException;
import model.Game;
import model.Session;



public class GamesManager {
	private Session session;
	private Hashtable<String,Game> games;
	
	public GamesManager(Session session){
		this.session = session;
		games = new Hashtable<String,Game>();
	}
	
	public void sendGeneralMessage(String message){
		session.getProxy().sendGeneralMessage(session.getUser().getUsername(), message);
	}

	public void sendPrivateMessage(String sender, String destinatary,
			String message) throws UserNotLoggedException {
		session.getProxy().sendPrivateMessage(sender, destinatary, message);	
	}

	public Game createGame(String gameName, GameType type) throws GameAlreadyExistsException {
		String username = session.getUser().getUsername();
		session.getProxy().createGame(gameName,username, type);
		Game game = new Game(gameName,username,type);
		games.put(username, game);	
		return game;
	}

	public Game searchGame(String game) {
		return games.get(game);
	}

	public void cancelGame(String gameName) {
		session.getProxy().deleteGame(gameName, session.getUser().getUsername());
		games.remove(gameName);
	}
}
