package features.in.java10;

//https://www.baeldung.com/java-10-performance-improvements
/**
 * <pre>
*Parallel Full GC for G1
*
*Improves G1 worst-case latencies by making the full GC parallel.
*
The G1 garbage collector is the default one since JDK 9. However, the full GC for G1 used 
a single threaded mark-sweep-compact algorithm.

This has been changed to the parallel mark-sweep-compact algorithm in Java 10 effectively
reducing the stop-the-world time during full GC.
 
 
 G1 was made the default GC, which was
 
 * designed to avoid full collections, but when the concurrent collections
 * couldn’t reclaim memory quick enough it would end up falling back on a full
 * GC, and here is where the problem lies.
 * 
 * The aim of JEP 307 is to parallelize the full GC algorithm so that in the
 * unlikely event of a G1 Full GC then the same number of threads can be used as
 * in the concurrent collections.
 * 
 * 
 * 
 * Description
	The G1 garbage collector is designed to avoid full collections, but when the concurrent collections 
	can't reclaim memory fast enough a fall back full GC will occur. The current implementation of the 
	full GC for G1 uses a single threaded mark-sweep-compact algorithm. We intend to parallelize the mark-sweep-compact 
	algorithm and use the same number of threads as the Young and Mixed collections do. The number of threads can be controlled 
	by the -XX:ParallelGCThreads option, but this will also affect the number of threads used for Young and Mixed collections.
 * </pre>
 */
class ParallelFullGC4G1 {

}

/**
 * 
 * <pre>
 *
 * This JEP increases code isolation of different garbage collectors and
 * introduces a clean interface for garbage collectors.
 * 
 * This has a couple of advantages such as, for example, making it easier to
 * exclude a GC from a JDK build and making it easier to add a new GC without it
 * affecting the code base.
 * 
 * SUMMARY 
 * 
 *  Improves the source code isolation of different garbage collectors by 
 *  introducing a clean garbage collector (GC) interface.
 *  
 *  Goals
	Better modularity for HotSpot internal GC code
	Make it simpler to add a new GC to HotSpot without perturbing the current code base
	Make it easier to exclude a GC from a JDK build
	
	Non-Goals
	It is not a goal to actually add or remove a GC.
	This work will make progress towards build-time isolation of GC algorithms in HotSpot, but it is not a 
	goal to fully achieve build-time isolation (that is for another JEP).
 * </pre>
 */
class GarbageCollectorInterface {

}

/**
 * Class-Data Sharing
 * 
 * <pre>
 * 
 * To improve startup and footprint, this JEP extends the existing Class-Data Sharing ("CDS") 
 * feature to allow application classes to be placed in the shared archive.
 * 
*Class-Data Sharing, introduced in JDK 5, allows a set of classes to be pre-processed into a 
*shared archive file that can then be memory-mapped at runtime to reduce startup time which can also 
*reduce dynamic memory footprint when multiple JVMs share the same archive file.

CDS only allowed the bootstrap class loader, limiting the feature to system classes only. 
Application CDS (AppCDS) extends CDS to allow the built-in system class loader 
(a.k.a., the “app class loader”), the built-in platform class loader, and custom class loaders to 
load archived classes. 

This makes it possible to use the feature for application classes.
 * </pre>
 */
class ApplicationClassDataSharing {

	/**
	 * We can use the following steps to make use of this feature:
	 * 
	 * <pre>
	* 1. Get the list of classes to archive
	The following command will dump the classes loaded by the HelloWorld application into hello.lst:
	
	$ java -Xshare:off -XX:+UseAppCDS -XX:DumpLoadedClassList=hello.lst \ -cp hello.jar HelloWorld
	
	2. Create the AppCDS archive
	Following command creates hello.js a using the hello.lst as input:
	
	$ java -Xshare:dump -XX:+UseAppCDS -XX:SharedClassListFile=hello.lst \  -XX:SharedArchiveFile=hello.jsa -cp hello.jar
	
	3. Use the AppCDS archive
	Following command starts the HelloWorld application with hello.jsa as input:
	
	$ java -Xshare:on -XX:+UseAppCDS -XX:SharedArchiveFile=hello.jsa \  -cp hello.jar HelloWorld
	
	AppCDS was a commercial feature in Oracle JDK for JDK 8 and JDK 9. Now it is open sourced and made publicly available.
	 * </pre>
	 */
	public static void main(String[] args) {

	}

}

/**
 * 
 * * JEP 317: Experimental Java-Based JIT Compiler
 * 
 * <pre>
*
This JEP introduces the Graal compiler research project to the JDK. A new Java-based JIT compiler which is the 
basis of an experimental Ahead-of-Time (AOT) compiler. Graal was already added back in Java 9, but now it 
is possible to enable it with the following arguments.

-XX:+UnlockExperimentalVMOptions -XX:+UseJVMCICompiler
However, keep in mind that it is in an experimental stage and definitely not recommended for production.
 * </pre>
 * 
 * Experimental Java-Based JIT Compiler
 * 
 * <pre>
 * Enables the Java-based JIT compiler, Graal, to be used as an experimental JIT compiler on the Linux/x64 platform.
 * 
 * 
*Graal is a dynamic compiler written in Java that integrates with the HotSpot JVM; 
*it’s focused on high performance and extensibility. It’s also the basis of the experimental 
*Ahead-of-Time (AOT) compiler introduced in JDK 9.

JDK 10 enables the Graal compiler, to be used as an experimental JIT compiler on the Linux/x64 platform.

To enable Graal as the JIT compiler, use the following options on the java command line:

 
-XX:+UnlockExperimentalVMOptions -XX:+UseJVMCICompiler
Note that this is an experimental feature and we may not necessarily get better performance than the existing JIT compilers.
 * </pre>
 */
class ExperimentalJavaBasedJITCompiler {

}

/**
 * JEP 316: Heap Allocation on Alternative Memory Devices
 * 
 * <pre>
 * Enables the HotSpot VM to allocate the Java object heap on an alternative memory device, 
 * such as an NV-DIMM, specified by the user.
 * 
 * 
 *This JEP enables the
 * HotSpot VM to allocate the Java object heap on an alternative memory device,
 * specified by the user. This new feature would, for example, make it possible
 * in a multi-JVM environment to assign lower priority processes to use the
 * NV-DIMM memory, and instead only allocate the higher priority processes to
 * the DRAM.
 * </pre>
 */
class HeapAllocationOnAlternativeMemoryDevices {

}

/**
 * Consolidate the JDK Forest into a Single Repository
 * 
 * For many years, the full code base of the JDK has been broken into numerous
 * Mercurial repositories. In JDK 9 there are eight repos: root, corba, hotspot,
 * jaxp, jaxws, jdk, langtools, and nashorn.
 * 
 * <pre>
 * Nothing much to say about this JEP aside the fact that it's all about housekeeping. It will combine the
 * numerous repositories of the JDK forest into a single repository.
 *  
 *  
 *  From Java 10: 
 *  Combine the numerous repositories of the JDK forest into a single repository in order to simplify and streamline development.
 * </pre>
 */
class ConsolidateJDKForestIntoSingleRepository {

}

/**
 * JEP 313: Remove the Native-Header Generation Tool
 * 
 * <pre>
 * 
 * Remove the javah tool from the JDK since it has been superseded by superior functionality in javac.
 * 
 * 
 *Following the effort of
 * housekeeping the jdk, java 10 will no longer have a separate tool to generate
 * header files when compiling JNI code, as this can be done through javac. This
 * JEP removes the javah tool from the JDK.
 * 
 * </pre>
 */
class RemoveNativeHeaderGenerationTool {

}

/**
 * Thread-Local Handshakes
 * 
 * <pre>
 * Introduce a way to execute a callback on threads without performing a global VM safepoint. 
 * Makes it both possible and cheap to stop individual threads and not just all threads or none.
 * 
 *This JEP lays the groundwork for improved VM
 * performance, by making it possible to execute a callback on application
 * threads without performing a global VM safepoint. This would mean that the
 * JVM could stop individual threads and not just all of them. Some of the
 * small, low-level improvements that this will enable include:
 * 
 * Reducing the impact of acquiring a stack trace sample (e.g. for profiling)
 * Better stack trace sampling by reducing reliance on signals. Improving biased
 * locking by only stopping individual threads for revoking biases. Removing
 * some memory barriers from the JVM
 * 
 * 
 * </pre>
 */
class ThreadLocalHandshake {

}

/**
 * 
 * <pre>
 * 
 * JVMs are now aware of being run in a Docker container and will extract
 * container-specific configuration instead of querying the operating system
 * itself – it applies to data like the number of CPUs and total memory that
 * have been allocated to the container.
 *
 *
 *-XX:-UseContainerSupport
 *
 *-XX:ActiveProcessorCount=count
 *
 *-XX:InitialRAMPercentage
-XX:MaxRAMPercentage
-XX:MinRAMPercentage
 * </pre>
 */
class ContainerAwareness {

}

/**
 * 
 * * Root Certificates
 * 
 * <pre>
 * Provides a default set of root Certification Authority (CA) certificates in the JDK.
 * 
 * 
 *JEP 319 will provide a default set of root Certification
 * Authority making OpenJDK builds more appealing to developers. It also aims to
 * reduce the difference between the OpenJDK and Oracle JDK builds. Critical
 * security components such as TLS will now work by default in OpenJDK builds.
 * 
 *
 * The cacerts keystore, which was initially empty so far, is intended to
 * contain a set of root certificates that can be used to establish trust in the
 * certificate chains used by various security protocols.
 * 
 * As a result, critical security components such as TLS didn’t work by default
 * under OpenJDK builds.
 * 
 * With Java 10, Oracle has open-sourced the root certificates in Oracle’s Java
 * SE Root CA program in order to make OpenJDK builds more attractive to
 * developers and to reduce the differences between those builds and Oracle JDK
 * builds.
 * </pre>
 * 
 * The cacerts keystore will be populated with a set of root certificates issued
 * by the CAs of Oracle's Java SE Root CA Program.
 * 
 * TRY: > cd C:\apps\jdk-12.0.1\lib\security > keytool -list -keystore cacerts >
 * changeit
 * 
 * 
 */
class RootCertificates {

}

/**
 * <pre>
 * Enhances java.util.Locale and related APIs to implement additional Unicode
 * extensions of BCP 47 language tags.
 * 
 * 
 * </pre>
 */
class AdditionalUnicodeLanguageTagExtensions {

}

/**
 * 
 * <pre>
* Revises the version-string scheme of the Java SE Platform and the JDK, and related versioning information, 
* for present and future time-based release models.
* 
* 
*Starting with Java 10, Oracle has moved to the time-based release of Java. This has following implications:

1. A new Java release every six months. The March 2018 release is JDK 10, the September 2018 release is JDK 11, 
and so forth. These are called feature releases and are expected to contain at least one or two significant features

2. Support for the feature release will last only for six months, i.e., until next feature release

3. Long-term support release will be marked as LTS. Support for such release will be for three years

4. Java 11 will be an LTS release
java -version will now contain the GA date, making it easier to identify how old the release is:
 
$ java -version
openjdk version "10" 2018-03-20
OpenJDK Runtime Environment 18.3 (build 10+46)
OpenJDK 64-Bit Server VM 18.3 (build 10+46, mixed mode)

 
 *
 * Time-Based Release Versioning
 
 * This JEP talks about revising the version
 * string scheme of the Java SE Platform and the JDK, as well as the related
 * versioning information, for present and future time-based release models for
 * some needed clarifications, with a six-month release model.
 *
 *
 *>java -version
 * </pre>
 */
class TimeBasedReleaseVersioning {

}