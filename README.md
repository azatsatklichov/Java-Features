[Java Features at GitHub](https://github.com/azatsatklichov/Java-Features.git) 

[Oracle Java SE at a Glance](https://www.oracle.com/technetwork/java/javase/overview/index.html), 
[JEP](https://openjdk.java.net/jeps/0), 
[Open JDK](http://openjdk.java.net/)



#Java 5 Features
[Java SE 5 Documentation](https://docs.oracle.com/javase/1.5.0/docs/), 
[API](https://docs.oracle.com/javase/1.5.0/docs/api/), 
[Features](https://www.oracle.com/technetwork/articles/entarch/java-5-features-083037.html)



#Java 6 Features
[Java SE 6 Documentation](https://docs.oracle.com/javase/6/docs/),
[API](https://docs.oracle.com/javase/6/docs/api/),  
[Open JDK](https://openjdk.java.net/projects/jdk6/)


# JavaSE 7 Features
[Java SE 7 Documentation](https://docs.oracle.com/javase/7/docs/index.html),
 [API](https://docs.oracle.com/javase/7/docs/api/), 
[Open JDK](https://openjdk.java.net/projects/jdk7/)

The important features of JavaSE 7 are try with resource, catching multiple exceptions etc.

- String in switch statement (Java 7)
- Binary Literals (Java 7)
- The try-with-resources (Java 7)
- Caching Multiple Exceptions by single catch (Java 7)
- Underscores in Numeric Literals (Java 7)


# JavaSE 8 Features (initial release 18-Mar 2014)
[JDK 8 doc](https://docs.oracle.com/javase/8/),
[API](https://docs.oracle.com/javase/8/docs/api/),  
[What's New in JDK 8](https://www.oracle.com/technetwork/java/javase/8-whats-new-2157071.html), 
[Open JDK](https://openjdk.java.net/projects/jdk8/)

The important features of JavaSE 8 are lambda expressions, methods references, default methods, functional interface, java 8 date/time, stream classes etc. 


##### Java Programming Language
- Lambda Expressions: a lot simplified code because of eliminating the need of anonymous class, and motivates powerful functional programming via defining inline implementation of a FI  
- Method References: provide easy-to-read lambda expressions for methods that already have a name.
- Functional Interfaces - https://docs.oracle.com/javase/8/docs/api/
- Default Methods and Static methods in Interface  
- Type Inference: Improved type inference
- Optional class to handle null values properly - similar to what Optional is in Guava
- Method Parameter Reflection
- Type annotations and repeating annotations: Type annotations provide the ability to apply an annotation anywhere a type is used, not just on a declaration. Repeating Annotations provide the ability to apply the same annotation type more than once to the same declaration or type use.    

##### Collections
- Stream API − `java.util.stream`. New stream API to facilitate pipeline processing. Process data in a declarative way similar to SQL. Supports aggregate operations like filter, map, limit, reduce, find, match,count, sorted, statistics,  and so on.
- forEach method 
- Collectors
- StringJoiner
- Parallel Array Sorting 
- Performance Improvement for HashMaps with Key Collisions - [read](https://www.nagarro.com/en/blog/post/24/performance-improvement-for-hashmap-in-java-8)
 
##### More on Scripting, DateTime, IO, Security etc.
- Base64 Encode Decode
- Nashorn (Rhino in Java7 replaced)  Java-based engine to execute JavaScript code. Tool $JAVA_HOME/bin/jjs
- Java 8 Date/Time API  
- Java JDBC Improvements - new features in JDBC 4.2, e.g. DriverAction, includes Java DB 10.10, etc. 
- Java IO Improvement, e.g.   - [read](https://docs.oracle.com/javase/8/docs/technotes/guides/io/enhancements.html)
- Java Concurrency Improvement  - [read](https://www.journaldev.com/2389/java-8-features-with-examples#java8-concurrency)

##### Tools
- New tools: New compiler tools and utilities are added like `jdeps`  to figure out dependencies.
- The `jjs`  command is provided to invoke the Nashorn engine.
- The `jarsigner`  command is provided to invoke the Nashorn engine.



# Java 9 Features
[JDK 9 doc](https://docs.oracle.com/javase/9/),
[API](https://docs.oracle.com/javase/9/docs/api/overview-summary.html),   
[What's New in JDK 9](https://docs.oracle.com/javase/9/whatsnew/toc.htm), 
[Open JDK](https://openjdk.java.net/projects/jdk9/) 

Oracle has released Java 9 with rich set of new features. It includes various upgrades to the Java programming, JVM, Tools and libraries. Its aim is to make JDK and Java Standard Edition platform modular based in the sense that it can be scalled down to small computing devices well. There are 90+ enhancements added to Java 8, the most significant ones are mentioned below.

- Platform Module System (Project Jigsaw): A new kind of Java programing component introduced as module, which is a named, self-describing collection of code and data.
- Multirelease JAR: Enhances the JAR format so that multiple, Java release-specific versions of class files can coexist in a single archive.
- Interface Private Methods
- Try-With Resources: Now final variables can be used as resources in the try-with-resources statement.
- Anonymous Classes
- @SafeVarargs Annotation
- Collection Factory Methods: New static factory methods for List, Set, and Map interfaces to create immutable instances of those collections.
- Process API Improvement: Improved API to control and manage operating system processes.
- New Version-String Scheme
- JShell: The Java Shell (REPL): Read-Eval-Print Loop (REPL) capability added to the Java platform.
- Process API Improvement
- Control Panel
- Stream API Improvement: Enhanced security and robustness by allowing incoming streams of object-serialization data to be filtered.
- Installer Enhancement for Microsoft windows and many more
- HTTP 2 Client: new HTTPClient API supporting websockets and HTTP 2 streams and server push features.
- Improved JavaDocs: Supports HTML5 output generation. Provides a search box to generated API documentation.
- Private Interface Methods: Enhanced interfaces with private and private static methods.
- Enhanced @Deprecated Annotation: @Deprecated annotation revamped to provide more information about the status and intended disposition of an API
- Inner Class Diamond Operator: Allow the diamond operator to be used with anonymous classes if the argument type of the inferred type can be denoted.
- Optional Class Improvements: New useful methods are added to java.util.Optional class.
- Multiresolution Image API: Supports encapsulation of a set of images with different resolutions into a single multiresolution image.
- CompletableFuture API improvements: The asynchronous mechanisms of the CompletableFuture class can perform an action when the process exits with ProcessHandle.onExit method.
- Lightweight JSON: A lightweight API introduced to consume and generating documents and data streams via json in java 9.
- Reactive Streams API: A new Reactive Streams API in Java SE 9 has been introduced to support reactive programming in java 9


# Java 10 Features
[JDK 10 doc](https://docs.oracle.com/javase/10/),
[API](https://docs.oracle.com/javase/10/docs/api/overview-summary.html), 
[What's New in JDK 10](https://www.oracle.com/technetwork/java/javase/10-relnote-issues-4108729.html#NewFeature),
[Open JDK](https://openjdk.java.net/projects/jdk/10/) 

- 286: Local-Variable Type Inference
- Unmodifiable Collections: java.util.List, java.util.Map and java.util.Set each got a new static method copyOf(Collection).  toUnmodifiable*() java.util.stream.Collectors get additional methods to collect a Stream into unmodifiable List, Map or Set:
- 296: Consolidate the JDK Forest into a Single Repository
- 304: Garbage-Collector Interface: improve the source code isolation of different garbage collectors by introducing a clean garbage collector (GC) interface
- 307: Parallel Full GC for G1: improves G1 worst-case latencies by making the full GC parallel
- 310: Application Class-Data Sharing:  JEP extends the existing Class-Data Sharing (“CDS”) feature
- 312: Thread-Local Handshakes
- 314: Additional Unicode Language-Tag Extensions
- 316: Heap Allocation on Alternative Memory Devices: It enables the HotSpot VM to allocate the Java object heap on an alternative memory device, such as an NV-DIMM, specified by the user.
- 317: Experimental Java-Based JIT Compiler: It will enhance the java.util.Locale and related APIs to implement additional Unicode extensions of BCP 47 language tags.
- 319: Root Certificates: It provides a default set of root Certification Authority (CA) certificates in the JDK
- 322: Time-Based Release Versioning
- 313: Remove the Native-Header Generation Tool (javah)
- Deprecated Features and Options in Java 10


# Java 11 Features
[JDK 11 doc](https://docs.oracle.com/en/java/javase/11/),
[API](https://docs.oracle.com/en/java/javase/11/docs/api/index.html),  
[What's New in JDK 11](https://www.oracle.com/technetwork/java/javase/11-relnote-issues-5012449.html#NewFeature),  
[Open JDK](https://openjdk.java.net/projects/jdk/11/) 



- 181: Nest-Based Access Control
- 309: Dynamic Class-File Constants
- 315: Improve Aarch64 Intrinsics
- 318: Epsilon: A No-Op Garbage Collector
- 320: Remove the Java EE and CORBA Modules
- 321: HTTP Client (Standard)
- 323: Local-Variable Syntax for Lambda Parameters
- 324: Key Agreement with Curve25519 and Curve448
- 327: Unicode 10
- 328: Flight Recorder
- 329: ChaCha20 and Poly1305 Cryptographic Algorithms
- 330: Launch Single-File Source-Code Programs
- 331: Low-Overhead Heap Profiling
- 332: Transport Layer Security (TLS) 1.3
- 333: ZGC: A Scalable Low-Latency Garbage Collector
   (Experimental)
- 335: Deprecate the Nashorn JavaScript Engine
- 336: Deprecate the Pack200 Tools and API
- 286: Local-Variable Type Inference


# Java 12 Features

[JDK 12 doc](https://docs.oracle.com/en/java/javase/12/index.html),
[API](https://docs.oracle.com/en/java/javase/12/docs/api/index.html),     
[What's New in JDK 12](https://www.oracle.com/technetwork/java/javase/12-relnote-issues-5211422.html#NewFeature), 
[Open JDK](https://openjdk.java.net/projects/jdk/12/) 

- 189:	Shenandoah: A Low-Pause-Time Garbage Collector (Experimental)
- 230:	Microbenchmark Suite
- 325:	Switch Expressions (Preview)
- 334:	JVM Constants API
- 340:	One AArch64 Port, Not Two
- 341:	Default CDS Archives
- 344:	Abortable Mixed Collections for G1
- 346:	Promptly Return Unused Committed Memory from G1

# Java 13 Features

[Java SE at a Glance](https://www.oracle.com/technetwork/java/javase/overview/index.html),  
[ava 13 Preview Features](https://blog.jetbrains.com/idea/2019/07/support-for-java-13-preview-features-in-intellij-idea-2019-2/), 
[Open JDK](https://openjdk.java.net/projects/jdk/13/) 

- 189:	Shenandoah: A Low-Pause-Time Garbage Collector (Experimental)
- 230:	Microbenchmark Suite
- 325:	Switch Expressions (Preview)
- 334:	JVM Constants API
- 340:	One AArch64 Port, Not Two
- 341:	Default CDS Archives
- 344:	Abortable Mixed Collections for G1
- 346:	Promptly Return Unused Committed Memory from G1
