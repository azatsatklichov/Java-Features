package features.in.java9;

import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
 

/**
 
*A New HTTP Client
*<pre>
*
A long-awaited replacement of the old HttpURLConnection.

The new API is located under the java.net.http package.

It should support both HTTP/2 protocol and WebSocket handshake, with performance that should be comparable with the Apache HttpClient, Netty and Jetty.

Let have a look at this new functionality by creating and sending a simple HTTP request.

Update: The HTTP Client JEP is being moved to Incubator module, so it is no longer available in the package java.net.http and instead is available under jdk.incubator.http.

3.1. Quick GET Request
The API uses the Builder pattern, which makes it really easy for quick use:

1
2
3
4
5
6
7
HttpRequest request = HttpRequest.newBuilder()
  .uri(new URI("https://postman-echo.com/get"))
  .GET()
  .build();
 
HttpResponse<String> response = HttpClient.newHttpClient()
  .send(request, HttpResponse.BodyHandler.asString());
*
*</pre>
*/
public class zBaeldungJ9_B_HttpClient {
    public static void main(String[] args) throws URISyntaxException { 
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new java.net.URI("http://sahet.net/"))  //https://postman-echo.com/get
                .GET()
                .build();
               
              //HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandler.asString());
        
       System.out.println(request.bodyPublisher().get());
    }

}
