package register;

import ProductLine.UserAlreadyExistsException;
import model.User;

public interface IRegister {
	public void registerUser(User user) throws UserAlreadyExistsException;
}
