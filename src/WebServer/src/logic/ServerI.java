package logic;

import java.util.List;

import Ice.Current;
import Ice.Identity;
import ProductLine.ClientPrx;
import ProductLine.ClientPrxHelper;
import ProductLine.Game;
import ProductLine.GameAlreadyExistsException;
import ProductLine.GameType;
import ProductLine.InvalidLoggingException;
import ProductLine.User;
import ProductLine.UserAlreadyExistsException;
import ProductLine.UserAlreadyLoggedException;
import ProductLine.UserNotInGameException;
import ProductLine.UserNotLoggedException;
import ProductLine._ServerDisp;

@SuppressWarnings("serial")
public class ServerI extends _ServerDisp{


	@Override
	public synchronized void registerUser(User user, Current __current) throws UserAlreadyExistsException {
		UsersController.getInstance().registerUser((model.User)user);

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
		MessagesController.getInstance().sendPrivateMessage(sender,destinatary,message);
		
	}


	@Override
	public void sendGameMessage(String game, String sender, String message,
			Current __current) {
		MessagesController.getInstance().sendGameMessage(game,sender,message);
		
	}

	@Override
	public void sendGeneralMessage(String sender, String message,
			Current __current) {
		MessagesController.getInstance().sendGeneralMessage(sender,message);
	}
	
	@Override
	public void sendGamePrivateMessage(String game, String sender,
			String destinatary, String message, Current __current) throws UserNotInGameException {
		MessagesController.getInstance().sendGamePrivateMessage(game,sender,destinatary,message);
	}	

	@Override
	public List<User> listUsers(String username,Current __current) {
		return UsersController.getInstance().listUsers(username);
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

	@Override
	public void changeName(String username, String name, String lastname,
			String password, Current __current) throws InvalidLoggingException {
		UsersController.getInstance().changeName(username, name, lastname,password);
		
	}

	@Override
	public void deleteAccount(String username, String password,
			Current __current) throws InvalidLoggingException {
		UsersController.getInstance().deleteAccount(username,password);
		
	}

	@Override
	public void createGame(String gameName,String creator, GameType type, Current __current) throws GameAlreadyExistsException {
		GamesController.getInstance().createGame(gameName,creator,type);
	}

	@Override
	public Game joinGame(String game, String player, Current __current) {
		return GamesController.getInstance().joinGame(game,player);
		
	}

	@Override
	public List<Game> listGames(String user,Current __current) {
		return GamesController.getInstance().listGames(user);
	}

	@Override
	public void deleteGame(String game, String creator, Current __current) {
		GamesController.getInstance().deleteGame(game,creator);	
	}

	@Override
	public void kickPlayer(String game, String player, Current __current) {
		GamesController.getInstance().kickPlayer(game,player);
		
	}

}
