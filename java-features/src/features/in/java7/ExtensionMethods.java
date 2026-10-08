package features.in.java7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExtensionMethods {
	public static void main(String[] args) {
		// I wish List had a sort() method...
		List<Duy> list = new ArrayList<>();
		// ...
		Collections.sort(list); // works for now
		// ERROR but cleaner

		// equivalent to Collections.sort(list);
		list.sort(new Comparator<Duy>() {
			@Override
			public int compare(Duy o1, Duy o2) {
				//TBD
				return 0;
			}
		});

	}

}

class Duy implements Comparable<Duy> {
	@Override
	public int compareTo(Duy o) {
		// TBD
		return 0;
	}

}