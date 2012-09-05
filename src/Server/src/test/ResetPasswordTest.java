package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import model.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import persistence.HibernateUtil;
import persistence.UserDAO;

import ProductLine.InvalidLoggingException;
import ProductLine.RoleType;

import email.MailSender;

import resetPassword.IResetPassword;
import resetPassword.ResetPassword;

public class ResetPasswordTest {
	private IResetPassword resetPassword;
	private User user;
	

	@Before
	public void setUp() throws Exception {
		HibernateUtil.start();
		resetPassword = new ResetPassword(new MailSender());
		user = new User("Prueba","Prueba", "Prueba", "Prueba", "Prueba@prueba.com", RoleType.Player, 0, null);
		UserDAO.getDAO().update(user);
	}

	@After
	public void tearDown() throws Exception {
		UserDAO.getDAO().delete(user);
	}

	@Test
	public void test() {
		try {
			resetPassword.resetPassword(user.getUsername());
		} catch (InvalidLoggingException e) {
			fail("InvalidLogginException");
		}
		user = UserDAO.getDAO().loadByID(user.getUsername());
		assertFalse(user.getPassword().equals("Prueba"));
	}
	
	@Test
	public void userNotExistsTest(){
		try {
			resetPassword.resetPassword("NotExists");
			fail("Exception excepted");
		} catch (InvalidLoggingException e) {
		}
		
	}

}
