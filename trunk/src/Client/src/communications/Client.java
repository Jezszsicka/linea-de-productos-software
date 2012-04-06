package communications;
import java.util.UUID;

import javax.swing.JOptionPane;

import IServer.ServerPrx;
import IServer.ServerPrxHelper;
import Ice.Application;


import domain.UserController;


public class Client extends Application {
	
	private static ServerPrx server;
	
	@Override
	public int run(String[] args) {
		try
        {
            starServerConnection();
            UserController.initialize();
            communicator().waitForShutdown();
        }
        catch (Ice.ConnectionRefusedException e) { 
    			try {
					javax.swing.UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
        	JOptionPane.showMessageDialog(null, "Server is off, try later","Server error",JOptionPane.ERROR_MESSAGE);
        }
			return 0;
	}
	
	private void starServerConnection(){
		server = ServerPrxHelper.checkedCast(communicator().propertyToProxy("Server.Proxy"));
        ServerProxy.setServerProxy(server);
	}
	
	public static void initializeCallback(){
		Ice.ObjectAdapter adapter = communicator().createObjectAdapter("");
        Ice.Identity callback = new Ice.Identity();
        callback.name = UUID.randomUUID().toString();
        callback.category = "";
        adapter.add(new ClientI(), callback);
        adapter.activate();
        server.ice_getConnection().setAdapter(adapter);
        UserController.getInstance().setCallback(callback); 
	}
	
	
	public static void main(String [] args){
		Client client = new Client();
		client.main("Client",args,"config.client");
	}

}
