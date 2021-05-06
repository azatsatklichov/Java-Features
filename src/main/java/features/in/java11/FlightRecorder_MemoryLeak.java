package features.in.java11;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class FlightRecorder_MemoryLeak {
	// no limit! - https://mkyong.com/java/java-11-java-flight-recorder/
	private static BlockingQueue<byte[]> queue = new LinkedBlockingQueue<>();

	/**
	 * Run with JVM option
	 * 
	 * -XX:StartFlightRecording
	 * 
	 * 
	 * OR in CMD >java
	 * -XX:StartFlightRecording=duration=30s,settings=profile,filename=leak.jfr
	 * FlightRecorder_MemoryLeak
	 * 
	 * 
	 * 
	 * After 10 or 20 seconds, it will throws the expected
	 * java.lang.OutOfMemoryError, CTRL+C to stop and kill the threads. Later we can
	 * use Java Mission Control (JMC) to analyze the leak.jfr to find the memory
	 * leaks.
	 * 
	 * 2.2 JFR settings. If omitted, default is default.jfc.
	 * 
	 * default.jfc (default) – Low overhead, good for continue recordings.
	 * profile.jfc – More overhead, more recorded data and events than the
	 * default.jfc, good for short time recording. In this example, we use the JFR
	 * profile settings, because we know the MemoryLeak.java will throw the
	 * OutOfMemoryError very soon
	 */
	public static void main(String[] args) {

		Runnable producer = () -> {
			while (true) {
				// generates 1mb of object every 10ms
				queue.offer(new byte[1 * 1024 * 1024]);
				try {
					TimeUnit.MILLISECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Runnable consumer = () -> {
			while (true) {
				try {
					// process every 100ms
					queue.take();
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		// give a name, good for profiling
		new Thread(producer, "Producer Thread").start();
		new Thread(consumer, "Consumer Thread").start();

	}

}