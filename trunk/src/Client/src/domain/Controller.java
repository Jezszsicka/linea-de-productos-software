package domain;

import javax.swing.JOptionPane;

import ProductLine.InvalidLoggingException;
import ProductLine.UserAlreadyExistsException;
import ProductLine.UserAlreadyLoggedException;
import ProductLine.UserNotLoggedException;

import model.Session;
import presentation.CreateGameUI;
import presentation.LoginUI;
import presentation.ProfileUI;
import presentation.RegisterUI;
import presentation.WaitingRoomUI;

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

	public static void initialize (){
		if( controller == null){
			controller = new Controller();
		}	
	}
	
	public static Controller getInstance() {
		return controller;
	}

	public void registerUser(String username, String password,
			String retypedPassword, String email, String retypedEmail) {
		try {
			sessionManager.registerUser(username, password, retypedPassword,
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
			session = sessionManager.loginUser(username, password);
			gameManager = new GamesManager(session);
			waitingRoomUI = new WaitingRoomUI(session.getUser().getUsername(),session.getProxy().listUsers());
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
		profileUI = new ProfileUI(session.getUser());
		waitingRoomUI.setEnabled(false);
	}
	
	public void closeProfile(boolean save) {
		if(save){
			sessionManager.saveProfile();
		}
		waitingRoomUI.setEnabled(true);
	}
	
	public void closeConnection() {
		Client.communicator().destroy();
		System.exit(0);
	}

	

}
