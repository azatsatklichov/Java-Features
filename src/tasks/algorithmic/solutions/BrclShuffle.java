package tasks.algorithmic.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BrclShuffle {

	public static void main(String[] args) {

		List<String> inputList = ProvideList.getFilledList();
		System.out.println(inputList);

		System.out.println("shuffling using Array way ");
		String[] arr = inputList.toArray(new String[0]);
		String[] randomizedArray = randomize(arr);
		System.out.println(Arrays.toString(randomizedArray));

		System.out.println("shuffling using List  way ");
		List<String> randomizedList = randomize(ProvideList.getFilledList());
		System.out.println(randomizedList);
	}

	private static String[] randomize(String[] arr) {
		Random r = new Random();
		for (int i = arr.length - 1; i > 0; i--) {
			int j = r.nextInt(i);
			swap(arr, i, j);
		}
		return arr;
	}

	private static void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static List<String> randomize(List<String> list) {
		Random r = new Random();
		for (int i = list.size() - 1; i > 0; i--) {
			int j = r.nextInt(i);
			swap(list, i, j);
		}
		return list;
	}

	private static void swap(List<String> list, int i, int j) {
		String temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
}

class ShuffleViaJavaCollections {
	public static void main(String[] args) {

		List<String> inputList = ProvideList.getFilledList();

		System.out.println("Given : " + inputList);

		Collections.shuffle(inputList, new Random());
		System.out.println("\nShuffled: " + inputList);

		Collections.shuffle(inputList, new Random(3));
		System.out.println("\nShuffled with Random(3): " + inputList);

		Collections.shuffle(inputList, new Random(5));
		System.out.println("\nShuffled with Random(5): " + inputList);
	}

}

class ProvideList {
	public static List<String> getFilledList() {
		List<String> inputList = new ArrayList<String>();
		inputList.add("mgm");
		inputList.add("kndx");
		inputList.add("dborse");
		inputList.add("omio");
		inputList.add("infor");
		inputList.add("amazon");
		inputList.add("estorage");
		inputList.add("epam");
		inputList.add("servodata");
		return inputList;
	}
}