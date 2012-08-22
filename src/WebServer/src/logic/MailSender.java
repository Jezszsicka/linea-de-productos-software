package logic;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import com.sun.mail.smtp.SMTPTransport;

import constants.MailConstants;

public class MailSender {

	private static MailSender manager = null;
	Session session = null;
	Properties props = null;

	private MailSender() {
		props = new Properties();

		// SMTP host name
		props.setProperty("mail.smtp.host", "smtp.gmail.com");

		// TLS
		props.setProperty("mail.smtp.starttls.enable", "true");

		// SMTP port
		props.setProperty("mail.smtp.port", "587");

		// SMTP User
		props.setProperty("mail.smtp.user", MailConstants.Account);
		session = Session.getDefaultInstance(props);
		// session.setDebug(true);
	}

	public static MailSender getMailSender() {
		if (manager == null)
			manager = new MailSender();
		return manager;
	}

	public void sendMessage(final String text, final String subject, final String address) {
		
		new Thread(){
			public void run(){
				MimeMessage message = new MimeMessage(session);
				try {
					message.setFrom(new InternetAddress(MailConstants.Account));
					message.addRecipient(RecipientType.TO, new InternetAddress(address));

					// Subject and text

					message.setSubject(MailConstants.Subject+subject);
					message.setText(text);
					SMTPTransport t = (SMTPTransport) session.getTransport("smtp");

					t.connect(MailConstants.Account, MailConstants.Password);
					t.sendMessage(message, message.getAllRecipients());

					t.close();
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();


	}
}
