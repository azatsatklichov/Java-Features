- [Java Features at GitHub](https://github.com/azatsatklichov/Java-Features.git), 
- [Open JDK](https://openjdk.java.net/), 
- [Specs](https://docs.oracle.com/javase/specs/),  
- [Java Doc](https://docs.oracle.com/en/java/index.html), 
- [The Java Tutorials](https://docs.oracle.com/javase/tutorial/), 
- [Sahet.Net JAVA Guide](http://sahet.net/htm/java.html),  
- [JCP](https://en.wikipedia.org/wiki/Java_Community_Process), 
- [JEP](https://openjdk.java.net/jeps/0), 
- [Wikipedia](https://en.wikipedia.org/wiki/Java_version_history#JDK_1.0), 
- [Oracle Java SE at a Glance](https://www.oracle.com/technetwork/java/javase/overview/index.html), 

# Five main goals which Java language intended to bring  
- Simple, object-oriented, and familiar.
- Robust and secure.
- Architecture-neutral (agnostic) and portable.
- Execute with high performance.
- Interpreted, threaded, and dynamic.


# Java 1 Features (GA January 1996), Java 1.1 (February 1997)
The first version was released on January 23, 1996. The first stable version, JDK 1.0.2, is called Java 1.
Java 1.1 Major additions in the release on February 19, 1997 included:
- an extensive retooling of the AWT event model
- inner classes added to the language
- JavaBeans
- JDBC
- RMI
- reflection which supported Introspection only, no modification at runtime was possible. (The ability to modify objects reflectively was added in J2SE 1.2, by introducing the AccessibleObject class and its subclasses such as the Field class.)
- JIT (Just In Time) compiler on Microsoft Windows platforms, produced for JavaSoft by Symantec
- Internationalization and Unicode support originating from Taligent 



# Java 2 Features (GA December 1998)
Codename Playground. The release on December 8, 1998 and subsequent releases through J2SE were rebranded retrospectively Java 2 and the version name "J2SE" (Java 2 Platform, Standard Edition) replaced JDK to distinguish the base platform from J2EE (Java 2 Platform, Enterprise Edition) and J2ME (Java 2 Platform, Micro Edition). This was a very significant release of Java as it tripled the size of the Java platform to 1520 classes in 59 packages. Major additions included:
- strictfp keyword
- the Swing graphical API was integrated into the core classes
- Sun's JVM was equipped with a JIT compiler for the first time
- Java plug-in
- Java IDL, an IDL implementation for CORBA interoperability
- Collections framework


# Java 3 Features (GA May 2000)
Codename Kestrel ([API](https://docs.oracle.com/javase/1.3/docs/api/)). The most notable changes in the May 8, 2000 release were: 
- HotSpot JVM included (the HotSpot JVM was first released in April 1999 for the J2SE 1.2 JVM)
- RMI was modified to support optional compatibility with CORBA
- Java Naming and Directory Interface (JNDI) included in core libraries (previously available as an extension)
- Java Platform Debugger Architecture (JPDA)
- JavaSound
- Synthetic proxy classes


# Java 4 Features (GA February 2002)
Codename Merlin ([API](https://docs.oracle.com/javase/1.4.2/docs/api/)). The February 6, 2002 release was the first release of the Java platform developed under the Java Community Process as JSR 59. Major changes included:

- Language changes
- assert keyword (specified in JSR 41)
- Library improvements
- Regular expressions modeled after Perl regular expressions
- Exception chaining allows an exception to encapsulate original lower-level exception
- Internet Protocol version 6 (IPv6) support
- Non-blocking I/O (Java) (named NIO) (specified in JSR 51)
- Logging API (specified in JSR 47)
- Image I/O API for reading and writing images in formats like JPEG and PNG
- Integrated XML parser and XSLT processor (JAXP) (specified in JSR 5 and JSR 63)
- Integrated security and cryptography extensions (JCE, JSSE, JAAS)
- Java Web Start included (Java Web Start was first released in March 2001 for J2SE 1.3) (specified in JSR 56)
- Preferences API (java.util.prefs)

Public support and security updates for Java 1.4 ended in October 2008. Paid security updates for Oracle customers ended in February 2013




# Java 5 Features (GA September 2004)
[Java SE 5 Documentation](https://docs.oracle.com/javase/1.5.0/docs/), 
[API](https://docs.oracle.com/javase/1.5.0/docs/api/), 
[Features](https://www.oracle.com/technetwork/articles/entarch/java-5-features-083037.html)

Codename Tiger ([API](https://docs.oracle.com/javase/1.5.0/docs/api/)) The release on September 30, 2004 was originally numbered 1.5, which is still used as the internal version number. The number was changed to "better reflect the level of maturity, stability, scalability and security of the J2SE". This version was developed under JSR 176.
J2SE 5.0 entered its end-of-public-updates period on April 8, 2008; updates are no longer available to the public as of November 3, 2009. Updates were available to paid Oracle customers until May 2015. 
Tiger added a number of significant new language features:

- Generics: provides compile-time (static) type safety for collections and eliminates the need for most typecasts (type conversion) (specified by JSR 14)
- Metadata: also called annotations; allows language constructs such as classes and methods to be tagged with additional data, which can then be processed by metadata-aware utilities (specified by JSR 175)
- Autoboxing/unboxing: automatic conversions between primitive types (such as int) and primitive wrapper classes (such as Integer) (specified by JSR 201)
- Enumerations: the enum keyword creates a typesafe, ordered list of values (such as Day.MONDAY, Day.TUESDAY, etc.); previously this could only be achieved by non-typesafe constant integers or manually constructed classes (typesafe enum pattern) (specified by JSR 201)
- Varargs: the last parameter of a method can now be declared using a type name followed by three dots (e.g. void drawtext(String... lines)); in the calling code any number of parameters of that type can be used and they are then placed in an array to be passed to the method, or alternatively the calling code can pass an array of that type
- Enhanced for each loop: the for loop syntax is extended with special syntax for iterating over each member of either an array or any Iterable, such as the standard Collection classes (specified by JSR 201)
- Improved semantics of execution for multi-threaded Java programs; the new Java memory model addresses issues of complexity, effectiveness, and performance of previous specifications 
- Static imports

There were also the following improvements to the standard libraries:

- Automatic stub generation for RMI objects
- Swing: New skinnable look and feel, called synth
- The concurrency utilities in package java.util.concurrent 
- Scanner class for parsing data from various input streams and buffers
 
Version 1.5.0 or 5.0?  This correspondence continued through later releases (Java 6 = JDK 1.6, Java 7 = JDK 1.7, and so on).



# Java 6 Features (GA December 2006)
[Java SE 6 Documentation](https://docs.oracle.com/javase/6/docs/),
[API](https://docs.oracle.com/javase/6/docs/api/),  
[Open JDK](https://openjdk.java.net/projects/jdk6/)

Codename Mustang ([API](https://docs.oracle.com/javase/6/docs/api/)). As of the version released on December 11, 2006, Sun replaced the name "J2SE" with Java SE and dropped the ".0" from the version number. Internal numbering for developers remains 1.6.0.  This version was developed under JSR 270.
 
Java 6 reached the end of its supported life in February 2013, at which time all public updates, including security updates, were scheduled to be stopped.  Oracle released two more updates to Java 6 in March and April 2013, which patched some security vulnerabilities. 

Major changes included in this version: 
- Support for older Win9x versions dropped; unofficially, Java 6 Update 7 was the last release of Java shown to work on these versions of Windows.[citation needed] This is believed[by whom?] to be due to the major changes in Update 10.
- Scripting Language Support (JSR 223): Generic API for tight integration with scripting languages, and built-in Mozilla JavaScript Rhino integration.
- Dramatic performance improvements for the core platform, and Swing.
- Improved Web Service support through JAX-WS (JSR 224).
- JDBC 4.0 support (JSR 221).
- Java Compiler API (JSR 199): an API allowing a Java program to select and invoke a Java Compiler programmatically.
- Upgrade of JAXB to version 2.0: Including integration of a StAX parser.
- Support for pluggable annotations (JSR 269). 
- Many GUI improvements, such as integration of SwingWorker in the API, table sorting and filtering, and true Swing double-buffering (eliminating the gray-area effect).
- JVM improvements include: synchronization and compiler performance optimizations, new algorithms and upgrades to existing garbage collection algorithms, and application start-up performance.



# JavaSE 7 Features (GA July 2011)
[Java SE 7 Documentation](https://docs.oracle.com/javase/7/docs/index.html),
 [API](https://docs.oracle.com/javase/7/docs/api/), 
[Open JDK](https://openjdk.java.net/projects/jdk7/)

Codename Dolphin
 
The important features of JavaSE 7 are try with resource, catching multiple exceptions etc.

- String in switch statement (Java 7)
- Binary Literals (Java 7)
- The try-with-resources (Java 7)
- Caching Multiple Exceptions by single catch (Java 7)
- Underscores in Numeric Literals (Java 7)


# JavaSE 8 Features (GA initial release 18-Mar 2014)
[JDK 8 doc](https://docs.oracle.com/javase/8/),
[API](https://docs.oracle.com/javase/8/docs/api/),  
[Docs](https://docs.oracle.com/javase/8/docs/), 
[What's New in JDK 8](https://www.oracle.com/technetwork/java/javase/8-whats-new-2157071.html), 
[Open JDK](https://openjdk.java.net/projects/jdk8/)


Codename Spider
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
- Stream API âˆ’ `java.util.stream`. New stream API to facilitate pipeline processing. Process data in a declarative way similar to SQL. Supports aggregate operations like filter, map, limit, reduce, find, match,count, sorted, statistics,  and so on.
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


# Java 9 Features (GA 21/09/2017)
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


# Java 10 Features (GA 20/03/2018)
[JDK 10 doc](https://docs.oracle.com/javase/10/),
[API](https://docs.oracle.com/javase/10/docs/api/overview-summary.html), 
[What's New in JDK 10](https://www.oracle.com/technetwork/java/javase/10-relnote-issues-4108729.html#NewFeature),
[Open JDK](https://openjdk.java.net/projects/jdk/10/) 

- 286: Local-Variable Type Inference
- Unmodifiable Collections: java.util.List, java.util.Map and java.util.Set each got a new static method copyOf(Collection).  toUnmodifiable*() java.util.stream.Collectors get additional methods to collect a Stream into unmodifiable List, Map or Set:
- 296: Consolidate the JDK Forest into a Single Repository
- 304: Garbage-Collector Interface: improve the source code isolation of different garbage collectors by introducing a clean garbage collector (GC) interface
- 307: Parallel Full GC for G1: improves G1 worst-case latencies by making the full GC parallel
- 310: Application Class-Data Sharing:  JEP extends the existing Class-Data Sharing (â€œCDSâ€�) feature
- 312: Thread-Local Handshakes
- 314: Additional Unicode Language-Tag Extensions
- 316: Heap Allocation on Alternative Memory Devices: It enables the HotSpot VM to allocate the Java object heap on an alternative memory device, such as an NV-DIMM, specified by the user.
- 317: Experimental Java-Based JIT Compiler: It will enhance the java.util.Locale and related APIs to implement additional Unicode extensions of BCP 47 language tags.
- 319: Root Certificates: It provides a default set of root Certification Authority (CA) certificates in the JDK
- 322: Time-Based Release Versioning
- 313: Remove the Native-Header Generation Tool (javah)
- Deprecated Features and Options in Java 10


# Java 11 Features (GA 25/09/2018)
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


# Java 12 Features (GA 19/03/2019)

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

# Java 13 Features (GA 17/09/2019)
[JDK 13 doc](https://docs.oracle.com/en/java/javase/13/index.html),
[API](https://docs.oracle.com/en/java/javase/13/docs/api/index.html),  
[Open JDK](https://openjdk.java.net/projects/jdk/13/) 
 
- JEP 350: Dynamic CDS Archives
- JEP-351: ZGC: Uncommit Unused Memory
- JEP-353: Reimplement the Legacy Socket API
- JEP-354: Switch Expressions (Preview) (developer feature)
- JEP-355: Text Blocks (Preview) (developer feature) and New Methods in String Class for Text Blocks
- FileSystems.newFileSystem() Method
- Support for Unicode 12.1
- DOM and SAX Factories with Namespace Support

# Java 14 Features (GA 17/03/2020)
[JDK 14 doc](https://docs.oracle.com/en/java/javase/14/index.html),
[API](https://docs.oracle.com/en/java/javase/14/docs/api/index.html), 
[Open JDK](https://openjdk.java.net/projects/jdk/14/) 

- 305:	Pattern Matching for instanceof (Preview)
- 343:	Packaging Tool (Incubator)
- 345:	NUMA-Aware Memory Allocation for G1
- 349:	JFR Event Streaming
- 352:	Non-Volatile Mapped Byte Buffers
- 358:	Helpful NullPointerExceptions
- 359:	Records (Preview)
- 361:	Switch Expressions (Standard)
- 362:	Deprecate the Solaris and SPARC Ports
- 363:	Remove the Concurrent Mark Sweep (CMS) Garbage Collector
- 364:	ZGC on macOS
- 365:	ZGC on Windows
- 366:	Deprecate the ParallelScavenge + SerialOld GC Combination
- 367:	Remove the Pack200 Tools and API
- 368:	Text Blocks (Second Preview)
- 370:	Foreign-Memory Access API (Incubator)



# Java 15 Features  (GA 15/09/2020)
[JDK 15 doc](https://docs.oracle.com/en/java/javase/15/index.html),
[API](https://docs.oracle.com/en/java/javase/15/docs/api/index.html), 
[Open JDK](https://openjdk.java.net/projects/jdk/15/) 

- 339:	Edwards-Curve Digital Signature Algorithm (EdDSA)
- 360:	Sealed Classes (Preview)
- 371:	Hidden Classes
- 372:	Remove the Nashorn JavaScript Engine
- 373:	Reimplement the Legacy DatagramSocket API
- 374:	Disable and Deprecate Biased Locking
- 375:	Pattern Matching for instanceof (Second Preview)
- 377:	ZGC: A Scalable Low-Latency Garbage Collector
- 378:	Text Blocks
- 379:	Shenandoah: A Low-Pause-Time Garbage Collector
- 381:	Remove the Solaris and SPARC Ports
- 383:	Foreign-Memory Access API (Second Incubator)
- 384:	Records (Second Preview)
- 385:	Deprecate RMI Activation for Removal



# Java 16 Features  (GA 16/03/2021)
[JDK 16 doc](https://docs.oracle.com/en/java/javase/16/index.html),
[API](https://docs.oracle.com/en/java/javase/16/docs/api/index.html), 
[Open JDK](https://openjdk.java.net/projects/jdk/16/) 


- 338:	Vector API (Incubator)
- 347:	Enable C++14 Language Features
- 357:	Migrate from Mercurial to Git
- 369:	Migrate to GitHub
- 376:	ZGC: Concurrent Thread-Stack Processing
- 380:	Unix-Domain Socket Channels
- 386:	Alpine Linux Port
- 387:	Elastic Metaspace
- 388:	Windows/AArch64 Port
- 389:	Foreign Linker API (Incubator)
- 390:	Warnings for Value-Based Classes
- 392:	Packaging Tool
- 393:	Foreign-Memory Access API (Third Incubator)
- 394:	Pattern Matching for instanceof
- 395:	Records
- 396:	Strongly Encapsulate JDK Internals by Default
- 397:	Sealed Classes (Second Preview)


# Java 17 Features  (GA 14/09/2021)
[JDK 17 doc](https://docs.oracle.com/en/java/javase/17/index.html),
[API](https://docs.oracle.com/en/java/javase/17/docs/api/index.html), 
[Open JDK](https://openjdk.java.net/projects/jdk/17/) 


JEPs targeted to JDK 17, so far

- 306: Restore Always-Strict Floating-Point Semantics
- 356: Enhanced Pseudo-Random Number Generators
- 382: New macOS Rendering Pipeline
- 391: macOS/AArch64 Port
- 398: Deprecate the Applet API for Removal
- 403: Strongly Encapsulate JDK Internals
- 406: Pattern Matching for switch (Preview)
- 407: Remove RMI Activation
- 409: Sealed Classes
- 410: Remove the Experimental AOT and JIT Compiler
- 411: Deprecate the Security Manager for Removal
- 412: Foreign Function & Memory API (Incubator)
- 414: Vector API (Second Incubator)
- 415: Vector API (Second Incubator) 



# Java 18 Features  (GA 22/03/2022)
[JDK 18 doc](https://docs.oracle.com/en/java/javase/18/index.html),
[API](https://docs.oracle.com/en/java/javase/18/docs/api/index.html), 
[Open JDK](https://openjdk.java.net/projects/jdk/18/) 


JEPs targeted to JDK 18, so far

- 400:	UTF-8 by Default
- 408:	Simple Web Server
- 413:	Code Snippets in Java API Documentation
- 416:	Reimplement Core Reflection with Method Handles
- 417:	Vector API (Third Incubator)
- 418:	Internet-Address Resolution SPI
- 419:	Foreign Function & Memory API (Second Incubator)
- 420:	Pattern Matching for switch (Second Preview)
- 421:	Deprecate Finalization for Removal
 

# Java 19 Features  (GA 20/09/2022)
[JDK 19 doc](https://docs.oracle.com/en/java/javase/19/index.html),
[API](https://docs.oracle.com/en/java/javase/19/docs/api/index.html), 
[Open JDK](https://openjdk.java.net/projects/jdk/19/) 

JEPs targeted to JDK 19, so far

- 405:	Record Patterns (Preview)
- 422:	Linux/RISC-V Port
- 424:	Foreign Function & Memory API (Preview)
- 425:	Virtual Threads (Preview)
- 426:	Vector API (Fourth Incubator)
- 427:	Pattern Matching for switch (Third Preview)
- 428:	Structured Concurrency (Incubator)


# Java 20 Features  (GA 21/03/2023)
[JDK 20 doc](https://docs.oracle.com/en/java/javase/20/index.html),
[API](https://docs.oracle.com/en/java/javase/20/docs/api/index.html), 
[Open JDK](https://openjdk.java.net/projects/jdk/20/) 

JEPs targeted to JDK 20, so far

- 429:	Scoped Values (Incubator)
- 432:	Record Patterns (Second Preview)
- 433:	Pattern Matching for switch (Fourth Preview)
- 434:	Foreign Function & Memory API (Second Preview)
- 436:	Virtual Threads (Second Preview)
- 437:	Structured Concurrency (Second Incubator)
- 438:	Vector API (Fifth Incubator)

# Java 21 Features  (GA 19/09/2023)
[JDK 21 doc](https://docs.oracle.com/en/java/javase/21/index.html),
[API](https://docs.oracle.com/en/java/javase/21/docs/api/index.html), 
[Open JDK](https://openjdk.java.net/projects/jdk/21/) 


JEPs proposed to target JDK 21	review ends
- 449:	Deprecate the Windows 32-bit x86 Port for Removal	
- 404:	Generational Shenandoah (Experimental)
- 430:	String Templates (Preview)
- 431:	Sequenced Collections
- 439:	Generational ZGC
- 440:	Record Patterns
- 441:	Pattern Matching for switch
- 442:	Foreign Function & Memory API (Third Preview)
- 443:	Unnamed Patterns and Variables (Preview)
- 444:	Virtual Threads
- 445:	Unnamed Classes and Instance Main Methods (Preview)
- 448:	Vector API (Sixth Incubator)




