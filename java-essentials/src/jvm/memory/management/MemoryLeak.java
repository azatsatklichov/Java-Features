package jvm.memory.management;

import java.util.ArrayList;
import java.util.List;

//https://www.baeldung.com/java-memory-leaks
public class MemoryLeak {

}

class StaticFieldsMemoryLeakUnitTest {
	/**
	 * However, if we just drop the keyword static in line number 2 of the above
	 * program, then it’ll bring a drastic change to the memory usage, as shown in
	 * this Visual VM response:
	 */
	public static List<Double> list = new ArrayList<>();


	public void populateList() {
		for (int i = 0; i < 10000000; i++) {
			list.add(Math.random());
		}
		
		System.out.println("Debug Point 2");
	}

	public static void main(String[] args) {
		System.out.println("Debug Point 1");
		//new StaticFieldsDemo().populateList();
		System.out.println("Debug Point 3");
	}
}
