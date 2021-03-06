[Open JDK](https://openjdk.java.net/),
[Specs](https://docs.oracle.com/javase/specs/), 
[Java Doc](https://docs.oracle.com/en/java/index.html),
[The Java](Tutorials](https://docs.oracle.com/javase/tutorial/),
[JAVA Guide](http://sahet.net/htm/java.html) 
 

# Java 5
Codename Tiger ([API](https://docs.oracle.com/javase/1.5.0/docs/api/)) The release on September 30, 2004 was originally numbered 1.5, which is still used as the internal version number. The number was changed to "better reflect the level of maturity, stability, scalability and security of the J2SE". This version was developed under JSR 176.
J2SE 5.0 entered its end-of-public-updates period on April 8, 2008; updates are no longer available to the public as of November 3, 2009. Updates were available to paid Oracle customers until May 2015.[18]
Tiger added a number of significant new language features:


- Generics: provides compile-time (static) type safety for collections and eliminates the need for most typecasts (type conversion) (specified by JSR 14)
- Metadata: also called annotations; allows language constructs such as classes and methods to be tagged with additional data, which can then be processed by metadata-aware utilities (specified by JSR 175)
- Autoboxing/unboxing: automatic conversions between primitive types (such as int) and primitive wrapper classes (such as Integer) (specified by JSR 201)
- Enumerations: the enum keyword creates a typesafe, ordered list of values (such as Day.MONDAY, Day.TUESDAY, etc.); previously this could only be achieved by non-typesafe constant integers or manually constructed classes (typesafe enum pattern) (specified by JSR 201)
- Varargs: the last parameter of a method can now be declared using a type name followed by three dots (e.g. void drawtext(String... lines)); in the calling code any number of parameters of that type can be used and they are then placed in an array to be passed to the method, or alternatively the calling code can pass an array of that type
- Enhanced for each loop: the for loop syntax is extended with special syntax for iterating over each member of either an array or any Iterable, such as the standard Collection classes (specified by JSR 201)
- Improved semantics of execution for multi-threaded Java programs; the new Java memory model addresses issues of complexity, effectiveness, and performance of previous specifications[21]
- Static imports

There were also the following improvements to the standard libraries:

- Automatic stub generation for RMI objects
- Swing: New skinnable look and feel, called synth
- The concurrency utilities in package java.util.concurrent[22]
- Scanner class for parsing data from various input streams and buffers


Java 5 is the last release of Java to officially support the Microsoft Windows 98 and Windows ME, while Windows Vista is the newest version of Windows that J2SE 5 was supported on prior to Java 5 going end of life in October 2009.

Java 5 Update 5 (1.5.0_05) is the last release of Java to work on Windows 95 (with Internet Explorer 5.5 installed) and Windows NT 4.0. 

Java 5 was first available on Apple Mac OS X 10.4 (Tiger)  and was the default version of Java installed on Apple Mac OS X 10.5 (Leopard).

Public support and security updates for Java 1.5 ended in November 2009. Paid security updates for Oracle customers ended in April 2015.

Versioning change
This version introduced a new versioning system for the Java language, although the old versioning system continued to be used for developer libraries:

Both version numbers "1.5.0" and "5.0" are used to identify this release of the Java 2 Platform Standard Edition. Version "5.0" is the product version, while "1.5.0" is the developer version. The number "5.0" is used to better reflect the level of maturity, stability, scalability and security of the J2SE.

— Version 1.5.0 or 5.0? 
This correspondence continued through later releases (Java 6 = JDK 1.6, Java 7 = JDK 1.7, and so on).

