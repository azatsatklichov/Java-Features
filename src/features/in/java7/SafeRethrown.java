package features.in.java7;

public class SafeRethrown {
	public void foo() throws RedException, BlueException { // without throwing Exception HERE

		try {
			// ...

			// final keyword HELP us to THROW SAFELY
		} catch (final Throwable e) {
			// LOGGER.info(e.getMessage(), e);
			throw e;
		}
	}

}

class RedException extends Exception {

	private static final long serialVersionUID = 1L;

}

class BlueException extends Exception {

	private static final long serialVersionUID = 1L;

}