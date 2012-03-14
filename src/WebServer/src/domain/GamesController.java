/**
 * 
 */
package domain;

import java.util.List;

import persistence.HibernateUtil;

/**
 * @author Juan
 *
 */
public class GamesController {
	
	public static GamesController controller;
	
	private GamesController(){
		
	}
	
	public static GamesController getInstance(){
		if(controller == null){
			controller = new GamesController();
		}
		
		return controller;
	}

	public List<GameInfo> listGames(){
		org.hibernate.Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
		hibernateSession.beginTransaction();
		@SuppressWarnings("unchecked")
		List<GameInfo> games = hibernateSession.createQuery("from Games").list();
		hibernateSession.getTransaction().commit();
		return games;
	}
	
	public void joinGame(String username, String game){
		
	}
	
	public void playGame(String username, String game){
		
	}
	
	public void quitGame(String username,String game){
		
	}
}
