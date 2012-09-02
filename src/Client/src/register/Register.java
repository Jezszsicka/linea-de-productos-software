package register;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utils.Utils;
import logic.Client;
import model.User;
import ProductLine.UserAlreadyExistsException;
import email.IEmail;
import exceptions.WrongInputException;

public class Register implements IRegister{
	
	private IEmail mail;

	public Register(IEmail mail){
		this.mail = mail;
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
				mail.sendMessage(content, subject,
						user.getEmail());
			}
		}.start();

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
