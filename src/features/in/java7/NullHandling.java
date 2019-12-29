package features.in.java7;

import java.util.Objects;

public class NullHandling {

	private Foo foo;

	/**
	 * This is one of my favorites. java.util.Objects class has 9 useful static
	 * methods. Javadoc for this class:
	 * 
	 * {@link http://download.java.net/jdk7/docs/api/java/util/Objects.html}
	 * 
	 * 
	 * nonNull - Similar to google preconditions
	 * 
	 * toString methods-Handles null automatically hash and hashCode methods - Does
	 * hashCode for single or multiple objects. Returns 0 if object is null.
	 * 
	 * equals and deepEquals - Handles null automatically. Deep equals handles
	 * arrays also.
	 * 
	 * This post talks about them in more detail -
	 * https://baptiste-wicht.com/posts/2010/04/java-7-the-new-java-util-objects-class.html
	 */
	public static void main(String[] args) {
		NullHandling nullHandling = new NullHandling(null);
		System.out.println(nullHandling);
	}

	public NullHandling(Foo foo) {
		this.foo = Objects.nonNull(foo) ? foo : new Foo();
	}

	@Override
	public String toString() {
		return "NullHandling (obj = " + Objects.toString(foo) + ")";
	}
}

class Foo {
	@Override
	public String toString() {
		return "foo";
	}
}
