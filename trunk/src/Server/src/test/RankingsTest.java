package test;

import static org.junit.Assert.assertTrue;
import model.Session;
import model.Sessions;
import model.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import persistence.HibernateUtil;
import persistence.UserDAO;
import rankings.IRankings;
import rankings.Rankings;
import ProductLine.GameType;
import ProductLine.RoleType;

public class RankingsTest {
	private IRankings rankings;
	private User user;
	
	@Before
	public void setUp() throws Exception {
		rankings = new Rankings();
		HibernateUtil.start();
		user = new User("Prueba","Prueba", "Prueba", "Prueba", "Prueba@prueba.com", RoleType.Player, 0, null);
		UserDAO.getDAO().update(user);
		Sessions.getInstance().addSession(new Session(user,null));
	}

	@After
	public void tearDown() throws Exception {
		UserDAO.getDAO().delete(user);
	}

	@Test
	public void test() {
		rankings.addLostGame(user.getUsername(), GameType.Checkers);
		rankings.addWonGame(user.getUsername(), GameType.Checkers);
		assertTrue(user.getRankings().get(0).getWonGames() == 1);
		assertTrue(user.getRankings().get(0).getLostGames() == 1);
	}

}
