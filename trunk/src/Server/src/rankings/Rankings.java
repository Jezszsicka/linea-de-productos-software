package rankings;

import persistence.UserDAO;
import model.Sessions;
import model.User;
import ProductLine.GameType;
import ProductLine.Ranking;

public class Rankings implements IRankings {

	@Override
	public void addWonGame(String username,GameType gameType) {
		User user = searchUser(username);
		for (Ranking ranking : user.getRankings()) {
			if (ranking.getGame() == gameType) {
				int wonGames = ranking.getWonGames();
				ranking.setLostGames(++wonGames);
				break;
			}
		}
		
		UserDAO userDAO = UserDAO.getDAO();
		userDAO.update(user);
	}

	@Override
	public void addLostGame(String username,GameType gameType) {
		User user = searchUser(username);
		for (Ranking ranking : user.getRankings()) {
			if (ranking.getGame() == gameType) {
				int lostGames = ranking.getLostGames();
				ranking.setLostGames(++lostGames);
				break;
			}
		}
		
		UserDAO userDAO = UserDAO.getDAO();
		userDAO.update(user);
	}
	
	
	private User searchUser(String username){
		return Sessions.getInstance().getSession(username).getUser();
	}

}
