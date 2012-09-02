package mailBox;

import ProductLine.Message;
import ProductLine.UserNotExistsException;

public interface IMailBox {
	public void sendMessage(Message msg) throws UserNotExistsException;
	public void deleteMessage(String username, int messageID);
	public void friendRequestResponse(String friend, String username,
			boolean accepted) throws UserNotExistsException;
	public void markMessageAsRead(String username, int messageID);
}
