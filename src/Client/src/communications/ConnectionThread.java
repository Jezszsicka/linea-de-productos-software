package communications;

public class ConnectionThread extends Thread {
	public static Client client;
	
	public void run(){
		client = new Client();
		String [] args = new String[0];
		client.main("Client",args,"config.client");
	}
	
	public static Client getClient(){
		return client;
	}
}
