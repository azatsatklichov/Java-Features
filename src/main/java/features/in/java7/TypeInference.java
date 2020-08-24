package features.in.java7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TypeInference {

	public static void main(String[] args) {
		//Old Way: 
		List<Integer> list = new ArrayList<Integer>();
		//Google collections: 
		//List<Integer> list = Lists.newArrayList();
		
		//New Way: 
		List<String> list2 = new ArrayList<>(); //(Look at <>).

		//complex example:

		//Old Way:
		List<Map<String, List<Double>>> myList = new ArrayList<Map<String, List<Double>>>();
		
		//New Way:
		List<Map<String, List<Double>>> myList2 = new ArrayList<>();
	}
}
