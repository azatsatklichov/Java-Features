package features.in.java9;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * 
 * A New HTTP Client
 *
 * A new way of performing HTTP calls arrives with Java 9. As existing or Legacy
 * HTTP Client API has numerous issues (like supports HTTP/1.1 protocol and does
 * not support HTTP/2 protocol and WebSocket, works only in Blocking mode and
 * lot of performance issues.), they are replacing this HttpURLConnection API
 * with new HTTP client. They are going to introduce new HTTP 2 Client API under
 * “java.net.http” package. It supports both HTTP/1.1 and HTTP/2 protocols. It
 * supports both Synchronous (Blocking Mode) and Asynchronous Modes. It supports
 * Asynchronous Mode using WebSocket API.
 * 
 * <pre>
*
A long-awaited replacement of the old HttpURLConnection.

The new API is located under the java.net.http package.

It should support both HTTP/2 protocol and WebSocket handshake, with performance that should be comparable with the Apache HttpClient, Netty and Jetty.

Let have a look at this new functionality by creating and sending a simple HTTP request.

Update: The HTTP Client JEP is being moved to Incubator module, so it is no longer available in the package java.net.http and instead is available under jdk.incubator.http.
 *
 * 
 * </pre>
 */
public class NewHttpClient {
	public static void main(String[] args) throws URISyntaxException {

		HttpClient client = HttpClient.newHttpClient();

		HttpRequest req = HttpRequest.newBuilder(URI.create("http://www.google.com")).header("User-Agent", "Java").GET()
				.build();

		//HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandler.asString());

		System.out.println(req.bodyPublisher().get());
	}

}
