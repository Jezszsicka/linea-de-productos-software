package communications;

import IServer.ServerPrx;

public class ServerProxy {
	private static ServerPrx server;
	
	public static void setServerProxy(ServerPrx server){
		ServerProxy.server = server;
	}
	
	public static ServerPrx getProxy(){
		return server;
	}
}
