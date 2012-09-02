package friends;

import ProductLine.UserNotExistsException;

public interface IFriends {
	public void friendRequestResponse(String friend, String user,
			boolean accepted) throws UserNotExistsException;
}
