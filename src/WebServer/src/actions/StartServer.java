package actions;


import logic.ServerController;

import com.opensymphony.xwork2.ActionSupport;

public class StartServer extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6550433380271292990L;

	public String execute(){
		ServerController.getInstance().startServer();
		return SUCCESS;
		
	}
}
