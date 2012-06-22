package logic;

import java.util.List;

import ProductLine.SlotState;
import ProductLine.Slot;
import ProductLine.UserNotInGameException;
import ProductLine.UserNotLoggedException;

import model.Session;


public class MessagesManager {
	public static MessagesManager controller;
	
	private MessagesManager(){
		
	}
	
	public static MessagesManager getInstance(){
		if(controller == null){
			controller = new MessagesManager();
		}
		return controller;
	}

	public void sendGeneralMessage(final String sender, final String message) {
		List<Session> sessions = UsersManager.getInstance().getSessions();
		for (final Session session : sessions) {
			if (!session.getUser().getUsername().equalsIgnoreCase(sender)) {
				new Thread(){
					public void run(){
						session.getCallback().receiveGeneralMessage(sender, message);
					}
				}.start();;
			}
		}
		
	}

	public void sendPrivateMessage(final String sender, String destinatary,
			final String message) throws UserNotLoggedException {
		final Session session = UsersManager.getInstance().searchSession(destinatary);
		if (session != null) {
			new Thread(){
				public void run(){
					session.getCallback().receivePrivateMessage(sender, message);
				}
			}.start();
		} else {
			throw new UserNotLoggedException();
		}
		
	}
	
	public void sendGameMessage(String game, String sender, String message) {
		List<Slot> slots = GamesManager.getInstance().searchGame(game).getSlots();
		for(Slot slot : slots)
			if(!slot.getPlayer().equalsIgnoreCase(sender) && slot.getType().equals(SlotState.Human))
				UsersManager.getInstance().searchSession(slot.getPlayer()).getCallback().receiveGameMessage(game, sender, message);
		
	}

	public void sendGamePrivateMessage(String game, String sender,
			String destinatary, String message) throws UserNotInGameException {
		String player = null;
		for(Slot slot : GamesManager.getInstance().searchGame(game).getSlots()){
			if(slot.getPlayer().equalsIgnoreCase(destinatary)){
				player = slot.getPlayer();
				break;
			}
				
		}
		if(player != null)
			UsersManager.getInstance().searchSession(destinatary).getCallback().receiveGamePrivateMessage(game, sender, message);
		else
			throw new UserNotInGameException();
	}
	
}
