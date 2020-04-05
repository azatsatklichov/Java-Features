package features.in.java11.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.Executors;

public class G_HttpClientConfig {

	public static void main(String[] args) throws IOException, InterruptedException {

		/**
		 * Configuration
		 */
		HttpClient httpClient = HttpClient.newBuilder()
				// .version(Version.HTTP_1_1)
				// default is HTTP_2, if Server not supports HTTP2 then it fallbacks to HTTP1.1
				.version(Version.HTTP_2).priority(1) // only works with HTTP2 requests, priority range 1-256
				.followRedirects(Redirect.NORMAL) // NEVER, ALWAYS,..
				// establishing TCP conn to server, default un-limited, not you want
				.connectTimeout(Duration.ofSeconds(5))
				/**
				 * sometimes you can share executor among different httpclients, which will help
				 * to reuse threads.
				 */
				.executor(Executors.newSingleThreadExecutor()).build();

		HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("http://sahet.net")).build();

		HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		System.out.println(httpResponse.body());

	}

}
