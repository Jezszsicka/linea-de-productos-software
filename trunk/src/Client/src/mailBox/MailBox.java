package mailBox;

import model.Session;
import model.User;
import exceptions.WrongInputException;
import ProductLine.Message;
import ProductLine.MessageType;
import ProductLine.UserNotExistsException;

public class MailBox implements IMailBox {

	public MailBox() {

	}

	/**
	 * Sends a message to an user
	 * 
	 * @param to
	 *            Recipient of the message
	 * @param subject
	 *            Subject of the message
	 * @param content
	 *            Content of the message
	 * @throws WrongInputException
	 * @throws UserNotExistsException
	 **/
	@Override
	public void sendMessage(String to, String subject, String content,
			MessageType type) throws WrongInputException,
			UserNotExistsException {
		if (to.isEmpty()) {
			throw new WrongInputException("Empty receiver",
					"Please specify a receiver");
		}
		Session session = Session.getInstance();
		String from = session.getUser().getUsername();
		Message message = new model.Message(from, to, subject, content, type);
		session.getProxy().sendMessage(message);
	}

	@Override
	public void markMessageAsRead(Message message) {
		Session session = Session.getInstance();
		message.setSeen(true);
		session.getProxy().markMessageAsRead(session.getUser().getUsername(),
				message.getMessageID());
	}

	@Override
	public void deleteMessage(Message message) {
		Session session = Session.getInstance();
		User user = session.getUser();
		user.getMessages().remove(message);
		session.getProxy().deleteMessage(user.getUsername(),
				message.getMessageID());
	}

	@Override
	public void receiveMessage(Message msg) {
		User user = Session.getInstance().getUser();
		user.getMessages().add(msg);
	}

}
