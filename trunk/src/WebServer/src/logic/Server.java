package logic;


import communications.ObjectFactory;
import communications.ServerI;

import Ice.Communicator;
import ProductLine.Filter;
import ProductLine.Game;
import ProductLine.User;



public class Server extends Ice.Application{
	
	private static Communicator communicator;

	@Override
	public int run(String[] args) {
		Server.communicator = communicator();
		communicator.addObjectFactory(new ObjectFactory(), Game.ice_staticId());
		communicator.addObjectFactory(new ObjectFactory(), User.ice_staticId());
		communicator.addObjectFactory(new ObjectFactory(), Filter.ice_staticId());
		Ice.ObjectAdapter adapter = communicator().createObjectAdapter(
				"ProductLine.Server");
		ServerI server = new ServerI();
		adapter.add(server, communicator().stringToIdentity("sender"));
		adapter.activate();
		communicator().waitForShutdown();
		System.out.println("Server down");
		return 0;
	}
	
	public static void stopServer(){
		communicator.destroy();
	}
}

