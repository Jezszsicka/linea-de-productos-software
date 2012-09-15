package mailBox;

import model.Session;
import model.Sessions;
import model.User;
import persistence.UserDAO;
import ProductLine.Message;
import ProductLine.UserNotExistsException;
import email.IEmail;

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