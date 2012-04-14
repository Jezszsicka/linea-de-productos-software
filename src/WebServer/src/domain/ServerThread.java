package domain;

public class ServerThread extends Thread {
	
	
	public void run(){
		Server server = new Server();
		String[] args = new String[0];
		server.main("Server", args, "config.server");
	}
}
