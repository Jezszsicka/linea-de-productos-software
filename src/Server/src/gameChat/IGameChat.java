package gameChat;

import ProductLine.UserNotInGameException;

public interface IGameChat {
	public void sendGameMessage(String game, String sender, String message);
	public void sendGamePrivateMessage(String game, String sender,
			String receiver, String message) throws UserNotInGameException;
}
