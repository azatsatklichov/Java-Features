package features.in.java7;

import java.util.ArrayList;
import java.util.List;
import java7.dolphin.libraries.Collections;

public class ExtensionMethods {
	public static void main(String[] args) {
		// I wish List had a sort() method... 
		List list = new ArrayList(); 
		 ... 
		Collections.sort(list);                     // works for now 
		list.sort();                                // ERROR but cleaner 

		// Maybe we can add it later! 
		import static java.util.Collections.sort; 

		List list = new ArrayList(); 
		 ... 
		list.sort();                // now this works! 
		// equivalent to Collections.sort(list); 


	}

}
