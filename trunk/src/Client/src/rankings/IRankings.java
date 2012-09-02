package rankings;

import ProductLine.GameType;

public interface IRankings {
	public void addWonGame(GameType game);
	public void addLostGame(GameType game);
}
