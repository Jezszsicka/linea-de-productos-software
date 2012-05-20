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
	private UserDAO userDAO;

	public List<Session> getSessions() {
		return sessions;
	}

	private UsersController() {
		sessions = new ArrayList<Session>();
		userDAO = UserDAO.getDAO();
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
	public void registerUser(User user) throws UserAlreadyExistsException {
		try {
			User loadedUser = userDAO.loadByID(user.getUsername());
			if (loadedUser == null) {
				userDAO.create(user);
			} else {
				throw new UserAlreadyExistsException();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
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

		User user = userDAO.checkLogin(username, password);
		// User found
		if (user != null) {
			Session newSession = new Session(user, callback);
			if (!sessions.contains(newSession)) {
				for (Session session : sessions)
					if (!session.getUser().getUsername()
							.equalsIgnoreCase(username))
						session.getCallback().userLogged(user);
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

		} else
			// User not found
			throw new InvalidLoggingException("Incorrect username or password");
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
			for (Session session : sessions) {
				if (!session.getUser().getUsername().equalsIgnoreCase(username)) {
					session.getCallback().userLeave(username);
				}
			}
			sessions.remove(leaveSession);
		}
	}

	public void deleteUser(String username) {
		User user = new User();
		user.setUsername(username);
		userDAO.delete(user);
	}

	public Session searchSession(String username) {
		for (Session session : sessions) {
			if (session.getUser().getUsername().equalsIgnoreCase(username))
				return session;
		}

		return null;

	}

	public List<User> listUsers(String username) {
		List<User> users = new ArrayList<User>();
		for (Session session : sessions) {
			if (!session.getUser().getUsername().equalsIgnoreCase(username))
				users.add(userDAO.loadByID(session.getUser().getUsername()));
		}
		return users;
	}

	public void sendGeneralMessage(String sender, String message) {
		for (Session session : sessions) {
			if (!session.getUser().getUsername().equalsIgnoreCase(sender)) {
				session.getCallback().receiveGeneralMessage(sender, message);
			}
		}

	}

	public void sendPrivateMessage(String sender, String destinatary,
			String message) throws UserNotLoggedException {

		Session session = searchSession(destinatary);
		if (session != null) {
			session.getCallback().receivePrivateMessage(sender, message);
		} else {
			throw new UserNotLoggedException();
		}

	}

	public void changeName(String username, String name, String lastname,String password) throws InvalidLoggingException {
		User user = searchSession(username).getUser();
		if (!user.getPassword().equals(password))
			throw new InvalidLoggingException("Incorrect password");
		user.setName(name);
		user.setLastName(lastname);
		userDAO.update(user);

	}

	public void changeEmail(String username, String email, String password)
			throws InvalidLoggingException {
		User user = searchSession(username).getUser();
		if (!user.getPassword().equals(password))
			throw new InvalidLoggingException("Incorrect password");
		user.setEmail(email);
		userDAO.update(user);
	}

	public void changePassword(String username, String password,
			String newPassword) throws InvalidLoggingException {
		User user = searchSession(username).getUser();
		if (!user.getPassword().equals(password))
			throw new InvalidLoggingException("Incorrect password");
		user.setPassword(newPassword);
		userDAO.update(user);
	}

	public void changeAvatar(String username, byte[] avatar) {
		User user = searchSession(username).getUser();
		user.setAvatar(avatar);
		userDAO.update(user);
	}

}
