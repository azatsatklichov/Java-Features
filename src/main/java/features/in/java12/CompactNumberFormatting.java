package features.in.java12;

import java.text.CompactNumberFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class CompactNumberFormatting {
	/**
	 * E.g. 3.6 M is very much easier to read than 3,600,000.
	 * 
	 * Java 12 introduces a convenient method called
	 * NumberFormat.getCompactNumberInstance(Locale, NumberFormat.Style) for
	 * creating a compact number representation.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Compact Formatting\n");
		NumberFormat upvotes = NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.SHORT);
		upvotes.setMaximumFractionDigits(1);

		
		System.out.println(upvotes.format(2592) + " upvotes");
		upvotes.setMaximumFractionDigits(2);

		System.out.println(upvotes.format(2592) + " upvotes\n");

		NumberFormat upvotes2 = NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.LONG);
		upvotes2.setMaximumFractionDigits(2);
		System.out.println(upvotes2.format(2011) + " upvotes");

		final String[] compactPatterns = { "", "", "", "0k", "00k", "000k", "0m", "00m", "000m", "0b", "00b", "000b",
				"0t", "00t", "000t" };

		final DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.GERMANY);

		// https://howtodoinjava.com/java12/compact-number-format/

		final CompactNumberFormat customCompactNumberFormat = new CompactNumberFormat(decimalFormat.toPattern(),
				decimalFormat.getDecimalFormatSymbols(), compactPatterns);
		
		
		
	}
}


class CompactNumberFormatExample {
	  public static void main(String[] args) {
	      formatForLocale(Locale.US);
	      formatForLocale(Locale.GERMANY);
	  }

	  private static void formatForLocale(Locale locale) {
	      List<Integer> numbers = List.of(1000, 1000000, 1000000000);
	      System.out.printf("-- SHORT format for locale=%s --%n", locale);
	      numbers.stream().forEach((num) -> {
	          NumberFormat nf = NumberFormat.getCompactNumberInstance(locale, NumberFormat.Style.SHORT);
	          String format = nf.format(num);
	          System.out.println(format);
	      });
	      System.out.printf("-- LONG format for locale=%s --%n", locale);
	      numbers.stream().forEach((num) -> {
	          NumberFormat nf = NumberFormat.getCompactNumberInstance(locale, NumberFormat.Style.LONG);
	          String format = nf.format(num);
	          System.out.println(format);
	      });
	  }
	}
