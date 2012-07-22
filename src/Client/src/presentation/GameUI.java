package presentation;

public interface GameUI {
	void updateBoard(int nextTurn);
	void lostGame();
	void receiveMessage(String sender,String message);
	void receivePrivateMessage(String sender, String message);
	void userLeaveGame(String player);
}
