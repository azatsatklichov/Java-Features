package features.in.java11.httpclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

class URLConnectionReader {
	/**
	 * Old HttpURLConnection
	 * 
	 * https://docs.oracle.com/javase/tutorial/networking/urls/readingWriting.html
	 *
	 * <pre>
	*
	*- Since Java 1.1
	*
	*- Designed for HTTP/1.1
	*
	*- Before  Generics, Enums, Lambdas
	*
	*- You need to manage the edge cases, close connection etc
	*
	*- Casting URLConnection, if server is HTTP server
	*
	*- Method names are string, e.g. GET, no ENUMs in Java 1.1.
	 *
	 *- returns raw input stream, need to decorate it it for readability
	 * 
	 * </pre>
	 */
	public static void main(String[] args) throws Exception {
		URL oracle = new URL("https://docs.oracle.com/javase/tutorial/networking/urls/readingWriting.html");
		// URLConnection conn = oracle.openConnection();
		HttpURLConnection conn = (HttpURLConnection) oracle.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("User-Agent", "Java 1.1");

		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
		in.close();
	}

}

class ParseURL {
	public static void main(String[] args) throws Exception {

		URL aURL = new URL("https://docs.oracle.com:80/javase/tutorial/networking/urls/"
				+ "/index.html?name=networking#DOWNLOADING");

		System.out.println("protocol = " + aURL.getProtocol());
		System.out.println("authority = " + aURL.getAuthority());
		System.out.println("host = " + aURL.getHost());
		System.out.println("port = " + aURL.getPort());
		System.out.println("path = " + aURL.getPath());
		System.out.println("query = " + aURL.getQuery());
		System.out.println("filename = " + aURL.getFile());
		System.out.println("ref = " + aURL.getRef());
	}
}

class URLConnectionWriter {
	public static void main(String[] args) throws Exception {

		if (args.length != 2) {
			System.err.println(
					"Usage:  java Reverse " + "http://<location of your servlet/script>" + " string_to_reverse");
			System.exit(1);
		}

		String stringToReverse = URLEncoder.encode(args[1], "UTF-8");

		URL url = new URL(args[0]);
		URLConnection connection = url.openConnection();
		connection.setDoOutput(true);

		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
		out.write("string=" + stringToReverse);
		out.close();

		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String decodedString;
		while ((decodedString = in.readLine()) != null) {
			System.out.println(decodedString);
		}
		in.close();
	}
}