package tasks.algorithmic.solutions;

//indracompany.com da interviewda bolanymda testde bardy, Hudson, Wrapper equality, Buffer  123null
public class Test_Indra {
	public static void main(String[] args) throws InterruptedException, IllegalMonitorStateException {
		Integer i1 = 1000;
		Integer i2 = 1000;
		if (i1 != i2)
			System.out.println("DIFFERENT objects");
		
		if (i1.equals(i2))
			System.out.println("meaningfully equal\n");

		
		Thread.currentThread().sleep(1000);
		

		System.out.println(" --- VIMP, no pool used ---");
		Integer indra1 = new Integer(23);
		Integer indra2 = new Integer(23);
		if (indra1 == indra2)
			System.out.println("indras are SAME objects");
		else
			System.out.println("indras are DIFFERENT objects");
		

		if (indra1.equals(indra2))
			System.out.println("meaningfully equal \n");
		

		System.out.println(" --- VIMP, pool is used that is why EQUAL ---");
		Integer indra3 = 23;// // optimized until 128, works like String pools
		Integer indra4 = 23; // -23 as well
		if (indra3 == indra4)
			System.out.println("indras are SAME objects");
		else
			System.out.println("indras are DIFFERENT objects");
		
		if (indra3.equals(indra4))
			System.out.println("meaningfully equal \n");
		

		// Short and Integer from -128 to 127
		System.out
				.println(" --- VIMP, pool is used only until 128, that is  why not EQUAL ---");
		Integer indra5 = 128;// // optimized until 128, works like String pools
		Integer indra6 = 128;
		if (indra5 == indra6)
			System.out.println("indras are SAME objects");
		else
			System.out.println("indras are DIFFERENT objects");
	
		if (indra5.equals(indra6))
			System.out.println("meaningfully equal \n");
		
		System.out.println(); 

		System.out.println(" --- VIMP,  pool is  used [-127, 128) ---");
		Integer i3 = 10;
		Integer i4 = 10;
		if (i3 == i4)
			System.out.println("SAME object"); 
		if (i3.equals(i4))
			System.out.println("meaningfully equal");

		System.out.println(" ---  no pool used ---");
		i3 = new Integer(10);
		i4 = new Integer(10); 
		if (i3 == i4)
			System.out.println("SAME object"); 
		else 
			System.out.println("not SAME object"); 
		if (i3.equals(i4))
			System.out.println("meaningfully equal");

 
		
		System.out
				.println("Yikes! The equals() method seems to be working, but what happened with == and != ? ");
		System.out
				.println("Why is != telling us that i1 and i2 are DIFFERENT objects, when == is saying that i3 and i4 are the SAME object?");
		System.out
				.println("In order to save memory, two instances of the  following wrapper objects will always be ==  when their primitive values are the SAME:");
		System.out.println("Boolean");
		System.out.println("Byte");
		System.out
				.println("Character from \\u0000 to \\u007f     (7f is 127 in decimal)");
		System.out.println("Short and Integer from -128 to 127");

		System.out.println("\n\n --- String created only in POOL");
		String s1 = "in pool";
		String s2 = "in pool";
		System.out.print("testing s1==s2   --> ");
		if (s1 == s2)
			System.out.println("TRUE");
		else
			System.out.println("FALE");
		


		System.out.print("s1.equals(s2)   --> ");
		if (s1.equals(s2))
			System.out.println("TRUE");
		else
			System.out.println("FALE");
		


		System.out.println("\n  --- String created both  in HEAP and pool");
		String s3 = new String("in pool");
		String s4 = new String("in pool");
		System.out.print("testing s3==s4  --> ");
		if (s3 == s4)
			System.out.println("TRUE");
		else
			System.out.println("FALsE");


		System.out.print("s3.equals(s4)   --> ");
		if (s3.equals(s4))
			System.out.println("TRuE");
		else
			System.out.println("FALsE");
		


		System.out.println("StringBuilder is mutable class");
		StringBuilder sb = new StringBuilder("abc");
		sb.append("def").reverse().insert(3, "---").append(new Integer(3));  
		
		System.out.println(sb); // output is "fed---cba"

		
		StringBuffer sb2 = new StringBuffer("abc");
		sb2.append("def");
		System.out.println("sb2 = " + sb2); // output is "sb = abcdef"
		

		// Indra company question
		System.out.println("Indra company question");
		StringBuilder sb3 = new StringBuilder(23); 
		String s;
		s = null;

		/**
		 * A key point to make is that null is not the same an an empty String.
		 * An empty String is still a String object with associated methods and
		 * fields associated with it, where a null pointer is not an object at
		 * all.
		 * 
		 * From the documentation for StringBuilder's append method:
		 * 
		 * The characters of the String argument are appended, in order,
		 * increasing the length of this sequence by the length of the argument.
		 * If str is null, then the four characters "null" are appended.
		 */

		System.out.println(sb3.append(s).append("Value: ").append(s)); //.append(null) compile error

		System.out.println("sb3 = " + sb3); //sb3 = nullValue: null
		System.out.println(sb.capacity());
		System.out.println(sb2.capacity());
		System.out.println(sb3.capacity());
		
		
	}

}
