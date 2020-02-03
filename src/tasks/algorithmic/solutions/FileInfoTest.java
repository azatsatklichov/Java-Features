package tasks.algorithmic.solutions;

import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import tasks.algorithmic.solutions.FileInfo.FileType;

public class FileInfoTest {

	public static void main(String[] args) {

		/*
		 * 4 lines of Words give
		 */
		var words = "my.song.mp3 11b\n" + "greatSong.flac 1000b\n" + "not3.txt 5b\n" + "video.mp4 200b\n"
				+ "game.exe 100b\n" + "mov!e.mkv 10000b\n";

		extractFileInfoByType(words);

		words = "song.jpg 11b\n" + "greatSong.flac 1000b\n" + "not3.txt 5b\n" + "video.mp4 200b\n" + "game.exe 100b\n"
				+ "mov!e.mkv 10000b\n";

		extractFileInfoByType(words);

	}

	private static Map<FileInfo.FileType, List<FileInfo>> groupFileInfoByType(List<FileInfo> fileInfos) {
		return fileInfos.stream().collect(groupingBy(FileInfo::getFileType));
	}

	private static void extractFileInfoByType(String words) {
		List<FileInfo> fileInfos = new ArrayList<>();
		words.lines().forEach(line -> {
			String[] split = line.split(" ");
			fileInfos.add(new FileInfo(split[0], Long.valueOf(split[1].substring(0, split[1].length() - 1))));
		});

		Map<FileType, List<FileInfo>> groupFileInfoByType = groupFileInfoByType(fileInfos);
		Set<FileType> keySet = groupFileInfoByType.keySet();
		for (FileType fileType : keySet) {
			Long totalsize = groupFileInfoByType.get(fileType).stream().map(f -> f.getSize())
					.collect(Collectors.summingLong(Long::longValue));
			System.out.println(fileType + " " + totalsize + "b");
		}

		System.out.println();
	}

}

class FileInfo {
	private static final String MP3 = "mp3";
	private static final String FLAC = "flac";

	private static final String MP4 = "mp4";
	private static final String MKV = "mkv";

	private static final String JPG = "jpg";
	private static final String PNG = "png";

	enum FileType {
		MUSIC, MOVIE, IMAGE, OTHER;
	}

	private Long size;
	private String fileName;
	FileType fileType;

	public FileInfo(String fileName, Long size) {
		this.fileName = fileName;
		this.size = size;
		this.fileType = getFileType(fileName);
	}

	private FileType getFileType(String fileName) {
		String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
		if (MP3.equals(fileExtension) || FLAC.equals(fileExtension)) {
			return FileType.MUSIC;
		} else if (MP4.equals(fileExtension) || MKV.equals(fileExtension)) {
			return FileType.MOVIE;
		} else if (JPG.equals(fileExtension) || PNG.equals(fileExtension)) {
			return FileType.IMAGE;
		} else {
			return FileType.OTHER;
		}

	}

	public Long getSize() {
		return size;
	}

	public String getFileName() {
		return fileName;
	}

	public FileType getFileType() {
		return fileType;
	}

	@Override
	public String toString() {
		return "FileInfo [" + fileName + ", size = " + size + "]";
	}

}