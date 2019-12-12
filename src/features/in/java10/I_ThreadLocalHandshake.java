package features.in.java10;

/**
 * Thread-Local Handshakes
 * 
 * <pre>
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
public class I_ThreadLocalHandshake {

}
