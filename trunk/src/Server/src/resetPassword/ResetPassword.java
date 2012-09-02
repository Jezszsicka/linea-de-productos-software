package resetPassword;

import email.IEmail;
import persistence.UserDAO;
import model.User;
import utils.Utils;
import ProductLine.InvalidLoggingException;

public class ResetPassword implements IResetPassword {
	private IEmail mail;
	
	public ResetPassword(IEmail mail){
		this.mail = mail;
	}

	@Override
	public void resetPassword(String identifier) throws InvalidLoggingException {
		UserDAO userDAO = UserDAO.getDAO();
		User user = userDAO.loadByID(identifier);
		if(user != null){
			String newPassword = Utils.getPassword();
			user.setPassword(Utils.hashMD5_Base64(newPassword));
			userDAO.update(user);
			final String content = "Su nueva contraseña es: "+newPassword;
			new Thread(){
				public void run(){
					mail.sendMessage(content, "Cambio de contraseña","juanyanezgc@gmail.com");
				}
			}.start();
		}else{
			throw new InvalidLoggingException();
		}
	}


}
