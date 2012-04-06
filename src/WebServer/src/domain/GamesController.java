/**
 * 
 */
package domain;

import java.util.List;

import model.Game;

import persistence.GameDAO;
import persistence.HibernateUtil;

/**
 * @author Juan
 *
 */
public class GamesController {
	
	public static GamesController controller;
	private List<Game> games;
	
	private GamesController(){
		
	}
	
	public static GamesController getInstance(){
		if(controller == null){
			controller = new GamesController();
		}
		
		return controller;
	}

	public List<Game> listGames(){
		
		List<Game> gamesInfo = GameDAO.getDAO().list();
		
		return gamesInfo;
	}
	
	public void joinGame(String player, String game){
		Game selectedGame = GameDAO.getDAO().loadByID(game);
		if(!selectedGame.isPlaying(player)){
			selectedGame.addPlayer(player);
		}
		
	}
	
	public void playGame(String username, String game){
		
	}
	
	public void quitGame(String username,String game){
		
	}
}
