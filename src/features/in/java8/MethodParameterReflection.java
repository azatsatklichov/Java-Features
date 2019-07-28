package features.in.java8;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/guides/reflection/enhancements.html#a8
 * 
 * https://docs.oracle.com/javase/tutorial/reflect/member/methodparameterreflection.html
 * 
 * 
 * You can obtain the names of the formal parameters of any method or
 * constructor with the method java.lang.reflect.Executable.getParameters.
 * However, .class files do not store formal parameter names by default. 
 * 
 * To  store formal parameter names in a particular .class file, and thus enable the
 * Reflection API to retrieve formal parameter names, compile the source file
 * with the -parameters option of the javac compiler.
 */
public class MethodParameterReflection {

	public static void main(String[] args) {
		System.out.println(
				"Method Parameter Reflection support was added in Java 8. Simply put, it provides support for getting the names of parameters at runtime.");
		System.out.println("e.g. During SOAP based WS, you can not get the name of the method parameters before");

		/*
		 * In order to be able to get access to method name information, we must opt-in
		 * explicitly.
		 * 
		 * To do this, we specify the parameters option during compilation.
		 */
		/**
		 * <pre>
		 * <plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-compiler-plugin</artifactId>
		<version>3.1</version>
		<configuration>
		<source>1.8</source>
		<target>1.8</target>
		<compilerArgument>-parameters</compilerArgument>
		</configuration>
		</plugin>
		 * </pre>
		 */
		System.out.println("-- Usage --");
		System.out.println(
				"The Parameter class is new in Java 8 and has a variety of interesting methods. If the -parameters compiler option was provided, "
				+ "\nthe isNamePresent() method will return true.");
		Person person = new Person("Poly");
		System.out.println(person.getFullName());
	}

}

class Person {

	private String fullName;

	public Person(String fullName) {
		this.fullName = fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}

}
