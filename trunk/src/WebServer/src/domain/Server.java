package domain;

import Ice.Communicator;



public class Server extends Ice.Application{
	
	private static Communicator communicator;

	@Override
	public int run(String[] args) {
		Ice.ObjectAdapter adapter = communicator().createObjectAdapter(
				"ProductLine.Server");
		ServerI server = new ServerI();
		adapter.add(server, communicator().stringToIdentity("sender"));
		adapter.activate();
		Server.communicator = communicator();
		communicator().waitForShutdown();
		System.out.println("Server down");
		return 0;
	}
	
	public static void stopServer(){
		communicator.destroy();
	}
}
