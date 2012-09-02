package identify;

import persistence.UserDAO;
import model.Session;
import model.Sessions;
import model.User;
import ProductLine.ClientPrx;
import ProductLine.InvalidLoggingException;
import ProductLine.UserAlreadyLoggedException;

public class UsersManager implements IIdentify {
	private UserDAO userDAO;
	
	public UsersManager(){
		userDAO = UserDAO.getDAO();
	}

	@Override
	public User loginUser(String username, String password, ClientPrx callback)
			throws InvalidLoggingException, UserAlreadyLoggedException {
		Sessions sessions = Sessions.getInstance();
		
		User user = userDAO.checkLogin(username, password);
		// User found
		if (user != null) {
			Session newSession = new Session(user, callback);
			if (!sessions.contains(newSession)) {
				for (Session session : sessions.getSessions())
					if (!session.getUser().getUsername()
							.equalsIgnoreCase(username))
						session.getCallback().userLogged(user);
				sessions.addSession((newSession));
			} else {
				for (Session session : sessions.getSessions()) {
					if (newSession.equals(session)) {
						try {
							session.checkConnection();
							throw new UserAlreadyLoggedException(
									"User Already logged");
						} catch (Ice.ConnectionLostException e) {
							sessions.removeSession(session);
							sessions.addSession(newSession);
						}
					}
				}

			}

		} else
			// User not found
			throw new InvalidLoggingException("Incorrect username or password");
		return user;
		
	}

	@Override
	public void logoutUser(String username) {
		Sessions sessions = Sessions.getInstance();
		Session leaveSession = sessions.getSession(username);
		for (Session session : Sessions.getInstance().getSessions()) {
			if (!session.getUser().getUsername().equalsIgnoreCase(username)) {
				session.getCallback().userLeave(username);
			}
		}
		sessions.removeSession(leaveSession);	
	}


}
