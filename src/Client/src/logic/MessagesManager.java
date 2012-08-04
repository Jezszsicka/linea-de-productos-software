package logic;


import model.Session;
import model.User;
import ProductLine.Message;
import ProductLine.MessageType;
import ProductLine.UserNotExistsException;
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
	 * @throws WrongInputException 
	 * @throws UserNotExistsException **/
	public void sendMessage(String to, String subject, String content, MessageType type) throws WrongInputException, UserNotExistsException{
		if(to.isEmpty()){
			throw new WrongInputException("Empty receiver","Please specify a receiver");
		}
		String from = session.getUser().getUsername();
		Message message = new model.Message(from,to,subject,content,type);
		session.getProxy().sendMessage(message);
	}
	
	public void markMessageAsRead(Message message) {
		message.setSeen(true);
		session.getProxy().markMessageAsRead(session.getUser().getUsername(), message.getMessageID());
		
	}

	public void deleteMessage(Message message) {
		User user = session.getUser();
		user.getMessages().remove(message);
		session.getProxy().deleteMessage(user.getUsername(), message.getMessageID());
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

	public void friendRequestResponse(String friend,
			boolean accepted) {
		try {
			session.getProxy().friendRequestResponse(friend,session.getUser().getUsername() , accepted);
			if(accepted)
				session.getUser().getFriends().add(friend);
			
		} catch (UserNotExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	
}
