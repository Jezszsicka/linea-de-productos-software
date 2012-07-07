package model;

import ProductLine.GameType;
import connect4.Tablero;

public class Connect4Game extends Game{
	private static final long serialVersionUID = -2414596199448297221L;
	
	private Tablero tablero;
	
	public Connect4Game(String name, String creator, GameType type){
		super(name,creator,type);
		tablero = new Tablero();
	}
	
	public Tablero getBoard(){
		return tablero;
	}
}
