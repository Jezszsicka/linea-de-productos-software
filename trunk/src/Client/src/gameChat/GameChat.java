package gameChat;

import model.Session;
import ProductLine.UserNotInGameException;

public class GameChat implements IGameChat {

	/**
	 * Sends a chat message to all the players in a game
	 * 
	 * @param game
	 *            Name of the game
	 * @param message
	 *            Message to send
	 **/
	@Override
	public void sendGameMessage(String game, String message) {
		Session session = Session.getInstance();
		String sender = session.getUser().getUsername();
		session.getProxy().sendGameMessage(game, sender, message);
	}

	/**
	 * Sends a chat private message to an user in a game
	 * 
	 * @param game
	 *            Name of the game
	 * @param destinatary
	 *            Recipient of the message
	 * @param message
	 *            Message to send
	 * @throws UserNotInGameException
	 * **/
	@Override
	public void sendGamePrivateMessage(String game, String destinatary,
			String message) throws UserNotInGameException {
		Session session = Session.getInstance();
		String sender = session.getUser().getUsername();
		session.getProxy().sendGamePrivateMessage(game, sender, destinatary,
				message);
	}

}
