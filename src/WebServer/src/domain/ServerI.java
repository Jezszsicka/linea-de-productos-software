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
	public synchronized void registerUser(User user, Current __current) throws UserAlreadyExistsException {
		UsersController.getInstance().registerUser(user);

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
			String message, Current __current) throws UserNotLoggedException {
		UsersController.getInstance().sendPrivateMessage(sender,destinatary,message);
		
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
	public List<User> listUsers(String username,Current __current) {
		return UsersController.getInstance().listUsers(username);
	}

	@Override
	public void saveProfile(User profile, Current __current) {
		UsersController.getInstance().saveProfile(profile);
		
	}

	@Override
	public void changeName(String username, String name, String lastname,
			Current __current) {
		UsersController.getInstance().changeName(username,name,lastname);
		
	}

	@Override
	public void changeEmail(String username, String email, String password,
			Current __current) throws InvalidLoggingException {
		UsersController.getInstance().changeEmail(username,email,password);
		
	}

	@Override
	public void changePassword(String username, String password,
			String newPassword, Current __current)
			throws InvalidLoggingException {
		UsersController.getInstance().changePassword(username,password,newPassword);
		
	}

	@Override
	public void changeAvatar(String username, byte[] avatar, Current __current) {
		UsersController.getInstance().changeAvatar(username,avatar);
		
	}	

}
