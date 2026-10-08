package features.in.java9;


/**
 * 
 * If we compile that with JDK 8 or earlier and then use  below command 
 * to see the bytecode, we see something like this:
 * 
 *  C:\workspace-17\Java-Features\src\main\java\features\in\java9>javac CompactStrin
gExample.java

C:\workspace-17\Java-Features\src\main\java\features\in\java9>javap -c  CompactStringExample.class
 * 
 * <pre>
 * public class Example {
  public Example();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: new           #2                  // class java/lang/StringBuilder
       3: dup
       4: invokespecial #3                  // Method java/lang/StringBuilder."<init>":()V
       7: aload_0
       8: iconst_0
       9: aaload
      10: invokevirtual #4                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      13: ldc           #5                  // String -
      15: invokevirtual #4                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      18: aload_0
      19: iconst_1
      20: aaload
      21: invokevirtual #4                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      24: ldc           #5                  // String -
      26: invokevirtual #4                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      29: aload_0
      30: iconst_2
      31: aaload
      32: invokevirtual #4                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      35: invokevirtual #6                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      38: astore_1
      39: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
      42: aload_1
      43: invokevirtual #8                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      46: return
}

As you can see, it creates a StringBuilder and uses append. This is famous fairly inefficient as the default capacity of the built-in buffer 
in StringBuilder is only 16 chars, and there's no way for the compiler to know to allocate more in advance, so it ends up having to reallocate. 
It's also a bunch of method calls. (Note that the JVM can sometimes detect and rewrite these patterns of calls to make them more efficient, though.)

Let's look at what Java 9 generates:
 
 
 C:\workspace-17\Java-Features\src\main\java\features\in\java9>javac CompactStrin
gExample.java

C:\workspace-17\Java-Features\src\main\java\features\in\java9>javap -c  CompactStringExample.class
Compiled from "CompactStringExample.java"
class features.in.java9.CompactStringExample {
  features.in.java9.CompactStringExample();   
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":
()V
  public static void main(java.lang.String[]);
    Code:
       0: aload_0
       1: iconst_0
       2: aaload
       3: aload_0
       4: iconst_1
       5: aaload
       6: aload_0
       7: iconst_2
       8: aaload
       9: invokedynamic #7,  0              // InvokeDynamic #0:makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/S
tring;
      14: astore_1
      15: getstatic     #11                 // Field java/lang/System.out:Ljava/io/PrintStream;
      18: aload_1
      19: invokevirtual #17                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      22: return
}


Oh my but that's shorter. :-) It makes a single call to makeConcatWithConstants from StringConcatFactory, which says this in its Javadoc:

Methods to facilitate the creation of String concatenation methods, that can be used to efficiently concatenate a known 
number of arguments of known types, possibly after type adaptation and partial evaluation of arguments. 
These methods are typically used as bootstrap methods for invokedynamic call sites, to support the string 
concatenation feature of the Java Programming Language.
 * </pre>
 *
 */
class CompactStringExample {
	public static void main(String[] args) {
		String result = args[0] + "-" + args[1] + "-" + args[2];
		System.out.println(result);
	}
}