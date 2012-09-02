package model;

import java.util.ArrayList;
import java.util.List;

public class Sessions {
	private List<Session> sessions;
	private static Sessions instance;
	
	private Sessions(){
		sessions = new ArrayList<Session>();
	}
	
	public static Sessions getInstance(){
		if(instance == null)
			instance = new Sessions();
		return instance;
	}
	
	public void addSession(Session session){
		sessions.add(session);
	}
	
	public void removeSession(Session session){
		sessions.remove(session);
	}
	
	public Session getSession(String user){
		for(Session session : sessions){
			if(session.getUser().getUsername().equals(user))
				return session;
		}
		
		return null;
	}
	
	public boolean contains(Session session){
		return sessions.contains(session);
	}

	/**
	 * @return the sessions
	 */
	public List<Session> getSessions() {
		return sessions;
	}

	/**
	 * @param sessions the sessions to set
	 */
	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}
	
	
	
	

}
