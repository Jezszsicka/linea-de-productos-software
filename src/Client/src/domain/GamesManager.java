package domain;

import ProductLine.UserNotLoggedException;
import model.Session;



public class GamesManager {
	private Session session;
	
	public GamesManager(Session session){
		this.session = session;
	}
	
	public void sendGeneralMessage(String message){
		session.getProxy().sendGeneralMessage(session.getUser().getUsername(), message);
	}

	public void sendPrivateMessage(String sender, String destinatary,
			String message) throws UserNotLoggedException {
		session.getProxy().sendPrivateMessage(sender, destinatary, message);	
	}
}
