package domain;

import java.util.List;

public class MessageController {
	private static MessageController controller;
	private List<String> participants;
	
	private MessageController(){
		
	}
	
	public static MessageController getInstance(){
		if(controller == null)
			controller = new MessageController();
		return controller;
	}
	
	public void sendPrivateMessage(String sender, String destinatary, String message) {
		if(participants.contains(destinatary)){
			Session session = UsersController.getInstance().searchSession(destinatary);
			session.getCallback().receiveMessage(sender, message);
		}
	}

	public void sendMessage(String sender, String message) {
		for(String chatUser : participants){
			UsersController.getInstance().searchSession(chatUser).getCallback().receiveMessage(sender, message);
		}
	}
	
	
}
