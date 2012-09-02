package test;

import static org.junit.Assert.assertTrue;
import gamesManagement.GamesManager;
import gamesManagement.IGames;

import org.junit.Before;
import org.junit.Test;

import ProductLine.GameType;

public class DeleteGameTest {
	private IGames gamesManagement;

	@Before
	public void setUp() throws Exception {
		gamesManagement = new GamesManager();
		gamesManagement.createGame("Game", "Creator", GameType.Checkers);
	}

	@Test
	public void test() {
		gamesManagement.deleteGame("Game", "Creator");
		assertTrue(gamesManagement.getGame("Game") == null);
	}

}
