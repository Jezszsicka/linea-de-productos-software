package test;

import static org.junit.Assert.*;

import model.User;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import ProductLine.RoleType;
import ProductLine.UserAlreadyExistsException;

import persistence.HibernateUtil;
import persistence.UserDAO;
import register.IRegister;
import register.Register;

public class RegisterTest {

	private static User user;
	
	@Before
	public void setUp() throws Exception {
		HibernateUtil.start();
		user = new User("Prueba", "Prueba", "Prueba", "Prueba", "Prueba",
				RoleType.Player, 0, null);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		UserDAO.getDAO().delete(user);
	}

	@Test
	public void test() {
		IRegister register = new Register();
		try {
			register.registerUser(user);
		} catch (UserAlreadyExistsException e) {
			fail("Unexcepted exception, UserAlreadyExists");
		}
	}
	
	@Test
	public void userExistsTest(){
		IRegister register = new Register();
		try {
			register.registerUser(user);
			fail("Unexcepted exception, UserNotExists");
		} catch (UserAlreadyExistsException e) {
		}
		
	}
	


}
