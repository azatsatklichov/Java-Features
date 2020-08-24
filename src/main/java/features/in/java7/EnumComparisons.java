package features.in.java7;

//Enum Comparisons 

enum Rank {
	LIEUTENANT, CAPTAIN, MAJOR, COLONEL, GENERAL
}

public class EnumComparisons {
	public static void main(String[] args) {
		// Compare using either compareTo() or ordinals
		Rank rank1 = Rank.CAPTAIN;
		Rank rank2 = Rank.MAJOR;
		if (rank1.compareTo(rank2) < 0) {
			// ...
		}
		if (rank1.ordinal() < rank2.ordinal()) {
			// ...
		}

		// better than ENUM equals, NPE safe
		if (rank1 == rank2) {
			// ...
		}
	}

}
