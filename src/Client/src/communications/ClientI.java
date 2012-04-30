package communications;


import Ice.Current;
import ProductLine._ClientDisp;
import domain.Controller;

public class ClientI extends _ClientDisp{

	/**
	 * 
	 */
	private static final long serialVersionUID = -817742229741007859L;

	@Override
	public void receiveGeneralMessage(String sender, String message,
			Current __current) {
		Controller.getInstance().receiveGeneralMessage(sender, message);
	}

	@Override
	public void userLogged(String username, Current __current) {
		Controller.getInstance().userLogged(username);
		
	}

	@Override
	public void userLeave(String username, Current __current) {
		Controller.getInstance().userLeave(username);	
	}



}
