package features.in.java6;
import java.util.*;

public class TreeMapExample{
	public static void main(String[] args) {
		System.out.println("Tree Map Example!\n");
		TreeMap <Integer, String>tMap = new TreeMap<Integer, String>();
		//Addding data to a tree map
		tMap.put(1, "Sunday");
		tMap.put(2, "Monday");
		tMap.put(3, "Tuesday");
		tMap.put(4, "Wednesday");
		tMap.put(5, "Thursday");
		tMap.put(6, "Friday");
		tMap.put(7, "Saturday");
		//Rerieving all keys
		System.out.println("Keys of tree map: " + tMap.keySet());
		//Rerieving all values
		System.out.println("Values of tree map: " + tMap.values());
		//Rerieving the value from key with key number 5
		System.out.println("Key: 5 value: " + tMap.get(5)+ "\n");
		//Rerieving the First key and its value
		System.out.println("First key: " + tMap.firstKey() + " Value: " + tMap.get(tMap.firstKey()) + "\n");
		//Rerieving the Last key and value
		System.out.println("Last key: " + tMap.lastKey() + " Value: " + tMap.get(tMap.lastKey()) + "\n");
		//Removing the first key and value
		System.out.println("Removing first data: " + tMap.remove(tMap.firstKey()));
		System.out.println("Now the tree map Keys: " + tMap.keySet());
		System.out.println("Now the tree map contain: " + tMap.values() + "\n");
		//Removing the last key and value
		System.out.println("Removing last data: " + tMap.remove(tMap.lastKey()));
		System.out.println("Now the tree map Keys: " + tMap.keySet());
		System.out.println("Now the tree map contain: " + tMap.values());
	}
}