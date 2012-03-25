/**
 * 
 */
package domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

/**
 * @author Juan
 *
 */

public class Game implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3501954857203872932L;
	private String name;
	private GameType gameType;
	private List<Player> players;
	private List<Calendar> dates;
	
	
	
	public Game() {
		
	}


	public void addPlayer(Player player) {
		players.add(player);
		
	}
	
	public boolean isPlaying(String newPlayer){
		for(Player player : players)
			if(player.getName().equals(newPlayer))
				return true;
		
		return false;
	}

}
