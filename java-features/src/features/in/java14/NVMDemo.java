package features.in.java14;

import java.io.File;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

//http://mashona.io/blog/2020/03/17/using-jep-352-api
public class NVMDemo {

	// A MappedByteBuffer provides a way to access a region of memory, corresponding
	// to a file, from Java.
	public static void main(String[] args) throws IOException {
		/*
		 * The steps to creating a MappedByteBuffer for Persistent Memory are almost the
		 * same as in the non-persistent case. First, create a FileChannel:
		 */
		final File file = new File("/path/to/some/file");

		final FileChannel fileChannel = (FileChannel) Files.newByteChannel(file.toPath(),
				EnumSet.of(StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE));

		MappedByteBuffer mappedByteBuffer = null;

		// Next, at the point the memory map is instantiated, use the new
		// ExtendedMapMode flag to take advantage of DAX mode mapping:
//		try {
//			mappedByteBuffer = fileChannel.map(ExtendedMapMode.READ_WRITE_SYNC, position, size);
//		} catch (IOException e) {
//			// mapping failed! maybe retry with MapMode.READ_WRITE instead?
//		}
	}

}
