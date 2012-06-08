package actions;

import logic.ServerController;

import com.opensymphony.xwork2.ActionSupport;


public class StopServer extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5860152018528430832L;
	
	public String execute(){
		ServerController.getInstance().stopServer();
		return SUCCESS;
		
	}
}
