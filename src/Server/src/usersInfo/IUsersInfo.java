package usersInfo;

import java.util.List;

import ProductLine.User;

public interface IUsersInfo {
	public User userInfo(String username);
	public List<User> listUsers(String username);
}
