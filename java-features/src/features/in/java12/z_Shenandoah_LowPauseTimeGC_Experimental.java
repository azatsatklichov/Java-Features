package features.in.java12;

/**
 * RedHat initiated Shenandoah Garbage Collector to reduce GC pause times. The
 * idea is to run GC concurrently with the running Java threads.
 *
 *
 * It aims at consistent and predictable short pauses irrelevant of the heap
 * size. So it does not matter if the heap size is 15 MB or 15GB.
 * 
 * It is an experimental feature in Java 12.
 * 
 * https://wiki.openjdk.java.net/display/shenandoah/Main
 * https://www.researchgate.net/publication/306112816_Shenandoah_An_open-source_concurrent_compacting_garbage_collector_for_OpenJDK
 * 
 * 
 * Implemented and supported by RedHat for aarch64 and amd64, Shenandoah Garbage
 * Collector, described in this paper, provides predictable and short GC pauses
 * independent of the heap size.
 * 
 * It will be provided as an experimental feature, so in order to use it,
 * 
 * <pre>
	-XX:+UnlockExperimentalVMOptions is needed together with -XX:+UseShenandoahGC.
 * </pre> 
 * 
 * Also, default (Oracle’s) OpenJDK builds will not contain this feature. You
 * can use another build or make your own build.
 * 
 * On Oracle’s OpenJDK Early-Release build:
 */
public class z_Shenandoah_LowPauseTimeGC_Experimental {
	//https://wiki.openjdk.java.net/display/shenandoah/Main

}
