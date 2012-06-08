package logic;

import javax.swing.JOptionPane;

import model.Game;
import model.Session;
import presentation.CreateGameUI;
import presentation.JoinGameUI;
import presentation.LoginUI;
import presentation.ProfileUI;
import presentation.RegisterUI;
import presentation.WaitingRoomUI;
import ProductLine.GameType;
import ProductLine.InvalidLoggingException;
import ProductLine.User;
import ProductLine.UserAlreadyExistsException;
import ProductLine.UserAlreadyLoggedException;
import ProductLine.UserNotLoggedException;

import communications.Client;

import exceptions.WrongInputException;

public class Controller {
	public static Controller controller;

	private RegisterUI registerUI;
	private LoginUI loginUI;
	private ProfileUI profileUI;
	private WaitingRoomUI waitingRoomUI;
	private CreateGameUI createGameUI;
	private JoinGameUI joinGameUI;
	

	private Session session;
	private SessionManager sessionManager;
	private GamesManager gameManager;
	private LanguageManager language;

	private Controller() {
		language = LanguageManager.language();
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

	public void showRegisterUI() {
		loginUI.setEnabled(false);
		registerUI = new RegisterUI();
	}

	public void closeRegisterUI() {
		loginUI.setEnabled(true);
		loginUI.toFront();
		registerUI.dispose();
		registerUI = null;
	}

	public void loginUser(String username, String password) {
		try {
			session = sessionManager.loginUser(username, password);
			language.loadPreferences(session.getUser());
			gameManager = new GamesManager(session);
			waitingRoomUI = new WaitingRoomUI(session.getUser(), session.getUsers());
			loginUI.dispose();
			loginUI = null;
		} catch (WrongInputException e) {
			JOptionPane.showMessageDialog(registerUI, e.getMessage(),
					e.getError(), JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		} catch (InvalidLoggingException e) {
			JOptionPane.showMessageDialog(registerUI,
					language.getString("InvalidLoggingMessage"), language.getString("InvalidLoggingTitle"),
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
			waitingRoomUI = null;
			loginUI = new LoginUI();
		} catch (UserNotLoggedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showCreateGameUI() {
		createGameUI = new CreateGameUI();
		waitingRoomUI.setEnabled(false);
	}

	public void closeCreateGameUI() {
		waitingRoomUI.setEnabled(true);
		waitingRoomUI.toFront();
		createGameUI.dispose();
		createGameUI = null;
	}

	public void userLogged(User user) {
		sessionManager.userLogged(user);
		waitingRoomUI.userLogged(user.getUsername());
	}

	public void userLeave(String user) {
		sessionManager.userLeave(user);
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

	public void showProfileUI() {
		profileUI = new ProfileUI(session.getUser());
		waitingRoomUI.setEnabled(false);
	}

	public void closeProfileUI() {
		waitingRoomUI.setEnabled(true);
		waitingRoomUI.toFront();
		profileUI.dispose();
	}

	public void closeConnection() {
		Client.communicator().destroy();
		System.exit(0);
	}

	public void showJoinGameUI() {
		waitingRoomUI.setEnabled(false);
		joinGameUI = new JoinGameUI();

	}

	public void sendPrivateMessage(String sender, String destinatary,
			String message) throws UserNotLoggedException {
		gameManager.sendPrivateMessage(sender, destinatary, message);

	}

	public void changeName(String name, String lastname, String password) {
		try {
			sessionManager.changeName(name, lastname, password);
			profileUI.closeChangeFrame();
		} catch (InvalidLoggingException e) {
			JOptionPane.showMessageDialog(profileUI, "The password is wrong",
					"Incorrect password", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (WrongInputException e) {
			JOptionPane.showMessageDialog(profileUI, e.getMessage(),
					e.getError(), JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}

	}

	public void changeEmail(String email, String confirmEmail, String password) {
		try {
			sessionManager.changeEmail(email, confirmEmail, password);
			profileUI.closeChangeFrame();
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
			profileUI.closeChangeFrame();
		} catch (InvalidLoggingException e) {
			JOptionPane.showMessageDialog(profileUI, "The password is wrong",
					"Incorrect password", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (WrongInputException e) {
			JOptionPane.showMessageDialog(profileUI, e.getMessage(),
					e.getError(), JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}

	}

	public void changeAvatar(byte[] avatar) {
		sessionManager.changeAvatar(avatar);
		waitingRoomUI.setAvatar(avatar);
	}

	public void closeJoinGameUI() {
		waitingRoomUI.setEnabled(true);
		waitingRoomUI.toFront();
		joinGameUI.dispose();
	}

	public void changeLanguage(int selectedLanguage) {
		LanguageManager.language().setLanguage(session.getUser().getUsername(),selectedLanguage);
		waitingRoomUI.languageChanged();
	}

	public void deleteAccount(String password) {
		try {
			sessionManager.deleteAccount(password);
		} catch (InvalidLoggingException e) {
			JOptionPane.showMessageDialog(profileUI, "The password is wrong",
					"Incorrect password", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (WrongInputException e) {
			JOptionPane.showMessageDialog(profileUI, e.getMessage(),
					e.getError(), JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		
	}

	public void createGame(String gameName, GameType type) {
		session.getProxy().createGame(session.getUser().getUsername(), gameName, type);
	}

}
