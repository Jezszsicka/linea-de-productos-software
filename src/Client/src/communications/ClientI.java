package communications;


import logic.Controller;
import Ice.Current;
import ProductLine.SlotState;
import ProductLine.User;
import ProductLine._ClientDisp;

public class ClientI extends _ClientDisp{
	private static final long serialVersionUID = -817742229741007859L;

	@Override
	public void receiveGeneralMessage(String sender, String message,
			Current __current) {
		Controller.getInstance().receiveGeneralMessage(sender, message);
	}

	@Override
	public void userLogged(User user, Current __current) {
		Controller.getInstance().userLogged((model.User)user);
		
	}

	@Override
	public void userLeave(String username, Current __current) {
		Controller.getInstance().userLeave(username);	
	}

	@Override
	public void receivePrivateMessage(String sender, String message,
			Current __current) {
		Controller.getInstance().receivePrivateMessage(sender,message);
		
	}

	@Override
	public void receiveGameMessage(String game, String sender, String message,
			Current __current) {
		Controller.getInstance().receiveGameMessage(game,sender,message);
		
	}

	@Override
	public void userJoinGame(String game, String player, Current __current) {
		Controller.getInstance().userJoinGame(game,player);
	}

	@Override
	public void userLeaveGame(String game, String player, Current __current) {
		Controller.getInstance().userLeaveGame(game,player);
		
	}

	@Override
	public void receiveGamePrivateMessage(String game, String sender,
			String message, Current __current) {
		Controller.getInstance().receiveGamePrivateMessage(game,sender,message);
		
	}

	@Override
	public void kickedFromGame(String game, Current __current) {
		Controller.getInstance().kickedFromGame(game);
	}

	@Override
	public void slotStateChanged(String game, int slot, SlotState state,
			Current __current) {
		System.out.println("Cambio de slot "+state);
		Controller.getInstance().slotStateChanged(game,slot,state);
	}

	@Override
	public void gameStarted(String game, Current __current) {
		Controller.getInstance().gameStarted(game);		
	}

	@Override
	public void gameUpdated(String game,int nextTurn, int[][] board, Current __current) {
		Controller.getInstance().gameUpdated(game,board);	
	}

	@Override
	public void gameFinished(String game, Current __current) {
		Controller.getInstance().gameFinished(game);
	}



}
