package logic;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import com.sun.mail.smtp.SMTPTransport;

import constants.Constants;

public class MailSender {

	public static MailSender myInstance = null;
	Session session = null;
	Properties props = null;

	public MailSender() {
		props = new Properties();

		// SMTP host name
		props.setProperty("mail.smtp.host", "smtp.gmail.com");

		// TLS
		props.setProperty("mail.smtp.starttls.enable", "true");

		// SMTP port
		props.setProperty("mail.smtp.port", "587");

		// SMTP User
		props.setProperty("mail.smtp.user", Constants.Account);
		session = Session.getDefaultInstance(props);
		// session.setDebug(true);
	}

	public static MailSender getMailSender() {
		if (myInstance == null)
			myInstance = new MailSender();
		return myInstance;
	}

	public void sendMessage(String text, String subject, String address) {

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(Constants.Account));
			message.addRecipient(RecipientType.TO, new InternetAddress(address));

			// Subject and text

			message.setSubject(Constants.Subject+subject);
			message.setText(text);
			SMTPTransport t = (SMTPTransport) session.getTransport("smtp");

			t.connect(Constants.Account, Constants.Password);
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
}
