package mailBox;

import email.IEmail;
import model.Session;
import model.Sessions;
import model.User;
import persistence.UserDAO;
import ProductLine.Message;
import ProductLine.MessageType;
import ProductLine.UserNotExistsException;

public class MailBox implements IMailBox {
	
	private IEmail mail;

	public MailBox(){
		
	}
	
	public MailBox(IEmail mail){
		this.mail = mail;
	}

	@Override
	public void sendMessage(Message msg) throws UserNotExistsException {
		User user = null;
		Session userSession = Sessions.getInstance().getSession(
				msg.getReceiver());
		if (userSession == null) {

			user = UserDAO.getDAO().loadByID(msg.getReceiver());

			if (user == null) {
				throw new UserNotExistsException();
			} else {
				user.getMessages().add(msg);
				UserDAO.getDAO().update(user);
				mail.sendMessage(msg.getContent(),
						msg.getSubject(), user.getEmail());
			}

		} else {
			user = userSession.getUser();
			user.getMessages().add(msg);
			UserDAO.getDAO().update(user);
			userSession.getCallback().receiveMessage(msg);
		}

	}

	@Override
	public void deleteMessage(String username, int messageID) {
		User user = Sessions.getInstance().getSession(username).getUser();
		Message message = null;

		for (Message msg : user.getMessages()) {
			if (msg.getMessageID() == messageID) {
				message = msg;
				break;
			}
		}

		user.getMessages().remove(message);
		UserDAO.getDAO().update(user);

	}

	@Override
	public void friendRequestResponse(String friend, String username,
			boolean accepted) throws UserNotExistsException {
		User friendUser = null;
		String content;
		String subject;
		Sessions sessions = Sessions.getInstance();
		Session friendSession = sessions.getSession(friend);
		User user = sessions.getSession(username).getUser();

		// User not connected
		if (friendSession == null) {

			friendUser = UserDAO.getDAO().loadByID(friend);

			if (friendUser == null) {
				throw new UserNotExistsException();
			} else {
				if (accepted) {
					user.getFriends().add(friend);
					friendUser.getFriends().add(username);
					subject = "Petición de amistad aceptada";
					content = username + " y tu sois amigos";
				} else {
					subject = "Petición de amistad rechazada";
					content = username + " ha rechazado tu petición de amistad";
				}
				Message msg = new model.Message(username, friend, subject,
						content, MessageType.Normal);
				friendUser.getMessages().add(msg);
				UserDAO.getDAO().update(friendUser);
				UserDAO.getDAO().update(user);
				mail.sendMessage(content, subject,
						friendUser.getEmail());
			}

		} else {
			friendUser = friendSession.getUser();
			if (accepted) {
				user.getFriends().add(friend);
				friendUser.getFriends().add(username);
				subject = "Petición de amistad aceptada";
				content = username + " y tu sois amigos";
			} else {
				subject = "Petición de amistad rechazada";
				content = username + " ha rechazado tu petición de amistad";
			}
			Message msg = new model.Message(username, friend, subject, content,
					MessageType.Normal);
			friendUser.getMessages().add(msg);
			UserDAO.getDAO().update(friendUser);
			UserDAO.getDAO().update(user);
			friendSession.getCallback().receiveMessage(msg);
		}

	}

	@Override
	public void markMessageAsRead(String username, int messageID) {
		User user = Sessions.getInstance().getSession(username).getUser();
		Message message = null;

		for (Message msg : user.getMessages()) {
			if (msg.getMessageID() == messageID) {
				message = msg;
				break;
			}
		}

		message.setSeen(true);
		UserDAO.getDAO().update(user);

	}

}
