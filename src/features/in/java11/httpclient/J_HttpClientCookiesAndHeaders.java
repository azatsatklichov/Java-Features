package features.in.java11.httpclient;

import java.io.IOException;
//import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

public class J_HttpClientCookiesAndHeaders {

	private static HttpClient httpClient;

	public static void main(String[] args) throws IOException, InterruptedException {
		/**
		 * Cookies - to manage state, token, etc..
		 * 
		 * cookies are persistent
		 * 
		 * HttpClient.Builder::cookieHandler
		 * 
		 * 
		 * 
		 * Headers
		 * 
		 * e.g. host-name is mandatory, we pass it automatically, ...
		 * 
		 * 
		 */

		// null - in memory PersistentStore will be used, accept all cookies
		CookieManager cookieManager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
		httpClient = HttpClient.newBuilder().cookieHandler(cookieManager).build();

		HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("http://jsonvat.com/"))
				.header("Accept", "text/html").header("content-language", "en-us")
				.headers("User-Agent", "Java", "Cache-Control", "no-transform", "Cache-Control", "no-store")
				// to replace header
				.setHeader("Accept", "application/json")

				.POST(BodyPublishers.ofString("some body infor form"))

				.build();

		httpClient.send(httpRequest, HttpResponse.BodyHandlers.discarding());
		System.out.println(cookieManager.getCookieStore().getCookies());

		System.out.println("another example for cookie");
		//httpClient = HttpClient.newBuilder().cookieHandler(CookieHandler.getDefault()).build();
		httpRequest = HttpRequest.newBuilder(URI.create("https://google.com")).build();
		httpClient.send(httpRequest, HttpResponse.BodyHandlers.discarding());

		System.out.println(cookieManager.getCookieStore().getURIs());
		System.out.println(cookieManager.getCookieStore().getCookies());

	}

}