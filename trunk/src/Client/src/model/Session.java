package model;

import java.util.ArrayList;
import java.util.List;

import Ice.Identity;
import ProductLine.ServerPrx;

public class Session {
	private static Session instance;

	private User user;
	private List<User> users;
	private Identity callback;
	private ServerPrx proxy;

	private Session() {
		users = new ArrayList<User>();
	}

	public static Session getInstance() {
		if (instance == null) {
			instance = new Session();
		}
		return instance;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users
	 *            the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * @return the callback
	 */
	public Identity getCallback() {
		return callback;
	}

	/**
	 * @param callback
	 *            the callback to set
	 */
	public void setCallback(Identity callback) {
		this.callback = callback;
	}

	/**
	 * @return the proxy
	 */
	public ServerPrx getProxy() {
		return proxy;
	}

	/**
	 * @param proxy
	 *            the proxy to set
	 */
	public void setProxy(ServerPrx proxy) {
		this.proxy = proxy;
	}

	public void addUser(User user) {
		users.add(user);
	}

	public void removeUser(String user) {
		for (int i = 0; i < users.size(); i++)
			if (users.get(i).getUsername().equalsIgnoreCase(user)) {
				users.remove(i);
				break;
			}

	}

}