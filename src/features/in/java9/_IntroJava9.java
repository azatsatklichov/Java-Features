package features.in.java9;

/**
 * JAVA 9 (aka jdk 1.9) is a major release of JAVA programming language development. Its initial version was released on 21 Sep 2017. The main goals of Java 9 release are −

To make JDK and Java Standard Edition platform modular based in the sense that it can be scalled down to small computing devices well.

To improve the overall security of the JDK and Java Implementations.

To make build process and maintainance of java code libraries and large applications easy for for JAVA SE and EE platforms.

To design and implement a standard module system for the Java Platform which can be applied on both Platform and JDK easily.

New Features
There are 90+ enhancements added to Java 8, the most significant ones are mentioned below −

Module − A new kind of Java programing component introduced as module, which is a named, self-describing collection of code and data.

REPL (JShell) − Read-Eval-Print Loop (REPL) capability added to the Java platform.

HTTP 2 Client − new HTTPClient API supporting websockets and HTTP 2 streams and server push features.

Improved JavaDocs − Supports HTML5 output generation. Provides a search box to generated API documentation.

Multirelease JAR − Enhances the JAR format so that multiple, Java release-specific versions of class files can coexist in a single archive.

Collection Factory Methods − New static factory methods for List, Set, and Map interfaces to create immutable instances of those collections.

Private Interface Methods − Enhanced interfaces with private and private static methods.

Process API Improvements − Improved API to control and manage operating system processes.

Stream API Improvements − Enhanced security and robustness by allowing incoming streams of object-serialization data to be filtered.

Try With Resources improvement − Now final variables can be used as resources in the try-with-resources statement.

Enhanced @Deprecated Annotation − @Deprecated annotation revamped to provide more information about the status and intended disposition of an API.

Inner Class Diamond Operator − Allow the diamond operator to be used with anonymous classes if the argument type of the inferred type can be denoted.

Optional Class Improvements − New useful methods are added to java.util.Optional class.

Multiresolution Image API − Supports encapsulation of a set of images with different resolutions into a single multiresolution image.

CompletableFuture API improvements − The asynchronous mechanisms of the CompletableFuture class can perform an action when the process exits with ProcessHandle.onExit method.

Lightweight JSON − A lightweight API introduced to consume and generating documents and data streams via json in java 9.

Reactive Streams API − A new Reactive Streams API in Java SE 9 has been introduced to support reactive programming in java 9
</pre>
 * @author ASUS
 *
 */
public class _IntroJava9 {
    
    public static void main(String[] args) {
        System.out.println("o make JDK and Java Standard Edition platform modular based in the sense that it can be scalled down to small computing devices well.");
        
        /**
         * A new optional phase,link time, is introduced. This phase is in-between compile time and run time. During this phase, a set of modules can be assembled and optimized, making a custom runtime image using jlink tool.

javac, jlink, and java have additional options to specify module paths, which further locate definitions of modules.

JAR format updated as modular JAR, which contains module-info.class file in its root directory.

JMOD format introduced, a packaging format (similar to JAR) which can include native code and configuration files.
         */
        System.out.println("1. A module is a self-describing collection of code and data and has a name to identify it.");
        System.out.println("--- module-info.class  ---");
        System.out.println("By convention, the source code of a module to lie in same directory which is the name of the module.");
        
        
        
    }

}
