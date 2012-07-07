package model;

import java.util.ArrayList;

import Ice.Current;
import ProductLine.GameType;
import ProductLine.SlotState;
import ProductLine.Slot;

@SuppressWarnings("serial")
public class Game extends ProductLine.Game {
	public Game() {
		super();
		typeGame = GameType.Checkers;
	}

	public Game(String name, String creator, GameType type) {
		this.name = name;
		this.typeGame = type;
		this.slots = new ArrayList<Slot>();
		slots.add(new Slot(creator,SlotState.Human));
		switch (typeGame) {
		case Checkers:
		case Chess:
		case Connect4:
			slots.add(new Slot("",SlotState.Empty));
			break;
		case Trivial:
			for(int i = 0; i<7; i++)
				slots.add(new Slot("",SlotState.Empty));
			break;
		}
		
	}

	@Override
	public boolean addPlayer(String player, Current __current) {
		for(Slot slot : slots){
			if(slot.getType().equals(SlotState.Empty)){
				slot.setPlayer(player);
				slot.setType(SlotState.Human);
				return true;
			}
		}
		return false;
	}

	@Override
	public void removePlayer(String player, Current __current) {
		for(Slot slot : slots){
			if(slot.getPlayer().equalsIgnoreCase(player)){
				slot.setPlayer("");
				slot.setType(SlotState.Empty);
			}
		}
	}

	@Override
	public Slot getSlot(int slot, Current __current) {
		return slots.get(slot);
	}

	@Override
	public void setSlot(int slotIndex, Slot newSlot, Current __current) {
		Slot slot = slots.get(slotIndex);
		slot.setPlayer(newSlot.getPlayer());
		slot.setType(newSlot.getType());
	}
	
	@Override
	public String toString() {
		return "Game [name=" + name + ", typeGame=" + typeGame
				+ ", started=" + started + "]";
	}

	@Override
	public int freeSlots(Current __current) {
		int freeSlots = 0;
		for(Slot slot : slots)
			if(slot.getType().equals(SlotState.Empty))
				freeSlots++;
		
		return freeSlots;
	}

	@Override
	public int players(Current __current) {
		int players = 0;
		for(Slot slot : slots)
			if(slot.getType().equals(SlotState.Human) || slot.getType().equals(SlotState.Computer) )
				players++;
		
		return players;
	}

	
}
