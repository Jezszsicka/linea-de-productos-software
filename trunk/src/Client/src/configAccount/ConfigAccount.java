package configAccount;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Session;
import utils.Utils;
import ProductLine.InvalidLoggingException;
import exceptions.WrongInputException;

public class ConfigAccount implements IConfigAccount{

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
	@Override
	public void changeName(String name, String lastname, String password)
			throws InvalidLoggingException, WrongInputException {
		// Check empty fields
		if (name.isEmpty() || lastname.isEmpty() || password.isEmpty())
			throw new WrongInputException("Incomplete fields",
					"Some fields are in blank, please complete all the fields");

		String encryptedPassword = Utils.hashMD5_Base64(password);
		Session session = Session.getInstance();
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
	@Override
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

		Session session = Session.getInstance();
		
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
	@Override
	public void changePassword(String password, String newPassword,
			String confirmPassword) throws InvalidLoggingException,
			WrongInputException {

		Session session = Session.getInstance();
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
	@Override
	public void changeAvatar(byte[] avatar) {
		Session session = Session.getInstance();
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
	@Override
	public void deleteAccount(String password) throws InvalidLoggingException,
			WrongInputException {

		if (password.isEmpty())
			throw new WrongInputException("Incomplete fields",
					"You must introduce the password");

		Session session = Session.getInstance();
		session.getProxy().deleteAccount(session.getUser().getUsername(),
				Utils.hashMD5_Base64(password));

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
