package domain;

import Ice.Current;

public class Server extends ProductLine._ServerDisp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7940671137250949695L;

	@Override
	public void loginUser(String username, String password, Current __current) {
		UsersController.getInstance().loginUser(username,password);
		
		
	}

	@Override
	public void registerUser(String username, String password, String email,
			Current __current) {
		// TODO Auto-generated method stub
		
	}

}
