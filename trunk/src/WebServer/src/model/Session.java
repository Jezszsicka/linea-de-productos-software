package model;

import ProductLine.ClientPrx;
import ProductLine.User;



public class Session {

	private User user;
	private ClientPrx callback;

	public Session(User user, ClientPrx callback) {
		this.user = user;
		this.callback = callback;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUsername(User user) {
		this.user = user;
	}

	/**
	 * @return the callback
	 */
	public ClientPrx getCallback() {
		return callback;
	}

	/**
	 * @param callback the callback to set
	 */
	public void setCallback(ClientPrx callback) {
		this.callback = callback;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Session)) {
			return false;
		}
		Session other = (Session) obj;
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.getUsername().equals(other.user.getUsername())) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Session [user=" + user + ", callback=" + callback + "]";
	}

	public void checkConnection() {
		callback.ice_ping();
		
	}

	
}
