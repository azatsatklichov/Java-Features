package features.in.java9;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFuture API Improvements
 *
 * <pre>
CompletableFuture class was introduced in Java 8 to represent the Future which can be completed by setting 
its value and status explicity. It can be used as java.util.concurrent.CompletionStage. 

It supports dependent functions and actions which got triggered upon the future's completion. 

In java 9 CompletableFuture API has been enhanced further. Following are the relevant changes done to the API.

Support for delays and timeouts.
Improved support for subclassing.
New factory methods added.
 * 
 * https://docs.oracle.com/javase/9/docs/api/java/util/concurrent/CompletableFuture.html
 * 
 *https://www.baeldung.com/java-9-completablefuture
 * </pre>
 */
public class zCompletableFutureAPIImprovements {

	public static void main(String[] args) {
		
		System.out.println("See also ProcessAPIImprovements#onExit");
		
		//This example will show how to delay the completion of a CompletableFuture with a specific value by one second.
		CompletableFuture<Object> future = new CompletableFuture<>();
		future.completeAsync(() -> "input", CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS));
	}

}
