package gameChat;

import gamesManagement.IGames;

import java.util.List;

import model.Sessions;
import ProductLine.Slot;
import ProductLine.SlotState;
import ProductLine.UserNotInGameException;

public class GameChat implements IGameChat{
	
	private IGames gamesManager;
	
	public GameChat(IGames gamesManager){
		this.gamesManager = gamesManager;
	}

	@Override
	public void sendGameMessage(String game, String sender, String message) {
		List<Slot> slots = gamesManager.getGame(game)
				.getSlots();
		for (Slot slot : slots)
			if (!slot.getPlayer().equalsIgnoreCase(sender)
					&& slot.getType().equals(SlotState.Human))
				Sessions.getInstance().getSession(slot.getPlayer())
						.getCallback()
						.receiveGameMessage(game, sender, message);		
	}

	@Override
	public void sendGamePrivateMessage(String game, String sender,
			String receiver, String message) throws UserNotInGameException {
		String player = null;
		for (Slot slot : gamesManager.getGame(game).getSlots()) {
			if (slot.getPlayer().equalsIgnoreCase(receiver)) {
				player = slot.getPlayer();
				break;
			}

		}
		if (player != null)
			Sessions.getInstance().getSession(receiver).getCallback()
					.receiveGamePrivateMessage(game, sender, message);
		else
			throw new UserNotInGameException();
		
	}


}
