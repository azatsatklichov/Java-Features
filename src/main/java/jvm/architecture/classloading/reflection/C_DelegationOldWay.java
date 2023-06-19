package jvm.architecture.classloading.reflection;

import java.net.URL;
import java.net.URLClassLoader;

//Try on Java 8
/**
 * <pre>
 * Classloader of this class:jdk.internal.loader.ClassLoaders$AppClassLoader@c387f44
   Classloader of DriverManager:jdk.internal.loader.ClassLoaders$ExtClassLoader@36baf30c
   Bootstrap classloader
 * </pre>
 *
 */
public class C_DelegationOldWay {
	public static void main(String[] args) {

		URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
		do {
			System.out.println(classLoader);
			for (URL url : classLoader.getURLs()) {
				System.out.printf("\t %s\n", url.getPath());
			}
		} while ((classLoader = (URLClassLoader) classLoader.getParent()) != null);
		System.out.println("Bootstrap classloader");
	}
}
