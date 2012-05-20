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
		User user = Client.getProxy().loginUser(username, Utils.hashMD5_Base64(password), callback);
		session = new Session(user, callback, Client.getProxy());
		return session;
	}

	public void registerUser(User user, String retypedPassword,
			String retypedEmail) throws WrongInputException,
			UserAlreadyExistsException {
		validateRegisterInput(user.getUsername(), user.getPassword(),
				retypedPassword, user.getEmail(), retypedEmail);
		user.setPassword(Utils.hashMD5_Base64(user.getPassword()));
		Client.getProxy().registerUser((ProductLine.User) user);

	}

	public void logoutUser() throws UserNotLoggedException {
		session.getProxy().logoutUser(session.getUser().getUsername());
		session = null;
	}

	public void changeName(String name, String lastname, String password) throws InvalidLoggingException, WrongInputException {
		// Check empty fields
		if(name.isEmpty() || lastname.isEmpty() || password.isEmpty())
			throw new WrongInputException("Incomplete fields",
					"Some fields are in blank, please complete all the fields");
		
		String encryptedPassword = Utils.hashMD5_Base64(password);
		session.getProxy().changeName(session.getUser().getUsername(), name,
				lastname,encryptedPassword);
		session.getUser().setName(name);
		session.getUser().setLastName(lastname);
	}

	public void changeEmail(String email, String confirmEmail, String password)
			throws WrongInputException, InvalidLoggingException {
		
		// Check empty fields
		if (email.isEmpty() || confirmEmail.isEmpty() || password.isEmpty())
			throw new WrongInputException("Incomplete fields",
					"Some fields are in blank, please complete all the fields");

		// Check valid email format
		if (!isCorrectEmail(email))
			throw new WrongInputException("Invalid email",
					"The format of the email is not valid");
		
		//Check confirm email
		if(!email.equals(confirmEmail))
			throw new WrongInputException("Emails don't match",
					"The emails must be the same");
		
		String encryptedPassword = Utils.hashMD5_Base64(password);
		session.getProxy().changeEmail(session.getUser().getUsername(),email,encryptedPassword);
		
	}

	public void changePassword(String password, String newPassword,
			String confirmPassword) throws InvalidLoggingException, WrongInputException {
		
		//Check empty fields
		if(password.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty())
			throw new WrongInputException("Incomplete fields", "Some fields are in blank, please complete all the fields");
		
		String encryptedPassword = Utils.hashMD5_Base64(password);
		String encryptedNewPassword = Utils.hashMD5_Base64(newPassword);
		session.getProxy().changePassword(session.getUser().getUsername(),encryptedPassword,encryptedNewPassword);
		
	}
	
	public void changeAvatar(byte[] avatar) {
		session.getProxy().changeAvatar(session.getUser().getUsername(), avatar);
		session.getUser().setAvatar(avatar);
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

		// Check empty fields
		if (username.isEmpty() || password.isEmpty()
				|| retypedPassword.isEmpty() || email.isEmpty()
				|| retypedEmail.isEmpty())
			throw new WrongInputException("Incomplete fields",
					"Some fields are in blank, please complete all the fields");

		// Check valid email format
		if (!isCorrectEmail(email))
			throw new WrongInputException("Invalid email",
					"The format of the email is not valid");

		// Check retyped password and email
		if (!password.equals(retypedPassword))
			throw new WrongInputException("Passwords don't match",
					"The passwords must be the same");

		if (!email.equals(retypedEmail))
			throw new WrongInputException("Emails don't match",
					"The emails must be the same");

	}

	private boolean isCorrectEmail(String email) {
		Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
