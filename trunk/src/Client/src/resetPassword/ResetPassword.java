package resetPassword;

import javax.swing.JOptionPane;

import logic.Client;
import ProductLine.InvalidLoggingException;

public class ResetPassword implements IResetPassword {
	private ResetPasswordUI resetPasswordUI;
	
	public ResetPassword(){
		resetPasswordUI = new ResetPasswordUI();
	}

	@Override
	public void resetPassword(String identifier) throws InvalidLoggingException {
		try {
			Client.getProxy().resetPassword(identifier);
			JOptionPane
					.showMessageDialog(
							resetPasswordUI,
							"Su contraseña ha sido reseteada en breve recibirá un email",
							"Contraseña reseteada",
							JOptionPane.INFORMATION_MESSAGE);
			resetPasswordUI.dispose();
		} catch (InvalidLoggingException e) {
			JOptionPane.showMessageDialog(resetPasswordUI,
					"El usuario introducido no existe", "Cuenta errónea",
					JOptionPane.INFORMATION_MESSAGE);
		}
		
	}



}
