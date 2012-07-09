package logic;

import java.util.Date;

import model.Message;
import model.Session;
import ProductLine.MessageType;
import ProductLine.UserNotInGameException;
import ProductLine.UserNotLoggedException;
import exceptions.WrongInputException;

public class MessagesManager {
	private Session session;
	
	
	public MessagesManager(Session session){
		this.session = session;
	}
	
	/**Sends a chat message to all the users in the waiting room
	 * @param message Message to send**/
	public void sendGeneralMessage(String message){
		String sender = session.getUser().getUsername();
		session.getProxy().sendGeneralMessage(sender, message);
	}
	
	/**Sends a chat private message to a user in the waiting room
	 * @param destinatary Recipient of the message
	 * @param message Message to send**/
	public void sendPrivateMessage(String destinatary,
			String message) throws UserNotLoggedException {
		String sender = session.getUser().getUsername();
		session.getProxy().sendPrivateMessage(sender, destinatary, message);	
	}
	
	/**Sends a message to an user
	 * @param to Recipient of the message
	 * @param subject Subject of the message
	 * @param content Content of the message
	 * @throws WrongInputException **/
	public void sendMessage(String to, String subject, String content) throws WrongInputException{
		if(to.isEmpty()){
			throw new WrongInputException("Empty receiver","Please specify a receiver");
		}
		String from = session.getUser().getUsername();
		Date date = new Date();
		Message message = new Message(from,to,subject,content,date,MessageType.Normal);
		session.getProxy().sendMessage(message);
	}

	/**Sends a chat message to all the players in a game
	 * @param game Name of the game
	 * @param message Message to send**/
	public void sendGameMessage(String game, String message) {
		String sender = session.getUser().getUsername();
		session.getProxy().sendGameMessage(game,
				sender, message);
	}
	
	/**Sends a chat private message to an user in a game
	 * @param game Name of the game
	 * @param destinatary Recipient of the message
	 * @param message Message to send
	 * @throws UserNotInGameException
	 * **/
	public void sendGamePrivateMessage(String game,
			String destinatary, String message) throws UserNotInGameException {
		String sender = session.getUser().getUsername();
		session.getProxy().sendGamePrivateMessage(game, sender, destinatary,
				message);
	}
	
}
