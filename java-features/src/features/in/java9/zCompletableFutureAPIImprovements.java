package features.in.java9;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFuture API Improvements
 * 
 * A Future that may be explicitly completed
 *
 * <pre>
CompletableFuture class was introduced in Java 8 to represent the Future which can be completed by setting 
its value and status explicity. It can be used as java.util.concurrent.CompletionStage. 

It supports dependent functions and actions which got triggered upon the future's completion. 

In java 9 CompletableFuture API has been enhanced further. Following are the relevant changes done to the API.

Support for delays and timeouts.
Improved support for sub classing.
New factory methods added.
 * 
 * </pre>
 */
public class zCompletableFutureAPIImprovements {

	public static void main(String[] args) throws InterruptedException {

		System.out.println(" Creating a Completed CompletableFuture");
		CompletableFuture<String> cf = CompletableFuture.completedFuture("message");
		if (cf.isDone()) {
			String msg = cf.getNow(null);
			System.out.println("--> "+msg);
		}

		System.out.println("Running a Simple Asynchronous Stage");
		CompletableFuture<Void> cf2 = CompletableFuture.runAsync(() -> {
			if (Thread.currentThread().isDaemon()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		if (!cf2.isDone()) {
			Thread.sleep(2000);
		}

		if (cf2.isDone()) {
			System.out.println("finally");
		}

		// This example will show how to delay the completion of a CompletableFuture
		// with a specific value by one second.
		CompletableFuture<Object> future = new CompletableFuture<>();
		future.completeAsync(() -> "input", CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS));
		if (future.isDone()) {
			System.out.println("--> "+future.getNow(null));
		}

		System.out.println("See also ProcessAPIImprovements#onExit");
		System.out.println("See also Reactivestreams - nonblocking API");

	}

}
