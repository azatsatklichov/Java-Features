package features.in.java11;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Outer {

	public void outerPublic() {
	}

	private void outerPrivate() {
		System.out.println("in private outer");
	}

	class Inner {

		/**
		 * Although the method outerPrivate() is private, it is accessible from the
		 * method innerPublic(). Here if we use Java Reflection, it will give an
		 * IllegalStateException.
		 */
		public void nestedPublic() {
			System.out.println("in public inner");
			outerPrivate();
		}
	}

	public static void main(String[] args) {

		System.out.println(
				"JVM access rules do not permit private access between nestmates. We should get a compilation error for the above example. \n"
						+ "However, the Java source code compiler permits the access by introducing a level of indirection. ");

		/**
		 * ava.lang.IllegalAccessException: Class features.in.java11.Outer$Inner can not
		 * access a member of class features.in.java11.Outer with modifiers "private"
		 */
		try {

			Class<?> outerClazz = Outer.class; // outer.getClass();
			// Outer outer = (Outer) outerClazz.newInstance(); //new Outer();
			Outer outer = (Outer) outerClazz.getDeclaredConstructor().newInstance();
			Method method = outer.getClass().getDeclaredMethod("outerPrivate");
			method.invoke(outer);

			// Outer.Inner inner = outer.new Inner();
		} catch (Exception e) { // InstantiationException | NoSuchMethodException | SecurityException |
								// IllegalAccessException | IllegalArgumentException | InvocationTargetException
			System.err.println(e.getMessage());
		}

		System.out.println("\n Java 11 tries to address these concerns.");
		/**
		 * https://www.baeldung.com/java-nest-based-access-control
		 * 
		 * Java 11 brings the notion of nestmates and the associated access rules within
		 * the JVM. This simplifies the job of Java source code compilers.
		 * 
		 * <pre>
		To achieve this, the class file format now contains two new attributes:
		
		One nest member (typically the top-level class) is designated as the nest host. It contains an attribute (NestMembers) to 
		identify the other statically known nest members.
		Each of the other nest members has an attribute (NestHost) to identify its nest host.
		Thus, for types C and D to be nest mates they must have the same nest host. A type C claims to be a member of the nest hosted by D, 
		if it lists D in its NestHost attribute. 
		The membership is validated if D also lists C in its NestMembers attribute. Also, type D is implicitly a member of the nest that it hosts.
		
		Now there is no need for the compiler to generate the bridge methods.
		
		Finally, the nest based access control removes the surprising behavior from the core reflection. Therefore, method innerPublicReflection() shown 
		in the previous section will execute without any exceptions.
		 * </pre>
		 * 
		 * 
		 */
		System.out.println(Outer.class.getNestHost().getName().equals("features.in.java11.Outer"));
		System.out.println(Outer.Inner.class.getNestHost().getName().equals("features.in.java11.Outer"));
		System.out.println(Outer.Inner.class.isNestmateOf(Outer.class));

		Set<String> nestMembers = Arrays.stream(Outer.Inner.class.getNestMembers()).map(Class::getName)
				.collect(Collectors.toSet());
		System.out.println(nestMembers);
		
	}

}
