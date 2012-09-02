package usersInfo;

import model.User;
import ProductLine.UserNotExistsException;

public interface IUsersInfo {
	public void listUsers();
	public User userInfo(String username) throws UserNotExistsException ;
	public void userLogged(User user);
	public void userLeave(String user);
}
