package domain;

import javax.swing.JOptionPane;

import presentation.CreateGameUI;
import presentation.LoginUI;
import presentation.RegisterUI;
import presentation.WaitingRoomUI;
import IServer.InvalidLoggingException;
import IServer.UserAlreadyExistsException;
import IServer.UserAlreadyLoggedException;
import IServer.UserNotLoggedException;
import exceptions.WrongInputException;

public class Facade {
	public static Facade facade;

	private LoginUI loginUI;
	private RegisterUI registerUI;
	private WaitingRoomUI waitingRoomUI;
	private CreateGameUI createGameUI;

	private SessionManager userManager;
	private GamesManager gameManager;

	private Facade() {
		loginUI = new LoginUI();
		userManager = SessionManager.getInstance();
	}

	public static void initialize() {
		if (facade == null)
			facade = new Facade();
	}

	public static Facade getInstance() {
		return facade;
	}

	public void registerUser(String username, String password,
			String retypedPassword, String email, String retypedEmail) {
		try {
			userManager.registerUser(username, password, retypedPassword,
					email, retypedEmail);
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
			userManager.loginUser(username, password);
			gameManager = new GamesManager();
			waitingRoomUI = new WaitingRoomUI();
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
			userManager.logoutUser();
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
		createGameUI.dispose();
	}

	public void userLogged(String user) {
		waitingRoomUI.userLogged(user);
	}
	
	public void userLeave(String user){
		waitingRoomUI.userLeave(user);
	}

	public void sendGeneralMessage(String message) {
		gameManager.sendGeneralMessage(message);
	}
	
	public void receiveGeneralMessage(String sender, String message){
		waitingRoomUI.receiveMessage(sender,message);
	}





}
