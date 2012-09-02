package identify;

import usersInfo.IUsersInfo;
import utils.Utils;
import Ice.Identity;
import ProductLine.InvalidLoggingException;
import ProductLine.UserAlreadyLoggedException;

import exceptions.WrongInputException;

import logic.Client;
import model.Session;
import model.User;

public class Identify implements IIdentify {

	private IUsersInfo usersInfo;
	
	
	public Identify(IUsersInfo usersInfo){
		this.usersInfo = usersInfo;
	}

	/**
	 * Log in a user
	 * 
	 * @param username
	 *            Account name (Can be the username or the email)
	 * @param password
	 *            Password of the account
	 * @throws WrongInputException
	 * @throws InvalidLoggingException
	 * @throws UserAlreadyLoggedException
	 * **/
	@Override
	public void loginUser(String username, String password)
			throws WrongInputException, InvalidLoggingException,
			UserAlreadyLoggedException {
		validateLoginInput(username, password);
		Identity callback = Client.getCallback();
		User user = (User) Client.getProxy().loginUser(username,
				Utils.hashMD5_Base64(password), callback);
		
		Session session = Session.getInstance();
		session.setUser(user);
		session.setProxy(Client.getProxy());
		session.setCallback(callback);
		usersInfo.listUsers();
	
	}
	
	
	/** Logs out the current session **/
	@Override
	public void logoutUser() {
		Session.getInstance().getProxy().logoutUser(Session.getInstance().getUser().getUsername());
	}
	
	
	/**
	 * Validates the login input fields
	 * 
	 * @param username
	 *            Input username
	 * @param password
	 *            Input password
	 * @throws WrongInputException
	 * **/
	private void validateLoginInput(String username, String password)
			throws WrongInputException {
		if (username.isEmpty() || password.isEmpty())
			throw new WrongInputException("Incomplete fields",
					"Some fields are in blank, please complete all the fields");
	}


}
