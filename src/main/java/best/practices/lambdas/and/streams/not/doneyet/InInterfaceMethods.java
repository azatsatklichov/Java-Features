package best.practices.lambdas.and.streams.not.doneyet;

/**
 * Prior to java 8, interfaces can have following type of variables/methods.
 *
 * <pre>
	Constant variables
	Abstract methods

So we cannot have method implementation in interfaces or more precisely 
a default implementation prior to Java 8. See the examples below.
 * 
 * </pre>
 */
public class InInterfaceMethods {
	public static void main(String[] args) {

	}
}

class Tester {
	public static void main(String[] args) {
		LogOracle log = new LogOracle();
		log.logInfo("");
		log.logWarn("");
		log.logError("");
		log.logFatal("");
		LogMySql log1 = new LogMySql();
		log1.logInfo("");
		log1.logWarn("");
		log1.logError("");
		log1.logFatal("");
	}
}

final class LogOracle implements Logging {
	@Override
	public void logInfo(String message) {
		getConnection();
		System.out.println("Log Message : " + "INFO");
		closeConnection();
	}

	@Override
	public void logWarn(String message) {
		getConnection();
		System.out.println("Log Message : " + "WARN");
		closeConnection();
	}

	@Override
	public void logError(String message) {
		getConnection();
		System.out.println("Log Message : " + "ERROR");
		closeConnection();
	}

	@Override
	public void logFatal(String message) {
		getConnection();
		System.out.println("Log Message : " + "FATAL");
		closeConnection();
	}

	@Override
	public void getConnection() {
		System.out.println("Open Database connection");
	}

	@Override
	public void closeConnection() {
		System.out.println("Close Database connection");
	}
}

final class LogMySql implements Logging {
	@Override
	public void logInfo(String message) {
		getConnection();
		System.out.println("Log Message : " + "INFO");
		closeConnection();
	}

	@Override
	public void logWarn(String message) {
		getConnection();
		System.out.println("Log Message : " + "WARN");
		closeConnection();
	}

	@Override
	public void logError(String message) {
		getConnection();
		System.out.println("Log Message : " + "ERROR");
		closeConnection();
	}

	@Override
	public void logFatal(String message) {
		getConnection();
		System.out.println("Log Message : " + "FATAL");
		closeConnection();
	}

	@Override
	public void getConnection() {
		System.out.println("Open Database connection");
	}

	@Override
	public void closeConnection() {
		System.out.println("Close Database connection");
	}
}

interface Logging {
	String ORACLE = "Oracle_Database";
	String MYSQL = "MySql_Database";

	void logInfo(String message);

	void logWarn(String message);

	void logError(String message);

	void logFatal(String message);

	void getConnection();

	void closeConnection();
}

/**
 * In above example, each log method has its own implementation. With Java 8
 * interfaces can have following type of variables/methods.
 * 
 * Constant variables Abstract methods Default methods Static methods Let's have
 * default implementation and static methods in interface itself using Java 8.
 * 
 * <pre>
 *
 * </pre>
 */

class TesterJava8 {
	public static void main(String[] args) {
		LogOracle2 log = new LogOracle2();
		log.logInfo("");
		log.logWarn("");
		log.logError("");
		log.logFatal("");

		LogMySql2 log1 = new LogMySql2();
		log1.logInfo("");
		log1.logWarn("");
		log1.logError("");
		log1.logFatal("");
	}
}

final class LogOracle2 implements Logging2 {
}

final class LogMySql2 implements Logging2 {
}

interface Logging2 {
	String ORACLE = "Oracle_Database";
	String MYSQL = "MySql_Database";

	default void logInfo(String message) {
		getConnection();
		System.out.println("Log Message : " + "INFO");
		closeConnection();
	}

	default void logWarn(String message) {
		getConnection();
		System.out.println("Log Message : " + "WARN");
		closeConnection();
	}

	default void logError(String message) {
		getConnection();
		System.out.println("Log Message : " + "ERROR");
		closeConnection();
	}

	default void logFatal(String message) {
		getConnection();
		System.out.println("Log Message : " + "FATAL");
		closeConnection();
	}

	static void getConnection() {
		System.out.println("Open Database connection");
	}

	static void closeConnection() {
		System.out.println("Close Database connection");
	}
}

/**
 * In above example, we're having repeating again. With Java 9 interfaces can
 * have following type of variables/methods.
 * 
 * <pre>
*
	Constant variables
	Abstract methods
	Default methods
	Static methods
	Private methods
	Private Static methods
	Let's have private methods and use them in Java 9.>
 *
 * </pre>
 */
class TesterJava9 {
	public static void main(String[] args) {
		LogOracle3 log = new LogOracle3();
		log.logInfo("");
		log.logWarn("");
		log.logError("");
		log.logFatal("");

		LogMySql3 log1 = new LogMySql3();
		log1.logInfo("");
		log1.logWarn("");
		log1.logError("");
		log1.logFatal("");
	}
}

final class LogOracle3 implements Logging3 {
}

final class LogMySql3 implements Logging3 {
}

interface Logging3 {
	String ORACLE = "Oracle_Database";
	String MYSQL = "MySql_Database";

	private void log(String message, String prefix) {
		getConnection();
		System.out.println("Log Message : " + prefix);
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
