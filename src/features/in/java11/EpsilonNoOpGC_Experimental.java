package features.in.java11;

/**
 * <pre>
 * 
 * Unlike the JVM GC which is responsible for allocating memory and releasing it, Epsilon only allocates memory.
 * This handles memory allocation but does not have actual memory reclamation mechanism. Once the available Java heap is exhausted, JVM will shut down.
	Its goals are:-  It allocates memory for the following things: 
	
	Performance testing.
	Memory pressure testing.
	VM interface testing.
	Extremely short lived jobs.
	Last-drop latency improvements.
	Last-drop throughput improvements.
	
	Now Epsilon is good only for test environments. It will lead to OutOfMemoryError in production and crash the applications.

	The benefit of Epsilon is no memory clearance overhead. Hence it’ll give an accurate test result of performance and we can no longer GC for stopping it.
	
	Note: This is an experimental feature.
	
	
	Summary
		Develop a GC that handles memory allocation but does not implement any actual memory reclamation mechanism. 
		Once the available Java heap is exhausted, the JVM will shut down.
	
	Goals
		Provide a completely passive GC implementation with a bounded allocation limit and the lowest latency overhead possible, at the expense of memory 
		footprint and memory throughput. A successful implementation is an isolated code change, does not touch other GCs, and makes minimal changes in the rest of JVM.
 * 
 * </pre>
 *
 */
public class EpsilonNoOpGC_Experimental {
	public static void main(String[] args) {
		System.out.println(
				"Epsilon is good only for test environments. It will lead to OutOfMemoryError in production and crash the applications");
	}
}
