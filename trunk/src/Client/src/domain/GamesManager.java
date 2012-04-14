package domain;

import model.Session;



public class GamesManager {
	private Session session;
	
	public GamesManager(Session session){
		this.session = session;
	}
	
	public void sendGeneralMessage(String message){
		session.getProxy().sendGeneralMessage(session.getUsername(), message);
	}
}
