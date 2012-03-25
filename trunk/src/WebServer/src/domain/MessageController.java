package domain;

import java.util.ArrayList;
import java.util.List;

public class MessageController {
	private static MessageController controller;
	private List<String> participants;
	
	private MessageController(){
		participants = new ArrayList<String>();
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
			if(!chatUser.equals(sender))
				UsersController.getInstance().searchSession(chatUser).getCallback().receiveMessage(sender, message);
		}
	}
	
	public void addParticipant(String participant){
		participants.add(participant);
	}
	
	public void removeParticipant(String participant){
		participants.remove(participant);
	}

	/**
	 * @return the participants
	 */
	public List<String> getParticipants() {
		return participants;
	}

	/**
	 * @param participants the participants to set
	 */
	public void setParticipants(List<String> participants) {
		this.participants = participants;
	}
	
}
