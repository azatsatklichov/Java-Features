package features.in.java12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import features.in.java11.FilesReadStringWriteString;

/**
 * This method returns the position of the first mismatch or -1L if there is no
 * mismatch.
 * 
 * Two files can have a mismatch in the following scenarios:
 * 
 * If the bytes are not identical. In this case, the position of the first
 * mismatching byte is returned. File sizes are not identical.
 * 
 * In this case, the size of the smaller file is returned.
 * 
 * {@link FilesReadStringWriteString }
 * 
 */
public class FileMismatchMethod {
	public static void main(String[] args) throws IOException {
		Path filePath1 = Files.createTempFile("file1", ".txt");
		Path filePath2 = Files.createTempFile("file2", ".txt");
		Files.writeString(filePath1, "TESTů");
		Files.writeString(filePath2, "TESTů");

		long mismatch = Files.mismatch(filePath1, filePath2);

		System.out.println("File Mismatch position... It returns -1 if there is no mismatch (SAME FILES)\n");

		System.out.print("Mismatch position in file1 and file2 is >>>> ");
		System.out.println(mismatch);

		filePath1.toFile().deleteOnExit();
		filePath2.toFile().deleteOnExit();

		Path filePath3 = Files.createTempFile("file3", ".txt");
		Path filePath4 = Files.createTempFile("file4", ".txt");
		Files.writeString(filePath3, "TEST  ");
		Files.writeString(filePath4, "TEST ů");

		long mismatch2 = Files.mismatch(filePath3, filePath4);

		System.out.print("\nMismatch position in file3 and file4 is >>>> ");
		System.out.println(mismatch2);

		filePath3.toFile().deleteOnExit();
		filePath4.toFile().deleteOnExit();

	}
}