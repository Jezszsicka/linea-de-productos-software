package resetPassword;

import ProductLine.InvalidLoggingException;

public interface IResetPassword {
	public void resetPassword(String identifier) throws InvalidLoggingException;
}
