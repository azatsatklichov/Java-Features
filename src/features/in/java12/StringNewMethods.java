package features.in.java12;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
 
/**
 * 4 new methods have been introduced in Java 12 which are:
 * 
 * indent(int n)
 * 
 * transform(Function f)
 * 
 * Optional describeConstable()
 * 
 * String resolveConstantDesc​(MethodHandles.Lookup lookup)
 *
 * 
 */
public class StringNewMethods {

	public static void main(String[] args) {
		System.out.println("indent(int n)");
		String str = "*****\n  Hi\n  \tHello friend\rHow are you?\n*****";

		System.out.println(str.indent(0));
		System.out.println(str.indent(3));
		System.out.println(str.indent(-3));

		System.out.println("transform(Function<? super String,​? extends R> f)");
		String s = "Hi,Hello,Howdy";
		List strList = s.transform(s1 -> {
			return Arrays.asList(s1.split(","));
		});
		System.out.println(strList);

		System.out.println();
		System.out.println("Optional<String> describeConstable()");
		/**
		 * If you look at the String class documentation, it implements two new
		 * interfaces from Constants API – Constable, and ConstantDesc.
		 */
		String so = "Hello";
		Optional os = so.describeConstable();
		System.out.println(os);
		System.out.println(os.get());

		System.out.println("\nString resolveConstantDesc​(MethodHandles.Lookup lookup)");
		String so1 = "Hello";
		String resolveConstantDesc = so1.resolveConstantDesc(MethodHandles.lookup());
		System.out.println(resolveConstantDesc);

		List<String> names = List.of("   Alex", "brian");

		List<String> transformedNames = new ArrayList<>();

		for (String name : names) {
			String transformedName = name.transform(String::strip).transform(String::toUpperCase);

			transformedNames.add(transformedName);
		}
		
		System.out.println(transformedNames);

	}
}
