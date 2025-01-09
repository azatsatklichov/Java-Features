package best.practices.lambdas.and.streams;
 

/**
 * Don�t Treat Lambda Expressions as Inner Classes
 * 
 * https://www.baeldung.com/java-8-lambda-expressions-tips
 * 
 * <pre>
 *Despite our previous example,
 * where we essentially substituted inner class by a lambda expression, the two
 * concepts are different in an important way: scope.
 * 
 * When you use an inner class, it creates a new scope. You can hide local
 * variables from the enclosing scope by instantiating new local variables with
 * the same names. You can also use the keyword this inside your inner class as
 * a reference to its instance.
 * 
 * However, lambda expressions work with enclosing scope. You can�t hide
 * variables from the enclosing scope inside the lambda�s body. In this case,
 * the keyword this is a reference to an enclosing instance.
 * 
 * For example, in the class UseFoo you have an instance variable value:
 * 
 * 
 * 
 * As you can see, by calling this.value in IC, you can access a local variable from its instance. 
 * But in the case of the lambda, this.value call gives you access to the variable value which 
 * is defined in the UseFoo class, but not to the variable value defined inside the lambda�s body.
 * </pre>
 */
public class LambdaExpressionsNotFullyLikeInnerClasses {
	private String value = "Enclosing scope value";

	public String scopeExperiment() {
		Foo fooIC = new Foo() {
			String value = "Inner class value";

			@Override
			public String method() {
				return this.value;
			}
		};
		String resultIC = fooIC.method();

		Foo fooLambda = () -> {
			String value = "Lambda value";
			return this.value; // enclosing value
		};
		String resultLambda = fooLambda.method();

		return "Results: resultIC = " + resultIC + ", resultLambda = " + resultLambda;
	}
}

@FunctionalInterface
interface Foo {
	String method();

	default void defaultMethod() {
	}
}

interface GreetingService {
	void hi(String message);
}

interface GreetingService2 {
	String msg(String message);
}



/**
* Desc: 
* <pre>
*Use �Effectively Final� Variables
Accessing a non-final variable inside lambda expressions will cause the compile-time error. But it doesn�t mean that
 you should mark every target variable as final.

According to the �effectively final� concept, a compiler treats every variable as final, as long as it is assigned only once.

It is safe to use such variables inside lambdas because the compiler will control their state and trigger a compile-time error 
immediately after any attempt to change them.

For example, the following code will not compile:

 
*</pre>
*/
class EffectifelyFinal {
	
	public void method() {
	    String localVariable = "Local";
	    GreetingService2  foo = parameter -> {
	        //String localVariable = parameter; //here must not be assigned 
	        return localVariable;
	    };
	}
}