package model;
public class Ranking {

	private int playedGames;
	private int wonGames;
	private int lostGames;
	private GameType game;
		
	/**
	 * @param playedGames
	 * @param wonGames
	 * @param lostGames
	 * @param game
	 */
	public Ranking(int playedGames, int wonGames, int lostGames, GameType game) {
		this.playedGames = playedGames;
		this.wonGames = wonGames;
		this.lostGames = lostGames;
		this.game = game;
	}
	
	
	/**
	 * @return the playGames
	 */
	public int getPlayedGames() {
		return playedGames;
	}
	/**
	 * @param playGames the playGames to set
	 */
	public void setPlayedGames(int playGames) {
		this.playedGames = playGames;
	}
	/**
	 * @return the wonGames
	 */
	public int getWonGames() {
		return wonGames;
	}
	/**
	 * @param wonGames the wonGames to set
	 */
	public void setWonGames(int wonGames) {
		this.wonGames = wonGames;
	}
	/**
	 * @return the lostGames
	 */
	public int getLostGames() {
		return lostGames;
	}
	/**
	 * @param lostGames the lostGames to set
	 */
	public void setLostGames(int lostGames) {
		this.lostGames = lostGames;
	}
	/**
	 * @return the game
	 */
	public GameType getGame() {
		return game;
	}
	/**
	 * @param game the game to set
	 */
	public void setGame(GameType game) {
		this.game = game;
	}
	
	@Override
	public String toString() {
		return "Ranking [playGames=" + playedGames + ", wonGames=" + wonGames
				+ ", lostGames=" + lostGames + ", game=" + game + "]";
	}
	
	
	
	
	
	
	
	

	
}