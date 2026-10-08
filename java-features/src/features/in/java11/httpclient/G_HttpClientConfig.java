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
		 * 
		 * * The default settings include: <code>
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
		 * Custome settings e.g. <code>
		 * var client = HttpClient.newBuilder()
		    .authenticator(Authenticator.getDefault())
		    .connectTimeout(Duration.ofSeconds(30))
		    .cookieHandler(CookieHandler.getDefault())
		    .executor(Executors.newFixedThreadPool(2))
		    .followRedirects(Redirect.NEVER)
		    .priority(1) //HTTP/2 priority
		    .proxy(ProxySelector.getDefault())
		    .sslContext(SSLContext.getDefault())
		    .version(Version.HTTP_2)
		    .sslParameters(new SSLParameters())
		    .build();
		 * </code>
		 */

		System.out.println(
				"Once created, an HttpClient instance is immutable, thus automatically thread-safe, and you can send multiple requests with it.");
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
				 * 
				 * Executor exec = Executors.newCachedThreadPool(); HttpClient.newBuilder()
				 * .executor(exec)
				 */
				.executor(Executors.newSingleThreadExecutor()).build();

		HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("http://sahet.net")).build();

		HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		System.out.println(httpResponse.body());

	}

}
