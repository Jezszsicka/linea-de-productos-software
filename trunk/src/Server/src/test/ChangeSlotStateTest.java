package test;

import static org.junit.Assert.*;
import gamesManagement.GamesManager;
import gamesManagement.IGames;

import org.junit.Before;
import org.junit.Test;

import ProductLine.FullGameException;
import ProductLine.GameType;
import ProductLine.Slot;
import ProductLine.SlotState;

public class ChangeSlotStateTest {

	private IGames gamesManagement;

	@Before
	public void setUp() throws Exception {
		gamesManagement = new GamesManager();
		gamesManagement.createGame("Game", "Creator", GameType.Checkers);
	}

	@Test
	public void test() {
		gamesManagement.changeSlotState("Game", 1, SlotState.Closed);
		Slot slot = gamesManagement.getGame("Game").getSlot(1);
		assertTrue(slot.getType() == SlotState.Closed);
	}
	
	@Test
	public void kickPlayerTest(){
		
		try {
			gamesManagement.joinGame("Game", "Player");
		} catch (FullGameException e) {
			fail("FullGameException");
		}
		
		Slot slot = gamesManagement.getGame("Game").getSlot(1);
		
		gamesManagement.changeSlotState("Game", 1, SlotState.Closed);
		assertTrue(slot.getType() == SlotState.Closed && !slot.getPlayer().equals(" "));
		
	}

}
