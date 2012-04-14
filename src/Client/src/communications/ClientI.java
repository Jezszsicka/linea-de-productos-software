package communications;

import IClient._ClientDisp;
import Ice.Current;
import domain.Controller;

public class ClientI extends _ClientDisp{

	/**
	 * 
	 */
	private static final long serialVersionUID = -817742229741007859L;

	@Override
	public void receiveWaitingRoomMessage(String sender, String message,
			Current __current) {
		//Facade.getInstance().receiveWaitingRoomMessage(sender, message);
		
	}

	@Override
	public void userLogged(String chatUser, Current __current) {
		Controller.getInstance().userLogged(chatUser);
		
	}

	@Override
	public void userLeave(String chatUser, Current __current) {
		// TODO Auto-generated method stub
		
	}



}
