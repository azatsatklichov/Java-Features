package features.in.java11;

/**
 * https://www.oracle.com/technetwork/java/javase/11-relnote-issues-5012449.html
 * 
 * The modules were already deprecated in Java 9. They are now completely
 * removed.
 * 
 * Following packages are removed:
 * 
 * <pre>
 *  
	 * java.xml.ws, 
	 * java.xml.bind, 
	 * java.activation, 
	 * java.xml.ws.annotation, 
	 * java.corba, java.transaction, 
	 * java.se.ee, 
	 * jdk.xml.ws, 
	 * jdk.xml.bind
	 * 
	 * Removed Features and Options
	 * 
		Removal of com.sun.awt.AWTUtilities Class
		Removal of Lucida Fonts from Oracle JDK
		Removal of appletviewer Launcher
		Oracle JDK’s javax.imageio JPEG Plugin No Longer Supports Images with alpha
		Removal of sun.misc.Unsafe.defineClass
		Removal of Thread.destroy() and Thread.stop(Throwable) Methods
		Removal of sun.nio.ch.disableSystemWideOverlappingFileLockCheck Property
		Removal of sun.locale.formatasdefault Property
		Removal of JVM-MANAGEMENT-MIB.mib
		Removal of SNMP Agent
		Removal of Java Deployment Technologies
		Removal of JMC from the Oracle JDK
		Removal of JavaFX from the Oracle JDK
		JEP 320 Remove the Java EE and CORBA Modules
		
		Deprecated Features and Options
		
		ThreadPoolExecutor Should Not Specify a Dependency on Finalization
		JEP 335 Deprecate the Nashorn JavaScript Engine
		Deprecate -XX+AggressiveOpts
		Obsolete Support for Commercial Features
		Deprecate Stream-Based GSSContext Methods
		JEP 336 Deprecate the Pack200 Tools and API
 * </pre>
 * 
 * Also
 * 
 * Removal of thread functions: stop(Throwable obj) and destroy()
 * 
 * objects have been removed from the JDK 11 because they only throw
 * UnSupportedOperation and NoSuchMethodError respectively. Other than that,
 * they were of no use.
 *
 */
public class RemoveJEEandCORBAModules {

}
