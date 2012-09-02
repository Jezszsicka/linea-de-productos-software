package chatGeneral;

import model.Session;
import ProductLine.UserNotLoggedException;

public class GeneralChat implements IGeneralChat {

	/**Sends a chat message to all the users in the waiting room
	 * @param message Message to send**/
	@Override
	public void sendGeneralMessage(String message){
		Session session = Session.getInstance();
		String sender = session.getUser().getUsername();
		session.getProxy().sendGeneralMessage(sender, message);
	}
	
	/**Sends a chat private message to a user in the waiting room
	 * @param destinatary Recipient of the message
	 * @param message Message to send**/
	@Override
	public void sendPrivateMessage(String destinatary,
			String message) throws UserNotLoggedException {
		Session session = Session.getInstance();
		String sender = session.getUser().getUsername();
		session.getProxy().sendPrivateMessage(sender, destinatary, message);	
	}

}
