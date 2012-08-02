package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ProductLine.GameType;
import ProductLine.Message;
import model.Ranking;
import ProductLine.RoleType;

@SuppressWarnings("serial")
public class User extends ProductLine.User {

	public User() {
		super();
	}

	public User(String username) {
		this.username = username;
	}

	public User(String username, String name, String lastName, String password,
			String email, RoleType role, int country, byte[] avatar) {
		this.username = username;
		this.name = name;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.role = role;
		this.country = country;
		this.avatar = avatar;
		this.rankings = new ArrayList<ProductLine.Ranking>();
		rankings.add(new Ranking(0,0,GameType.Checkers));
		rankings.add(new Ranking(0,0,GameType.Chess));
		rankings.add(new Ranking(0,0,GameType.Connect4));
		rankings.add(new Ranking(0,0,GameType.Goose));
		rankings.add(new Ranking(0,0,GameType.Ludo));
		this.messages = new ArrayList<Message>();
	}

	public User(String username, String name, String lastName, String password,
			String email, RoleType role, int country, byte[] avatar,
			List<String> friends,
			List<ProductLine.Ranking> rankings, List<Message> messages) {
		this.username = username;
		this.name = name;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.role = role;
		this.country = country;
		this.avatar = avatar;
		this.friends = friends;
		this.rankings = rankings;
		this.messages = messages;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equalsIgnoreCase(other.username)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", name=" + name + ", lastName="
				+ lastName + ", password=" + password + ", email=" + email
				+ ", role=" + role + ", country=" + country + ", avatar="
				+ Arrays.toString(avatar) + ", friends=" + friends
				+ ", rankings=" + rankings + "]";
	}

}
