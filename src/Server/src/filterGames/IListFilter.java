package filterGames;

import java.util.List;

import ProductLine.Filter;
import ProductLine.Game;

public interface IListFilter {
	public List<Game> listGames(String user, String gameName,
			Filter gamesFilter);
}
