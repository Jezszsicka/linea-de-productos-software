package configAccount;

import ProductLine.InvalidLoggingException;

public interface IConfigAccount {
	public void changeName(String username, String name, String lastname,
			String password) throws InvalidLoggingException;

	public void changeEmail(String username, String email, String password)
			throws InvalidLoggingException;

	public void changePassword(String username, String password,
			String newPassword) throws InvalidLoggingException;

	public void changeAvatar(String username, byte[] avatar);

	public void deleteAccount(String username, String password)
			throws InvalidLoggingException;
}
