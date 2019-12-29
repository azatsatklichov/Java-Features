package features.in.java7;

public class ImmutableCollections {
	public static void main(String[] args) {
		//Now: We use 
		//Collections.unmodifiableList, Collections.unmodifiableSet, Collections.unmodifiableMap etc.,

		//within Java 7, it is more elegant and straightforward.: (groovy like syntax)
		List myList = [ "foo", "bar", "value" ];
		Set mySet = { "foo", "bar", "value" };
		Map myMap = { "foo" : 1, "bar" : 2, "value" : 3 };
		
	}
}
