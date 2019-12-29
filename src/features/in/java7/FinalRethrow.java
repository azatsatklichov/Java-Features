package features.in.java7;

import java.io.IOException;
import java.text.ParseException;

public class FinalRethrow {

	// suppose we have
	private void testFinalRethrow(final int a) throws IOException,
			ParseException {
		// code which throws IOException and ParseException
	}

	/*
	 * Now, if we want to do some operation (say log the exception) upon
	 * catching these exceptions and before rethrowing them, we could modify the
	 * above method like this:
	 */

	private void testFinalRethrow2(final int a) throws IOException,
			ParseException {
		try {
			// code which throws IOException and ParseException
		} catch (Exception ex) {
			// Log exception
			throw ex;
		}
	}

	/*
	 * But, the problem with this is, compiler will not like this since the
	 * method does not throw Exception (It only throws IOException and
	 * ParseException, which are subtypes of Exception). We are now forced to
	 * add Exception to method signature, but we may not be able to do this if
	 * testFinalRethrow overrides a method which does not declare throwing
	 * Exception.
	 */

	// In Java7, we could simplify this by adding final keyword in catch block.
	// We could modify the above method to look like this:
	private void testFinalRethrow3(final int a) throws IOException,
			ParseException {
		try {
			// code which throws IOException and ParseException
		} catch (final Exception ex) { // Look at final keyword here
			// Log exception
			throw ex;
		}
	}

	private void testFinalRethrow4(final int a) throws Exception {
		try {
			// code which throws IOException and ParseException
		} catch (final Exception ex) { // Look at final keyword here
			// Log exception
			throw ex; 
		}
	}
}
