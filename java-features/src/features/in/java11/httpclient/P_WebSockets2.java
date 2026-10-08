package features.in.java11.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CountDownLatch;

public class P_WebSockets2 {

    public static void main(String... args) throws Exception {

        int msgCount = 5;
        CountDownLatch receiveLatch = new CountDownLatch(msgCount);

        CompletableFuture<WebSocket> wsFuture = HttpClient.newHttpClient()
             .newWebSocketBuilder()
             .connectTimeout(Duration.ofSeconds(3))
             .buildAsync(URI.create("ws://echo.websocket.org"), new EchoListener(receiveLatch));

        wsFuture.thenAccept(webSocket -> {
            webSocket.request(msgCount);
            for(int i = 0; i < msgCount; ++i)
                webSocket.sendText("Message " + i, true);
        });

        receiveLatch.await();
    }


    static class EchoListener implements WebSocket.Listener {

        CountDownLatch receiveLatch;

        public EchoListener(CountDownLatch receiveLatch) {
            this.receiveLatch = receiveLatch;
        }

        @Override
        public void onOpen(WebSocket webSocket) {
            System.out.println("WebSocket opened");
        }

        @Override
        public CompletionStage<?> onText(WebSocket webSocket,
                CharSequence data, boolean last) {
            System.out.println("onText " + data);
            receiveLatch.countDown();
            return null;
        }

    }
}
