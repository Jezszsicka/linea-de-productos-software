package register;

import org.hibernate.HibernateException;

import persistence.UserDAO;

import model.User;
import ProductLine.UserAlreadyExistsException;

public class Register implements IRegister {

	@Override
	public void registerUser(User user) throws UserAlreadyExistsException {
		UserDAO userDAO = UserDAO.getDAO();
		
		try {
			if (userDAO.userAvailable(user.getUsername())) {
				userDAO.create(user);
			} else {
				throw new UserAlreadyExistsException();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}



}
