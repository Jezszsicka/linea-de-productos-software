package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import gamesManagement.GamesManager;
import gamesManagement.IGames;

import org.junit.BeforeClass;
import org.junit.Test;

import ProductLine.Game;
import ProductLine.GameAlreadyExistsException;
import ProductLine.GameType;
import ProductLine.Slot;
import ProductLine.SlotState;

public class CreateGameTest {
	private static IGames gamesManagement;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		gamesManagement = new GamesManager();
	}

	@Test
	public void createGameTest() {
		try {
			gamesManagement.createGame("Game", "Creator", GameType.Connect4);
		} catch (GameAlreadyExistsException e) {
			fail("GameAlreadyExists");
		}
		assertTrue(gamesManagement.getGame("Game") != null);
		Game game = gamesManagement.getGame("Game");
		Slot slot = game.getSlot(0);
		assertTrue(slot.getPlayer().equals("Creator") && slot.getType() == SlotState.Human);
	}
	
	@Test
	public void gameAlreadyExists(){
		try {
			gamesManagement.createGame("Game", "Creator", GameType.Connect4);
			fail("Game not exists");
		} catch (GameAlreadyExistsException e) {
			
		}
	}

}
