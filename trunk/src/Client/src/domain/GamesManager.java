package domain;

import model.Session;



public class GamesManager {
	private static Session session;
	
	
	public GamesManager(){
		session = SessionManager.getInstance().getSession();
	}
	
	public void sendGeneralMessage(String message){
		session.getProxy().sendGeneralMessage(session.getUsername(), message);
	}
	
	
/*	public void List<String> listUsers(){
		session.getProxy().listUsers();
	}*/
	
	

}
