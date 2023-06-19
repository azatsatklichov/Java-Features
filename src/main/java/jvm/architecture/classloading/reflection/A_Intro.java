package jvm.architecture.classloading.reflection;

import java.sql.DriverManager;
import java.util.ArrayList;

// https://www.baeldung.com/java-classloaders
public class A_Intro {

	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("Classloader of this class:" + A_Intro.class.getClassLoader());
		System.out.println("Classloader of DriverManager:" + DriverManager.class.getClassLoader());
		System.out.println("Classloader of ArrayList:" + ArrayList.class.getClassLoader());
	}
}