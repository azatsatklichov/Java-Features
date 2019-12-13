package features.in.java13;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The underlying implementations of java.net.Socket and java.net.ServerSocket
 * is very old, date back to JDK 1.0, it is a mix of legacy Java and C code that
 * is hard to maintain and debug. This JEP introduces a new underlying
 * implementations for the Socket APIs and it is the default implementation in
 * Java 13.
 * 
 * Before Java 13, it uses the PlainSocketImpl for the SocketImpl
 *
 */
public class JEP353Socket {
	public static void main(String[] args) {

		try (ServerSocket serverSocket = new ServerSocket(8888)) {

			boolean running = true;
			while (running) {

				Socket clientSocket = serverSocket.accept();
				// do something with clientSocket
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
