package rankings;

import java.util.List;

import model.Session;
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
	}
	
	
	private User searchUser(String username){
		Session session = Session.getInstance();
		if(session.getUser().getUsername().equals(username)){
			return session.getUser();
		}else{
			List<User> users = session.getUsers();
			for(User user : users){
				if(user.getUsername().equals(username))
					return user;
			}
		}
		
		return null;
	}

}
