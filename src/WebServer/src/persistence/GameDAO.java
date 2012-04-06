package persistence;

import java.util.List;

import model.Game;


public class GameDAO extends DAO<Game,String> {
	
	private static GameDAO gameDAO;

	public static GameDAO getDAO() {
		if (gameDAO == null) {
			gameDAO = new GameDAO();
		}

		return gameDAO;
	}
	
	@Override
	public Game loadByID(String game) {
		begin();
		@SuppressWarnings({ "unchecked" })
		List<Game> games = session.createQuery(
				"from Game as game where game.name = '" + game + "'")
				.list();
		commit();
		return games.get(0);
	}
	

	@Override
	public List<Game> list() {
		begin();
		List<Game> games = session.createQuery("from Game").list();
		commit();
		return games;
	}
	

}
