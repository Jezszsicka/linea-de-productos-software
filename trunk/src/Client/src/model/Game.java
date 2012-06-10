package model;

import java.util.ArrayList;

import Ice.Current;
import ProductLine.GameType;

@SuppressWarnings("serial")
public class Game extends ProductLine.Game {
	public Game() {
		super();
		typeGame = GameType.Checkers;
	}

	public Game(String name, String creator, GameType type) {
		this.name = name;
		this.typeGame = type;
		switch (typeGame) {
		case Checkers:
			maxPlayers = 2;
			break;
		}
		this.players = new ArrayList<String>();
		players.add(creator);
	}

	@Override
	public void addPlayer(String player, Current __current) {
		players.add(player);
	}

	@Override
	public void removePlayer(String player, Current __current) {
		players.remove(player);
	}

}
