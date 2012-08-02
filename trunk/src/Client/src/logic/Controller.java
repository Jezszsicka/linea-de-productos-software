package logic;

import java.util.Hashtable;
import java.util.List;

import javax.swing.JOptionPane;

import ludo.LudoUI;
import model.Filter;
import model.Game;
import model.Session;
import model.User;
import presentation.CreateGameUI;
import presentation.GameUI;
import presentation.GameWaitingRoomUI;
import presentation.JoinGameUI;
import presentation.LoginUI;
import presentation.MessagesUI;
import presentation.ProfileUI;
import presentation.RegisterUI;
import presentation.ResetPasswordUI;
import presentation.WaitingRoomUI;
import ProductLine.FullGameException;
import ProductLine.GameAlreadyExistsException;
import ProductLine.GameType;
import ProductLine.InvalidLoggingException;
import ProductLine.NotEnoughPlayersException;
import ProductLine.SlotState;
import ProductLine.UserAlreadyExistsException;
import ProductLine.UserAlreadyLoggedException;
import ProductLine.UserNotInGameException;
import ProductLine.UserNotLoggedException;
import checkers.CheckersUI;
import chess.ChessUI;

import communications.Client;

import connect4.Connect4UI;
import exceptions.WrongInputException;
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
	private JoinGameUI joinGameUI;

	private Hashtable<String, GameWaitingRoomUI> gameWaitingRooms;
	private Hashtable<String, GameUI> gamesUI;

	// Managers
	private Session session;
	private SessionManager sessionManager;
	private GamesManager gamesManager;
	private LanguageManager language;
	private MessagesManager messagesManager;

	private Controller() {
		language = LanguageManager.language();
		loginUI = new LoginUI();
		sessionManager = new SessionManager();
		gameWaitingRooms = new Hashtable<String, GameWaitingRoomUI>();
		gamesUI = new Hashtable<String, GameUI>();
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
			sessionManager.registerUser(user, retypedPassword, retypedEmail);
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
			session = sessionManager.loginUser(username, password);
			language.loadPreferences(session.getUser());
			gamesManager = new GamesManager(session);
			messagesManager = new MessagesManager(session);
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
		sessionManager.logoutUser();
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
		sessionManager.userLogged(user);
		waitingRoomUI.userLogged(user.getUsername());
	}

	public void userLeave(String user) {
		sessionManager.userLeave(user);
		waitingRoomUI.userLeave(user);
	}

	public void sendGeneralMessage(String message) {
		messagesManager.sendGeneralMessage(message);
	}

	public void sendPrivateMessage(String destinatary, String message)
			throws UserNotLoggedException {
		messagesManager.sendPrivateMessage(destinatary, message);
	}

	public void sendGameMessage(String game, String message) {
		messagesManager.sendGameMessage(game, message);
	}

	public void sendGamePrivateMessage(String game, String destinatary,
			String message) throws UserNotInGameException {
		messagesManager.sendGamePrivateMessage(game, destinatary, message);
	}

	public void sendMessage(String to, String subject, String content)
			throws WrongInputException {
		messagesManager.sendMessage(to, subject, content);
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
			GameUI gameUI = gamesUI.get(gameName);
			gameUI.receiveMessage(sender, message);
		} else
			gameWaitingRooms.get(gameName).receiveMessage(sender, message);
	}

	public void receiveGamePrivateMessage(String gameName, String sender,
			String message) {
		Game game = gamesManager.searchGame(gameName);
		if (game.isStarted()) {
			GameUI gameUI = gamesUI.get(gameName);
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

	public void showJoinGameUI() {
		waitingRoomUI.setEnabled(false);
		joinGameUI = new JoinGameUI();
	}

	public void changeName(String name, String lastname, String password) {
		try {
			sessionManager.changeName(name, lastname, password);
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
			sessionManager.changeEmail(email, confirmEmail, password);
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
			sessionManager.changePassword(password, newPassword,
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
		sessionManager.changeAvatar(avatar);
		waitingRoomUI.setAvatar(avatar);
	}

	public void closeJoinGameUI() {
		waitingRoomUI.setEnabled(true);
		waitingRoomUI.toFront();
		joinGameUI.dispose();
	}

	public void changeLanguage(int selectedLanguage) {
		LanguageManager.language().setLanguage(session.getUser().getUsername(),
				selectedLanguage);
		waitingRoomUI.languageChanged();
	}

	public void deleteAccount(String password) {
		try {
			sessionManager.deleteAccount(password);
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
			joinGameUI.dispose();
			waitingRoomUI.setEnabled(true);
		} catch (FullGameException e) {
			JOptionPane.showMessageDialog(joinGameUI, "The game is full",
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
		gamesManager.userLeaveGame(gameName, player);
		if (game.isStarted()) {
			GameUI gameUI = gamesUI.get(gameName);
			gameUI.userLeaveGame(player);
			gamesUI.remove(gameName);
		} else {
			GameWaitingRoomUI gameUI = gameWaitingRooms.get(gameName);
			gameUI.userLeaveGame(player);
		}
	}

	public User searchUser(String username) {
		if (session.getUser().getUsername().equalsIgnoreCase(username))
			return session.getUser();
		else {
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
		System.out.println("LLAMAOS AL CHANGE SLOT CON EL USUARIO "
				+ session.getUser().getUsername());
		gamesManager.changeSlotState(gameName, slot, slotState);
	}

	public void slotStateChanged(String gameName, int slot, SlotState state) {
		System.out.println("HA CAMBIADO EL SLOT DE " + gameName);
		gamesManager.slotStateChanged(gameName, slot, state);
		GameWaitingRoomUI gameWaitingRoomUI = gameWaitingRooms.get(gameName);
		gameWaitingRoomUI.slotStateChanged();
	}

	public void showMessagesUI() {
		messagesUI = new MessagesUI();
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
		try {
			Client.getProxy().resetPassword(identifier);
			JOptionPane
					.showMessageDialog(
							resetPasswordUI,
							"Su contraseña ha sido reseteada en breve recibirá un email",
							"Contraseña reseteada",
							JOptionPane.INFORMATION_MESSAGE);
			resetPasswordUI.dispose();
		} catch (InvalidLoggingException e) {
			JOptionPane.showMessageDialog(resetPasswordUI,
					"El usuario introducido no existe", "Cuenta errónea",
					JOptionPane.INFORMATION_MESSAGE);
		}
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
			GameUI connect4UI = new Connect4UI(session.getUser().getUsername(),
					game);
			gamesUI.put(gameName, connect4UI);
			break;
		case Checkers:
			GameUI checkersUI = new CheckersUI(session.getUser().getUsername(),
					game);
			gamesUI.put(gameName, checkersUI);
			break;
		case Chess:
			GameUI chessUI = new ChessUI(session.getUser().getUsername(), game);
			gamesUI.put(gameName, chessUI);
			break;
		case Goose:
			GameUI gooseUI = new GooseUI(session.getUser().getUsername(), game);
			gamesUI.put(gameName, gooseUI);
			break;
		case Ludo:
			GameUI ludoUI = new LudoUI(session.getUser().getUsername(), game);
			gamesUI.put(gameName, ludoUI);
		}
	}

	public void gameUpdated(String gameName, int[][] board, int nextTurn) {
		GameUI gameUI = gamesUI.get(gameName);
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
		GameUI gameUI = gamesUI.get(game);
		gamesManager.finishGame(game);
		gameUI.lostGame();
	}

	public void finishGame(String game, String winnerPlayer) {
		gamesManager.finishGame(game, winnerPlayer);
	}
	
}
