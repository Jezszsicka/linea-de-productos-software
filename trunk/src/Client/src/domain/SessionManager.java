package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Session;
import Ice.Identity;
import ProductLine.InvalidLoggingException;
import ProductLine.User;
import ProductLine.UserAlreadyExistsException;
import ProductLine.UserAlreadyLoggedException;
import ProductLine.UserNotLoggedException;

import communications.Client;

import exceptions.WrongInputException;

public class SessionManager {
	private Session session;
	
	public SessionManager() {
		
	}
	
	public Session loginUser(String username, String password)
			throws WrongInputException, InvalidLoggingException,
			UserAlreadyLoggedException {
		validateLoginInput(username, password);
		Identity callback = Client.getCallback();
		User user = Client.getProxy().loginUser(username, password, callback);
		session = new Session(user,callback,Client.getProxy());
		return session;
	}

	public void registerUser(String username, String password,
			String retypedPassword, String email, String retypedEmail) throws WrongInputException, UserAlreadyExistsException {
		validateRegisterInput(username, password, retypedPassword, email,
				retypedEmail);
		session.getProxy().registerUser(username, password, email);

	}

	private void validateLoginInput(String username, String password)
			throws WrongInputException {
		if (username.isEmpty() || password.isEmpty())
			throw new WrongInputException("Incomplete fields",
					"Some fields are in blank, please complete all the fields");
	}

	private void validateRegisterInput(String username, String password,
			String retypedPassword, String email, String retypedEmail)
			throws WrongInputException {

		// Checks empty fields
		if (username.isEmpty() || password.isEmpty()
				|| retypedPassword.isEmpty() || email.isEmpty()
				|| retypedEmail.isEmpty()) {
			throw new WrongInputException("Incomplete fields",
					"Some fields are in blank, please complete all the fields");
		} else {
			// Checks valid email format
			Pattern pattern = Pattern
					.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			Matcher matcher = pattern.matcher(email);

			if (!matcher.matches()) {
				throw new WrongInputException("Invalid email",
						"The format of the email is not valid");

				// Checks retyped password and email
			} else if (!password.equals(retypedPassword)) {
				throw new WrongInputException("Passwords don't match",
						"The passwords must be the same");

			} else if (!email.equals(retypedEmail))
				throw new WrongInputException("Emails don't match",
						"The emails must be the same");
		}
	}

	public void logoutUser() throws UserNotLoggedException {
		session.getProxy().logoutUser(session.getUser().getUsername());
		session = null;
	}

	public void saveProfile() {
		session.getProxy().saveProfile(session.getUser());
	}
}
