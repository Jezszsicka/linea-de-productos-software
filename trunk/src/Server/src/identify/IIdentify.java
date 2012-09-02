package identify;


import model.User;
import ProductLine.ClientPrx;
import ProductLine.InvalidLoggingException;
import ProductLine.UserAlreadyLoggedException;

public interface IIdentify {
	public User loginUser(String user, String password, ClientPrx callback) throws InvalidLoggingException, UserAlreadyLoggedException;
	public void logoutUser(String username);
}
