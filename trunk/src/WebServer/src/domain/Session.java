package domain;

import IClient.ClientPrx;

public class Session {

	private String username;
	private ClientPrx callback;

	public Session(String username, ClientPrx callback) {
		this.username = username;
		this.callback = callback;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Session other = (Session) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Session [username=" + username + "]";
	}

	public void checkConnection() {
		callback.ice_ping();
		
	}

	
}
