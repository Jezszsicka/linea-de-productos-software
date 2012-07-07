package logic;

import java.util.Hashtable;
import java.util.List;

import exceptions.WrongInputException;

import ProductLine.FullGameException;
import ProductLine.GameAlreadyExistsException;
import ProductLine.GameType;
import ProductLine.NotEnoughPlayersException;
import ProductLine.Slot;
import ProductLine.SlotState;
import ProductLine.UserNotLoggedException;
import model.Connect4Game;
import model.Filter;
import model.Game;
import model.Session;



public class GamesManager {
	private Session session;
	private Hashtable<String,Game> games;
	
	public GamesManager(Session session){
		this.session = session;
		games = new Hashtable<String,Game>();
	}

	public Game createGame(String gameName, GameType type) throws GameAlreadyExistsException, WrongInputException {
		if(gameName.isEmpty())
			throw new WrongInputException("Name is empty","Please, introduce a name for the game");
		String username = session.getUser().getUsername();
		session.getProxy().createGame(gameName,username, type);
		//TODO crear el juego con polimorfismo que corresponda
		Game game = new Connect4Game(gameName,username,type);
		games.put(gameName, game);	
		return game;
	}

	public Game searchGame(String game) {
		return games.get(game);
	}

	public void deleteGame(String gameName) {
		session.getProxy().deleteGame(gameName, session.getUser().getUsername());
		games.remove(gameName);
	}

	public Game joinGame(String gameName) throws FullGameException {
		//TODO casting a lo que tenga que ser
		Game game = (Connect4Game) session.getProxy().joinGame(gameName, session.getUser().getUsername());
		games.put(gameName, game);
		return game;
		
	}

	public List<ProductLine.Game> listGames(String game, Filter filter) {
		return session.getProxy().listGames(session.getUser().getUsername(), game, filter);
	}
	
	public void userJoinGame(String game, String player) {
		searchGame(game).addPlayer(player);
	}

	public void userLeaveGame(String game, String player) {
		searchGame(game).removePlayer(player);
	}

	public void leaveGame(String game) {
		session.getProxy().leaveGame(game,session.getUser().getUsername());
	}

	public void changeSlotState(String gameName, int slot, SlotState slotState) {
		session.getProxy().changeSlotState(gameName, slot, slotState);
		Game game = searchGame(gameName);
		game.setSlot(slot, new Slot("",slotState));
	}

	public void slotStateChanged(String gameName, int slot, SlotState state) {
		Game game = searchGame(gameName);
		game.setSlot(slot, new Slot("",state));
	}

	public void startGame(String gameName) throws NotEnoughPlayersException {
		Game game = searchGame(gameName);
		if(game.players() > 1){
			session.getProxy().startGame(gameName);
			game.setStarted(true);
		}else{
			throw new NotEnoughPlayersException();
		}
	}

	public void gameStarted(String gameName) {
		Game game = searchGame(gameName);
		game.setStarted(true);
	}

	public void gameUpdated(String gameName, int[][] board) {
		Game game = searchGame(gameName);
		switch(game.getTypeGame()){
		case Connect4:
			Connect4Game connect4 = (Connect4Game) game;
			connect4.getBoard().setTablero(board);
			break;
		}
		
	}

	public void updateGame(String gameName) {
		Game game = searchGame(gameName);
		switch(game.getTypeGame()){
		case Connect4:
			Connect4Game connect4 = (Connect4Game) game;
			String player = session.getUser().getUsername();
			session.getProxy().updateGame(gameName, player, connect4.getBoard().getTablero());
			break;
		}
		
		
	}
}
