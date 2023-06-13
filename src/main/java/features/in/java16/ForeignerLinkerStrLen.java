//package features.in.java16;
//
//import jdk.incubator.foreign.*;
//
//import java.lang.invoke.MethodHandle;
//import java.lang.invoke.MethodType;
//
//import static jdk.incubator.foreign.CLinker.C_LONG;
//import static jdk.incubator.foreign.CLinker.C_POINTER;
//
//
//// Java call standard C library
//// size_t strlen(const char *s);
//public class ForeignerLinkerStrLen {
//	// add --add-modules jdk.incubator.foreign to compile and run the Java code
//	/**
//	 * javac --add-modules jdk.incubator.foreign ForeignerLinkerStrLen.java
//	 * 
//	 * java --add-modules jdk.incubator.foreign -Dforeign.restricted=permit
//	 * ForeignerLinkerStrLen alm 
//	 */
//	public static void main(String[] args) throws Throwable {
//
//		if (args.length == 0) {
//			throw new IllegalArgumentException("Please provide an argument.");
//		}
//
//		String input = args[0];
//
//		MethodHandle strlen = CLinker.getInstance().downcallHandle(LibraryLookup.ofDefault().lookup("strlen").get(),
//				MethodType.methodType(long.class, MemoryAddress.class), FunctionDescriptor.of(C_LONG, C_POINTER));
//
//		try (MemorySegment str = CLinker.toCString(input)) {
//			long len = (long) strlen.invokeExact(str.address()); // 5
//			System.out.println(len);
//		}
//
//	}
//}