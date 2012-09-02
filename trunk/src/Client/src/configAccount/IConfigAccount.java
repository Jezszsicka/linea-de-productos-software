package configAccount;

import exceptions.WrongInputException;
import ProductLine.InvalidLoggingException;

public interface IConfigAccount {
	public void changeName(String name, String lastname, String password)
			throws InvalidLoggingException, WrongInputException;

	public void changeEmail(String email, String confirmEmail, String password)
			throws WrongInputException, InvalidLoggingException;

	public void changePassword(String password, String newPassword,
			String confirmPassword) throws InvalidLoggingException,
			WrongInputException;

	public void changeAvatar(byte[] avatar);

	public void deleteAccount(String password) throws InvalidLoggingException,
			WrongInputException;
}
