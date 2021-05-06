package features.in.java15;

/**
 * Biased locking is an optimization technique used in the HotSpot Virtual
 * Machine to reduce the overhead of uncontended locking.
 * 
 * The initial lock of the monitor biases the monitor towards that thread,
 * avoiding the need for atomic instructions in subsequent synchronized
 * operations on the same object.
 * 
 * JEP 374: Disable and Deprecate Biased Locking This JEP disable and deprecated
 * the biased locking by default. Before Java 15, the biased locking is always
 * enabled by default, giving performance gains for synchronized stuff.
 * 
 * The older or legacy Java application uses synchronize collections APIs like
 * Hashtable and Vector, and the biased locking may giving performance gains.
 * Nowadays, the newer Java application generally uses the non-synchronized
 * collections HashMap and ArrayList, and the performance gains of biased
 * locking are generally less useful now.
 * 
 * However, for Java 15, we still can enable the biased locking by using
 * -XX:+UseBiasedLocking, but it will prompt VM warning for deprecated API.
 *
 */
public class BiasedLockingDisabled {

	/**
	 * The older or legacy Java application uses synchronize collections APIs like
	 * Hashtable and Vector, and the biased locking may giving performance gains.
	 * Nowadays, the newer Java application generally uses the non-synchronized
	 * collections HashMap and ArrayList, and the performance gains of biased
	 * locking are generally less useful now.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
