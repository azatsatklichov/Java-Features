package tasks.algorithmic.solutions;

import org.junit.Before;
import org.junit.Test; 

public class NCallsTest {

	private NCalls call;

	@Before
	public void init() {
		call = new NCalls();
	}

	@Test
	public void test1() throws Exception {
		System.out.println();
		call.omio();
		System.out.println();
		call.omio();
		System.out.println();
		call.omio();
	}

	/**
	 * 
	 * Expected to be fail after "Omio processing .. 14 (depends on processor also)
	 * 
	 * Reason: More than 1 second
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void test2() throws Exception {

		System.out.println();
		call.omio();
		System.out.println();
		call.omio();
		System.out.println();

		for (int i = 0; i < 997; i++) {
			Thread.currentThread().sleep(100);
			call.omio();
		}
		System.out.println();
		call.omio();
		Thread.currentThread().sleep(2000);
		System.out.println();
		call.omio();
	}

	/**
	 * 
	 * * Expected to be fail after "Omio processing .. 1000"
	 * 
	 * Reason: Can not run more than N times in 1 second
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void test3() throws Exception {
		System.out.println();
		call.omio();
		System.out.println();
		call.omio();
		System.out.println();


		for (int i = 0; i < 997; i++) {
			call.omio();
		}
		System.out.println();
		call.omio();
		Thread.currentThread().sleep(2000);
		System.out.println();
		call.omio();
	}
	 

}
