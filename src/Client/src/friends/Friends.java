package friends;

import model.Session;
import ProductLine.UserNotExistsException;

public class Friends implements IFriends {

	@Override
	public void friendRequestResponse(String friend, boolean accepted) {
		Session session = Session.getInstance();
		try {
			session.getProxy().friendRequestResponse(friend,session.getUser().getUsername() , accepted);
			if(accepted)
				session.getUser().getFriends().add(friend);
			
		} catch (UserNotExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}


}
