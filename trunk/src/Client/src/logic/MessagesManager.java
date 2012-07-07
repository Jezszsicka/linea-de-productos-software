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
	
	public void sendGeneralMessage(String message){
		String sender = session.getUser().getUsername();
		session.getProxy().sendGeneralMessage(sender, message);
	}
	
	public void sendPrivateMessage(String sender, String destinatary,
			String message) throws UserNotLoggedException {
		session.getProxy().sendPrivateMessage(sender, destinatary, message);	
	}
	
	public void sendMessage(String to, String subject, String content) throws WrongInputException{
		if(to.isEmpty()){
			throw new WrongInputException("Empty receiver","Please specify a receiver");
		}
		String from = session.getUser().getUsername();
		Date date = new Date();
		Message message = new Message(from,to,subject,content,date,MessageType.Normal);
		session.getProxy().sendMessage(message);
	}

	public void sendGamePrivateMessage(String game, String sender,
			String destinatary, String message) throws UserNotInGameException {
		session.getProxy().sendGamePrivateMessage(game, sender, destinatary,
				message);
	}

	public void sendGameMessage(String game, String message) {
		String user = session.getUser().getUsername();
		session.getProxy().sendGameMessage(game,
				user, message);
	}
	
	
}
