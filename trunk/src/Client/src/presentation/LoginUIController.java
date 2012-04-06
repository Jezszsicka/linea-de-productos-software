package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import domain.UserController;

public class LoginUIController implements ActionListener{
	private LoginUI loginUI;
	
	public LoginUIController(){
		loginUI = new LoginUI(this);
		loginUI.setLocationRelativeTo(null);
		loginUI.setVisible(true);
	}
	
	public void close(){
		loginUI.dispose();
	}

	public void loginUser(String username, String password) {
		try {
			validateInput(username,password);
			UserController.getInstance().loginUser(username, password);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(loginUI, "Input error", "Incorrect login",JOptionPane.WARNING_MESSAGE);
			
		}
		
	}
	
	private void validateInput(String username, String password) throws Exception{
		if(username.isEmpty()|| password.isEmpty())
			throw new Exception();
	}

	public void openRegisterUI() {
		loginUI.setEnabled(false);
		UserController.getInstance().startRegister();	
	}

	public void activate() {
		loginUI.setEnabled(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
