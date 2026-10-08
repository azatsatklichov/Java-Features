package features.in.java13;

/**
 * ZGC: Uncommit Unused Memory – JEP 351
 * 
 * <pre>
 * This JEP has enhanced ZGC to return unused heap memory to the operating
 * system.
 * 
 *  The Z Garbage Collector was introduced in Java 11. It adds a short
 * pause time before the heap memory cleanup. 
 * 
 * But, the unused memory was not being returned to the operating system. 
 * 
 * This was a concern for devices with
 * small memory footprint such as IoT and microchips. Now, it has been enhanced
 * to return the unused memory to the operating system.
 *
 * </pre>
 */
public class ZGCUncommitUnusedMemoryJEP351 {
	public static void main(String[] args) {
		System.out.println("Now, ZGC has been enhanced to return the unused memory to the operating system.");
	}
}
