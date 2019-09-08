package features.in.java9;

/**
 * Desc:
 * 
 * <pre>
* Prior to java 8, interfaces can have following type of variables/methods.

Constant variables
Abstract methods

So we cannot have method implementation in interfaces or more precisely a default implementation prior to Java 8

With Java 8 interfaces can have following type of variables/methods.

Constant variables
Abstract methods

Default methods
Static methods
 
 *
 *With Java 9 interfaces can have following type of variables/methods.

Constant variables
Abstract methods
Default methods
Static methods

Private methods - To avoid redundant code and more re-usability.
Private Static methods
 * 
 * 
 * </pre>
 */
public interface PrivateInterfaceMethods {
	public static void main(String[] args) {
		Logging log = new LogOracle();
		log.logInfo("a");
		log.logWarn("b");
		log.logError("c");
		log.logFatal("d");

		System.out.println();

		Logging log1 = new LogMySql();
		log1.logInfo("1");
		log1.logWarn("2");
		log1.logError("3");
		log1.logFatal("4");
	}

}

final class LogOracle implements Logging {
}

final class LogMySql implements Logging {
}

interface Logging {
	String ORACLE = "Oracle_Database";
	String MYSQL = "MySql_Database";

	private void log(String message, String prefix) {
		getConnection();
		System.out.println("Log Message : " + message + " " + prefix);
		closeConnection();
	}

	default void logInfo(String message) {
		log(message, "INFO");
	}

	default void logWarn(String message) {
		log(message, "WARN");
	}

	default void logError(String message) {
		log(message, "ERROR");
	}

	default void logFatal(String message) {
		log(message, "FATAL");
	}

	private static void getConnection() {
		System.out.println("Open Database connection");
	}

	private static void closeConnection() {
		System.out.println("Close Database connection");
	}
}