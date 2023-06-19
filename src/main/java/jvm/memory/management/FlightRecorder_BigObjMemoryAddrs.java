package jvm.memory.management;

import java.util.Random;

import jvm.memory.management.BigObj;

public class FlightRecorder_BigObjMemoryAddrs {

	// to try Flight Recorder run with JVM options
	// -XX:StartFlightRecording=duration=30s,settings=profile,filename=leak_bigMemory.jfr

	// or in command line
	// >java -XX:StartFlightRecording=duration=30s,settings=profile,filename=leak_bigMemory.jfr FlightRecorder_BigObjMemoryAddrs

	// or try run without option and use via JPS its PID for below command
	//> jps   //to find PID 
	// > jcmd 35088 JFR.start duration=30s settings=profile filename=C:/workspace-17/Java-Features/leak_bigMemory_jcmd.jfr

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