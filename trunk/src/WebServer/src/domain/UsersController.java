package domain;

import java.util.ArrayList;
import java.util.List;

import persistence.HibernateUtil;
import IClient.ClientPrx;
import IServer.InvalidLoggingException;
import IServer.UserAlreadyExistsException;
import IServer.UserAlreadyLoggedException;
import IServer.UserNotLoggedException;
import constants.UserConstants;



public class UsersController {

	private static UsersController controller;
	private List<Session> sessions;
	
	public List<Session> getSessions(){
		return sessions;
	}
	
	private UsersController(){
		sessions = new ArrayList<Session>();
	}
	
	public static UsersController getInstance() {
		if(controller == null)
			controller = new UsersController();
		return controller;
	}

	/**Create a new user account
	 * 
	 * @param username	Username for the new account
	 * @param password	Password for the user account
	 * @param email		Email of the user
	 * **/
	public void registerUser(String username,String password,String email) throws UserAlreadyExistsException{
		org.hibernate.classic.Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
		hibernateSession.beginTransaction();
		@SuppressWarnings("unchecked")
		List<User> query = hibernateSession.createQuery("from User as user where user.username = '"+username+"' or user.email = '"+email+"'").list();
		hibernateSession.getTransaction().commit();
		
		if(query.size() > 0){
			User user = query.get(0);
			if(user.getUsername().equals(username))
				throw new UserAlreadyExistsException("Username is already in use");
			if(user.getEmail().equals(email))
				throw new UserAlreadyExistsException("Email already in use");
		}else{
			hibernateSession.beginTransaction();
			User user = new User(username,Utils.hashMD5(password),email,Role.Player);
			hibernateSession.save(user);
			hibernateSession.getTransaction().commit();
		}
	}
	
	
	/**Allows a user to enter the system
	 * 
	 * @param username
	 * @param password
	 * @param callback
	 * 
	 * **/
	public void loginUser(String username, String password,ClientPrx callback) throws UserAlreadyLoggedException, InvalidLoggingException {
		org.hibernate.classic.Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
		hibernateSession.beginTransaction();
		@SuppressWarnings("unchecked")
		List<User> query = hibernateSession.createQuery("from User as user where user.username = '"+username+"'").list();
		hibernateSession.getTransaction().commit();
		
		//User found
		if(query.size() > 0){
			User user = query.get(0);
			if(user.isBlocked()){
				throw new InvalidLoggingException("Blocked account");
			}else{
				//Checking password
				String hashMD5 = Utils.hashMD5(password);
				if(!user.getPassword().equals(hashMD5)){	//Incorrect password
					int attemps = user.getAttemps();
					user.setAttemps(++attemps);
					if(attemps >= UserConstants.MAXATTEMPS){
						user.setBlocked(true);
						hibernateSession.beginTransaction();
						hibernateSession.update(user);
						hibernateSession.getTransaction().commit();
						throw new InvalidLoggingException("Blocked account");
					}
					hibernateSession.beginTransaction();
					hibernateSession.update(user);
					hibernateSession.getTransaction().commit();
					throw new InvalidLoggingException("Incorrect password");
				}else{ //Correct password
					Session newSession = new Session(username,callback);
					if(!sessions.contains(newSession)){
						sessions.add(newSession);
						if(user.getAttemps()>0){
							user.setAttemps(0);
							hibernateSession.beginTransaction();
							hibernateSession.update(user);
							hibernateSession.getTransaction().commit();
						}
					}else{
						for(Session session : sessions){
							if(newSession.equals(session)){
								try{
									session.checkConnection();
									throw new UserAlreadyLoggedException("User Already logged");
								}catch(Ice.ConnectionLostException e){
									sessions.remove(session);
									sessions.add(newSession);
								}
							}
						}
						
					}
				}
			}
		}else //User not found
			throw new InvalidLoggingException("Incorrect username");
	}
	
	public Role loginUser(String username, String password) {
		return Role.Admin;
		
	}
	
	
	
	public void logoutUser(String username) throws UserNotLoggedException {
		Session session = searchSession(username);
		if(session == null)
			throw new UserNotLoggedException("User not logged, session expired");
		else
			sessions.remove(session);
	}
	
	
	public void deleteUser(String username){
		User user = new User(username);
		org.hibernate.classic.Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
		hibernateSession.beginTransaction();
		hibernateSession.delete(user);
		hibernateSession.getTransaction().commit();
	}
	
	public Session searchSession(String username){
		for(Session session : sessions){
			if(session.getUsername().equals(username))
				return session;
		}
		
		return null;
			
	}
	
	
	
}
