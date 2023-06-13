//package features.in.java15;
//
//import java.lang.invoke.VarHandle;
//import java.nio.ByteOrder;
//
//import jdk.incubator.foreign.MemoryHandles;
//import jdk.incubator.foreign.MemorySegment;
//import jdk.jfr.MemoryAddress;
//
///**
// * Java 14 JEP 370 introduced a new Foreign-Memory Access API as an Incubator
// * Modules. This JEP made some changes to the APIs, and it will be still in
// * incubator modules.
// * 
// * We need to add --add-modules jdk.incubator.foreign to enable the incubator
// * modules jdk.incubator.foreign.
// * 
// * 
// * >javac --add-modules jdk.incubator.foreign HelloForeignMemory.java
// *
// */
//public class ForeignMemoryAccess {
//	public static void main(String[] args) {
//
//		VarHandle intHandle = MemoryHandles.varHandle(int.class, ByteOrder.nativeOrder());
//
//		try (MemorySegment segment = MemorySegment.allocateNative(1024)) {
//
//			MemoryAddress base = segment.baseAddress();
//
//			// print memory address
//			System.out.println(base);
//
//			// set value 999 into the foreign memory
//			intHandle.set(base, 999);
//
//			// get the value from foreign memory
//			System.out.println(intHandle.get(base));
//
//		}
//
//	}
//
//}