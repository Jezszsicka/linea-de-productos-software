package domain;

import javax.swing.JOptionPane;

import model.Session;
import presentation.CreateGameUI;
import presentation.LoginUI;
import presentation.ProfileUI;
import presentation.RegisterUI;
import presentation.WaitingRoomUI;
import IServer.InvalidLoggingException;
import IServer.UserAlreadyExistsException;
import IServer.UserAlreadyLoggedException;
import IServer.UserNotLoggedException;

import communications.ConnectionController;

import exceptions.WrongInputException;

public class Controller {
	public static Controller controller;

	private LoginUI loginUI;
	private RegisterUI registerUI;
	private WaitingRoomUI waitingRoomUI;
	private CreateGameUI createGameUI;
	private ProfileUI profileUI;
	
	private Session session;
	private SessionManager userManager;
	private GamesManager gameManager;
	private ConnectionController connection;
	
	private Controller() {
		loginUI = new LoginUI();
		connection = new ConnectionController();
		userManager = new SessionManager();

	}

	public static Controller getInstance() {
		if( controller == null){
			controller = new Controller();
		}
		return controller;
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
			session = userManager.loginUser(username, password);
			connection.startSession();
			gameManager = new GamesManager(session);
			waitingRoomUI = new WaitingRoomUI(session.getUsername(),session.getProxy().listUsers());
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

	public void showProfile() {
		profileUI = new ProfileUI();
	}
	
	public void closeConnection() {
		connection.stopConnection();
		System.exit(0);
	}

	public static void main(String[] args){
		Controller.getInstance();
	}



}
