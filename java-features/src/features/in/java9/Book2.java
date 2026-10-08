package features.in.java9;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Book2 implements PricedObject {

	String title;
	double price;
	List<String> authors;

	public Book2(String title, double price) {
		this.title = title;
		this.price = price;
	}

	public Book2(String string, Set<Object> of, double d) {
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public double getPrice() {
		return price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	

	public static Stream<Book2> getBooks() {
		//just test purpose
		List authors  = List.of("Berdi Kerbabayew", "Atajan Tagan", "Elwan",  "Viktor Hugo", 
				"Berdinazar Hudaynazarow", "Kerim Gurbannepesow", "Gurbannazar Ezizow");
		Book2 b1 = new Book2("Book1", 11.99);
		Book2 b2 = new Book2("Book2", 12.99);
		Book2 b3 = new Book2("Book3", 13.99);
		Book2 b4 = new Book2("Book4", 14.99);
		
		//return List.of(b1, b2, b3, b4).stream();
		return authors.stream();
	}
	
	@Override
	public String toString() { 
		return  "Book[ "+getTitle()+", "+getAuthors()+"]";
	}

}
