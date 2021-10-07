package jvm.memory.management;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

//https://www.baeldung.com/java-unsafe
public class B1_BigObjAllocation {
	private static Unsafe unsafe;

	static {
		try {
			Field field = Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			unsafe = (Unsafe) field.get(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String... args) throws Exception {
		for (int i = 0; i < 32000; i++) {
			Object obj = new BigObj();
			long address = addressOf(obj);
			System.out.println(address);
			// Verify address works - should see the characters in the array in the output
			// printBytes(address, 31);
		}
	}

	public static long addressOf(Object o) throws Exception {
		Object[] array = new Object[] { o };

		long baseOffset = unsafe.arrayBaseOffset(Object[].class);
		int addressSize = unsafe.addressSize();
		long objectAddress;
		switch (addressSize) {
		case 4:
			objectAddress = unsafe.getInt(array, baseOffset);
			break;
		case 8:
			objectAddress = unsafe.getLong(array, baseOffset);
			break;
		default:
			throw new Error("unsupported address size: " + addressSize);
		}

		return (objectAddress);
	}

	public static void printBytes(long objectAddress, int num) {
		for (long i = 0; i < num; i++) {
			int cur = unsafe.getByte(objectAddress + i);
			System.out.print((char) cur);
		}
		System.out.println();
	}
}
