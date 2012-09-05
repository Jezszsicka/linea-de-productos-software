package test;

import static org.junit.Assert.*;

import mailBox.IMailBox;
import mailBox.MailBox;
import model.Message;
import model.Session;
import model.Sessions;
import model.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import email.MailSender;

import ProductLine.MessageType;
import ProductLine.RoleType;
import ProductLine.UserNotExistsException;

import persistence.HibernateUtil;
import persistence.UserDAO;

public class MailBoxTest {
	private static IMailBox mailBox;
	private static User user;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		mailBox = new MailBox(new MailSender());
		HibernateUtil.start();
		user = new User("Prueba","Prueba", "Prueba", "Prueba", "Prueba@prueba.com", RoleType.Player, 0, null);
		UserDAO.getDAO().update(user);
		Sessions.getInstance().addSession(new Session(user,null));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Message msg = new Message("Prueba","Juan","Subject","Message",MessageType.Normal);
		try {
			mailBox.sendMessage(msg);
		} catch (UserNotExistsException e) {
			fail("UserNotExistsException");
		}
		User receiver = UserDAO.getDAO().loadByID("Juan");
		assertTrue(receiver.getMessages().get(0).getMessageID() == msg.getMessageID());
	}

}
