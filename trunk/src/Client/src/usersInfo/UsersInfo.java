package usersInfo;

import java.util.ArrayList;
import java.util.List;

import model.Session;
import model.User;
import ProductLine.UserNotExistsException;

public class UsersInfo implements IUsersInfo{

	/**
	 * An user has logged
	 * 
	 * @param user
	 *            New logged user
	 * **/
	@Override
	public void userLogged(User user) {
		Session.getInstance().addUser(user);
	}

	/**
	 * An user has left
	 * 
	 * @param user
	 *            User who left
	 **/
	@Override
	public void userLeave(String user) {
		Session.getInstance().removeUser(user);
	}
	
	
	public User userInfo(String username) throws UserNotExistsException {
		return (User)Session.getInstance().getProxy().userInfo(username);
	}

	@Override
	public void listUsers() {
		Session session = Session.getInstance();
		List<ProductLine.User> serverUsers = session.getProxy().listUsers(session.getUser().getUsername());
		List<User> users = new ArrayList<User>();
		for (ProductLine.User aux : serverUsers)
			users.add((User) aux);
		Session.getInstance().setUsers(users);
	}
}
