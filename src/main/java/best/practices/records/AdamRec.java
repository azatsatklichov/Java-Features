package best.practices.records;

import java.util.Objects;

//public record AdamRec (String name, String address) { }

public record AdamRec(String name, String address) {}

//constructor with different arguments by supplying a different argument list:
/**
 * We can also add constructors, and modify the canonical constructor (the one that takes the two String parameters). 
 *
 */
record AdamRec1(String name, String address) {
	public AdamRec1(String name) {
		// this.name = name;
		this(name, "Unknown");
		// Objects.requireNonNull(name);
	}
}

record AdamRec11(String name, String address) {
	public AdamRec11() {
		this(null, null);
	}
}

record AdamRec2(String name, String address) {
	public AdamRec2 {
		Objects.requireNonNull(name);
		Objects.requireNonNull(address);

	}
}

/**
 * creating a constructor with the same arguments as the generated public
 * constructor is valid, but this requires that each field be manually
 * initialized:
 *
 */
record AdamRec3(String name, String address) {
	public AdamRec3(String name, String address) {
		this.name = name;
		this.address = address;
	}
}

/**
 * no-argument constructor and one with an argument list matching the generated
 * constructor results in a compilation error.
 *
 */
record AdamRec4(String name, String address) {
	public AdamRec4 {
		Objects.requireNonNull(name);
		Objects.requireNonNull(address);
	}

//  public AdamRec4(String name, String address) {
//      this.name = name;
//      this.address = address;
//  }
}

record AdamRec5(String name, String address) {
	public static String UNKNOWN_ADDRESS = "Unknown";

	public static AdamRec5 unnamed(String address) {
		return new AdamRec5("Unnamed", address);
	}
}

/*
 * Using records – with their compiler-generated methods – we can reduce
 * boilerplate code and improve the reliability of our immutable classes.
 */
enum ok  implements Runnable {
	OK;
	
	//User declared non-static fields POSSIBLE in ENUM
	int aha;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		for (ok o : ok.values()) {
			System.out.println(o);
			ok valueOf = o.valueOf("OK");
			System.out.println(valueOf);
		}
	}
}

record ForSpecSemantic(String name) implements Runnable {
	
	//User declared non-static fields aha are not permitted in a record
	//int aha;

	@Override
	public void run() {
		System.out.println("Running in Record");		
	}
	
	 @Override
	  public String toString() {
	      return "ForSpecSemantic {" +
	              "name=" + name + 
	              '}';
	  }
}
