package best.practices.lambdas.and.streams.not.doneyet;

import java.util.Comparator;

//from Effective Java 
// Broken comparator - can you spot the flaw?  
public class SortingComparatorFlaw {
	public static void main(String[] args) {

		Comparator<Integer> naturalOrder = (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);

		int result = naturalOrder.compare(new Integer(42), new Integer(42));
		System.out.println(result);

		// Fixed Comparator
		naturalOrder = (iBoxed, jBoxed) -> {
			int i = iBoxed, j = jBoxed; // Auto-unboxing
			return i < j ? -1 : (i == j ? 0 : 1);
		};

		result = naturalOrder.compare(new Integer(42), new Integer(42));
		System.out.println(result);
	}
}

class NFE {
	static Integer i;

	public static void main(String[] args) {
		if (i == 42)
			System.out.println("Unbelievable");
	}
}