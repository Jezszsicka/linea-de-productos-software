package domain;
public class Ranking {

	private int playGames;
	private int wonGames;
	private int lostGames;
	private GameType game;
		
	/**
	 * @param playGames
	 * @param wonGames
	 * @param lostGames
	 * @param game
	 */
	public Ranking(int playGames, int wonGames, int lostGames, GameType game) {
		this.playGames = playGames;
		this.wonGames = wonGames;
		this.lostGames = lostGames;
		this.game = game;
	}
	
	
	/**
	 * @return the playGames
	 */
	public int getPlayGames() {
		return playGames;
	}
	/**
	 * @param playGames the playGames to set
	 */
	public void setPlayGames(int playGames) {
		this.playGames = playGames;
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
		return "Ranking [playGames=" + playGames + ", wonGames=" + wonGames
				+ ", lostGames=" + lostGames + ", game=" + game + "]";
	}
	
	
	
	
	
	
	
	

	
}