/**
 * 
 */
package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import logic.ServerThread;
import logic.UsersManager;
import model.Session;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ProductLine.InvalidLoggingException;
import ProductLine.UserAlreadyLoggedException;


/**
 * @author Juan
 *
 */
public class LoginTest {

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
			int sessions = controller.getSessions().size();
			controller.loginUser("testUser","testUser",null);
			Session newSession = controller.getSessions().get(0);
			assertTrue(newSession.getUsername().equals("testUser") && controller.getSessions().size() == sessions+1);
		} catch (UserAlreadyLoggedException e) {
			fail("User already logged");
		} catch (InvalidLoggingException e) {
			fail("Invalid loggin exception");
		}
	}
}
