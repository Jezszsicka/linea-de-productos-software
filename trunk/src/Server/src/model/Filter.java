package model;

import java.util.ArrayList;

import Ice.Current;
import ProductLine.GameType;
import ProductLine.Players;

@SuppressWarnings("serial")
public class Filter extends ProductLine.Filter {
	
	public Filter(){
		super();
		gamesFilter = new ArrayList<GameType>();
		playersFilter = new ArrayList<Players>();
	}
	
	

	@Override
	public void addGame(GameType game, Current __current) {
		if(!gamesFilter.contains(game))
			gamesFilter.add(game);
	}

	@Override
	public void removeGame(GameType game, Current __current) {
		gamesFilter.remove(game);
	}

	@Override
	public void addPlayers(Players numPlayers, Current __current) {
		if(!playersFilter.contains(numPlayers))
			playersFilter.add(numPlayers);
		
	}

	@Override
	public void removePlayers(Players numPlayers, Current __current) {
		playersFilter.remove(numPlayers);
	}

}