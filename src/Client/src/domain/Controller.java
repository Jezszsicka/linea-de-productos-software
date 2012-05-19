package domain;

import javax.swing.JOptionPane;

import model.Session;
import presentation.CreateGameUI;
import presentation.JoinGameUI;
import presentation.LoginUI;
import presentation.ProfileUI;
import presentation.RegisterUI;
import presentation.WaitingRoomUI;
import ProductLine.InvalidLoggingException;
import ProductLine.User;
import ProductLine.UserAlreadyExistsException;
import ProductLine.UserAlreadyLoggedException;
import ProductLine.UserNotLoggedException;

import communications.Client;

import exceptions.WrongInputException;

public class Controller {
	public static Controller controller;

	private LoginUI loginUI;
	private RegisterUI registerUI;
	private WaitingRoomUI waitingRoomUI;
	private CreateGameUI createGameUI;
	private ProfileUI profileUI;

	private Session session;
	private SessionManager sessionManager;
	private GamesManager gameManager;

	private Controller() {
		loginUI = new LoginUI();
		sessionManager = new SessionManager();
	}

	public static void initialize() {
		if (controller == null) {
			controller = new Controller();
		}
	}

	public static Controller getInstance() {
		return controller;
	}

	public void registerUser(User user, String retypedPassword,
			String retypedEmail) {
		try {
			sessionManager.registerUser(user, retypedPassword, retypedEmail);
			loginUI.setEnabled(true);
			registerUI.dispose();
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

	public void startRegister() {
		loginUI.setEnabled(false);
		registerUI = new RegisterUI();
	}

	public void cancelRegister() {
		registerUI.dispose();
		loginUI.setEnabled(true);
		loginUI.toFront();
	}

	public void loginUser(String username, String password) {
		try {
			session = sessionManager.loginUser(username, password);
			gameManager = new GamesManager(session);
			waitingRoomUI = new WaitingRoomUI(session.getUser(), session
					.getProxy().listUsers(session.getUser().getUsername()));
			loginUI.dispose();
			loginUI = null;

		} catch (WrongInputException e) {
			JOptionPane.showMessageDialog(registerUI, e.getMessage(),
					e.getError(), JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		} catch (InvalidLoggingException e) {
			JOptionPane.showMessageDialog(registerUI,
					"Wrong username or password", "Incorrect login",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (UserAlreadyLoggedException e) {
			JOptionPane.showMessageDialog(registerUI, "This account is in use",
					"Account in use", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void logoutUser() {
		try {
			sessionManager.logoutUser();
			gameManager = null;
			waitingRoomUI.dispose();
			loginUI = new LoginUI();
		} catch (UserNotLoggedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void startCreateGame() {
		createGameUI = new CreateGameUI();
		waitingRoomUI.setEnabled(false);
	}

	public void cancelCreateGame() {
		waitingRoomUI.setEnabled(true);
		waitingRoomUI.toFront();
		createGameUI.dispose();
	}

	public void userLogged(User user) {
		waitingRoomUI.userLogged(user);
	}

	public void userLeave(String user) {
		waitingRoomUI.userLeave(user);
	}

	public void sendGeneralMessage(String message) {
		gameManager.sendGeneralMessage(message);
	}

	public void receiveGeneralMessage(String sender, String message) {
		waitingRoomUI.receiveMessage(sender, message);
	}

	public void receivePrivateMessage(String sender, String message) {
		waitingRoomUI.receivePrivateMessage(sender, message);

	}

	public void showProfile() {
		profileUI = new ProfileUI(session.getUser());
		waitingRoomUI.setEnabled(false);
	}

	public void closeProfile(boolean save) {
		if (save) {
			sessionManager.saveProfile();
			waitingRoomUI.setAvatar(session.getUser().getAvatar());
		}
		waitingRoomUI.setEnabled(true);
		waitingRoomUI.toFront();
	}

	public void closeConnection() {
		Client.communicator().destroy();
		System.exit(0);
	}

	public void joinGame() {
		waitingRoomUI.setEnabled(false);
		new JoinGameUI();

	}

	public void sendPrivateMessage(String sender, String destinatary,
			String message) throws UserNotLoggedException {
		gameManager.sendPrivateMessage(sender, destinatary, message);

	}

	public void changeName(String name, String lastname) {
		sessionManager.changeName(name, lastname);

	}

	public void changeEmail(String email, String confirmEmail, String password) {
		try {
			sessionManager.changeEmail(email, confirmEmail, password);
		} catch (WrongInputException e) {
			JOptionPane.showMessageDialog(profileUI, e.getMessage(),
					e.getError(), JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		} catch (InvalidLoggingException e) {
			JOptionPane.showMessageDialog(profileUI, "The password is wrong",
					"Incorrect password", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public void changePassword(String password, String newPassword,
			String confirmPassword) {
		try {
			sessionManager.changePassword(password, newPassword,
					confirmPassword);
		} catch (InvalidLoggingException e) {
			JOptionPane.showMessageDialog(profileUI, "The password is wrong",
					"Incorrect password", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public void changeAvatar() {
		sessionManager.changeAvatar();
		waitingRoomUI.setAvatar(session.getUser().getAvatar());
	}

}
