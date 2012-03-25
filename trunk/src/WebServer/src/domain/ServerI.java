package domain;

import java.util.List;

import IClient.ClientPrx;
import IClient.ClientPrxHelper;
import IServer.InvalidLoggingException;
import IServer.UserAlreadyExistsException;
import IServer.UserAlreadyLoggedException;
import IServer.UserNotLoggedException;
import Ice.Communicator;
import Ice.Current;
import Ice.Identity;

public class ServerI extends IServer._ServerDisp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7940671137250949695L;

	public ServerI(Communicator communicator) {

	}

	@Override
	public synchronized void registerUser(String username, String password,
			String email, Current __current) throws UserAlreadyExistsException {
		UsersController.getInstance().registerUser(username, password, email);

	}

	@Override
	public synchronized void loginUser(String username, String password,
			Identity client, Current __current)
			throws UserAlreadyLoggedException, InvalidLoggingException {
		Ice.ObjectPrx base = __current.con.createProxy(client);
		ClientPrx callback = ClientPrxHelper.uncheckedCast(base);
		UsersController.getInstance().loginUser(username, password, callback);
	}
	
	@Override
	public void logoutUser(String username, Current __current)
			throws UserNotLoggedException {
		UsersController.getInstance().logoutUser(username);
	}

	@Override
	public synchronized void sendPrivateMessage(String sender, String destinatary,
			String message, Current __current) {
		MessageController.getInstance().sendPrivateMessage(sender,destinatary,message);
		
	}

	@Override
	public synchronized void sendMessage(String sender, String message, Current __current) {
		MessageController.getInstance().sendMessage(sender,message);
	}

	@Override
	public List<String> chatParticipants(Current __current) {
		return MessageController.getInstance().getParticipants();
	}

}
