
/**
 * https://www.graalvm.org/reference-manual/native-image/#install-native-image
 * 
 * Build a Native Image A native image can be built as a standalone executable,
 * which is the default, or as a shared library (see Build a Shared Library).
 * 
 * For an image to be useful, it needs to have at least one entry point method.
 * 
 * For standalone executables, Native Image supports Java main methods with a
 * signature that takes the command line arguments as an array of strings:
 *
 */
public class NativeImage {

	public static void main(String[] args) {
		String str = "Native Image is awesome";
		String reversed = reverseString(str);
		System.out.println("The reversed string is: " + reversed);
	}

	public static String reverseString(String str) {
		if (str.isEmpty())
			return str;
		return reverseString(str.substring(1)) + str.charAt(0);
	}

}
