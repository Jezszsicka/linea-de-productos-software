package register;

import model.User;
import ProductLine.UserAlreadyExistsException;
import exceptions.WrongInputException;

public interface IRegister {
	public void registerUser(final User user, String retypedPassword,
			String retypedEmail) throws WrongInputException,
			UserAlreadyExistsException;
}
