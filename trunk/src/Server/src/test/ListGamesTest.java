package test;

import static org.junit.Assert.*;

import java.util.List;

import gamesManagement.GamesManager;
import gamesManagement.IGames;

import org.junit.BeforeClass;
import org.junit.Test;

import ProductLine.FullGameException;
import ProductLine.Game;
import ProductLine.GameType;

public class ListGamesTest {
	
	private static IGames gamesManagement;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		gamesManagement = new GamesManager();
		gamesManagement.createGame("Game", "Creator", GameType.Checkers);
	}

	@Test
	public void test() {
		List<Game> games  = gamesManagement.listGames("Player");
		assertTrue(games.get(0).getName().equals("Game"));
	}
	
	@Test
	public void listCreatedGame(){
		List<Game> games  = gamesManagement.listGames("Creator");
		assertTrue(games.isEmpty());
	}
	
	@Test
	public void listJoinedGame(){
		try {
			gamesManagement.joinGame("Game", "Player");
		} catch (FullGameException e) {
			fail("FullGameException");
		}
		
		List<Game> games  = gamesManagement.listGames("Player");
		assertTrue(games.isEmpty());
		
		
	}

}
