package rankings;

import ProductLine.GameType;

public interface IRankings {
	public void addWonGame(String user,GameType gameType);
	public void addLostGame(String user,GameType gameType);
}
