package logic;

import java.util.ArrayList;
import java.util.List;

import model.Session;
import model.User;

import org.hibernate.HibernateException;

import persistence.UserDAO;
import ProductLine.ClientPrx;
import ProductLine.InvalidLoggingException;
import ProductLine.RoleType;
import ProductLine.UserAlreadyExistsException;
import ProductLine.UserAlreadyLoggedException;

public class UsersManager {

	private static UsersManager controller;
	private List<Session> sessions;
	private UserDAO userDAO;

	public List<Session> getSessions() {
		return sessions;
	}

	private UsersManager() {
		sessions = new ArrayList<Session>();
		userDAO = UserDAO.getDAO();
	}

	public static UsersManager getInstance() {
		if (controller == null)
			controller = new UsersManager();
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
			if (userDAO.userAvailable(user.getUsername())) {
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

	public void logoutUser(String username) {
		Session leaveSession = searchSession(username);
		for (Session session : sessions) {
			if (!session.getUser().getUsername().equalsIgnoreCase(username)) {
				session.getCallback().userLeave(username);
			}
		}
		sessions.remove(leaveSession);

	}

	public void deleteUser(String username) {
		User user = new User(username);
		userDAO.delete(user);
	}

	public List<ProductLine.User> listUsers(String username) {
		List<ProductLine.User> users = new ArrayList<ProductLine.User>();
		for (Session session : sessions) {
			if (!session.getUser().getUsername().equalsIgnoreCase(username))
				users.add(userDAO.loadByID(session.getUser().getUsername()));
		}
		return users;
	}

	public void changeName(String username, String name, String lastname,
			String password) throws InvalidLoggingException {
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

	public void deleteAccount(String username, String password)
			throws InvalidLoggingException {
		User user = searchSession(username).getUser();
		if (user.getPassword().equals(password))
			throw new InvalidLoggingException("Incorrect password");
		userDAO.delete(user);

	}

	public Session searchSession(String username) {
		for (Session session : sessions) {
			if (session.getUser().getUsername().equalsIgnoreCase(username))
				return session;
		}
		return null;
	}

	public void resetPassword(String identifier) throws InvalidLoggingException {
		User user = userDAO.loadByID(identifier);
		if(user != null){
			String newPassword = Utils.getPassword();
			user.setPassword(Utils.hashMD5_Base64(newPassword));
			userDAO.update(user);
			final String content = "Su nueva contraseña es: "+newPassword;
			new Thread(){
				public void run(){
					MailSender.getMailSender().sendMessage(content, "Cambio de contraseña","juanyanezgc@gmail.com");
				}
			}.start();
		}else{
			throw new InvalidLoggingException();
		}
		
	}

	public void saveUser(User user) {
		userDAO.update(user);
		
	}

}
