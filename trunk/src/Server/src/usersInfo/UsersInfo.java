package usersInfo;

import java.util.ArrayList;
import java.util.List;

import model.Session;
import model.Sessions;

import persistence.UserDAO;
import ProductLine.User;

public class UsersInfo implements IUsersInfo {

	@Override
	public User userInfo(String username) {
		User user = UserDAO.getDAO().loadByID(username);
		return user;
	}

	@Override
	public List<User> listUsers(String username) {
		List<ProductLine.User> users = new ArrayList<ProductLine.User>();
		List<Session> sessions = Sessions.getInstance().getSessions();
		UserDAO userDAO = UserDAO.getDAO();
		
		for (Session session : sessions) {
			if (!session.getUser().getUsername().equalsIgnoreCase(username))
				users.add(userDAO.loadByID(session.getUser().getUsername()));
		}
		return users;
	}


}
