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
	
	 * </pre>
	 */
	public static void main(String[] args) {

	}
}
