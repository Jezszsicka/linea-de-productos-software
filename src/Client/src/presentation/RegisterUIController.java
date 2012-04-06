package presentation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import IServer.UserAlreadyExistsException;
import domain.UserController;
import exceptions.WrongInputException;

public class RegisterUIController {
	private RegisterUI registerUI;

	public RegisterUIController() {
		registerUI = new RegisterUI(this);
		registerUI.setLocationRelativeTo(null);
		registerUI.setVisible(true);
	}

	public void close() {
		registerUI.dispose();
	}

	public void registerUser(String username, String password,
			String retypedPassword, String email, String retypedEmail) {

		try {
			validateInput(username, password, retypedPassword, email,
					retypedEmail);
			UserController.getInstance()
					.registerUser(username, password, email);
			JOptionPane.showMessageDialog(registerUI,
					"The register has been competed successfully",
					"Register complete", JOptionPane.INFORMATION_MESSAGE);
		} catch (UserAlreadyExistsException e) {
			JOptionPane.showMessageDialog(registerUI,
					"User already exists, choose another username",
					"Username error", JOptionPane.WARNING_MESSAGE);
		} catch (WrongInputException e) {
			JOptionPane.showMessageDialog(registerUI, e.getMessage(),
					e.getError(), JOptionPane.WARNING_MESSAGE);
		}
	}

	private void validateInput(String username, String password,
			String retypedPassword, String email, String retypedEmail)
			throws WrongInputException {

		// Checks empty fields
		if (username.isEmpty() || password.isEmpty()
				|| retypedPassword.isEmpty() || email.isEmpty()
				|| retypedEmail.isEmpty())
			throw new WrongInputException("Incomplete fields",
					"Some fields are in blank, please complete all the fields");

		// Checks valid email format
		Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = pattern.matcher(email);

		if (!matcher.matches())
			throw new WrongInputException("Invalid email",
					"The format of the email is not valid");

		// Checks retyped password and email
		if (!password.equals(retypedPassword))
			throw new WrongInputException("Passwords don't match",
					"The passwords must be the same");

		if (!email.equals(retypedEmail))
			throw new WrongInputException("Emails don't match",
					"The emails must be the same");
	}

}
