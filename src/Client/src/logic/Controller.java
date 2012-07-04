package logic;

import java.util.Hashtable;
import java.util.List;

import javax.swing.JOptionPane;

import model.Filter;
import model.Game;
import model.Session;
import model.User;
import presentation.CreateGameUI;
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
import ProductLine.SlotState;
import ProductLine.UserAlreadyExistsException;
import ProductLine.UserAlreadyLoggedException;
import ProductLine.UserNotInGameException;
import ProductLine.UserNotLoggedException;

import communications.Client;

import exceptions.WrongInputException;

public class Controller {
	public static Controller controller;

	//UI
	private RegisterUI registerUI;
	private ResetPasswordUI resetPasswordUI;
	private LoginUI loginUI;
	private ProfileUI profileUI;
	private WaitingRoomUI waitingRoomUI;
	private CreateGameUI createGameUI;
	private MessagesUI messagesUI;
	private Hashtable<String, GameWaitingRoomUI> gameWaitingRooms;
	private JoinGameUI joinGameUI;

	//Managers
	private Session session;
	private SessionManager sessionManager;
	private GamesManager gameManager;
	private LanguageManager language;
	private MessagesManager messagesManager;

	

	private Controller() {
		language = LanguageManager.language();
		loginUI = new LoginUI();
		sessionManager = new SessionManager();
		gameWaitingRooms = new Hashtable<String, GameWaitingRoomUI>();
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
			gameManager = new GamesManager(session);
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
			gameManager = null;
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

	public void sendPrivateMessage(String sender, String destinatary,
			String message) throws UserNotLoggedException {
		messagesManager.sendPrivateMessage(sender, destinatary, message);
	}
	
	public void sendGameMessage(String game, String message) {
		messagesManager.sendGameMessage(game,message);
	}
	
	public void sendGamePrivateMessage(String game, String sender,
			String destinatary, String message) throws UserNotInGameException {
		messagesManager.sendGamePrivateMessage(game,sender,destinatary,message);
	}
	
	public void sendMessage(String to, String subject, String content) throws WrongInputException {
		messagesManager.sendMessage(to, subject, content);
	}
	
	public void receiveGeneralMessage(String sender, String message) {
		waitingRoomUI.receiveMessage(sender, message);
	}

	public void receivePrivateMessage(String sender, String message) {
		waitingRoomUI.receivePrivateMessage(sender, message);

	}

	public void receiveGameMessage(String game, String sender, String message) {
		if (gameManager.searchGame(game).isStarted()) {

		} else
			gameWaitingRooms.get(game).receiveMessage(sender, message);
	}

	public void receiveGamePrivateMessage(String gameName, String sender,
			String message) {
		Game game = gameManager.searchGame(gameName);
		if (gameManager.searchGame(gameName).isStarted()) {

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
			Game game = gameManager.createGame(gameName, type);
			createGameUI.dispose();
			waitingRoomUI.setEnabled(true);
			gameWaitingRooms.put(game.getName(), new GameWaitingRoomUI(session
					.getUser().getUsername(), game,true));
		} catch (GameAlreadyExistsException e) {
			JOptionPane.showMessageDialog(createGameUI, "Please, choose another name for the game",
					"Game already exists", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (WrongInputException e) {
			JOptionPane.showMessageDialog(createGameUI, e.getMessage(),
					e.getError(), JOptionPane.WARNING_MESSAGE);
		}

	}

	public List<ProductLine.Game> listGames(String game, Filter filter) {
		return gameManager.listGames(game,filter);
	}

	public void deleteGame(String gameName) {
		gameManager.deleteGame(gameName);
		gameWaitingRooms.remove(gameName);
		waitingRoomUI.toFront();
	}

	public void joinGame(String gameName) {
		try {
			Game game = gameManager.joinGame(gameName);
			gameWaitingRooms.put(game.getName(), new GameWaitingRoomUI(session
					.getUser().getUsername(), game,false));
			joinGameUI.dispose();
			waitingRoomUI.setEnabled(true);
		} catch (FullGameException e) {
			JOptionPane.showMessageDialog(joinGameUI, "The game is full",
					"Full game", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}
	
	public void leaveGame(String game) {
		gameManager.leaveGame(game);
		gameWaitingRooms.remove(game);
	}

	public void userJoinGame(String game, String player) {
		gameManager.userJoinGame(game, player);
		GameWaitingRoomUI gameUI = gameWaitingRooms.get(game);
		gameUI.userJoinGame(player);

	}

	public void userLeaveGame(String game, String player) {
		gameManager.userLeaveGame(game,player);
		GameWaitingRoomUI gameUI = gameWaitingRooms.get(game);
		gameUI.userLeaveGame(player);
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
		JOptionPane.showMessageDialog(gameWaitingRooms.get(game), "You haven been kicked from game",
				"Kicked from game", JOptionPane.INFORMATION_MESSAGE);
		gameWaitingRooms.get(game).dispose();
	}
	
	public void changeSlotState(String gameName, int slot, SlotState slotState) {
		gameManager.changeSlotState(gameName,slot,slotState);
	}

	public void slotStateChanged(String gameName, int slot, SlotState state) {
		gameManager.slotStateChanged(gameName, slot, state);
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
			JOptionPane.showMessageDialog(resetPasswordUI, "Su contraseña ha sido reseteada en breve recibirá un email",
					"A la mierdaaa!", JOptionPane.INFORMATION_MESSAGE);
			resetPasswordUI.dispose();
		} catch (InvalidLoggingException e) {
			JOptionPane.showMessageDialog(resetPasswordUI, "El usuario no existe",
					"A la mierdaaa!", JOptionPane.INFORMATION_MESSAGE);
		}	
	}


}
