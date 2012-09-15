package gamesManagement;

import java.util.List;

import model.Game;
import ProductLine.FullGameException;
import ProductLine.GameAlreadyExistsException;
import ProductLine.GameType;
import ProductLine.SlotState;

public interface IGames {
	public void createGame(String gameName, String creator, GameType type)
			throws GameAlreadyExistsException;

	public Game joinGame(String game, String player)
			throws FullGameException;

	public void leaveGame(String gameName, String player);

	public List<ProductLine.Game> listGames(String user);

	public void deleteGame(String game, String creator);

	public void changeSlotState(String gameName, int slot,
			SlotState state);

	public void startGame(String gameName);
	
	public void updateGame(String gameName, String player, int nextTurn,
			int[][] board);
	
	public void updateDiceGame(String gameName, String player, int nextTurn,
			int[][] board, int fromSquare, int dice, int movedPiece);
	
	public void finishGame(String gameName, String winnerPlayer);
	
	public Game getGame(String gameName);
}