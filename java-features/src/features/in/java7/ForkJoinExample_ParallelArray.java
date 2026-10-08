package features.in.java7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

//https://www.mkyong.com/java/java-fork-join-framework-examples/
public class ForkJoinExample_ParallelArray extends RecursiveTask<Long> {

	/**
	 * ParallelArray is a set of your domain items whose work is backed by a
	 * ForkJoinPool. You can define many common functional operators -- such as
	 * filter, map, and apply them to a ParallelArray
	 */

	private static final long serialVersionUID = 1L;

	private final long[] numbers;
	private final int start;
	private final int end;
	public static final long threshold = 10_000;

	public ForkJoinExample_ParallelArray(long[] numbers) {
		this(numbers, 0, numbers.length);
	}

	private ForkJoinExample_ParallelArray(long[] numbers, int start, int end) {
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}

	public static void main(String[] args) {
		System.out.println(startForkJoinSum(1_000_000_000));
	}

	@Override
	protected Long compute() {

		int length = end - start;
		if (length <= threshold) {
			return add();
		}

		ForkJoinExample_ParallelArray firstTask = new ForkJoinExample_ParallelArray(numbers, start, start + length / 2);
		firstTask.fork(); // start asynchronously

		ForkJoinExample_ParallelArray secondTask = new ForkJoinExample_ParallelArray(numbers, start + length / 2, end);

		Long secondTaskResult = secondTask.compute();
		Long firstTaskResult = firstTask.join();

		return firstTaskResult + secondTaskResult;

	}

	private long add() {
		long result = 0;
		for (int i = start; i < end; i++) {
			result += numbers[i];
		}
		return result;
	}

	public static long startForkJoinSum(long n) {
		long[] numbers = LongStream.rangeClosed(1, n).toArray();
		ForkJoinTask<Long> task = new ForkJoinExample_ParallelArray(numbers);
		return new ForkJoinPool().invoke(task);
	}

}
