package actions;




import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6769482045149966541L;
	private String username;
	private String password;

	public String execute(){
	/*	RoleType role = UsersController.getInstance().loginUser(username, password);
		switch(role){
		case Admin:
			return "Admin";
		case Player:
			return "Player";
		default:
			return ERROR;
		}*/
		return "Admin";
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
