package identify;

import ProductLine.InvalidLoggingException;
import ProductLine.UserAlreadyLoggedException;
import exceptions.WrongInputException;

public interface IIdentify {
	public void loginUser(String user, String password) throws WrongInputException, InvalidLoggingException, UserAlreadyLoggedException;
	public void logoutUser();
}
