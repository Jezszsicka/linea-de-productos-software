package domain;

import java.util.List;
import Ice.Current;
import Ice.Identity;
import ProductLine.ClientPrx;
import ProductLine.ClientPrxHelper;
import ProductLine.InvalidLoggingException;
import ProductLine.User;
import ProductLine.UserAlreadyExistsException;
import ProductLine.UserAlreadyLoggedException;
import ProductLine.UserNotLoggedException;
import ProductLine._ServerDisp;

@SuppressWarnings("serial")
public class ServerI extends _ServerDisp{


	@Override
	public synchronized void registerUser(String username, String password,
			String email, Current __current) throws UserAlreadyExistsException {
		UsersController.getInstance().registerUser(username, password, email);

	}

	@Override
	public synchronized User loginUser(String username, String password,
			Identity client, Current __current)
			throws UserAlreadyLoggedException, InvalidLoggingException {
		Ice.ObjectPrx base = __current.con.createProxy(client);
		ClientPrx callback = ClientPrxHelper.uncheckedCast(base);
		return UsersController.getInstance().loginUser(username, password, callback);
	}
	
	@Override
	public void logoutUser(String username, Current __current)
			throws UserNotLoggedException {
		UsersController.getInstance().logoutUser(username);
	}

	@Override
	public synchronized void sendPrivateMessage(String sender, String destinatary,
			String message, Current __current) {
		
		
	}


	@Override
	public void sendGameMessage(String game, String sender, String message,
			Current __current) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendGeneralMessage(String sender, String message,
			Current __current) {
		UsersController.getInstance().sendGeneralMessage(sender, message);
		
	}

	@Override
	public List<String> listUsers(Current __current) {
		return UsersController.getInstance().listUsers();
	}	

}
