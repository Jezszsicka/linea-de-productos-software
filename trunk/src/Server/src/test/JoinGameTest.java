package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import gamesManagement.GamesManager;
import gamesManagement.IGames;
import model.Game;

import org.junit.BeforeClass;
import org.junit.Test;

import ProductLine.FullGameException;
import ProductLine.GameType;

public class JoinGameTest {
	private static IGames gamesManagement;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		gamesManagement = new GamesManager();
		gamesManagement.createGame("Game", "Creator", GameType.Checkers);
	}

	@Test
	public void test() {
		try {
			gamesManagement.joinGame("Game", "Player");
		} catch (FullGameException e) {
			fail("FullGameException");
		} 
		
		Game game = gamesManagement.getGame("Game");
		assertTrue(game.getSlot(1).getPlayer().equals("Player"));
	}
	
	@Test
	public void fullGameTest(){
		try {
			gamesManagement.joinGame("Game", "Player");
			fail("User not in game");
		} catch (FullGameException e) {
		}
	}

}
