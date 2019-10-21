package features.in.java9;

import java.util.ArrayList;
import java.util.List;

/**
 * It is used to ensure that the method does not perform unsafe operations on
 * its varargs parameters.
 *
 * <pre>
 *It was included in Java7 and can only be applied on

Final methods
Static methods
Constructors

From Java 9, it can also be used with private instance methods.
 * </pre>
 */
public class SafeVargs {

	@SafeVarargs
	private void display(List<String>... products) { // Not using @SaveVarargs
		for (List<String> product : products) {
			System.out.println(product);
		}
	}

	public static void main(String[] args) {
		
//		/List list =  new ArrayList<>();

		System.out.println(
				"Note: To apply @SaveVarargs annotation on private instance methods, compile code using Java 9 or higher versions only.");
		SafeVargs p = new SafeVargs();
		List<String> list = new ArrayList<String>();
		list.add("Laptop");
		list.add("Tablet");
		p.display(list);
	}

}
