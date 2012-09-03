package communications;

import email.IEmail;
import email.MailSender;
import filterGames.IList;
import filterGames.GamesFilter;
import friends.Friends;
import friends.IFriends;
import generalChat.IGeneralChat;
import generalChat.GeneralChat;

import gameChat.IGameChat;
import gameChat.GameChat;
import gamesManagement.IGames;
import gamesManagement.GamesManager;

import identify.IIdentify;
import identify.UsersManager;

import java.util.List;

import configAccount.ConfigAccount;
import configAccount.IConfigAccount;

import rankings.IRankings;
import rankings.Rankings;
import register.IRegister;
import register.Register;
import resetPassword.IResetPassword;
import resetPassword.ResetPassword;
import usersInfo.IUsersInfo;
import usersInfo.UsersInfo;


import mailBox.IMailBox;
import mailBox.MailBox;

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
public class ServerI extends _ServerDisp {

	private IIdentify identify;
	private IRegister register;
	private IGeneralChat generalChat;
	private IGameChat gameChat;
	private IResetPassword resetPassword;
	private IConfigAccount configAccount;
	private IMailBox mailBox;
	private IFriends friends;
	private IEmail mailSender;
	private IUsersInfo usersInfo;
	private IGames gamesManagement;
	private IList gamesFilter;
	private IRankings rankings;

	public ServerI() {
		super();
		identify = new UsersManager();
		register = new Register();
		rankings = new Rankings();
		gamesManagement = new GamesManager(rankings);
		generalChat = new GeneralChat();
		mailSender = new MailSender();
		configAccount = new ConfigAccount();
		friends = new Friends();
		usersInfo = new UsersInfo();
		resetPassword = new ResetPassword(mailSender);
		mailBox = new MailBox(mailSender);
		gameChat = new GameChat(gamesManagement);
		gamesFilter = new GamesFilter(gamesManagement);
	}

	@Override
	public void registerUser(User user, Current __current)
			throws UserAlreadyExistsException {
		register.registerUser((model.User) user);
	}

	@Override
	public User loginUser(String username, String password, Identity client,
			Current __current) throws InvalidLoggingException,
			UserAlreadyLoggedException {
		Ice.ObjectPrx base = __current.con.createProxy(client);
		ClientPrx callback = ClientPrxHelper.uncheckedCast(base);
		return identify.loginUser(username, password, callback);
	}

	@Override
	public void logoutUser(String username, Current __current) {
		identify.logoutUser(username);
	}

	@Override
	public void sendGeneralMessage(String sender, String message,
			Current __current) {
		generalChat.sendGeneralMessage(sender, message);
	}

	@Override
	public void sendPrivateMessage(String sender, String receiver,
			String message, Current __current) throws UserNotLoggedException {
		generalChat.sendPrivateMessage(sender, receiver, message);

	}

	@Override
	public void sendGameMessage(String game, String sender, String message,
			Current __current) {
		gameChat.sendGameMessage(game, sender, message);

	}

	@Override
	public void sendGamePrivateMessage(String game, String sender,
			String receiver, String message, Current __current)
			throws UserNotInGameException {
		gameChat.sendGamePrivateMessage(game, sender, receiver, message);
	}

	@Override
	public void changeEmail(String username, String email, String password,
			Current __current) throws InvalidLoggingException {
		configAccount.changeEmail(username, email, password);

	}

	@Override
	public void changePassword(String username, String password,
			String newPassword, Current __current)
			throws InvalidLoggingException {
		configAccount.changePassword(username, password, newPassword);

	}

	@Override
	public void changeAvatar(String username, byte[] avatar, Current __current) {
		configAccount.changeAvatar(username, avatar);

	}

	@Override
	public void changeName(String username, String name, String lastname,
			String password, Current __current) throws InvalidLoggingException {
		configAccount.changeName(username, name, lastname, password);

	}

	@Override
	public void deleteAccount(String username, String password,
			Current __current) throws InvalidLoggingException {
		configAccount.deleteAccount(username, password);

	}

	@Override
	public List<User> listUsers(String username, Current __current) {
		return usersInfo.listUsers(username);
	}

	@Override
	public void createGame(String gameName, String creator, GameType type,
			Current __current) throws GameAlreadyExistsException {
		gamesManagement.createGame(gameName, creator, type);
	}

	@Override
	public Game joinGame(String game, String player, Current __current)
			throws FullGameException {
		return gamesManagement.joinGame(game, player);
	}

	@Override
	public List<Game> listGames(String user, String gameName,
			Filter gamesFilter, Current __current) {
		return this.gamesFilter.listGames(user, gameName, gamesFilter);
	}

	@Override
	public void deleteGame(String game, String creator, Current __current) {
		gamesManagement.deleteGame(game, creator);
	}

	@Override
	public void kickPlayer(String game, String player, Current __current) {
		// gamesManagement.kickPlayer(game,player);

	}

	@Override
	public void leaveGame(String game, String player, Current __current) {
		gamesManagement.leaveGame(game, player);

	}

	@Override
	public void changeSlotState(String game, int slot, SlotState state,
			Current __current) {
		gamesManagement.changeSlotState(game, slot, state);
	}

	@Override
	public void startGame(String game, Current __current) {
		gamesManagement.startGame(game);

	}

	@Override
	public void updateGame(String game, String player, int nextTurn,
			int[][] board, Current __current) {
		gamesManagement.updateGame(game, player, nextTurn, board);

	}

	@Override
	public void updateDiceGame(String game, String player, int nextTurn,
			int[][] board, int fromSquare, int dice, int movedPiece,
			Current __current) {
		gamesManagement.updateDiceGame(game, player, nextTurn, board,
				fromSquare, dice, movedPiece);
	}

	@Override
	public void finishGame(String game, String player, Current __current) {
		gamesManagement.finishGame(game, player);
	}

	@Override
	public void sendMessage(Message msg, Current __current)
			throws UserNotExistsException {
		mailBox.sendMessage(msg);
	}

	@Override
	public void deleteMessage(String user, int messageID, Current __current) {
		mailBox.deleteMessage(user, messageID);

	}

	@Override
	public void markMessageAsRead(String user, int messageID, Current __current) {
		mailBox.markMessageAsRead(user, messageID);

	}

	@Override
	public void resetPassword(String identifier, Current __current)
			throws InvalidLoggingException {
		resetPassword.resetPassword(identifier);
	}

	@Override
	public void friendRequestResponse(String friend, String user,
			boolean accepted, Current __current) throws UserNotExistsException {
		friends.friendRequestResponse(friend, user, accepted);
	}

	@Override
	public User userInfo(String username, Current __current)
			throws UserNotExistsException {
		return usersInfo.userInfo(username);
	}

}
