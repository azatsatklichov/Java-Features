package features.in.java11.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Desc: HttpClient
 *
 * 
 * HttpClient standardized The new HttpClient has been standardized. It is
 * located in the java.net.http package. It is designed to improve the overall
 * performance of sending requests by a client and receiving responses from the
 * server. It also natively supports WebSockets.
 * 
 * <pre>
* 
	 *  - Available since Java 11
	 *  
	 *  - Replaces HttpURLConnection API
	 *  
	 *  - The new API supports both HTTP/1.1 and HTTP/2, WebSockets
	 *  
	 *  - Sync and Async methoda
	 *  
	 *  - In case you do modular-application then use "java.net.http" in your module-info.java
 * 
 * </pre>
 */
public class C_New_HttpClient {

	public static void main(String[] args) throws IOException, InterruptedException {

		/**
		 * client with default settings
		 */
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("http://sahet.net")).build();

		/**
		 * send methods throws 2 exceptions IOException, InterruptedException
		 * 
		 * BodyHandlers
		 * 
		 * - ofString -> String
		 * 
		 * - ofByteArray -> byte[]
		 * 
		 * - ofFile(Path) -> as response writes to Path you provided
		 * 
		 * - ofLines -> Stream<String>
		 * 
		 * - discarding -> Void
		 * 
		 */
		HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		System.out.println(httpResponse.body());

	}

}

class HttpClientSendAsync {
	public static void main(String[] args) {

		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder()
				.uri(URI.create("https://www.baeldung.com/java-flight-recorder-monitoring")).build();

		client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body)
				.thenAccept(System.out::println).join();

	}
}
