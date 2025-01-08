package best.practices.records;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableRecordDemo {

	private static final String FILE_PATH = "location.obj";

	public static void main(String[] args) {

		GPS obj = new GPS(10, 20);
		save(obj, FILE_PATH);

		GPS result = read(FILE_PATH);
		System.out.println(result);

	}

	private static void save(GPS obj, String path) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
			oos.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static GPS read(String path) {
		GPS result = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
			result = (GPS) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}

record GPS(double latitude, double longitude) implements Serializable {
};
