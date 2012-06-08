/**
 * 
 */
package test;

import static org.junit.Assert.fail;
import logic.ServerThread;
import logic.UsersController;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ProductLine.InvalidLoggingException;
import ProductLine.UserAlreadyLoggedException;


/**
 * @author Juan
 *
 */
public class LoginUserLogged {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ServerThread thread = new ServerThread();
		thread.start();
		UsersController.getInstance().registerUser("testUser", "testUser", "testEmail");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		UsersController.getInstance().deleteUser("testUser");
	}

	@Test
	public void test() {
		try {
			UsersController controller = UsersController.getInstance();
			controller.loginUser("testUser","testUser",null);
			controller.loginUser("testUser","testUser",null);
		} catch (UserAlreadyLoggedException e) {
			
		} catch (InvalidLoggingException e) {
			fail("Invalid loggin exception");
		}
	}

}
