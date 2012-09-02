package test;

import static org.junit.Assert.assertTrue;
import gamesManagement.GamesManager;
import gamesManagement.IGames;
import model.Game;

import org.junit.BeforeClass;
import org.junit.Test;

import ProductLine.GameType;
import ProductLine.Slot;
import ProductLine.SlotState;

public class LeaveGameTest {

	private static IGames gamesManagement;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		gamesManagement = new GamesManager();
		gamesManagement.createGame("Game", "Creator", GameType.Checkers);
		gamesManagement.joinGame("Game", "Player");
	}

	@Test
	public void test() {
		gamesManagement.leaveGame("Game", "Player");
		Game game = gamesManagement.getGame("Game");
		Slot slot = game.getSlot(1);
		assertTrue(!slot.getPlayer().equals("Player") && slot.getType() == SlotState.Empty);
	}

}
