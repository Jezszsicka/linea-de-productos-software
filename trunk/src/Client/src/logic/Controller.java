package logic;

import identify.IIdentify;
import identify.Identify;

import java.util.Hashtable;
import java.util.List;

import javax.swing.JOptionPane;
import mailBox.MailBox;
import ludo.LudoUI;
import mailBox.IMailBox;
import model.Filter;
import model.Game;
import model.Session;
import model.User;
import presentation.CreateGameUI;
import presentation.IGame;
import presentation.GameWaitingRoomUI;
import presentation.GamesListUI;
import presentation.LoginUI;
import presentation.MessagesUI;
import presentation.ProfileUI;
import presentation.RegisterUI;
import presentation.WaitingRoomUI;
import register.IRegister;
import register.Register;
import resetPassword.ResetPassword;
import resetPassword.ResetPasswordUI;
import usersInfo.IUsersInfo;
import usersInfo.UsersInfo;
import ProductLine.FullGameException;
import ProductLine.GameAlreadyExistsException;
import ProductLine.GameType;
import ProductLine.InvalidLoggingException;
import ProductLine.Message;
import ProductLine.MessageType;
import ProductLine.NotEnoughPlayersException;
import ProductLine.SlotState;
import ProductLine.UserAlreadyExistsException;
import ProductLine.UserAlreadyLoggedException;
import ProductLine.UserNotExistsException;
import ProductLine.UserNotInGameException;
import ProductLine.UserNotLoggedException;
import chatGeneral.GeneralChat;
import chatGeneral.IGeneralChat;
import checkers.CheckersUI;
import chess.ChessUI;


import configAccount.ConfigAccount;
import configAccount.IConfigAccount;
import connect4.Connect4UI;
import email.IEmail;
import email.MailSender;
import exceptions.WrongInputException;
import friends.Friends;
import friends.IFriends;
import gameChat.GameChat;
import gameChat.IGameChat;
import gamesManagement.GamesManager;
import gamesManagement.IGames;
import goose.GooseUI;

public class Controller {
	public static Controller controller;

	// UI
	private RegisterUI registerUI;
	private ResetPasswordUI resetPasswordUI;
	private LoginUI loginUI;
	private ProfileUI profileUI;
	private WaitingRoomUI waitingRoomUI;
	private MessagesUI messagesUI;
	private CreateGameUI createGameUI;
	private GamesListUI gamesListUI;

	private Hashtable<String, GameWaitingRoomUI> gameWaitingRooms;
	private Hashtable<String, IGame> gamesUI;


	private Session session;
	private LanguageManager language;
	
	private IIdentify identify;
	private IRegister register;
	private IGames gamesManager;
	private IUsersInfo usersInfo;
	private IConfigAccount configAccount;
	private IGeneralChat generalChat;
	private IGameChat gameChat;
	private IMailBox  mailBox;
	private IFriends  friends;
	private IEmail email;
	

	private Controller() {
		usersInfo = new UsersInfo();
		email = new MailSender();
		register = new Register(email);
		identify = new Identify(usersInfo);
		configAccount = new ConfigAccount();
		generalChat = new GeneralChat();
		gameChat = new GameChat();
		friends = new Friends();
		mailBox = new MailBox();
		language = LanguageManager.language();
		loginUI = new LoginUI();
		gameWaitingRooms = new Hashtable<String, GameWaitingRoomUI>();
		gamesUI = new Hashtable<String, IGame>();
	}

	public static void initialize() {
		if (controller == null) {
			controller = new Controller();
		}
	}

	public static Controller getInstance() {
		return controller;
	}

	public void registerUser(User user, String retypedPassword,
			String retypedEmail) {
		try {
			register.registerUser(user, retypedPassword, retypedEmail);
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

	public void showRegisterUI() {
		loginUI.setEnabled(false);
		registerUI = new RegisterUI();
	}

	public void closeRegisterUI() {
		loginUI.setEnabled(true);
		loginUI.toFront();
		registerUI.dispose();
		registerUI = null;
	}

	public void loginUser(String username, String password) {
		try {
			identify.loginUser(username, password);
			session = Session.getInstance();
			language.loadPreferences();
			gamesManager = new GamesManager();
			waitingRoomUI = new WaitingRoomUI(session.getUser(),
					session.getUsers());
			loginUI.dispose();
			loginUI = null;
		} catch (WrongInputException e) {
			JOptionPane.showMessageDialog(registerUI, e.getMessage(),
					e.getError(), JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		} catch (InvalidLoggingException e) {
			JOptionPane.showMessageDialog(registerUI,
					language.getString("InvalidLoggingMessage"),
					language.getString("InvalidLoggingTitle"),
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (UserAlreadyLoggedException e) {
			JOptionPane.showMessageDialog(registerUI, "This account is in use",
					"Account in use", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void logoutUser() {
		identify.logoutUser();
		gamesManager = null;
		waitingRoomUI.dispose();
		waitingRoomUI = null;
		loginUI = new LoginUI();
	}

	public void showCreateGameUI() {
		createGameUI = new CreateGameUI();
		waitingRoomUI.setEnabled(false);
	}

	public void closeCreateGameUI() {
		waitingRoomUI.setEnabled(true);
		waitingRoomUI.toFront();
		createGameUI.dispose();
		createGameUI = null;
	}

	public void userLogged(User user) {
		usersInfo.userLogged(user);
		waitingRoomUI.userLogged(user.getUsername());
	}

	public void userLeave(String user) {
		usersInfo.userLeave(user);
		waitingRoomUI.userLeave(user);
	}

	public void sendGeneralMessage(String message) {
		generalChat.sendGeneralMessage(message);
	}

	public void sendPrivateMessage(String destinatary, String message)
			throws UserNotLoggedException {
		generalChat.sendPrivateMessage(destinatary, message);
	}

	public void sendGameMessage(String game, String message) {
		gameChat.sendGameMessage(game, message);
	}

	public void sendGamePrivateMessage(String game, String destinatary,
			String message) throws UserNotInGameException {
		gameChat.sendGamePrivateMessage(game, destinatary, message);
	}

	public void sendMessage(String to, String subject, String content,
			MessageType type) throws WrongInputException {
		try {
			mailBox.sendMessage(to, subject, content, type);
		} catch (UserNotExistsException e) {
			JOptionPane.showMessageDialog(messagesUI,
					"El destinatario del mensaje no existe",
					"Destinatario erróneo", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void markMessageAsRead(Message message) {
		mailBox.markMessageAsRead(message);

	}

	public void deleteMessage(Message message) {
		mailBox.deleteMessage(message);

	}

	public void receiveGeneralMessage(String sender, String message) {
		waitingRoomUI.receiveMessage(sender, message);
	}

	public void receivePrivateMessage(String sender, String message) {
		waitingRoomUI.receivePrivateMessage(sender, message);

	}

	public void receiveGameMessage(String gameName, String sender,
			String message) {
		Game game = gamesManager.searchGame(gameName);
		if (game.isStarted()) {
			IGame gameUI = gamesUI.get(gameName);
			gameUI.receiveMessage(sender, message);
		} else
			gameWaitingRooms.get(gameName).receiveMessage(sender, message);
	}

	public void receiveGamePrivateMessage(String gameName, String sender,
			String message) {
		Game game = gamesManager.searchGame(gameName);
		if (game.isStarted()) {
			IGame gameUI = gamesUI.get(gameName);
			gameUI.receivePrivateMessage(sender, message);
		} else
			gameWaitingRooms.get(gameName).receivePrivateMessage(sender,
					message);
	}

	public void showProfileUI() {
		profileUI = new ProfileUI(session.getUser());
		waitingRoomUI.setEnabled(false);
	}

	public void closeProfileUI() {
		waitingRoomUI.setEnabled(true);
		waitingRoomUI.toFront();
		profileUI.dispose();
	}

	public void closeConnection() {
		Client.communicator().destroy();
		System.exit(0);
	}

	public void showGamesListUI() {
		waitingRoomUI.setEnabled(false);
		gamesListUI = new GamesListUI();
	}

	public void changeName(String name, String lastname, String password) {
		try {
			configAccount.changeName(name, lastname, password);
			profileUI.closeChangeFrame();
			profileUI.toFront();
		} catch (InvalidLoggingException e) {
			JOptionPane.showMessageDialog(profileUI, "The password is wrong",
					"Incorrect password", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (WrongInputException e) {
			JOptionPane.showMessageDialog(profileUI, e.getMessage(),
					e.getError(), JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}

	}

	public void changeEmail(String email, String confirmEmail, String password) {
		try {
			configAccount.changeEmail(email, confirmEmail, password);
			profileUI.closeChangeFrame();
			profileUI.toFront();
		} catch (WrongInputException e) {
			JOptionPane.showMessageDialog(profileUI, e.getMessage(),
					e.getError(), JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		} catch (InvalidLoggingException e) {
			JOptionPane.showMessageDialog(profileUI, "The password is wrong",
					"Incorrect password", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public void changePassword(String password, String newPassword,
			String confirmPassword) {
		try {
			configAccount.changePassword(password, newPassword,
					confirmPassword);
			profileUI.closeChangeFrame();
			profileUI.toFront();
		} catch (InvalidLoggingException e) {
			JOptionPane.showMessageDialog(profileUI, "The password is wrong",
					"Incorrect password", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (WrongInputException e) {
			JOptionPane.showMessageDialog(profileUI, e.getMessage(),
					e.getError(), JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}

	}

	public void changeAvatar(byte[] avatar) {
		configAccount.changeAvatar(avatar);
		waitingRoomUI.setAvatar(avatar);
	}
	
	public void deleteAccount(String password) {
		try {
			configAccount.deleteAccount(password);
		} catch (InvalidLoggingException e) {
			JOptionPane.showMessageDialog(profileUI, "The password is wrong",
					"Incorrect password", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (WrongInputException e) {
			JOptionPane.showMessageDialog(profileUI, e.getMessage(),
					e.getError(), JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}

	}

	public void closeJoinGameUI() {
		waitingRoomUI.setEnabled(true);
		waitingRoomUI.toFront();
		gamesListUI.dispose();
	}

	public void changeLanguage(int selectedLanguage) {
		LanguageManager.language().setLanguage(session.getUser().getUsername(),
				selectedLanguage);
		waitingRoomUI.languageChanged();
	}



	public void createGame(String gameName, GameType type) {
		try {
			Game game = gamesManager.createGame(gameName, type);
			createGameUI.dispose();
			waitingRoomUI.setEnabled(true);
			gameWaitingRooms.put(game.getName(), new GameWaitingRoomUI(session
					.getUser().getUsername(), game, true));
		} catch (GameAlreadyExistsException e) {
			JOptionPane.showMessageDialog(createGameUI,
					"Please, choose another name for the game",
					"Game already exists", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (WrongInputException e) {
			JOptionPane.showMessageDialog(createGameUI, e.getMessage(),
					e.getError(), JOptionPane.WARNING_MESSAGE);
		}

	}

	public List<ProductLine.Game> listGames(String game, Filter filter) {
		return gamesManager.listGames(game, filter);
	}

	public void deleteGame(String gameName) {
		gamesManager.deleteGame(gameName);
		gameWaitingRooms.remove(gameName);
		waitingRoomUI.toFront();
	}

	public void joinGame(String gameName) {
		try {
			Game game = gamesManager.joinGame(gameName);
			gameWaitingRooms.put(game.getName(), new GameWaitingRoomUI(session
					.getUser().getUsername(), game, false));
			gamesListUI.dispose();
			waitingRoomUI.setEnabled(true);
		} catch (FullGameException e) {
			JOptionPane.showMessageDialog(gamesListUI, "The game is full",
					"Full game", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public void leaveGame(String game) {
		gamesManager.leaveGame(game);
		gameWaitingRooms.remove(game);
	}

	public void userJoinGame(String game, String player) {
		gamesManager.userJoinGame(game, player);
		GameWaitingRoomUI gameUI = gameWaitingRooms.get(game);
		gameUI.userJoinGame(player);

	}

	public void userLeaveGame(String gameName, String player) {
		Game game = gamesManager.searchGame(gameName);

		if (game.getTypeGame() != GameType.Ludo)
			gamesManager.userLeaveGame(gameName, player);

		if (game.isStarted()) {
			IGame gameUI = gamesUI.get(gameName);
			gameUI.userLeaveGame(player);
			if (game.players() <= 1)
				gamesUI.remove(gameName);

			if (game.getTypeGame() == GameType.Ludo)
				gamesManager.userLeaveGame(gameName, player);
			
		} else {
			GameWaitingRoomUI gameUI = gameWaitingRooms.get(gameName);
			gameUI.userLeaveGame(player);
		}
	}

	public User searchUser(String username) {
		if (session.getUser().getUsername().equalsIgnoreCase(username))
			return session.getUser();
		else {
			System.out.println("Buscamos al usuario");
			for (User user : session.getUsers())
				if (user.getUsername().equalsIgnoreCase(username))
					return user;
		}
		return null;

	}

	public void kickedFromGame(String game) {
		JOptionPane.showMessageDialog(gameWaitingRooms.get(game),
				"You haven been kicked from game", "Kicked from game",
				JOptionPane.INFORMATION_MESSAGE);
		gameWaitingRooms.get(game).dispose();
	}

	public void changeSlotState(String gameName, int slot, SlotState slotState) {
		gamesManager.changeSlotState(gameName, slot, slotState);
	}

	public void slotStateChanged(String gameName, int slot, SlotState state) {
		gamesManager.slotStateChanged(gameName, slot, state);
		GameWaitingRoomUI gameWaitingRoomUI = gameWaitingRooms.get(gameName);
		gameWaitingRoomUI.slotStateChanged();
	}

	public void showMessagesUI() {
		messagesUI = new MessagesUI(session.getUser().getMessages());
		waitingRoomUI.setEnabled(false);
	}

	public void closeMessagesUI() {
		messagesUI.dispose();
		messagesUI = null;
		waitingRoomUI.setEnabled(true);
		waitingRoomUI.toFront();

	}

	public void showResetPasswordUI() {
		resetPasswordUI = new ResetPasswordUI();
	}

	public void resetPassword(String identifier) {
		new ResetPassword();
	}

	public void startGame(String game) throws NotEnoughPlayersException {
		gamesManager.startGame(game);
	}

	public void gameStarted(String game) {
		GameWaitingRoomUI gameUI = gameWaitingRooms.get(game);
		gameUI.gameStarted();
	}

	public void closeGameWaitingRoomUI(String gameName) {
		Game game = gamesManager.searchGame(gameName);
		GameWaitingRoomUI gameUI = gameWaitingRooms.get(gameName);
		gameUI.dispose();
		gameWaitingRooms.remove(game.getName());
		game.setStarted(true);
		switch (game.getTypeGame()) {
		case Connect4:
			IGame connect4UI = new Connect4UI(session.getUser().getUsername(),
					game);
			gamesUI.put(gameName, connect4UI);
			break;
		case Checkers:
			IGame checkersUI = new CheckersUI(session.getUser().getUsername(),
					game);
			gamesUI.put(gameName, checkersUI);
			break;
		case Chess:
			IGame chessUI = new ChessUI(session.getUser().getUsername(), game);
			gamesUI.put(gameName, chessUI);
			break;
		case Goose:
			IGame gooseUI = new GooseUI(session.getUser().getUsername(), game);
			gamesUI.put(gameName, gooseUI);
			break;
		case Ludo:
			IGame ludoUI = new LudoUI(session.getUser().getUsername(), game);
			gamesUI.put(gameName, ludoUI);
		}
	}

	public void gameUpdated(String gameName, int[][] board, int nextTurn) {
		IGame gameUI = gamesUI.get(gameName);
		gamesManager.gameUpdated(gameName, board);
		gameUI.updateBoard(nextTurn);
	}

	public void diceGameUpdated(String gameName, int nextTurn, int[][] board,
			int fromSquare, int dice, int movedPiece) {
		LudoUI gameUI = (LudoUI) gamesUI.get(gameName);
		gamesManager.gameUpdated(gameName, nextTurn, board);
		gameUI.updateBoard(fromSquare, dice, movedPiece);

	}

	public void updateGame(String gameName) {
		gamesManager.updateGame(gameName);
	}

	public void updateDiceGame(String gameName, int fromSquare, int dice,
			int piece) {
		gamesManager.updateDiceGame(gameName, fromSquare, dice, piece);
	}

	public void gameFinished(String game) {
		IGame gameUI = gamesUI.get(game);
		gamesManager.finishGame(game);
		gameUI.lostGame();
	}

	public void finishGame(String game, String winnerPlayer) {
		gamesManager.finishGame(game, winnerPlayer);
	}


	public void friendRequestResponse(String friend, boolean accepted) {
		friends.friendRequestResponse(friend, accepted);
		if (accepted)
			waitingRoomUI.refreshFriendList();
	}

	public User userInfo(String username) {
		User user = null;
		try {
			user = usersInfo.userInfo(username);
		} catch (UserNotExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;

	}

}
