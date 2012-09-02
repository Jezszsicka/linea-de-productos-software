package generalChat;

import java.util.List;

import model.Session;
import model.Sessions;
import ProductLine.UserNotLoggedException;

public class GeneralChat implements IGeneralChat{

	@Override
	public void sendGeneralMessage(final String sender, final String message) {
		List<Session> sessions = Sessions.getInstance().getSessions();
		for (final Session session : sessions) {
			if (!session.getUser().getUsername().equalsIgnoreCase(sender)) {
				new Thread() {
					public void run() {
						session.getCallback().receiveGeneralMessage(sender,
								message);
					}
				}.start();
				;
			}
		}
	}

	@Override
	public void sendPrivateMessage(final String sender, String receiver,
			final String message) throws UserNotLoggedException {
		final Session session = Sessions.getInstance().getSession(
				receiver);
		if (session != null) {
			new Thread() {
				public void run() {
					session.getCallback()
							.receivePrivateMessage(sender, message);
				}
			}.start();
		} else {
			throw new UserNotLoggedException();
		}
		
	}

}
