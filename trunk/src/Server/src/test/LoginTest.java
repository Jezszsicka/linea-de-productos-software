package test;

import static org.junit.Assert.*;
import identify.IIdentify;
import identify.UsersManager;

import model.Sessions;
import model.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import persistence.HibernateUtil;
import persistence.UserDAO;
import ProductLine.InvalidLoggingException;
import ProductLine.RoleType;
import ProductLine.UserAlreadyLoggedException;

public class LoginTest {
	private static String wrongUsername;
	private static String wrongPassword;
	private static User user;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		HibernateUtil.start();
		user = new User("Prueba", "Prueba", "Prueba", "Prueba", "Prueba",
				RoleType.Player, 0, null);
		wrongUsername = "WrongUser";
		wrongPassword = "WrongPassoword";
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		UserDAO.getDAO().delete(user);
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		IIdentify identify = new UsersManager();
		try {
			identify.loginUser("Prueba","Prueba", null);
		} catch (InvalidLoggingException e) {
			fail("InvalidLoggingException");
		} catch (UserAlreadyLoggedException e) {
			fail("UserAlreadyLoggedException");
		}
		assertTrue(Sessions.getInstance().getSession("Prueba") != null);
	}
	
	@Test
	public void wrongUserTest(){
		IIdentify identify = new UsersManager();
		try {
			identify.loginUser(wrongUsername,"Prueba", null);
			fail("Exception excepted");
		} catch (InvalidLoggingException e) {			
		} catch (UserAlreadyLoggedException e) {
			fail("UserAlreadyLoggedException");
		}
	}
	
	@Test
	public void wrongPasswordTest(){
		IIdentify identify = new UsersManager();
		try {
			identify.loginUser("Prueba",wrongPassword, null);
			fail("Exception excepted");
		} catch (InvalidLoggingException e) {	
			
		} catch (UserAlreadyLoggedException e) {
			fail("UserAlreadyLoggedException");
		}
	}

}
