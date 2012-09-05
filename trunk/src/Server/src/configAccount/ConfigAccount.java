package configAccount;

import persistence.UserDAO;
import model.Session;
import model.Sessions;
import model.User;
import ProductLine.InvalidLoggingException;

public class ConfigAccount implements IConfigAccount {

	@Override
	public void changeName(String username, String name, String lastname,
			String password) throws InvalidLoggingException {
		
		User user = Sessions.getInstance().getSession(username).getUser();
		if (!user.getPassword().equals(password))
			throw new InvalidLoggingException("Incorrect password");
		user.setName(name);
		user.setLastName(lastname);
		UserDAO.getDAO().update(user);
	}

	@Override
	public void changeEmail(String username, String email, String password)
			throws InvalidLoggingException {
		User user = Sessions.getInstance().getSession(username).getUser();
		if (!user.getPassword().equals(password))
			throw new InvalidLoggingException("Incorrect password");
		user.setEmail(email);
		UserDAO.getDAO().update(user);
	}

	@Override
	public void changePassword(String username, String password,
			String newPassword) throws InvalidLoggingException {
		User user = Sessions.getInstance().getSession(username).getUser();
		if (!user.getPassword().equals(password))
			throw new InvalidLoggingException("Incorrect password");
		user.setPassword(newPassword);
		UserDAO.getDAO().update(user);
		
	}

	@Override
	public void changeAvatar(String username, byte[] avatar) {
		User user = Sessions.getInstance().getSession(username).getUser();
		user.setAvatar(avatar);
		UserDAO.getDAO().update(user);	
	}

	@Override
	public void deleteAccount(String username, String password)
			throws InvalidLoggingException {
		Session session = Sessions.getInstance().getSession(username);
		User user = session.getUser();
		if (!user.getPassword().equals(password))
			throw new InvalidLoggingException("Incorrect password");
		Sessions.getInstance().removeSession(session);
		UserDAO.getDAO().delete(user);
	}


}
