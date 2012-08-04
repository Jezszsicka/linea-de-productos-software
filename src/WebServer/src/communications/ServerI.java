package communications;

import java.util.List;

import logic.GamesManager;
import logic.MessagesManager;
import logic.UsersManager;

import Ice.Current;
import Ice.Identity;
import ProductLine.ClientPrx;
import ProductLine.ClientPrxHelper;
import ProductLine.Filter;
import ProductLine.FullGameException;
import ProductLine.Game;
import ProductLine.GameAlreadyExistsException;
import ProductLine.GameType;
import ProductLine.InvalidLoggingException;
import ProductLine.Message;
import ProductLine.SlotState;
import ProductLine.User;
import ProductLine.UserAlreadyExistsException;
import ProductLine.UserAlreadyLoggedException;
import ProductLine.UserNotExistsException;
import ProductLine.UserNotInGameException;
import ProductLine.UserNotLoggedException;
import ProductLine._ServerDisp;

@SuppressWarnings("serial")
public class ServerI extends _ServerDisp{


	@Override
	public void registerUser(User user, Current __current) throws UserAlreadyExistsException {
		UsersManager.getInstance().registerUser((model.User)user);
	}

	@Override
	public User loginUser(String username, String password,
			Identity client, Current __current)
			throws UserAlreadyLoggedException, InvalidLoggingException {
		Ice.ObjectPrx base = __current.con.createProxy(client);
		ClientPrx callback = ClientPrxHelper.uncheckedCast(base);
		return UsersManager.getInstance().loginUser(username, password, callback);
	}
	
	@Override
	public void logoutUser(String username, Current __current) {
		UsersManager.getInstance().logoutUser(username);
	}

	@Override
	public void sendGeneralMessage(String sender, String message,
			Current __current) {
		MessagesManager.getInstance().sendGeneralMessage(sender,message);
	}
	
	
	@Override
	public void sendPrivateMessage(String sender, String receiver,
			String message, Current __current) throws UserNotLoggedException {
		MessagesManager.getInstance().sendPrivateMessage(sender,receiver,message);
		
	}
	
	@Override
	public void sendGameMessage(String game, String sender, String message,
			Current __current) {
		MessagesManager.getInstance().sendGameMessage(game,sender,message);
		
	}
	
	@Override
	public void sendGamePrivateMessage(String game, String sender,
			String receiver, String message, Current __current) throws UserNotInGameException {
		MessagesManager.getInstance().sendGamePrivateMessage(game,sender,receiver,message);
	}	

	@Override
	public void changeEmail(String username, String email, String password,
			Current __current) throws InvalidLoggingException {
		UsersManager.getInstance().changeEmail(username,email,password);
		
	}

	@Override
	public void changePassword(String username, String password,
			String newPassword, Current __current)
			throws InvalidLoggingException {
		UsersManager.getInstance().changePassword(username,password,newPassword);
		
	}

	@Override
	public void changeAvatar(String username, byte[] avatar, Current __current) {
		UsersManager.getInstance().changeAvatar(username,avatar);
		
	}

	@Override
	public void changeName(String username, String name, String lastname,
			String password, Current __current) throws InvalidLoggingException {
		UsersManager.getInstance().changeName(username, name, lastname,password);
		
	}

	@Override
	public void deleteAccount(String username, String password,
			Current __current) throws InvalidLoggingException {
		UsersManager.getInstance().deleteAccount(username,password);
		
	}

	@Override
	public List<User> listUsers(String username,Current __current) {
		return UsersManager.getInstance().listUsers(username);
	}
	
	@Override
	public void createGame(String gameName,String creator, GameType type, Current __current) throws GameAlreadyExistsException {
		GamesManager.getInstance().createGame(gameName,creator,type);
	}

	@Override
	public Game joinGame(String game, String player, Current __current) throws FullGameException {
		return GamesManager.getInstance().joinGame(game,player);
		
	}

	@Override
	public List<Game> listGames(String user, String gameName,
			Filter gamesFilter, Current __current) {
		return GamesManager.getInstance().listGames(user,gameName,gamesFilter);
	}

	@Override
	public void deleteGame(String game, String creator, Current __current) {
		GamesManager.getInstance().deleteGame(game,creator);	
	}

	@Override
	public void kickPlayer(String game, String player, Current __current) {
		GamesManager.getInstance().kickPlayer(game,player);
		
	}

	@Override
	public void leaveGame(String game, String player, Current __current) {
		GamesManager.getInstance().leaveGame(game,player);
		
	}

	@Override
	public void changeSlotState(String game, int slot, SlotState state,
			Current __current) {
		GamesManager.getInstance().changeSlotState(game,slot,state);
	}

	@Override
	public void sendMessage(Message msg, Current __current) throws UserNotExistsException {
		MessagesManager.getInstance().sendMessage(msg);
	}

	@Override
	public void resetPassword(String identifier, Current __current) throws InvalidLoggingException {
		UsersManager.getInstance().resetPassword(identifier);
	}

	@Override
	public void startGame(String game, Current __current) {
		GamesManager.getInstance().startGame(game);
		
	}

	@Override
	public void updateGame(String game, String player,int nextTurn, int[][] board,
			Current __current) {
		GamesManager.getInstance().updateGame(game,player,nextTurn,board);
		
	}

	@Override
	public void updateDiceGame(String game, String player, int nextTurn,
			int[][] board,int fromSquare, int dice, int movedPiece, Current __current) {
		GamesManager.getInstance().updateDiceGame(game,player,nextTurn,board,fromSquare,dice,movedPiece);
	}
	
	@Override
	public void finishGame(String game, String player, Current __current) {
		GamesManager.getInstance().finishGame(game,player);
	}

	@Override
	public void deleteMessage(String user,int messageID, Current __current) {
		MessagesManager.getInstance().deleteMessage(user,messageID);
		
	}

	@Override
	public void markMessageAsRead(String user,int messageID, Current __current) {
		MessagesManager.getInstance().markMessageAsRead(user,messageID);
		
	}

	@Override
	public void friendRequestResponse(String friend, String user,
			boolean accepted, Current __current) throws UserNotExistsException {
		MessagesManager.getInstance().friendRequestResponse(friend,user,accepted);
		
	}

	@Override
	public User userInfo(String username, Current __current)
			throws UserNotExistsException {
		return UsersManager.getInstance().userInfo(username);
	}


}
