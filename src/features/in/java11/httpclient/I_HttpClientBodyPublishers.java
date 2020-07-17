package features.in.java11.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

public class I_HttpClientBodyPublishers {

	private static HttpClient httpClient;

	public static void main(String[] args) throws IOException, InterruptedException {

		httpClient = HttpClient.newHttpClient();

		/**
		 * POST method used as PAYLOAD as being BODY PUBLISHER
		 * 
		 * also see PUT, PATCH, ...
		 * 
		 * and also method -> method(String methodName, BodyPublisher pub)
		 * 
		 * ofString(body)
		 * 
		 * ofByteArray(Path)
		 * 
		 * ofInputStream
		 * 
		 * noBody
		 * 
		 *  
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
		 * - discarding -> Void - noBody, just used to check STATUS
	 
		 */

		HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("http://sahet.net"))
				.POST(BodyPublishers.ofString("some body infor form")).build();

		httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body)
				.thenAccept(System.out::println).join();

	}

}