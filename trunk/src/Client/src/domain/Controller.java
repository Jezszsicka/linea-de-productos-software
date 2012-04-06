package domain;

import java.util.List;

import presentation.LoginUIController;
import presentation.RegisterUIController;

import IServer.InvalidLoggingException;
import IServer.UserAlreadyExistsException;
import IServer.UserAlreadyLoggedException;
import IServer.UserNotLoggedException;
import IServer._ServerOperationsNC;
import Ice.Identity;

public class Controller implements _ServerOperationsNC {
	private LoginUIController loginUIController;
	private RegisterUIController registerUIController;
	
	
	
	@Override
	public void registerUser(String username, String password, String email)
			throws UserAlreadyExistsException {
		
		
	}

	@Override
	public void loginUser(String username, String password, Identity client)
			throws InvalidLoggingException, UserAlreadyLoggedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logoutUser(String username) throws UserNotLoggedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendPrivateMessage(String sender, String destinatary,
			String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMessage(String sender, String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> chatParticipants() {
		// TODO Auto-generated method stub
		return null;
	}

}
