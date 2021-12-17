package features.in.java13;

import java.nio.ByteBuffer;

public class MappedByteBuffer {

	public static void main(String[] args) {

		System.out.println("bb");
		ByteBuffer bbuf = ByteBuffer.allocate(10);

		int capacity = bbuf.capacity();

		bbuf.put(0, (byte) 0xFF); // position=0

		// position 5
		bbuf.position(5);

		bbuf.put((byte) 0xFF);

		int pos = bbuf.position(); // 6

		int rem = bbuf.remaining(); // 4

		bbuf.limit(7); // 1 left

		bbuf.rewind(); // 7 left
		
		System.out.println("done");
	}

}
