package domain;

import presentation.WaitingRoomController;

public class GamesController {
	
	private static GamesController controller;
	private WaitingRoomController waitingRoomController;
	
	public GamesController(){
		waitingRoomController = new WaitingRoomController();
	}
	
	public static void initialize() {
		if(controller == null)
			controller = new GamesController();
		
	}
	
	public static GamesController getInstance(){
		return controller;
	}
	

}
