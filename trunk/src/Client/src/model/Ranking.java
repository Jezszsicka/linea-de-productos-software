package model;

import ProductLine.GameType;

@SuppressWarnings("serial")
public class Ranking extends ProductLine.Ranking{

	public Ranking(){
		
	}
	
	public Ranking(int wonGames,int lostGames,GameType game){
		this.wonGames = wonGames;
		this.lostGames = lostGames;
		this.game = game;
	}
}
