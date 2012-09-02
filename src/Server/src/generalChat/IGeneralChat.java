package generalChat;

import ProductLine.UserNotLoggedException;

public interface IGeneralChat {
	public void sendGeneralMessage(String sender, String message);
	public void sendPrivateMessage(String sender, String receiver,
			final String message) throws UserNotLoggedException;
}
