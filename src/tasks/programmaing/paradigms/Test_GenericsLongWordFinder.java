package tasks.programmaing.paradigms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Test_GenericsLongWordFinder {
    public static void main(String[] args) {
        String[] array = { "123", "12345678", "1", "12", "1234567890" };
        System.out.println(Arrays.toString(array));
        List<String> list = Arrays.asList(array);
        System.out.println(list);

        //backed convertion, if ARR updated, List will be updated
        System.out.println("see this is just BACKED conversion");
        array[2] = "111";
        //list.add("Alfonso-backed"); Exception in thread "main" java.lang.UnsupportedOperationException
        System.out.println(list);
        System.out.println(Arrays.toString(array));

        list  = Arrays.asList(new String[] { "123", "12345678", "1", "12", "1234567890" });
        Collection<String> resultList = null; // getLongWords(list);
        System.out.println("done");
    }
}



class Conversion_Array_List {
	/**
	 * Converting Arrays to Lists to Arrays
	 * 
	 * There are a couple of methods that allow you to convert arrays to Lists,
	 * and Lists to arrays. The List and Set classes have toArray() methods, and
	 * the Arrays class has a method called asList().
	 * 
	 * 
	 * The Arrays.asList() method copies an array into a List. The API says,
	 * "Returns a fixed-size list backed by the specified array. (Changes to the
	 * returned list 'write through' to the array.)"
	 * 
	 * When you use the asList() method, the array and the List become joined at
	 * the hip. When you update one of them, the other gets updated
	 * automatically. Let's take a look:
	 */
	public static void main(String[] args) {
		String[] sa = { "one", "two", "three", "four" };
		List sList = Arrays.asList(sa); // make a List
		// this convesrion is BACKED
		System.out.println("size  " + sList.size());
		System.out.println("idx2  " + sList.get(2));
		sList.set(3, "six"); // change List
		sa[1] = "five"; // change array
		for (String s : sa)
			System.out.print(s + " ");
		System.out.println("\nsl[1] " + sList.get(1));

		/*
		 * Now let's take a look at the toArray() method. There's nothing too
		 * fancy going on with the toArray() method; it comes in two flavors:
		 * one that returns a new Object array, and one that uses the array you
		 * send it as the destination array:
		 */

		List<Integer> iL = new ArrayList<Integer>();
		for (int x = 0; x < 3; x++)
			iL.add(x);
		// NOT BACKED, completely NEW array generated
		Object[] oa = iL.toArray(); // create an Object array
		Integer[] ia2 = new Integer[3];
		ia2 = iL.toArray(ia2); // create an Integer array
	}
}