package tasks.algorithmic.solutions;

/**
 * You are working on a product that has a good test suite. Unfortunately, your
 * CI server was down for several days and
 * 
 * when it was restarted the very next test execution failed. Between the last
 * successful test execution and today, there were 300 commits made by
 * developers. It takes 10 minutes to execute tests on a commit. You need to
 * implement a function that returns the first commit id that broke the tests.
 * Your implementation should return response in less than 2 hours. You can
 * assume that all commits before the bad commit pass and all commits after
 * fail.
 * 
 * Input: ordered list of commit IDs ([123, 127, 130, 137,...]) Available API:
 * boolean executeTests(commitId) - runs tests on a given commit. Returns true
 * if tests pass, false otherwise. Output: single number - first commit id that
 * broke the tests
 *
 */
public class FindBadCommit {

	/**
	 * As described we have a ORDERED array and condition is find commit which
	 * causes the issue in less than 2 hours. And if one commit needs 10 mins to
	 * pass the test then our method MUST find BAD commit in less than 12 steps
	 * (12*10min=2 hours)
	 * 
	 * In optimization point of view we need to use BINARY search algorithm (but
	 * optimized for our case), either BUILT-in method by Java, or our custom
	 * implementation.
	 * 
	 * Worst case to find BAD commit
	 * 
	 * <pre>
	 * 1-step(10 mins): 300/2 = 150 (we know bad commit is in these 150 elements)
	 * 2-step(10 mins): 150/2 = 75 (we know bad commit is in these 75 elements)
	 * 3-step(10 mins): 75/2 = 34 (we know bad commit is in these 34 elements)
	 * 4-step(10 mins): 34/2 = 17 (we know bad commit is in these 17 elements)
	 * 5-step(10 mins): 17/2 = 8 (we know bad commit is in these 8 elements)
	 * 6-step(10 mins): 8/2=4 (we know bad commit is in these 4 elements)
	 * 7-step(10 mins): 4/2 = 2  (we know bad commit is in these 2 elements)
	 * 8-step(10 mins): 2=/2 = 1 this is a BAD element
	 * 
	 * We will find BAD commit (worst case) in 8*10 = 80 mins
	 * 
	 * </pre>
	 * 
	 * SOLUTION 2 ways
	 * 
	 * 1-Java built-in Arrays.binarySearch(arr,searchVal) can be used
	 * 
	 * 2 - Custom, implementing BINARY-SEARCH ALGORITHM
	 * 
	 * 
	 * 
	 * @param commitIds (in our case we expect 300 ids)
	 * @return
	 */
	public static int findBadCommit(int[] commitIds) {

		int left = 0;
		int right = commitIds.length - 1;
		int badCommitId = 0;

		/**
		 * You can assume that all commits before the bad commit pass and all commits
		 * after fail.
		 */
		while (left < right) {
			int mid = (left + right) / 2;
			// int mid = left + (right - left) / 2;

			if (executeTests(commitIds[mid - 1]) && !executeTests(commitIds[mid + 1])) {
				badCommitId = commitIds[mid];
				break;
			} else if (executeTests(commitIds[mid])) { // bad commit is on right
				left = mid + 1;
			} else { // on left
				right = mid + 1;
			}
		}

		return badCommitId;

	}

	/**
	 * simulator method
	 * 
	 * @return
	 */
	public static boolean executeTests(int commitId) {
		return commitId < 679;
	}

	public static void main(String[] args) {
		System.out.println("Tw");

		int[] commitIds = { 123, 127, 130, 137, 344, 677, 688, 4553 };
		int findBadCommit = findBadCommit(commitIds);
		System.out.println("test = " + findBadCommit);
	}

}