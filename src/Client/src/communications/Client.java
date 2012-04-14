package communications;
import java.util.UUID;

import javax.swing.JOptionPane;

import IServer.ServerPrx;
import IServer.ServerPrxHelper;
import Ice.Application;
import Ice.Communicator;
import Ice.Identity;
import Ice.ObjectAdapter;


public class Client extends Application {
	
	private static ServerPrx proxy;
	private static Communicator communicator;
	
	@Override
	public int run(String[] args) {
		try
        {
            starServerConnection();
            communicator.waitForShutdown();
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
		proxy = ServerPrxHelper.checkedCast(communicator().propertyToProxy("Server.Proxy"));
		communicator = communicator();
	}
	
	public static Identity initializeCallback(){
		ObjectAdapter adapter = communicator().createObjectAdapter("");
        Identity callback = new Ice.Identity();
        callback.name = UUID.randomUUID().toString();
        callback.category = "";
        adapter.add(new ClientI(), callback);
        adapter.activate();
        return callback;
	}
	
	public static ServerPrx getProxy(){
		return proxy;
	}
	
	public static void main(String [] args){
		Client client = new Client();
		client.main("Client",args,"config.client");
	}

}
