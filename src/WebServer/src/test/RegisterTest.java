/**
 * 
 */
package test;

import static org.junit.Assert.*;
import logic.ServerThread;
import logic.UsersController;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author Juan
 *
 */
public class RegisterTest {

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
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
