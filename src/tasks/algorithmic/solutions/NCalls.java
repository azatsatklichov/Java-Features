package tasks.algorithmic.solutions;

import java.util.Calendar;

public class NCalls {
	/**
	 * allowedCount (V) can be configurable
	 */
	private static int allowedCount = 1000;
	private static int count = 1;
	private static long startTime = 0;
	private static long stopTime = 0;

	public void omio() throws Exception {

		if (count == 1) {
			startTime = Calendar.getInstance().getTimeInMillis();
		}

		stopTime = Calendar.getInstance().getTimeInMillis();
		long totalTime = (stopTime - startTime);
		if (totalTime > 1000 || count > allowedCount) {
			count = 1;
			startTime = 0;
			stopTime = 0;
			throw new Exception("Method can not be called more than " + allowedCount + " times in 1 sec");
		}
		System.out.println("Omio processing .. " + count);
		count++;
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
		NCalls call = new NCalls();
		System.out.println();
		call.omio();
		System.out.println();
		call.omio();
		System.out.println();

		for (int i = 0; i < 997; i++) {
			Thread.currentThread().sleep(100);
			call.omio();
		}
		System.out.println();
		call.omio();
	}

}
