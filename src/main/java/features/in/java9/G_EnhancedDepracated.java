package features.in.java9;

/**
 * Desc
 *
 * <pre>
*&#64;Deprecated annotation was introduced in java 5 version. A program element annotated with @Deprecated means 
*it should not be used for any of the following reasons −

Its usage may leads to errors.
It may be incompatible in future version.
It may be removed in future version.
A better and efficient alternative has superseeded it.
Compiler generates warnings whenever a deprecated element is used. With Java 9, two new enhancements are made to 

@Deprecated annotation.

forRemoval − Indicates whether the annotated element is subject to removal in a future version. The default value is false.

since − Returns the version in which the annotated element became deprecated. The default value is the empty string.

Deprecated with since
Following example of Boolean class javadoc on Java 9 illustrate the use of since attribute on @Deprecated annotation.
 * </pre>
 */
public class G_EnhancedDepracated {

}


class NoAloneUnderscore{
	//From Java 9, "_" is a keyword, and can not be used as an identifier
	//String _ = "aloneUnderscore";
	
	//"_" Possible future use, so element is not taken into account just ignored
	//list.forEach(_ -> doSomething())
}
