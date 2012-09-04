package chatGeneral;

import ProductLine.UserNotLoggedException;

public interface IGeneralChat {
	public void sendGeneralMessage(String message);
	public void sendPrivateMessage(String receiver,
			String message) throws UserNotLoggedException;
}
