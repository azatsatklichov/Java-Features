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
 *The new implementation will be easy to adapt to work with user-mode threads, a.k.a. fibers, currently being explored in Project Loom.
 *
 *
 *In Java 13, it introduces a new NioSocketImpl class as a drop-in replacement for PlainSocketImpl.
 *
 * </pre>
 */

//>java -Djdk.net.usePlainSocketImpl -XX:+TraceClassLoading JEP353ReimplementLegacySocketAPI  | findStr Socket
public class JEP353ReimplementLegacySocketAPI {
	public static void main(String[] args) {

		/*
		 * 
		 * java.net.Socket -> java.net.serverSocket sun.ni.ch.NioSocketImplementation
		 * 
		 * In Java 13, the default implementation is NioSocketImpl
		 * 
		 * 
		 * To switch back to old PlainSocketImpl: -Djdk.net.usePlainSocketImpl
		 * 
		 * 
		 * TO TRACE
		 * 
		 * java -Djdk.net.usePlainSocketImpl -XX:+TraceClassLoading
		 * JEP353ReimplementLegacySocketAPI | findStr Socket
		 * 
		 */
		try (ServerSocket serverSocket = new ServerSocket(8888)) {

			boolean running = true;
			while (running) {
				Socket clientSocket = serverSocket.accept();
				// process on client socket
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
