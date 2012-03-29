package domain;

import persistence.HibernateUtil;

public class ServerController {
	
	private static ServerController controller;
	private boolean online;
	private ServerThread server;
	
	private ServerController(){
		online = false;
	}
	
	public static ServerController getInstance(){
		if(controller == null)
			controller = new ServerController();
		return controller;
	}
	
	public void startServer(){
		if(!online){
			server = new ServerThread();
			server.start();
			online = true;
			HibernateUtil.start();
		}
			
	}
	
	public void restartServer(){
		Server.communicator().destroy();
		try {
			server.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		server = new ServerThread();
		server.start();
	}
	
	public void stopServer(){
		Server.communicator().shutdown();
		try {
			server.join(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		online = false;
	}

	/**
	 * @return the online
	 */
	public boolean isOnline() {
		return online;
	}

	/**
	 * @param online the online to set
	 */
	public void setOnline(boolean online) {
		this.online = online;
	}
	
}