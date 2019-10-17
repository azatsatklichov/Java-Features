package features.in.java11;

public class DynamicClassFileConstants {

	/**
	 * The Java class-file format now extends support a new constant pool form,
	 * CONSTANT_Dynamic. The goal of this JEP is to reduce the cost and disruption
	 * of developing new forms of materializable class-file constraints,
	 * 
	 * by creating a single new constant-pool form that can be parameterized with
	 * user-provided behavior. This enhances performance
	 * 
	 * 
	 * Extend the Java class-file format to support a new constant-pool form,
	 * CONSTANT_Dynamic.
	 * 
	 * Loading a CONSTANT_Dynamic will delegate creation to a bootstrap method, just
	 * as linking an invokedynamic call site delegates linkage to a bootstrap
	 * method.
	 * 
	 * <pre>
	 * The Constant Pool - {@link here http://cr.openjdk.java.net/~jrose/jvm/constant-dynamic-jrose.html} 
	 * 
	Java Virtual Machine instructions do not rely on the run-time layout of classes, interfaces, class instances, or arrays. 
	Instead, instructions refer to symbolic information in the constant_pool table.
	
	All constant_pool table entries have the following general format:
	
	cp_info {
		u1 tag;
		u1 info[];
	}
	
	
	https://stackoverflow.com/questions/53591470/understanding-what-java-11-dynamic-class-file-constants
	
	I'm trying to understand the java 11 (JEP 309) dynamic class-file constants, it looks like an interesting feature.
	and I google it, but I didn't find detailed articles (if you know any please share it) I just find this one by Rafael Winterhalter, but I still have some questions :
	
	1. does this feature will make it possible to extend the types of constants that could be added to the pool (actually the pool could hold primitive and string values- correct me if I'm wrong)
	2. in the article it is said that dynamic constant is generated as a result of invoking a bootstrap method, and that this method need to be referenced from the class’s constant pool, but how to do it (how to reference this method from class’s constant pool??)??.
	
	https://www.javacodegeeks.com/2018/08/hands-on-java-constantdynamic.html
	 * 
	 * </pre>
	 */
	public static void main(String[] args) {
		/**
		 * With the intention of making the JVM more appealing to dynamic languages, the
		 * seventh version of the platform had introduced invokedynamic to its
		 * instruction set
		 * 
		 */
		System.out.println("Java 7 'invokedynamic' technique is for example used by the Java language to  "
				+ "\n  make the JVM more appealing to dynamic languages to run their code onto JVM"
				+ "\n  implement lambda expressions which are only manifested on demand upon their first use. ");
		System.out.println(
				" SO by using invokedynamic it has become possible to delay the binding of a method call until its first invocation.");
		System.out.println(
				"\nWith Java 11 'constantdynamic' a similar mechanism was introduced to EXTEND Extend the Java class-file format to support a new constant-pool form, CONSTANT_Dynamic");

		System.out.println(" SO that it delays the creation of a constant value");

		/**
		 * - Class’s constant pool, values can be referenced by an offset pointing to a
		 * specific entry within the constant pool.
		 * 
		 * - Another problem of declaring constant values in a class file’s constant
		 * pool, is its limitation to simple values.
		 * 
		 * -And also the Java 7 release added new constant pool types to the class file
		 * specification to allow for a constant representation of MethodType and
		 * MethodHandle instances.
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

		System.out.println(
				" Loading a CONSTANT_Dynamic will delegate creation to a bootstrap method, "
				+ "just as linking an invokedynamic call site delegates linkage to a bootstrap method.");
		/**
		 * This is fairly similar to the invokedynamic instruction that binds method
		 * call sites by invoking a bootstrap method during runtime where a pointer to a
		 * target implementation for the dynamically bound call site is returned. As key
		 * difference, a bootstrapped constant is however immutable whereas dynamically
		 * bound method calls can be redirected to another implementation at a later
		 * point.
		 */

	}
}

class ConstantSample {
	final String field = "foo"; // compile time constant

	void hello() {
		System.out.print(field);
	}
}
