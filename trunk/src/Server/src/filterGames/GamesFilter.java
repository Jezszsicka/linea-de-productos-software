package filterGames;

import gamesManagement.IGames;

import java.util.ArrayList;
import java.util.List;

import ProductLine.Filter;
import ProductLine.Game;
import ProductLine.GameType;
import ProductLine.Slot;

public class GamesFilter implements IList {
	private IGames gamesManager;

	public GamesFilter(IGames gamesManager) {
		this.gamesManager = gamesManager;
	}

	@Override
	public List<Game> listGames(String user, String gameName, Filter gamesFilter) {

		FilterType type = null;
		List<ProductLine.Game> list = new ArrayList<ProductLine.Game>();
		List<Game> games = gamesManager.listGames(user);

		if (!gamesFilter.getGamesFilter().isEmpty()
				&& !gamesFilter.getPlayersFilter().isEmpty()) {
			type = FilterType.BothFilter;
		} else {
			if (!gamesFilter.getGamesFilter().isEmpty()
					&& gamesFilter.getPlayersFilter().isEmpty()) {
				type = FilterType.GamesFilter;
			} else {
				if (gamesFilter.getGamesFilter().isEmpty()
						&& !gamesFilter.getPlayersFilter().isEmpty()) {
					type = FilterType.PlayersFilter;
				} else {
					if (gamesFilter.getGamesFilter().isEmpty()
							&& gamesFilter.getPlayersFilter().isEmpty()) {
						type = FilterType.NoFilter;
					}
				}
			}
		}

		System.out.println("Tipo de filtro"+type);
		
		switch (type) {
		case BothFilter:
			break;
		case GamesFilter:
			//TODO
			System.out.println(gamesFilter.getGamesFilter());
			for (Game game : games) {
				boolean toList = true;
				for (GameType gameType : gamesFilter.getGamesFilter()) {
					if (!game.isStarted() && game.getName().contains(gameName)
							&& game.getTypeGame() == gameType) {
						
						for (Slot slot : game.getSlots()) {
							if (slot.getPlayer().equalsIgnoreCase(user)) {
								toList = false;
								break;
							}
						}
						
					} else{
						toList = false;
					}

					if (toList)
						list.add(game);
				}
			}
			break;
		case PlayersFilter:
			for (Game game : games) {
				boolean toList = true;
				for (GameType gameType : gamesFilter.getGamesFilter()) {
					if (!game.isStarted() && game.getName().contains(gameName)
							&& game.getTypeGame() == gameType) {
						for (Slot slot : game.getSlots()) {
							if (slot.getPlayer().equalsIgnoreCase(user)) {
								toList = false;
								break;
							}
						}
					} else
						toList = false;

					if (toList)
						list.add(game);
				}
			}
			break;
		case NoFilter:
			return games;
		default:
			break;

		}

		System.out.println(list);
		return list;
	}

}
