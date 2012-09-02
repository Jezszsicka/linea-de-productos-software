package rankings;

import model.Session;
import ProductLine.GameType;
import ProductLine.Ranking;

public class Rankings implements IRankings {

	@Override
	public void addWonGame(GameType gameType) {
		Session session = Session.getInstance();
		for (Ranking ranking : session.getUser().getRankings()) {
			if (ranking.getGame() == gameType) {
				int lostGames = ranking.getLostGames();
				ranking.setLostGames(++lostGames);
				break;
			}
		}
		
	}

	@Override
	public void addLostGame(GameType game) {
		// TODO Auto-generated method stub
		
	}

}
