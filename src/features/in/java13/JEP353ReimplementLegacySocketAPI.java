package features.in.java13;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * JEP-353 Reimplement the Legacy Socket API
 * 
 * <pre>
 *  The underlying implementations of java.net.Socket and java.net.ServerSocket
 * is very old, date back to JDK 1.0, it is a mix of legacy Java and C code that
 * is hard to maintain and debug. This JEP introduces a new underlying
 * implementations for the Socket APIs and it is the default implementation in
 * Java 13.
 *
 *
 *
 *In Java 13, it introduces a new NioSocketImpl class as a drop-in replacement for PlainSocketImpl.
 *
 * </pre>
 */

//java -XX:+TraceClassLoading JEP353  | findStr Socket 
public class JEP353ReimplementLegacySocketAPI {
	public static void main(String[] args) {

		try (ServerSocket serverSocket = new ServerSocket(8888)) {

			boolean running = true;
			while (running) {

				Socket clientSocket = serverSocket.accept();
				// process
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
