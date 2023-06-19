package jvm.memory.management;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.Random;

public class E_BigObjMemoryAddrs {

	//Default G1 - (no need to put: (-XX:+UseG1GC  )
	//-XX:+UseParallelGC
	//-XX:+UseConcMarkSweepGC - Unrecognized VM option 'UseConcMarkSweepGC' 
	public static void main(String... args) throws Exception {
		int arraySize = 1000000;
		BigObj[] bigArr = new BigObj[arraySize]; 
		//System.out.println(bigArr[0]);

		int count = 0;
		Random rnd = new Random();
		while (true) {
			bigArr[rnd.nextInt(arraySize)] = new BigObj();
			if (count % 2000000 == 0) { //2000000
				System.out.print(".");
				//Thread.sleep(1);
			}
			count++;
		}
		
		
	}
}

class DetermineWhichCGUsed{
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
