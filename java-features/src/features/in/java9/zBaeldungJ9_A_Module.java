package features.in.java9;

public class zBaeldungJ9_A_Module {
    /**
     * 
     * Modular System – Jigsaw Project
     *
     * <pre>
    Let’s start with the big one – bringing modularity into the Java platform.
    
    A modular system provides capabilities similar to OSGi framework’s system. Modules have a concept of dependencies, 
    can export a public API and keep implementation details hidden/private.
    
    One of the main motivations here is to provide modular JVM, which can run on devices with a lot less available memory. 
    The JVM could run with only those modules and APIs which are required by the application. Check out this link for a 
    description of what these modules are.
    
    Also, JVM internal (implementation) APIs like com.sun.* are no longer accessible from application code.
    
    Simply put, the modules are going to be described in a file called module-info.java located in the top of java code hierarchy:
    
    1
    2
    3
    4
    module com.baeldung.java9.modules.car {
     requires com.baeldung.java9.modules.engines;
     exports com.baeldung.java9.modules.car.handling;
    }
    Our module car requires module engine to run and exports a package for handling.
    
    For more in-depth example check OpenJDK Project Jigsaw: Module System Quick-Start Guide.
     * </pre>
     */

}


