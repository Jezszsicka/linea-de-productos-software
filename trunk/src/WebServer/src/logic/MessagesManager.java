package logic;

import java.util.List;

import model.Session;
import model.User;
import persistence.UserDAO;
import ProductLine.Message;
import ProductLine.MessageType;
import ProductLine.Slot;
import ProductLine.SlotState;
import ProductLine.UserNotExistsException;
import ProductLine.UserNotInGameException;
import ProductLine.UserNotLoggedException;

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

	public void sendMessage(Message msg) throws UserNotExistsException {
		User user = null;
		Session userSession = UsersManager.getInstance().searchSession(
				msg.getReceiver());
		if (userSession == null) {

			user = UserDAO.getDAO().loadByID(msg.getReceiver());

			if (user == null) {
				throw new UserNotExistsException();
			} else {
				user.getMessages().add(msg);
				UserDAO.getDAO().update(user);
				MailSender.getMailSender().sendMessage(msg.getContent(), msg.getSubject(), user.getEmail());
			}

		} else {
			user = userSession.getUser();
			user.getMessages().add(msg);
			UserDAO.getDAO().update(user);
			userSession.getCallback().receiveMessage(msg);
		}

	}

	public void deleteMessage(String username, int messageID) {
		User user = UsersManager.getInstance().searchSession(username).getUser();
		Message message = null;
		
		for(Message msg : user.getMessages()){
			if(msg.getMessageID() == messageID){
				message = msg;
				break;
			}
		}
		
		user.getMessages().remove(message);
		UserDAO.getDAO().update(user);
	}

	
	public void friendRequestResponse(String friend, String username,
			boolean accepted) throws UserNotExistsException {
		User friendUser = null;
		String content;
		String subject;
		Session friendSession = UsersManager.getInstance().searchSession(
				friend);
		User user = UsersManager.getInstance().searchSession(username).getUser();
		
		//User not connected
		if (friendSession == null) {

			friendUser = UserDAO.getDAO().loadByID(friend);

			if (friendUser == null) {
				throw new UserNotExistsException();
			} else {
				if(accepted){
					user.getFriends().add(friend);
					friendUser.getFriends().add(username);
					subject = "Petición de amistad aceptada";
					content = username+" y tu sois amigos";
				}else{
					subject = "Petición de amistad rechazada";
					content = username+" ha rechazado tu petición de amistad";
				}
				Message msg = new model.Message(username,friend,subject,content,MessageType.Normal);
				friendUser.getMessages().add(msg);
				UserDAO.getDAO().update(friendUser);
				UserDAO.getDAO().update(user);
				MailSender.getMailSender().sendMessage(content, subject, friendUser.getEmail());
			}

		} else {
			friendUser = friendSession.getUser();
			if(accepted){
				user.getFriends().add(friend);
				friendUser.getFriends().add(username);
				subject = "Petición de amistad aceptada";
				content = username+" y tu sois amigos";
			}else{
				subject = "Petición de amistad rechazada";
				content = username+" ha rechazado tu petición de amistad";
			}
			Message msg = new model.Message(username,friend,subject,content,MessageType.Normal);
			friendUser.getMessages().add(msg);
			UserDAO.getDAO().update(friendUser);
			UserDAO.getDAO().update(user);
			friendSession.getCallback().receiveMessage(msg);
		}
		
	}
	
	public void markMessageAsRead(String username, int messageID) {
		User user = UsersManager.getInstance().searchSession(username).getUser();
		Message message = null;
		
		for(Message msg : user.getMessages()){
			if(msg.getMessageID() == messageID){
				message = msg;
				break;
			}
		}
		
		message.setSeen(true);
		UserDAO.getDAO().update(user);
		
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


}
