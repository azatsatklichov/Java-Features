package features.in.java14;

/**
 * NUMA-Aware Memory Allocation for G1
 * 
 * Improve G1 performance on large machines by implementing NUMA-aware memory
 * allocation.
 * 
 * Motivation Modern multi-socket machines increasingly have non-uniform memory
 * access (NUMA), that is, memory is not equidistant from every socket or core.
 * Memory accesses between sockets have different performance characteristics,
 * with access to more-distant sockets typically having more latency.
 * 
 * https://openjdk.java.net/jeps/345
 * 
 * 
 *
 */
public class NumaAware {

}
