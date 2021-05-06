package features.in.java9;

import java.util.ArrayList;
import java.util.List;

public class DiamondDemo {

	public static void main(String... args) {
		List<String> l1 = new ArrayList<String>();
		List<String> l2 = new ArrayList<>();
		List<String> l3 = new ArrayList<>() {
			@Override
			public boolean add(String s) {
				System.out.println("Adding " + s);
				return super.add(s);
			}
		};
	}

}