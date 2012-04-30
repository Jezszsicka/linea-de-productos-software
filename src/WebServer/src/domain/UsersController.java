package domain;

import java.util.ArrayList;
import java.util.List;

import model.Session;

import org.hibernate.HibernateException;

import persistence.UserDAO;
import ProductLine.ClientPrx;
import ProductLine.InvalidLoggingException;
import ProductLine.RoleType;
import ProductLine.User;
import ProductLine.UserAlreadyExistsException;
import ProductLine.UserAlreadyLoggedException;
import ProductLine.UserNotLoggedException;

public class UsersController {

	private static UsersController controller;
	private List<Session> sessions;

	public List<Session> getSessions() {
		return sessions;
	}

	private UsersController() {
		sessions = new ArrayList<Session>();
	}

	public static UsersController getInstance() {
		if (controller == null)
			controller = new UsersController();
		return controller;
	}

	/**
	 * Create a new user account
	 * 
	 * @param username
	 *            Username for the new account
	 * @param password
	 *            Password for the user account
	 * @param email
	 *            Email of the user
	 * **/
	public void registerUser(String username, String password, String email)
			throws UserAlreadyExistsException {
		try {
			UserDAO userDAO = UserDAO.getDAO();
			User user = userDAO.loadByID(username);
			if(user == null){
				user = new User();
				user.setUsername(username);
				user.setPassword(password);
				user.setEmail(email);
				UserDAO.getDAO().create(user);
			}else{
				throw new UserAlreadyExistsException();
			}
			
		} catch (HibernateException e) {
			System.out.println("Error en al base de datos al registrar");
		}
	}

	/**
	 * Allows a user to enter the system
	 * 
	 * @param username
	 * @param password
	 * @param callback
	 * 
	 * **/
	public User loginUser(String username, String password, ClientPrx callback)
			throws UserAlreadyLoggedException, InvalidLoggingException {
		
		String hashMD5 = Utils.hashMD5(password);
		UserDAO userDAO = UserDAO.getDAO();
		User user = userDAO.checkLogin(username,hashMD5);
		

		// User found
		if (user != null) {
				// Checking password
				hashMD5 = Utils.hashMD5(password);
				if (!user.getPassword().equals(hashMD5)) { // Incorrect password
					throw new InvalidLoggingException("Incorrect password");
				} else { // Correct password
					Session newSession = new Session(username, callback);
					if (!sessions.contains(newSession)) {
						for(Session session : sessions)
							if(!session.getUsername().equals(username))
								session.getCallback().userLogged(username);
						sessions.add(newSession);
					} else {
						for (Session session : sessions) {
							if (newSession.equals(session)) {
								try {
									session.checkConnection();
									throw new UserAlreadyLoggedException(
											"User Already logged");
								} catch (Ice.ConnectionLostException e) {
									sessions.remove(session);
									sessions.add(newSession);
								}
							}
						}

					}
				}
			}
		 else
			// User not found
			throw new InvalidLoggingException("Incorrect username");
		
		return user;
	}

	public RoleType loginUser(String username, String password) {
		return RoleType.Admin;

	}

	public void logoutUser(String username) throws UserNotLoggedException {
		Session leaveSession = searchSession(username);
		if (leaveSession == null)
			throw new UserNotLoggedException("User not logged, session expired");
		else {
			for(Session session : sessions){
				if(!session.getUsername().equals(username)){
					session.getCallback().userLeave(username);
				}
			}
			sessions.remove(leaveSession);
		}
	}

	public void deleteUser(String username) {
		User user = new User();
		user.setUsername(username);
		UserDAO.getDAO().delete(user);
	}

	public Session searchSession(String username) {
		for (Session session : sessions) {
			if (session.getUsername().equals(username))
				return session;
		}

		return null;

	}

	public List<String> listUsers() {
		List<String> users = new ArrayList<String>();
		for(Session session : sessions){
			users.add(session.getUsername());
		}
		return users;
	}

	public void sendGeneralMessage(String sender, String message) {
		for(Session session : sessions){
			if(!session.getUsername().equals(sender)){
				session.getCallback().receiveGeneralMessage(sender, message);
			}
		}
		
	}

}
