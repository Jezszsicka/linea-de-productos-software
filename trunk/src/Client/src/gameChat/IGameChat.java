package gameChat;

import ProductLine.UserNotInGameException;

public interface IGameChat {
	public void sendGameMessage(String game, String message);

	public void sendGamePrivateMessage(String game, String receiver,
			String message) throws UserNotInGameException;
}
