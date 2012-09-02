package friends;

import email.IEmail;
import model.Session;
import model.Sessions;
import model.User;
import persistence.UserDAO;
import ProductLine.Message;
import ProductLine.MessageType;
import ProductLine.UserNotExistsException;

public class Friends implements IFriends {
	private IEmail mail;
	
	public Friends(){
		
	}
	
	public Friends(IEmail mail){
		this.mail = mail;
	}

	@Override
	public void friendRequestResponse(String friend, String username,
			boolean accepted) throws UserNotExistsException {
		User friendUser = null;
		String content;
		String subject;
		Session friendSession = Sessions.getInstance().getSession(
				friend);
		User user = Sessions.getInstance().getSession(username).getUser();
		
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
				mail.sendMessage(content, subject, friendUser.getEmail());
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

}
