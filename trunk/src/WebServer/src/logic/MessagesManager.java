package logic;

import java.util.List;

import ProductLine.Message;
import ProductLine.SlotState;
import ProductLine.Slot;
import ProductLine.UserNotInGameException;
import ProductLine.UserNotLoggedException;

import model.Session;

public class MessagesManager {
	private static MessagesManager controller;

	private MessagesManager() {

	}

	public static MessagesManager getInstance() {
		if (controller == null) {
			controller = new MessagesManager();
		}
		return controller;
	}

	/**
	 * Sends a message to all the users
	 * 
	 * @param sender
	 *            User who send the message
	 * @param message
	 *            Message sent
	 * **/
	public void sendGeneralMessage(final String sender, final String message) {
		List<Session> sessions = UsersManager.getInstance().getSessions();
		for (final Session session : sessions) {
			if (!session.getUser().getUsername().equalsIgnoreCase(sender)) {
				new Thread() {
					public void run() {
						session.getCallback().receiveGeneralMessage(sender,
								message);
					}
				}.start();
				;
			}
		}

	}

	/**
	 * Sends a private message to a user
	 * 
	 * @param sender
	 *            User who send the message
	 * @param receiver
	 *            Receiver of the message
	 * @param message
	 *            Message sent
	 * **/
	public void sendPrivateMessage(final String sender, String receiver,
			final String message) throws UserNotLoggedException {
		final Session session = UsersManager.getInstance().searchSession(
				receiver);
		if (session != null) {
			new Thread() {
				public void run() {
					session.getCallback()
							.receivePrivateMessage(sender, message);
				}
			}.start();
		} else {
			throw new UserNotLoggedException();
		}

	}

	/**
	 * Sends a message to all the users in a game
	 * 
	 * @param game
	 *            Game to send the message
	 * @param sender
	 *            User who send the message
	 * @para message Message sent
	 **/
	public void sendGameMessage(String game, String sender, String message) {
		List<Slot> slots = GamesManager.getInstance().searchGame(game)
				.getSlots();
		for (Slot slot : slots)
			if (!slot.getPlayer().equalsIgnoreCase(sender)
					&& slot.getType().equals(SlotState.Human))
				UsersManager.getInstance().searchSession(slot.getPlayer())
						.getCallback()
						.receiveGameMessage(game, sender, message);

	}

	/**
	 * Sends a private message to a user in a game
	 * 
	 * @param game
	 *            Game to send the message
	 * @param sender
	 *            User who send the message
	 * @param receiver
	 *            Receiver of the message
	 * @param message
	 *            Message sent
	 **/
	public void sendGamePrivateMessage(String game, String sender,
			String receiver, String message) throws UserNotInGameException {
		String player = null;
		for (Slot slot : GamesManager.getInstance().searchGame(game).getSlots()) {
			if (slot.getPlayer().equalsIgnoreCase(receiver)) {
				player = slot.getPlayer();
				break;
			}

		}
		if (player != null)
			UsersManager.getInstance().searchSession(receiver).getCallback()
					.receiveGamePrivateMessage(game, sender, message);
		else
			throw new UserNotInGameException();
	}

	public void sendMessage(Message msg) {
		//TODO guardamos el mensaje en la base de datos
	}

}
