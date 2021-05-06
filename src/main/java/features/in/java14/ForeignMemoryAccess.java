package features.in.java14;

import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;

import jdk.incubator.foreign.MemoryHandles;
import jdk.incubator.foreign.MemorySegment;
import jdk.jfr.MemoryAddress;

/**
 * JEP 370: Foreign-Memory Access API (Incubator) An incubator module, allow
 * Java API to access foreign memory outside of the Java heap.
 * 
 * 
 * >javac --add-modules jdk.incubator.foreign ForeignMemoryAccess.java
 *
 */
public class ForeignMemoryAccess {

	public static void main(String[] args) {

		VarHandle intHandle = MemoryHandles.varHandle(int.class, ByteOrder.nativeOrder());

		try (MemorySegment segment = MemorySegment.allocateNative(1024)) {

			MemoryAddress base = segment.baseAddress();

			// print memory address
			System.out.println(base);

			// set value 999 into the foreign memory
			intHandle.set(base, 999);

			// get the value from foreign memory
			System.out.println(intHandle.get(base));

		}

	}

}
