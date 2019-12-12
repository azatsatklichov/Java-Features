package features.in.java10;

/**
 * Parallel Full GC for G1 In Java 9
 * 
 * <pre>
 * , G1 was made the default GC, which was
 * designed to avoid full collections, but when the concurrent collections
 * couldn’t reclaim memory quick enough it would end up falling back on a full
 * GC, and here is where the problem lies.
 * 
 * The aim of JEP 307 is to parallelize the full GC algorithm so that in the
 * unlikely event of a G1 Full GC then the same number of threads can be used as
 * in the concurrent collections.
 * 
 * </pre>
 */
public class D_ParallelFullGC4G1 {

}
