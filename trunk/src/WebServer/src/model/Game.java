package model;

import Ice.Current;
import ProductLine.GameType;

@SuppressWarnings("serial")
public class Game extends ProductLine.Game {
	public Game(){
		super();
		typeGame = GameType.Checkers;
	}
	
	public Game(String name, String creator,GameType type){
		this.name = name;
		this.creator = creator;
		this.typeGame = type;
	}
	
	@Override
	public void addPlayer(String user, Current __current) {
		
	}

	@Override
	public void removePlayer(String user, Current __current) {
		// TODO Auto-generated method stub
		
	}

}
