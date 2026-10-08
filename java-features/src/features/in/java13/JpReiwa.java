package features.in.java13;

import java.time.chrono.JapaneseEra;

/**
 * Unicode 12.1 Support (from Unicode 11 to 12.1) 4 new scripts (South-East
 * Asian lang.), 555 new chars, , 61 new emojis, CLDR 35.1 Japanese new era,
 * Reiwa
 *
 * 
 * An instance representing the new Reiwa era has been added to this update.
 * Unlike other eras, there is no public field for this era. It can be obtained
 * by calling JapaneseEra.of(3) or JapaneseEra.valueOf("Reiwa"). JDK 13 and
 * later will have a new public field to represent this era.
 */
public class JpReiwa {
	public static void main(String[] args) {
		JapaneseEra v1 = JapaneseEra.of(3);
		System.out.println(v1);
		JapaneseEra v2 = JapaneseEra.valueOf("Reiwa");
		System.out.println(v2);
		// to obtain the new era singleton (JapaneseEra.valueOf("NewEra")) will no longer work.
		JapaneseEra v3 = JapaneseEra.valueOf("NewEra");
		System.out.println(v3);
	}

}
