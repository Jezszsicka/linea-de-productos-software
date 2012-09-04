package register;

import model.User;
import ProductLine.UserAlreadyExistsException;
import exceptions.WrongInputException;

public interface IRegister {
	public void registerUser(User user, String password,
			String email) throws WrongInputException,
			UserAlreadyExistsException;
}
