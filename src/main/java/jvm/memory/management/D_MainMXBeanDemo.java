package jvm.memory.management;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

public class D_MainMXBeanDemo {

	//also run with: 
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
