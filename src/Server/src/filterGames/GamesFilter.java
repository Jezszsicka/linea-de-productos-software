package filterGames;

import gamesManagement.IGames;

import java.util.ArrayList;
import java.util.List;

import ProductLine.Filter;
import ProductLine.Game;
import ProductLine.GameType;
import ProductLine.Players;
import ProductLine.Slot;

public class GamesFilter implements IListFilter {
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

		switch (type) {
		case BothFilter:
			for (Game game : games) {
				boolean toList;
				for (GameType gameType : gamesFilter.getGamesFilter()) {
					toList = true;
					if (!game.isStarted() && game.getName().contains(gameName)
							&& game.getTypeGame() == gameType) {
						for (Slot slot : game.getSlots()) {
							if (slot.getPlayer().equalsIgnoreCase(user)) {
								toList = false;
								break;
							}
						}
					} else {
						toList = false;
					}

					if (toList) {
						list.add(game);
						break;
					}
				}
			}

			for (Game game : games) {
				int size = game.getSlots().size();
				switch (size) {
				case 2:
					if (gamesFilter.getPlayersFilter().contains(
							Players.TwoPlayers)) {
						if (!list.contains(game))
							list.add(game);
					}
					break;
				case 3:
					if (gamesFilter.getPlayersFilter().contains(
							Players.ThreeOrMore))
						if (!list.contains(game))
							list.add(game);
					break;
				case 4:
					if (gamesFilter.getPlayersFilter().contains(
							Players.ThreeOrMore))
						if (!list.contains(game))
							list.add(game);
					break;
				}
			}
			break;

		case GamesFilter:
			for (Game game : games) {
				boolean toList;
				for (GameType gameType : gamesFilter.getGamesFilter()) {
					toList = true;
					if (!game.isStarted() && game.getName().contains(gameName)
							&& game.getTypeGame() == gameType) {
						for (Slot slot : game.getSlots()) {
							if (slot.getPlayer().equalsIgnoreCase(user)) {
								toList = false;
								break;
							}
						}
					} else {
						toList = false;
					}

					if (toList) {
						list.add(game);
						break;
					}
				}
			}
			break;
		case PlayersFilter:
			for (Game game : games) {
				int size = game.getSlots().size();
				switch (size) {
				case 2:
					if (gamesFilter.getPlayersFilter().contains(
							Players.TwoPlayers))
						list.add(game);
					break;
				case 3:
					if (gamesFilter.getPlayersFilter().contains(
							Players.ThreeOrMore))
						list.add(game);
					break;
				case 4:
					if (gamesFilter.getPlayersFilter().contains(
							Players.ThreeOrMore))
						list.add(game);
					break;
				}
			}
			break;
		case NoFilter:
			return games;
		default:
			break;

		}

		return list;
	}

}
