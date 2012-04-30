package model;

import java.util.HashSet;
import java.util.Set;

import Ice.Identity;
import ProductLine.ServerPrx;
import ProductLine.User;

public class Session {
	private User user;
	private Identity callback;
	private ServerPrx proxy;
	
	
	public Session(User user,Identity callback,ServerPrx proxy){
		this.user = user;
		this.callback = callback;
		this.proxy = proxy;
		Set<String> set = new HashSet<String>();
		set.add("asfd");
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
	public void setUser(User user) {
		this.user = user;
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
