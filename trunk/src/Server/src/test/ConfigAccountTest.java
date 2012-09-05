package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import model.Session;
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
import configAccount.ConfigAccount;
import configAccount.IConfigAccount;

public class ConfigAccountTest {
	private static IConfigAccount config;
	private static User user;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		config = new ConfigAccount();
		HibernateUtil.start();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		UserDAO.getDAO().delete(user);
	}

	@Before
	public void setUp() throws Exception {
		user = new User("Prueba","Prueba", "Prueba", "Prueba", "Prueba@prueba.com", RoleType.Player, 0, null);
		UserDAO.getDAO().update(user);
		Sessions.getInstance().addSession(new Session(user,null));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			config.changeName("Prueba", "Nombre", "Apellido", "Prueba");
		} catch (InvalidLoggingException e) {
			fail("Invalid logging exception");
		}
		
		try {
			config.changeEmail("Prueba", "a@a.aa", "Prueba");
		} catch (InvalidLoggingException e) {
			fail("Invalid logging exception");
		}
		
		try {
			config.changePassword("Prueba", "Prueba", "Contraseña");
		} catch (InvalidLoggingException e) {
			fail("Invalid logging exception");
		}
		
		user = UserDAO.getDAO().loadByID(user.getUsername());
		Sessions.getInstance().getSession(user.getUsername()).setUser(user);
		assertTrue(user.getName().equals("Nombre") && user.getLastName().equals("Apellido"));
		assertTrue(user.getEmail().equals("a@a.aa"));
		assertFalse(user.getPassword().equals("Prueba"));
		
		try {
			config.deleteAccount(user.getUsername(), user.getPassword());
		} catch (InvalidLoggingException e) {
			fail("Invalid logging exception");
		}
		
		assertTrue(Sessions.getInstance().getSession(user.getUsername()) == null);
		assertTrue(UserDAO.getDAO().loadByID(user.getUsername()) == null);
	}
	
	@Test
	public void wrongPasswordTest(){
		try {
			config.changeEmail(user.getUsername(),"email" , "wrongPassword");
			fail("Exception excepted");
		} catch (InvalidLoggingException e) {
		}
	}

}
