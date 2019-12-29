package features.in.java7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Diamond {
	// Improved Type Inference for Generic Instance Creation (diamond)
	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<String, Integer>(); 

		Map<String, Integer> map = new HashMap<>(); 
		
		//This is a particular annoyance which is best served with an example:

		Map<String, List<String>> anagrams = new HashMap<String, List<String>>();

		//becomes:
			Map<String, List<String>> anagrams7 = new HashMap<>();
			
		


	}
}
