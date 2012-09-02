package test;

import static org.junit.Assert.*;
import gamesManagement.GamesManager;
import gamesManagement.IGames;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ProductLine.FullGameException;
import ProductLine.GameType;

public class StartGameTest {
	private static IGames gamesManagement;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		gamesManagement = new GamesManager();
		gamesManagement.createGame("Game", "Creator", GameType.Checkers);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			gamesManagement.joinGame("Game", "Player");
		} catch (FullGameException e) {
			fail("FullGameException");
		}
		
		gamesManagement.startGame("Game");
		assertTrue(gamesManagement.getGame("Game").isStarted());
	}

}
