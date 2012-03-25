package persistence;

import java.util.List;

import domain.User;

public class UserDAO extends DAO<User, String> {

	private static UserDAO userDAO;

	public static UserDAO getDAO() {
		if (userDAO == null) {
			userDAO = new UserDAO();
		}

		return userDAO;
	}

	@Override
	public User loadByID(String username) {
		begin();
		@SuppressWarnings({ "unchecked" })
		List<User> query = session.createQuery(
				"from User as user where user.username = '" + username + "'")
				.list();
		commit();
		return query.get(0);
	}

	@Override
	public List<User> list() {
		begin();
		@SuppressWarnings("unchecked")
		List<User> query = session.createQuery("from User").list();
		commit();
		return query;
	}

	public User checkLogin(String username, String password) {
		@SuppressWarnings("unchecked")
		List<User> query = session.createQuery("from User as user where user.username = '"+ username +"' and password = '"+password +"'" ).list();
		return query.get(0);
	}

}
