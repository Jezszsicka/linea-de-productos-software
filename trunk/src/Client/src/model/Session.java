package model;

import IServer.ServerPrx;
import Ice.Identity;

public class Session {
	private String username;
	private Identity callback;
	private ServerPrx proxy;
	
	
	public Session(String username,Identity callback,ServerPrx proxy){
		this.username = username;
		this.callback = callback;
		this.proxy = proxy;
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
	public Identity getCallback() {
		return callback;
	}

	/**
	 * @param callback the callback to set
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
	 * @param proxy the proxy to set
	 */
	public void setProxy(ServerPrx proxy) {
		this.proxy = proxy;
	}

	
}
