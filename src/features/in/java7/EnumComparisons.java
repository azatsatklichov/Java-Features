package features.in.java7;

//Enum Comparisons 

enum Rank { 
  LIEUTENANT, CAPTAIN, MAJOR, COLONEL, GENERAL 
} 



public class EnumComparisons {
	public static void main(String[] args) {
		// Compare using either compareTo() or ordinals 
		if(rank1.compareTo(rank2) < 0) ... 
		if(rank1.ordinal() < rank2.ordinal()) ... 

		// With enum comparison support can instead do: 
		if(rank1 < rank2) ... 
	}
	
}
