package domain;

import communications.Client;
import communications.ServerProxy;
import IServer.InvalidLoggingException;
import IServer.UserAlreadyExistsException;
import IServer.UserAlreadyLoggedException;
import Ice.Identity;
import presentation.LoginUIController;
import presentation.RegisterUIController;

public class UserController {
	private static UserController controller;
	private Identity callback;
	private LoginUIController loginUIController;
	private RegisterUIController registerUIController;
	
	private UserController(){
		loginUIController = new LoginUIController();
	}
	
	public static void initialize() {
		if(controller == null)
			controller = new UserController();
		
	}
	
	public static UserController getInstance(){
		return controller;
	}
	
	public void loginUser(String username, String password) throws InvalidLoggingException, UserAlreadyLoggedException{
		Client.initializeCallback();
		ServerProxy.getProxy().loginUser(username, password, callback);
		loginUIController.close();
		GamesController.initialize();
	}

	public void registerUser(String username, String password, String email) throws UserAlreadyExistsException {
			ServerProxy.getProxy().registerUser(username, password, email);
			loginUIController.activate();
			registerUIController.close();
	}

	public void startRegister() {
		registerUIController = new RegisterUIController();
	}

	public void cancelRegister() {
		loginUIController.activate();
		registerUIController.close();
	}

	/**
	 * @return the callback
	 */
	public Identity getCallback() {
		return callback;
	}

	/**
	 * @param callback the callback to set
	 */
	public void setCallback(Identity callback) {
		this.callback = callback;
	}
	
	
}
