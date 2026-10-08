package jvm.memory.management;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * <pre>
 * 
 * 
 * G1 - by default (no need to put: (-XX:+UseG1GC  )
 * 
 * Name: G1 Young Generation
Number of collections: 0
Collection time: 0ms
Pool names
	G1 Eden Space
	G1 Survivor Space
	G1 Old Gen

Name: G1 Old Generation
Number of collections: 0
Collection time: 0ms
Pool names
	G1 Eden Space
	G1 Survivor Space
	G1 Old Gen




-XX:+UseParallelGC
--------------
Name: PS MarkSweep
Number of collections: 0
Collection time: 0ms
Pool names
	PS Eden Space
	PS Survivor Space
	PS Old Gen

Name: PS Scavenge
Number of collections: 0
Collection time: 0ms
Pool names
	PS Eden Space
	PS Survivor Space




-XX:+UseConcMarkSweepGC -XX:-UseParNewGC
------------ 
Unrecognized VM option 'UseConcMarkSweepGC'
 * </pre>
 *
 */
public class D_MainMXBeanDemo {

	//also run with VM arguments: 
	//-XX:+UseParallelGC
	//-XX:+UseConcMarkSweepGC 
	//-XX:+UseConcMarkSweepGC -XX:-UseParNewGC
	public static void main(String[] args) {
		List<GarbageCollectorMXBean> list = ManagementFactory.getGarbageCollectorMXBeans();
		for (GarbageCollectorMXBean bean : list) {
			System.out.println("Name: " + bean.getName());
			System.out.println("Number of collections: " + bean.getCollectionCount());
			System.out.println("Collection time: " + bean.getCollectionTime() + "ms");
			System.out.println("Pool names");
			
			for (String name : bean.getMemoryPoolNames()) {
				System.out.println("\t" + name);
			}

			System.out.println();
		}
	}
}
