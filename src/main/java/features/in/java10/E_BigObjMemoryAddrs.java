package features.in.java10;

 
import java.util.Random;

import jvm.memory.management.BigObj;

public class E_BigObjMemoryAddrs {
	
	 

	/**
	 * // first run
	 * 
	 * -Xshare:dump -XX:+UseAppCDS -XX:ShareClassListFile=..
	 * -XX:ShareArchiveFile=myApp.jsa
	 * 
	 * // using CDS on other run or on different JVM
	 * 
	 * -Xshare:on -XX:+UseAppCDS -XX:ShareArchiveFile=myApp.jsa
	 * 
	 * 
	 *classpath should be identical on all JVMs
	 * 
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String... args) throws Exception {
		int arraySize = 1000000;
		BigObj[] bigArr = new BigObj[arraySize];
		// System.out.println(bigArr[0]);

		int count = 0;
		Random rnd = new Random();
		while (true) {
			bigArr[rnd.nextInt(arraySize)] = new BigObj();
			if (count % 2000000 == 0) { // 2000000
				System.out.print(".");
				// Thread.sleep(1);
			}
			count++;
		}

	}
} 