package domain;


public class UsersController {

	private static UsersController controller;
	
	
	public static UsersController getInstance() {
		if(controller == null)
			controller = new UsersController();
		return controller;
	}


	public void loginUser(String username, String password) {
		// TODO Auto-generated method stub
		
	}

}
