package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Session;
import model.User;
import Ice.Identity;
import ProductLine.InvalidLoggingException;
import ProductLine.UserAlreadyExistsException;
import ProductLine.UserAlreadyLoggedException;

import communications.Client;

import exceptions.WrongInputException;

public class SessionManager {
	private Session session;

	public SessionManager() {

	}

	/**
	 * Registers a new user
	 * 
	 * @param user
	 *            New user to register
	 * @param retypedPassword
	 *            Repeated password
	 * @param retypedEmail
	 *            Repeated email
	 * @throws WrongInputException
	 * @throws UserAlreadyExistsException
	 **/
	public void registerUser(final User user, String retypedPassword,
			String retypedEmail) throws WrongInputException,
			UserAlreadyExistsException {
		validateRegisterInput(user.getUsername(), user.getPassword(),
				retypedPassword, user.getEmail(), retypedEmail);
		final String password = user.getPassword();
		user.setPassword(Utils.hashMD5_Base64(user.getPassword()));
		Client.getProxy().registerUser((ProductLine.User) user);
		new Thread() {
			public void run() {
				String content = "Bienvenido a a Board Games \n\nSus datos de registro son:\n\nUsuario: "
						+ user.getUsername() + "\nPassword: " + password;
				String subject = "Datos de registro";
				MailSender.getMailSender().sendMessage(content, subject,
						user.getEmail());
			}
		}.start();

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
	public Session loginUser(String username, String password)
			throws WrongInputException, InvalidLoggingException,
			UserAlreadyLoggedException {
		validateLoginInput(username, password);
		Identity callback = Client.getCallback();
		User user = (User) Client.getProxy().loginUser(username,
				Utils.hashMD5_Base64(password), callback);
		List<ProductLine.User> serverUsers = Client.getProxy().listUsers(
				username);
		List<User> users = new ArrayList<User>();
		for (ProductLine.User aux : serverUsers)
			users.add((User) aux);
		session = new Session(user, users, callback, Client.getProxy());
		return session;
	}

	/** Logs out the current session **/
	public void logoutUser() {
		session.getProxy().logoutUser(session.getUser().getUsername());
		session = null;
	}

	/**
	 * Changes the name of the user
	 * 
	 * @param name
	 *            New name for the user
	 * @param lastname
	 *            New lastname for the user
	 * @param password
	 *            Account password
	 * @throws InvalidLoggingException
	 **/
	public void changeName(String name, String lastname, String password)
			throws InvalidLoggingException, WrongInputException {
		// Check empty fields
		if (name.isEmpty() || lastname.isEmpty() || password.isEmpty())
			throw new WrongInputException("Incomplete fields",
					"Some fields are in blank, please complete all the fields");

		String encryptedPassword = Utils.hashMD5_Base64(password);
		session.getProxy().changeName(session.getUser().getUsername(), name,
				lastname, encryptedPassword);
		session.getUser().setName(name);
		session.getUser().setLastName(lastname);
	}

	/**
	 * Changes the email of the user
	 * 
	 * @param email
	 *            New email for the user
	 * @param confirmEmail
	 *            Confirmation of the new email
	 * @param password
	 *            Account password
	 * @throws WrongInputException
	 * @throws InvalidLoggingException
	 * **/
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

		// Check confirm email
		if (!email.equals(confirmEmail))
			throw new WrongInputException("Emails don't match",
					"The emails must be the same");

		String encryptedPassword = Utils.hashMD5_Base64(password);
		session.getProxy().changeEmail(session.getUser().getUsername(), email,
				encryptedPassword);

	}

	/**
	 * Changes the password of the user
	 * 
	 * @param password
	 *            Account password
	 * @param newPassword
	 *            New password for the user
	 * @param confirmPassword
	 *            Confirmation of the new password
	 * @throws InvalidLoggingException
	 * @throws WrongInputException
	 **/
	public void changePassword(String password, String newPassword,
			String confirmPassword) throws InvalidLoggingException,
			WrongInputException {

		// Check empty fields
		if (password.isEmpty() || newPassword.isEmpty()
				|| confirmPassword.isEmpty())
			throw new WrongInputException("Incomplete fields",
					"Some fields are in blank, please complete all the fields");

		String encryptedPassword = Utils.hashMD5_Base64(password);
		String encryptedNewPassword = Utils.hashMD5_Base64(newPassword);
		session.getProxy().changePassword(session.getUser().getUsername(),
				encryptedPassword, encryptedNewPassword);

	}

	/**
	 * Changes the avatar of the user
	 * 
	 * @param avatar
	 *            Byte array containing the new avatar for the user
	 **/
	public void changeAvatar(byte[] avatar) {
		session.getProxy()
				.changeAvatar(session.getUser().getUsername(), avatar);
		session.getUser().setAvatar(avatar);
	}

	/**
	 * Deletes the user account
	 * 
	 * @param password
	 *            Account password
	 * @throws InvalidLoggingException
	 * @throws WrongInputException
	 **/
	public void deleteAccount(String password) throws InvalidLoggingException,
			WrongInputException {

		if (password.isEmpty())
			throw new WrongInputException("Incomplete fields",
					"You must introduce the password");

		session.getProxy().deleteAccount(session.getUser().getUsername(),
				Utils.hashMD5_Base64(password));

	}

	/**
	 * An user has logged
	 * 
	 * @param user
	 *            New logged user
	 * **/
	public void userLogged(User user) {
		session.addUser(user);
	}

	/**
	 * An user has left
	 * 
	 * @param user
	 *            User who left
	 **/
	public void userLeave(String user) {
		session.removeUser(user);
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

	/**
	 * Validates the register input fields
	 * 
	 * @param username
	 *            Input username
	 * @param password
	 *            Input password
	 * @param retypedPassword
	 *            Input password confirmation
	 * @param email
	 *            Input email
	 * @param retypedEmail
	 *            Input email confirmation
	 * @throws WrongInputException
	 **/
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

	/**
	 * Validates correct email addresses
	 * 
	 * @param email
	 *            Email to validate
	 * @return True if is a correct email, false otherwise
	 **/
	private boolean isCorrectEmail(String email) {
		Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
