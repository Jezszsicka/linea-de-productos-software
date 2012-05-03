package domain;

import java.util.ArrayList;

import ProductLine.GameType;
import ProductLine.Ranking;
import ProductLine.RoleType;
import ProductLine.User;
import persistence.HibernateUtil;
import persistence.UserDAO;

public class Mian {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HibernateUtil.start();
		
		Ranking ranking = new Ranking(GameType.Ludo,10,6);
		ArrayList<Ranking> rankings = new ArrayList<Ranking>();
		rankings.add(ranking);
		ArrayList<String> friends = new ArrayList<String>();
		//friends.add("Pepo");
		
		User user = new User("pepon", "juadaf", "asdfas@gmail.sca", RoleType.Player, "Juan", "ASdasd", "asdfasd", friends, rankings);
		UserDAO.getDAO().create(user);
		

	}

}
