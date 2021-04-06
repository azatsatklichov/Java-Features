package features.in.java11.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Desc: HttpClient, some examples are her influenced from the HttpClient course
 * of Sander Mak from pluralsight.
 * 
 * 
 * HttpClient standardized The new HttpClient has been standardized. It is
 * located in the java.net.http package. It is designed to improve the overall
 * performance of sending requests by a client and receiving responses from the
 * server. It also natively supports WebSockets.
 * 
 * <pre>
	 *  - Available since Java 11
	 *  
	 *  - modular, java.net.http
	 *  
	 *  - Replaces HttpURLConnection API
	 *  
	 *  - The new API supports both HTTP/1.1 and HTTP/2, WebSockets
	 *  
	 *  - Sync and Async methods
	 *  
	 *  - In case you do modular-application then use "java.net.http" in your module-info.java
 * 
 * </pre>
 */
public class C_New_HttpClient {

	public static void main(String[] args) throws IOException, InterruptedException {

		/**
		 * client with default settings <code>
		 * The default settings include:
				prefer HTTP/2
				no connection timeout - Don't confuse with request timeout!
				redirection policy of NEVER
				no cookie handler
				no authenticator
				default thread pool executor
				default proxy selector
				default SSL context
		 * </code>
		 * 
		 * 
		 * To configure yourself, use Otherwise use
		 * HttpClient.newBuilder().version(Version.HTTP_1_1) ..
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
		var request = HttpRequest.newBuilder().uri(URI.create("https://www.baeldung.com/java-flight-recorder-monitoring")).build();
		
		var request2Way = HttpRequest.newBuilder().
				uri(URI.create("https://www.baeldung.com/java-flight-recorder-monitoring")).build();

		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenAccept(System.out::println).join();

	}
}
