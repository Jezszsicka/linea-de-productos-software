package gamesManagement;

import java.util.List;

import model.Filter;
import model.Game;
import ProductLine.FullGameException;
import ProductLine.GameAlreadyExistsException;
import ProductLine.GameType;
import ProductLine.NotEnoughPlayersException;
import ProductLine.SlotState;
import exceptions.WrongInputException;

public interface IGames {
	public Game createGame(String gameName, GameType type)
			throws GameAlreadyExistsException, WrongInputException;

	public Game joinGame(String gameName) throws FullGameException;

	public void deleteGame(String gameName);

	public void leaveGame(String gameName);

	public void userJoinGame(String game, String player);

	public void userLeaveGame(String gameName, String player);

	public void changeSlotState(String gameName, int slot, SlotState slotState);

	public void slotStateChanged(String gameName, int slot, SlotState state);

	public void startGame(String gameName) throws NotEnoughPlayersException;

	public void updateGame(String gameName);

	public void updateDiceGame(String gameName, int fromSquare, int dice,
			int piece);

	public void gameUpdated(String gameName, int[][] board);

	public void gameUpdated(String gameName, int turn, int[][] board);

	public void finishGame(String gameName, String winnerPlayer);

	public void finishGame(String gameName);

	public Game searchGame(String game);

	List<ProductLine.Game> listGames(String game, Filter filter);
}
