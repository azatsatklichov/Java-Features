package features.in.java9;

/**
 * Desc
 *
 * <pre>
 *  
 * @Deprecated annotation was introduced in java 5 version. A program element annotated with 
 * @Deprecated means it should not be used for any of the following reasons −

Its usage may leads to errors.
It may be incompatible in future version.
It may be removed in future version.
A better and efficient alternative has superseeded it.


Compiler generates warnings whenever a deprecated element is used. With Java 9, two new enhancements are made to @Deprecated annotation.

forRemoval − Indicates whether the annotated element is subject to removal in a future version. The default value is false.

since − Returns the version in which the annotated element became deprecated. The default value is the empty string.
 * </pre>
 */
@Deprecated(forRemoval = true, since = "9")
public class EnhancedDepracated {

}
