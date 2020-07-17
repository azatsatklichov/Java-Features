package features.in.java14;

//https://www.infoworld.com/article/3436795/jdk-14-the-new-features-in-java-14.html

/**
 * 
 * Enhance the language with pattern matching for the instanceof operator.
 */
class PatternMatchingForInstanceof {
}

/**
 * 
 * A packaging tool, in an incubator phase of development, for packaging
 * self-contained Java applications. The tool would be based on the JavaFX
 * javapackager. Such a tool had been included in Java but was cut from JDK 11
 * as part of the removal of JavaFX.
 *
 */
class PackagingToolIncubator {
}

/**
 * NUMA-aware memory allocation for the G1 garbage collector, intended to
 * improve G1 performance on large machines.
 * 
 * Non-uniform memory access (NUMA) is a computer memory design used in
 * multiprocessing, where the memory access time depends on the memory location
 * relative to the processor.
 *
 */
class NUMAAwareMemoryAllocation4G1 {
}

/**
 * JDK Flight Recorder
 * 
 * JFR Event Streaming provides an API for the continuous consumption of JFR
 * data from both in-process and out-of-process applications. JFR is a tool for
 * collecting profiling and diagnostic data about a Java application and the JVM
 * as they�re running.
 */
class JFREventStreaming {
}

/**
 * Non-volatile mapped byte buffers would add new JDK-specific file mapping
 * modes that allow the FileChannel API to be used to create MappedByteBuffer
 * instances that refer to non-volatile memory (NVM).
 *
 */
class NonVolatileMappedByteBuffers {
}

/**
 * The planned improvement to NullPointerExceptions pertains to improving the
 * usability of the exceptions generated by the JVM by describing exactly which
 * variable was null.
 *
 */
class HelpfulNullPointerExceptions {
}

/**
 * Records, which would provide a compact syntax for declaring classes that are
 * transparent holders for shallowly immutable data. Records make it easy to
 * create classes that are essentially data carriers without having to write a
 * lot of boilerplate
 *
 */
class RecordsPreview {
}

/**
 * 
 * Switch expressions simplify coding by extending switch so that it can be used
 * as either a statement or an expression. Switch expressions are expected to be
 * a permanent feature in JDK 14, after being previewed in both JDK 12 and JDK
 * 13.
 */
class SwitchExpressionsStandard {
}

/**
 * Deprecation of the Solaris/Sparc, Solaris/x64, and Linux/Sparc ports, with
 * the intent to remove them in a future release.
 *
 */
class DeprecateSolarisAndSPARCPorts {
}

/**
 * Removal of the Concurrent Mark Sweep (CMS) garbage collector, which
 * previously was deprecated and slated for removal. Successors to CMS have
 * arisen including ZGC and Shenandoah.
 *
 */
class RemoveConcurrentMarkSweepCMSGarbageCollector {
}

/**
 * Porting of ZGC to MacOS. It has been supported only on Linux thus far.
 *
 */
class ZGConMacOS {
}

/**
 * Porting of the ZGC (Z Garbage Collector) to Windows.
 *
 */
class ZGConWindows {
}

/**
 * Deprecating the combination of the Parallel Scavenge and Serial Old garbage
 * collection algorithms.
 *
 */
class DeprecateParallelScavengeAndSerialOldGCCombination {
}

/**
 * Removal of the pack200 and unpack200 tools and the Pack200 API in the
 * java.util.jar package. These all were deprecated in Java SE 11 with the
 * intent to remove them in the future. Pack200 is a compression scheme for JAR
 * files.
 * 
 *
 */
class RemovePack200ToolsAndAPI {
}

/**
 * A second preview of text blocks, a multi-line string literal that avoids the
 * need for most escape sequences and automatically formats the string in a
 * predictable way.
 *
 */
class TextBlocksSecondPreview {
}

/**
 * Foreign-memory access API, with the introduction of an API for Java programs
 * to safely and efficiently access foreign memory outside of the Java heap.
 *
 */
class ForeignMemoryAccessAPIIncubator {
}
