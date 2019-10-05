package features.in.java11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * HttpClient standardized The new HttpClient has been standardized. It is
 * located in the java.net.http package.
 * 
 * The new API supports both HTTP/1.1 and HTTP/2. It is designed to improve the
 * overall performance of sending requests by a client and receiving responses
 * from the server. It also natively supports WebSockets.
 */
public class HttpClientStandardized {
	public static void main(String[] args) {

		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder()
				// .uri(URI.create("http://webcode.me"))
				.uri(URI.create("http://sahet.net")).build();

		client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body)
				.thenAccept(System.out::println).join();
	}
}
