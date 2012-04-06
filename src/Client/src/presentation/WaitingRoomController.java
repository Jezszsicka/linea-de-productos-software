package presentation;

public class WaitingRoomController {
	private WaitingRoomUI waitingRoomUI;
	
	public WaitingRoomController(){
		waitingRoomUI = new WaitingRoomUI(this);
		waitingRoomUI.setLocationRelativeTo(null);
		waitingRoomUI.setVisible(true);
	}
}
