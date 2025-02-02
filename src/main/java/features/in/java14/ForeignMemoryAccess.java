//package features.in.java14;
//
//import java.lang.invoke.VarHandle;
//import java.lang.reflect.Field;
//import java.nio.ByteOrder;
//
//import jdk.incubator.foreign.MemoryHandles;
//import jdk.incubator.foreign.MemorySegment;
//import jdk.jfr.MemoryAddress;
//import jvm.memory.management.B1_BigObjAllocation;
//import sun.misc.Unsafe;
//
///**
// * Overview: https://www.baeldung.com/java-foreign-memory-access
// * 
//Java objects reside on the heap. However, this can occasionally lead to problems such as inefficient memory usage,
// low performance, and garbage collection issues. Native memory can be more efficient in these cases, but using it has been 
// traditionally very difficult and error-prone.
//
//Java 14 introduces the foreign memory access API to access native memory more securely and efficiently.
// */
//
///**
// * {@link B1_BigObjAllocation}
// *
// */
//class UnsafeTest {
//
//	public static void main(String[] args) throws Exception {
//
//		/*
//		 * https://dzone.com/articles/native-memory-allocation-in-examples
//		 * 
//		 * STAGE 1
//		 * 
//		 * Gets an access to an instance of Unsafe
//		 * 
//		 */
//
//		Field f = Unsafe.class.getDeclaredField("theUnsafe");
//
//		f.setAccessible(true);
//
//		Unsafe unsafe = (Unsafe) f.get(null);
//
//		System.out.println(
//				" The Page is a fixed-length addressable block of virtual memory that can be mapped to physical memory (whatever it is, \n"
//						+ "RAM or swapped out memory to disk).\n");
//		System.out.println("PAGE SIZE: " + unsafe.pageSize());
//
//		System.out.println("allocate a 50MB block of memory, enter the number and press enter:  ");
//		System.in.read();
//
//		/*
//		 * 
//		 * STAGE 2
//		 * 
//		 * Allocates 50MB of native memory
//		 * 
//		 */
//
//		int memoryBlock = 50 * 1024 * 1024;
//
//		long address = unsafe.allocateMemory(memoryBlock);
//
//		System.out.println("ALLOCATED");
//
//		System.in.read();
//
//		/*
//		 * 
//		 * STAGE 3
//		 * 
//		 * Touches the allocated pages:
//		 * 
//		 * writes one byte to every page to ensure that
//		 * 
//		 * the page will be physically backed/mapped in memory
//		 * 
//		 */
//
//		long currentAddress = address;
//
//		while (currentAddress < (address + memoryBlock)) {
//
//			unsafe.putByte(currentAddress, (byte) 0);
//
//			currentAddress += unsafe.pageSize();
//
//		}
//
//		System.out.println("MEMORY TOUCHED");
//
//		System.in.read();
//
//		/*
//		 * 
//		 * STAGE 4
//		 * 
//		 * Frees the allocated memory.
//		 * 
//		 */
//
//		unsafe.freeMemory(address);
//
//		System.out.println("DE-ALLOCATED");
//
//		System.in.read();
//
//	}
//}
//
//class NativeAllocations {
//	/**
//	 * https://www.baeldung.com/native-memory-tracking-in-jvm
//	 * 
//	 * 
//	 * The heap usually is the largest consumer of memory in Java applications, but
//	 * there are others. Besides the heap, the JVM allocates a fairly large chunk
//	 * from the native memory to maintain its class metadata, application code, the
//	 * code generated by JIT, internal data structures, etc. In the following
//	 * sections, we'll explore some of those allocations.
//	 * 
//	 * In order to maintain some metadata about the loaded classes, The JVM uses a
//	 * dedicated non-heap area called Metaspace. Before Java 8, the equivalent was
//	 * called PermGen or Permanent Generation. Metaspace or PermGen contains the
//	 * metadata about the loaded classes rather than the instances of them, which
//	 * are kept inside the heap.
//	 * 
//	 * The important thing here is that the heap sizing configurations won't affect
//	 * the Metaspace size since the Metaspace is an off-heap data area. In order to
//	 * limit the Metaspace size, we use other tuning flags:
//	 */
//
//}
//
///**
// * 
// * Foreign-Memory Access API (Incubator, JEP-370) – project PANAMA, integrating
// * Java with native-env, allow Java API to access foreign memory outside of the
// * Java heap. E.g. used by JFR There were two main ways to access native memory
// * in Java via: ByteBuffer [HeapByteBuffer and DirectByteBuffer] and Unsafe
// * 
// * java.nio.ByteBuffer [limitations: buffer size max 2GB, GC is resp. for memory
// * deallocation, incorrect usage mem-leak] sun.misc.Unsafe [extremely efficient
// * due to its addressing model but now Java 9 jdk.unsupported module ... ] Or
// * using other libraries like: Netty or Aeron Project PANAMA is born -  close to
// * the efficiency of Unsafe
// * 
// * 
// * 
// * JEP 370: Foreign-Memory Access API (Incubator) An incubator module, allow
// * Java API to access foreign memory outside of the Java heap.
// * 
// * 
// * >javac --add-modules jdk.incubator.foreign ForeignMemoryAccess.java
// *
// *
// * $ /usr/lib/jvm/jdk-14/bin/javac --add-modules jdk.incubator.foreign Test.java
// * 
// * warning: using incubating module(s): jdk.incubator.foreign 1 warning
// * 
// * $ /usr/lib/jvm/jdk-14/bin/java --add-modules jdk.incubator.foreign Test
// * 
// * WARNING: Using incubator modules: jdk.incubator.foreign MemoryAddress{
// * region: MemorySegment{ id=0x4aac6dca limit: 1024 } offset=0x0 } 999
// */
//public class ForeignMemoryAccess {
//
//	public static void main(String[] args) {
//		// https://www.baeldung.com/java-foreign-memory-access
//
//		VarHandle intHandle = MemoryHandles.varHandle(int.class, ByteOrder.nativeOrder());
//
//		try {
//
//			/**
//			 * A memory segment backed by native memory is known as a native memory segment.
//			 * It's created using one of the overloaded allocateNative methods.
//			 */
//			// MemorySegment segment = MemorySegment.allocateNative(1024, null);
//
//			/**
//			 * A memory segment can also be backed by an existing heap-allocated Java array.
//			 * For example, we can create an array memory segment from an array of long:
//			 */
//			MemorySegment segment = MemorySegment.ofArray(new long[100]);
//
//			/**
//			 * Alternatively, we can use a memory-mapped file. This is known as a mapped
//			 * memory segment. Let's define a 200-byte memory segment using a file path with
//			 * read-write access:
//			 */
//			// MemorySegment memorySegment =
//			// MemorySegment.mapFromPath(Path.of("/tmp/memory.txt"), 200,
//			// FileChannel.MapMode.READ_WRITE);
//
//			/**
//			 * A memory segment is attached to a specific thread. So, if any other thread
//			 * requires access to the memory segment, it must gain access using the acquire
//			 * method.
//			 */
//
//			// A MemoryAddress is an offset within a memory segment. It's commonly obtained
//			// using the baseAddress method:
//			// A memory address is used to perform operations such as retrieving data from
//			// memory on the underlying memory segment.
//			MemoryAddress base = (MemoryAddress) segment.address();
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
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//		}
//
//	}
//}
//
//class PanamaMain {
//	public static void main(String[] args) {
//		MemoryAddress address = MemorySegment.allocateNative(24).baseAddress();
//
//		MemoryAddress address1 = address.segment().asSlice(0, 8).baseAddress();
//		MemoryAddress address2 = address.segment().asSlice(8, 8).baseAddress();
//		MemoryAddress address3 = address.segment().asSlice(16, 8).baseAddress();
//
//		VarHandle handle = MemoryHandles.varHandle(long.class, ByteOrder.nativeOrder());
//		handle.set(address1, Long.MIN_VALUE);
//		handle.set(address2, 0);
//		handle.set(address3, Long.MAX_VALUE);
//
//		long value1 = (long) handle.get(address1);
//		long value2 = (long) handle.get(address2);
//		long value3 = (long) handle.get(address3);
//
//		System.out.println("Memory Value 1: " + value1);
//		System.out.println("Memory Value 2: " + value2);
//		System.out.println("Memory Value 3: " + value3);
//	}
//}