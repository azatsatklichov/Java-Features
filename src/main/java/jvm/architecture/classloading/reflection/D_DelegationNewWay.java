package jvm.architecture.classloading.reflection;

//Try on Java 9 or later
/**
 * <pre>
*jdk.internal.loader.ClassLoaders$AppClassLoader@c387f44
	 app
jdk.internal.loader.ClassLoaders$PlatformClassLoader@3f99bd52
	 platform
Bootstrap classloader
 * </pre>
 *
 */
public class D_DelegationNewWay {
	public static void main(String[] args) {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		do {
			System.out.println(classLoader);
			System.out.printf("\t %s\n", classLoader.getName());
		} while ((classLoader = classLoader.getParent()) != null);
		System.out.println("Bootstrap classloader");
	}
}