package domain;
import java.util.List;

public class User {

	private String username;
	private String name;
	private String first_Name;
	private String last_name;
	private String email;
	private List<String> friends;
	private boolean online;
	private List<Ranking> ranking;

	/**
	 * @param username
	 * @param name
	 * @param first_Name
	 * @param last_name
	 * @param email
	 * @param friends
	 * @param online
	 * @param ranking
	 */
	public User(String username, String name, String first_Name,
			String last_name, String email, List<String> friends,
			boolean online, List<Ranking> ranking) {
		this.username = username;
		this.name = name;
		this.first_Name = first_Name;
		this.last_name = last_name;
		this.email = email;
		this.friends = friends;
		this.online = online;
		this.ranking = ranking;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
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
	 * @param first_Name the first_Name to set
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
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the friends
	 */
	public List<String> getFriends() {
		return friends;
	}
	/**
	 * @param friends the friends to set
	 */
	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
	/**
	 * @return the online
	 */
	public boolean isOnline() {
		return online;
	}
	/**
	 * @param online the online to set
	 */
	public void setOnline(boolean online) {
		this.online = online;
	}
	/**
	 * @return the ranking
	 */
	public List<Ranking> getRanking() {
		return ranking;
	}
	/**
	 * @param ranking the ranking to set
	 */
	public void setRanking(List<Ranking> ranking) {
		this.ranking = ranking;
	}
	
	
	
}