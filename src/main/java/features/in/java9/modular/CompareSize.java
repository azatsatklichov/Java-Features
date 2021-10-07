package features.in.java9.modular;

import java.io.File;
import java.text.DecimalFormat;

public class CompareSize {

	public static void main(String[] args) {
		System.out.println("MODULAR JAVA - see in ModularJavaProjects folder");
		File folder1 = new File("C:\\apps\\Java\\jdk-17");
		File folder2 = new File("C:\\workspace-JavaNew\\J8\\out-standalone");
		File folder3 = new File("C:\\workspace-JavaNew\\J8\\out-standalone-optimized"); 
		
		long sizeJDK17 = getFolderSize(folder1);
		long sizeImage = getFolderSize(folder2);
		long sizeImage2 = getFolderSize(folder3);

		String readableSize = getReadableSize(sizeJDK17);
		System.out.println("JDK17 (without app): "+readableSize);
		readableSize = getReadableSize(sizeImage);
		System.out.println("Runtime Image (app+runtime): "+readableSize);
		readableSize = getReadableSize(sizeImage2);
		System.out.println("Runtime Image (app+runtime) optimized: "+readableSize);
	}

	private static String getReadableSize(long sizeJDK17) {
		String[] units = new String[] { "B", "KB", "MB", "GB", "TB" };
		int unitIndex = (int) (Math.log10(sizeJDK17) / 3);
		double unitValue = 1 << (unitIndex * 10);

		String readableSize = new DecimalFormat("#,##0.#").format(sizeJDK17 / unitValue) + " " + units[unitIndex];
		return readableSize;
	}

	private static long getFolderSize(File folder) {
		long length = 0;
		File[] files = folder.listFiles();

		int count = files.length;

		for (int i = 0; i < count; i++) {
			if (files[i].isFile()) {
				length += files[i].length();
			} else {
				length += getFolderSize(files[i]);
			}
		}
		return length;
	}

}
