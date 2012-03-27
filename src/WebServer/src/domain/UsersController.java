package domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import persistence.UserDAO;
import IClient.ClientPrx;
import IServer.InvalidLoggingException;
import IServer.UserAlreadyExistsException;
import IServer.UserAlreadyLoggedException;
import IServer.UserNotLoggedException;
import constants.UserConstants;

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
			User user = new User(username, Utils.hashMD5(password), email,
					Role.Player);
			UserDAO.getDAO().create(user);
		} catch (HibernateException e) {
			throw new UserAlreadyExistsException();
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
	public void loginUser(String username, String password, ClientPrx callback)
			throws UserAlreadyLoggedException, InvalidLoggingException {
		
		String hashMD5 = Utils.hashMD5(password);
		UserDAO userDAO = UserDAO.getDAO();
		User user = userDAO.checkLogin(username,hashMD5);
		

		// User found
		if (user != null) {
			if (user.isBlocked()) {
				throw new InvalidLoggingException("Blocked account");
			} else {
				// Checking password
				hashMD5 = Utils.hashMD5(password);
				if (!user.getPassword().equals(hashMD5)) { // Incorrect password
					int attemps = user.getAttemps();
					user.setAttemps(++attemps);
					if (attemps >= UserConstants.MAXATTEMPS) {
						user.setBlocked(true);
						userDAO.update(user);
						throw new InvalidLoggingException("Blocked account");
					}
					userDAO.update(user);
					throw new InvalidLoggingException("Incorrect password");
				} else { // Correct password
					Session newSession = new Session(username, callback);
					if (!sessions.contains(newSession)) {
						sessions.add(newSession);
						MessageController.getInstance()
								.addParticipant(username);
						if (user.getAttemps() > 0) {
							user.setAttemps(0);
							userDAO.update(user);
						}
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
		} else
			// User not found
			throw new InvalidLoggingException("Incorrect username");
	}

	public Role loginUser(String username, String password) {
		return Role.Admin;

	}

	public void logoutUser(String username) throws UserNotLoggedException {
		Session session = searchSession(username);
		if (session == null)
			throw new UserNotLoggedException("User not logged, session expired");
		else {
			sessions.remove(session);
			MessageController.getInstance().removeParticipant(username);
		}
	}

	public void deleteUser(String username) {
		User user = new User(username);
		UserDAO.getDAO().delete(user);
	}

	public Session searchSession(String username) {
		for (Session session : sessions) {
			if (session.getUsername().equals(username))
				return session;
		}

		return null;

	}

}
