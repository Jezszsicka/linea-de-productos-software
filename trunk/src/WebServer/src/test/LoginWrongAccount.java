/**
 * 
 */
package test;

import static org.junit.Assert.*;
import logic.ServerThread;
import logic.UsersManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ProductLine.InvalidLoggingException;
import ProductLine.UserAlreadyLoggedException;


/**
 * @author Juan
 *
 */
public class LoginWrongAccount {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ServerThread thread = new ServerThread();
		thread.start();
		UsersManager.getInstance().registerUser("testUser", "testUser", "testEmail");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		UsersManager.getInstance().deleteUser("testUser");
	}

	@Test
	public void test() {
		try {
			UsersManager controller = UsersManager.getInstance();
			controller.loginUser("testUser","WrongPassword",null);
		} catch (UserAlreadyLoggedException e) {
			fail("Invalid loggin exception");
		} catch (InvalidLoggingException e) {
			
		}
	}

}
