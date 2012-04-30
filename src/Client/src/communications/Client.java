package communications;
import java.util.UUID;

import javax.swing.JOptionPane;

import domain.Controller;

import Ice.Application;
import Ice.Communicator;
import Ice.Identity;
import Ice.ObjectAdapter;
import ProductLine.ServerPrx;
import ProductLine.ServerPrxHelper;


public class Client extends Application {
	
	private static ServerPrx proxy;
	private static Communicator communicator;
	private static Identity callback;
	
	@Override
	public int run(String[] args) {
		try
        {
            starServerConnection();
            Controller.initialize();
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
		ObjectAdapter adapter = communicator.createObjectAdapter("");
        callback = new Ice.Identity();
        callback.name = UUID.randomUUID().toString();
        callback.category = "";
        adapter.add(new ClientI(), callback);
        adapter.activate();
        proxy.ice_getConnection().setAdapter(adapter);
	}
	
	public static Identity getCallback(){
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
