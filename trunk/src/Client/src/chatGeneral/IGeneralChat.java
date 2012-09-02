package chatGeneral;

import ProductLine.UserNotLoggedException;

public interface IGeneralChat {
	public void sendGeneralMessage(String message);
	public void sendPrivateMessage(String receiver,
			final String message) throws UserNotLoggedException;
}
