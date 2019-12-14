package tasks.programmaing.paradigms;



//so boxing and unboxing will not supported 
class Convert {
	public static void main(String[] args) {
		Long xL = new Long(456L);
		long x1 = Long.valueOf("123"); //NOT
		Long x2 = Long.valueOf("123");
		long x3 = xL.longValue();
		Long x4 = xL.longValue(); //NOT
		Long x5 = Long.parseLong("456"); //NOT
		long x6 = Long.parseLong("123");
	}
}
