package tasks.programmaing.paradigms;

public class EnumOverridingMotiveToStrategy {

}

class BridgeZ {
	public enum Suits {
		CLUBS(20), DIAMONDS(20), NOTRUMP(40) {

			public int getValue(int bid) {
				return ((bid - 1) * 111) + 40;
			}
		},
		HEARTS(30), SPADES(30);

		Suits(int points) {
			this.points = points;
		}

		private int points;

		public int getValue(int bid) {
			return points * bid;
		}
	}

	/**
	 * Which are true? (Choose all that apply.)
	 * 
	 * A. The output could contain 30
	 * 
	 * B. The output could contain @bf73fa (or @7150bd4d, or other hash-value)
	 * 
	 * C. The output could contain DIAMONDS
	 * 
	 * D. Compilation fails due to an error on line 6
	 * 
	 * E. Compilation fails due to an error on line 7
	 * 
	 * F. Compilation fails due to an error on line 8
	 */
	public static void main(String[] args) {
		/*
		 * A and B are correct. The code compiles and runs without exception. The
		 * values() method returns an array reference, not the contents of the enum, so
		 * DIAMONDS is never printed.
		 */
		System.out.println(Suits.NOTRUMP.getValue(3));
		System.out.println(Suits.SPADES.getValue(3));
		System.out.println(Suits.DIAMONDS.getValue(3));
		System.out.println(Suits.CLUBS.getValue(3));
		System.out.println(Suits.SPADES + " " + Suits.SPADES.points);
		Suits[] values = Suits.values();
		System.out.println(values);// this method is included by
									// COMPILER
		for (Suits suits : values) {
			System.out.println(suits);
		}

		System.out.println();
		System.out.println("Bahbit bola ");
	}
}
