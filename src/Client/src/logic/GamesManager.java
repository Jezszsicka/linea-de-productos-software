package logic;

import java.util.Hashtable;
import java.util.List;

import connect4.Connect4;

import checkers.Checkers;
import chess.Chess;

import model.Filter;
import model.Game;
import model.Session;
import ProductLine.FullGameException;
import ProductLine.GameAlreadyExistsException;
import ProductLine.GameType;
import ProductLine.NotEnoughPlayersException;
import ProductLine.Slot;
import ProductLine.SlotState;
import exceptions.WrongInputException;

public class GamesManager {
	private Session session;
	private Hashtable<String,Game> games;
	
	public GamesManager(Session session){
		this.session = session;
		games = new Hashtable<String,Game>();
	}

	/**Lists the games to join**/
	public List<ProductLine.Game> listGames(String game, Filter filter) {
		return session.getProxy().listGames(session.getUser().getUsername(), game, filter);
	}
	
	/**Creates a new game
	 * @param gameName Name for the game
	 * @param type Type of the game
	 * @throws GameAlreadyExistsException
	 * @throws WrongInputException**/
	public Game createGame(String gameName, GameType type) throws GameAlreadyExistsException, WrongInputException {
		if(gameName.isEmpty())
			throw new WrongInputException("Name is empty","Please, introduce a name for the game");
		String username = session.getUser().getUsername();
		session.getProxy().createGame(gameName,username, type);
		Game game = new Game(gameName,username,type);
		switch(type){
		case Checkers:
			Checkers.initBoard(game.getBoard());
			break;
		case Chess:
			Chess.initBoard(game.getBoard());
			break;
		case Connect4:
			Connect4.initBoard(game.getBoard());
			break;
		
			
		}
		games.put(gameName, game);	
		return game;
	}
	
	/**Joins to a game
	 * @param gameName Name of the game to join
	 * @throws FullGameException The game is full**/
	public Game joinGame(String gameName) throws FullGameException {
		Game game = (Game)session.getProxy().joinGame(gameName, session.getUser().getUsername());
		switch(game.getTypeGame()){
		case Checkers:
			Checkers.initBoard(game.getBoard());
			break;
			
		}
		games.put(gameName, game);
		return game;
		
	}
	
	/**Deletes a created game by the user
	 * @param gameName Name of the game to be deleted
	 * **/
	public void deleteGame(String gameName) {
		session.getProxy().deleteGame(gameName, session.getUser().getUsername());
		games.remove(gameName);
	}

	/**Leaves a game
	 * @param game Name of the game to leave**/
	public void leaveGame(String game) {
		session.getProxy().leaveGame(game,session.getUser().getUsername());
	}
	
	/**An user joins a game that you're playing
	 * @param game Name of the game
	 * @param Player that joins the game**/
	public void userJoinGame(String game, String player) {
		searchGame(game).addPlayer(player);
	}

	/**An user leaves a game that you're playing
	 * @param gameName Name of the game
	 * @param player Player that leaves the game**/
	public void userLeaveGame(String gameName, String player) {
		Game game = searchGame(gameName);
		if(game.isStarted())
			games.remove(gameName);
		else
			game.removePlayer(player);
	}


	/**Changes a slot state of a game
	 * @param gameName Name of the game
	 * @param slot Number of the slot to be changed
	 * @param slotState New state for the slot**/
	public void changeSlotState(String gameName, int slot, SlotState slotState) {
		session.getProxy().changeSlotState(gameName, slot, slotState);
		Game game = searchGame(gameName);
		game.setSlot(slot, new Slot("",slotState));
	}

	/**Notification: An slot state has been changed by the owner of the game
	 * @param gameName Name of the game
	 * @param slot Number of the slot that has been changed
	 * @param New state for the slot**/
	public void slotStateChanged(String gameName, int slot, SlotState state) {
		Game game = searchGame(gameName);
		game.setSlot(slot, new Slot("",state));
	}

	/**Start a game that you have created
	 * @param gameName Name of the game
	 * @throws NotEnoughPlayersException**/
	public void startGame(String gameName) throws NotEnoughPlayersException {
		Game game = searchGame(gameName);
		if(game.players() > 1){
			session.getProxy().startGame(gameName);
		}else{
			throw new NotEnoughPlayersException();
		}
	}

	/*public void gameStarted(String gameName) {
		Game game = searchGame(gameName);
		game.setStarted(true);
	}*/

	/**Update the board of a game
	 * @param gameName Name of the game**/
	public void updateGame(String gameName) {
		Game game = searchGame(gameName);
		int nextTurn = game.getTurn();
		System.out.println("Updateamos con el turno "+nextTurn);
		String player = session.getUser().getUsername();
		session.getProxy().updateGame(gameName, player,nextTurn, game.getBoard());		
	}
	
	/**Notification: The board of a game has been updated
	 * @param gameName Name of the game
	 * @param board The updated board of the game**/
	public void gameUpdated(String gameName, int[][] board) {
		Game game = searchGame(gameName);
		game.setBoard(board);
	}

	/**A game has finished
	 * @param game Name of the game
	 * @param winnerPlayer Name of the winner player
	 * **/
	public void finishGame(String game, String winnerPlayer) {
		games.remove(game);
		session.getProxy().finishGame(game, winnerPlayer);
	}
	
	/**Notification: A game has finished
	 * @game Name of the game**/
	public void finishGame(String game) {
		games.remove(game);
	}
	
	/**Search a game by its name
	 * @param game Name of the game to search
	 * @return The found game**/
	public Game searchGame(String game) {
		return games.get(game);
	}

}
