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
		ArrayList<String> friends = new ArrayList<String>();
		friends.add("Lala");
		
		User user = new User("peponaco", "juadaf", "asdfas@gmail.sca", RoleType.Player, "Juan", "ASdasd", "asdfasd", friends, rankings);
		UserDAO.getDAO().create(user);
		

	}

}
