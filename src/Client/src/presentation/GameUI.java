package presentation;

public interface GameUI {
	void updateBoard();
	void lostGame();
	void receiveMessage(String sender,String message);
	void receivePrivateMessage(String sender, String message);
	void userLeaveGame(String player);
}
