package email;

public interface IEmail {
	public void sendMessage(final String text, final String subject, final String address);
}
