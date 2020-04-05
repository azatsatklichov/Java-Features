package features.in.java11.hhtpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class G_HttpClientInDeep {

	public static void main(String[] args) throws IOException, InterruptedException {

		HttpClient httpClient = HttpClient.newHttpClient();
		HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("http://sahet.net")).build();

		HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		System.out.println(httpResponse.body());

	}

}
