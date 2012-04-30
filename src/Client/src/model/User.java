package model;


public class User extends ProductLine.User{

	private static final long serialVersionUID = 902549047392648283L;

	public User (String username, String password, String email){
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
}