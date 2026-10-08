package features.in.java15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

//https://docs.oracle.com/en/java/javase/15/language/records.html
/**
 * Features of Record Classes
 * 
 * A record class is implicitly final, so you cannot explicitly extend a record
 * class. However, beyond these restrictions, record classes behave like normal
 * classes:
 *
 * 
 */

//You can create a generic record class, for example:
//record Triangle<C extends Coordinate> (C top, C left, C right) {}

//You can declare a record class that implements one or more interfaces, for example:
//record Customer(...) implements Billable { }

//You can annotate a record class and its individual components, for example:
//record Rectangle(@GreaterThanZero double length, @GreaterThanZero double width) {}

/**
 * A local record class is similar to a local class; it's a record class you can
 * define in the body of a method.
 *
 */
class LocalRecordExample {

	List<Merchant> findTopMerchants(List<Sale> sales, List<Merchant> merchants, int year, Month month) {

		// Local record class
		/**
		 * This local record class improves the readability of the stream operations
		 * that follow
		 * 
		 *
		 */
		record MerchantSales(Merchant merchant, double sales) {
		}

		return merchants.stream()
				.map(merchant -> new MerchantSales(merchant, this.computeSales(sales, merchant, year, month)))
				.sorted((m1, m2) -> Double.compare(m2.sales(), m1.sales())).map(MerchantSales::merchant)
				.collect(Collectors.toList());
	}

	double computeSales(List<Sale> sales, Merchant mt, int yr, Month mo) {
		return sales.stream().filter(
				s -> s.merchant().name().equals(mt.name()) && s.date().getYear() == yr && s.date().getMonth() == mo)
				.mapToDouble(s -> s.value()).sum();
	}

	public static void main(String[] args) {

		Merchant sneha = new Merchant("Sneha");
		Merchant raj = new Merchant("Raj");
		Merchant florence = new Merchant("Florence");
		Merchant leo = new Merchant("Leo");

		List<Merchant> merchantList = List.of(sneha, raj, florence, leo);

		List<Sale> salesList = List.of(new Sale(sneha, LocalDate.of(2020, Month.NOVEMBER, 13), 11034.20),
				new Sale(raj, LocalDate.of(2020, Month.NOVEMBER, 20), 8234.23),
				new Sale(florence, LocalDate.of(2020, Month.NOVEMBER, 19), 10003.67),
				// ...
				new Sale(leo, LocalDate.of(2020, Month.NOVEMBER, 4), 9645.34));

		LocalRecordExample app = new LocalRecordExample();

		List<Merchant> topMerchants = app.findTopMerchants(salesList, merchantList, 2020, Month.NOVEMBER);
		System.out.println("Top merchants: ");
		topMerchants.stream().forEach(m -> System.out.println(m.name()));
	}
}

record Merchant(String name) {
}

record Sale(Merchant merchant, LocalDate date, double value) {
}

//Record Serialization
/**
 * Record Serialization:
 * https://docs.oracle.com/en/java/javase/15/serializable-records/index.html
 * 
 * You can serialize and deserialize instances of record classes, but you can't
 * customize the process by providing writeObject, readObject, readObjectNoData,
 * writeExternal, or readExternal methods.
 */

class RecordSerializationExample {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// serialize
		try (var fos = new FileOutputStream("serial.data"); var oos = new ObjectOutputStream(fos)) {
			oos.writeObject(new RangeClass(100, 1));
			oos.writeObject(new RangeRecord(100, 1));
		}

		// deserialize
		try (var fis = new FileInputStream("serial.data"); var ois = new ObjectInputStream(fis)) {
			System.out.println(ois.readObject());
			System.out.println(ois.readObject());
		}
	}

}

class RangeClass implements Serializable {
	private static final long serialVersionUID = -3305276997530613807L;
	private final int lo;
	private final int hi;

	public RangeClass(int lo, int hi) {
		this.lo = lo;
		this.hi = hi;
	}

	public int lo() {
		return lo;
	}

	public int hi() {
		return hi;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof RangeClass that && this.lo == that.lo && this.hi == that.hi) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lo, hi);
	}

	@Override
	public String toString() {
		return String.format("%s[lo=%d, hi=%d]", getClass().getName(), lo, hi);
	}
}

//Notice the verbose boilerplate code for the equals, hashCode and toString!
/**
 * A record class is made serializable in the same way as a normal class, by
 * implementing Serializable. The equivalent record counterpart of RangeClass
 * looks like this:
 *
 *
 * Notice that there is no need to add any additional boilerplate to RangeRecord
 * in order to make it serializable. Specifically, there is no need to add a
 * serialVersionUID field
 * 
 */
record RangeRecord(int lo, int hi) implements Serializable {
}
