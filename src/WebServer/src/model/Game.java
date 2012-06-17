package model;

import java.util.ArrayList;

import Ice.Current;
import ProductLine.GameType;
import ProductLine.PlayerType;
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
		switch (typeGame) {
		case Checkers:
			slots.add(new Slot(creator,PlayerType.Human));
			slots.add(new Slot("",PlayerType.Empty));
			break;
		}
		
	}

	@Override
	public boolean addPlayer(String player, Current __current) {
		for(Slot slot : slots){
			if(slot.getType().equals(PlayerType.Empty)){
				slot.setPlayer(player);
				slot.setType(PlayerType.Human);
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
				slot.setType(PlayerType.Empty);
			}
		}
	}

	@Override
	public String toString() {
		return "Game [name=" + name + ", typeGame=" + typeGame
				+ ", started=" + started + "]";
	}

	
}
