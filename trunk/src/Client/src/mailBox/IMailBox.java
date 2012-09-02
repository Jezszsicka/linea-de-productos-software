package mailBox;

import exceptions.WrongInputException;
import ProductLine.Message;
import ProductLine.MessageType;
import ProductLine.UserNotExistsException;

public interface IMailBox {
	public void sendMessage(String to, String subject, String content, MessageType type) throws WrongInputException, UserNotExistsException;
	public void markMessageAsRead(Message message);
	public void deleteMessage(Message message);
}
