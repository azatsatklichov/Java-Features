package features.in.java12;

import features.in.java10._PerformanceImprovementsAndMoreJEPs;

/**
 * This enhances the JDK build process to generate a class data-sharing (CDS)
 * archive, using the default class list, on 64-bit platforms. The goal is to
 * improve startup time. From Java 12, CDS is by default ON.
 * 
 * To run your program with CDS turned off do the following:
 * 
 * {@link _PerformanceImprovementsAndMoreJEPs}
 * {@link ApplicationClassDataSharing}
 */
public class DefaultCDSArchives {
	
	/**
	 * The goal is to improve startup time. From Java 12, CDS is by default ON.
	 * 
	 * java -Xshare:off HelloWorld.java
	 * 
	 * Now, this would delay the startup time of the program.
	 */

}
