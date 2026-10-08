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


e.g. {@link java.lang.Object#finalize },  {@link javax.net.ssl.HandshakeCompletedEvent#getPeerCertificateChain }


 * </pre>
 * 
 * 
 */
@Deprecated(forRemoval = true, since = "9")
public class EnhancedDepracated {
	
	public static void main(String[] args) {
		/**
		 * 
		 * https://www.oracle.com/technetwork/java/javase/9-deprecated-features-3745636.html 
		 * 
		 * 
		 */
		System.out.println("E.g. see Object finalize method ");
		//C:\apps\jdk-10.0.2\bin
		/**
		 *  JDK 9 supports UTF-8 based properties resource bundles (see JEP 226) and the conversion
		 *  for UTF-8 based properties resource bundles to ISO-8859-1 is no longer needed.
		 */
		System.out.println("E.g. Visual VM removed in JDK 9. The tool (jvisualvm, native2ascii ) is no longer " +
				"included in Oracle JDK. But can be downloaded https://visualvm.github.io/ ");
		System.out.println("E.g. serialver -show option has been removed (Serial Version Inspector ) ");
		
		 
	}

}
