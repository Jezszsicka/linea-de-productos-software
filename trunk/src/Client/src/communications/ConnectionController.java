package communications;

public class ConnectionController {
	
	private ConnectionThread connection;
	
	public ConnectionController() {
		connection = new ConnectionThread();
		connection.start();
	}
	
	public void startServerConnection(){
		connection = new ConnectionThread();
		connection.start();
	}
	
	public void startSession(){
		Client.initializeCallback();
	}
	
	public void stopConnection(){
		Client.communicator().destroy();
		try {
			connection.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
