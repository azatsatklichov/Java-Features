package features.in.java9;

import java.util.List;
import java.util.Set;

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

	public static List<String> getAuthors() {
		return List.of(); // ;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

}
