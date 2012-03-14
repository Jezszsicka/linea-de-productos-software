package domain;

import java.util.List;
import java.util.Set;

public class User {

	private String username;
	private String password;
	private String email;
	private Role role;
	private String name;
	private String first_Name;
	private String last_name;
	private Set<String> friends;
	// private List<Ranking> ranking;
	private int attemps;
	private boolean blocked;

	public User() {

	}

	public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public User(String username, String password, String email, Role role) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	/**
	 * @param username
	 * @param password
	 * @param name
	 * @param first_Name
	 * @param last_name
	 * @param email
	 * @param friends
	 */
	public User(String username, String password, String name,
			String first_Name, String last_name, String email,
			Set<String> friends) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.first_Name = first_Name;
		this.last_name = last_name;
		this.email = email;
		this.friends = friends;
	}

	/**
	 * @param username
	 * @param password
	 * @param name
	 * @param first_Name
	 * @param last_name
	 * @param email
	 * @param friends
	 * @param ranking
	 */
	public User(String username, String password, String name,
			String first_Name, String last_name, String email,
			Set<String> friends, List<Ranking> ranking) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.first_Name = first_Name;
		this.last_name = last_name;
		this.email = email;
		this.friends = friends;
		// this.ranking = ranking;
	}

	public User(String username) {
		this.username = username;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the first_Name
	 */
	public String getFirst_Name() {
		return first_Name;
	}

	/**
	 * @param first_Name
	 *            the first_Name to set
	 */
	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * @param last_name
	 *            the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * @return the friends
	 */
	public Set<String> getFriends() {
		return friends;
	}

	/**
	 * @param friends
	 *            the friends to set
	 */
	public void setFriends(Set<String> friends) {
		this.friends = friends;
	}

	/**
	 * @return the attemps
	 */
	public int getAttemps() {
		return attemps;
	}

	/**
	 * @param attemps
	 *            the attemps to set
	 */
	public void setAttemps(int attemps) {
		this.attemps = attemps;
	}

	/**
	 * @return the blocked
	 */
	public boolean isBlocked() {
		return blocked;
	}

	/**
	 * @param blocked
	 *            the blocked to set
	 */
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", name=" + name + ", first_Name=" + first_Name
				+ ", last_name=" + last_name + ", email=" + email
				+ ", friends=" + friends + "]";
	}

	/**
	 * @return the ranking
	 */
	/*
	 * public List<Ranking> getRanking() { return ranking; }
	 */
	/**
	 * @param ranking
	 *            the ranking to set
	 */
	/*
	 * public void setRanking(List<Ranking> ranking) { this.ranking = ranking; }
	 */

}