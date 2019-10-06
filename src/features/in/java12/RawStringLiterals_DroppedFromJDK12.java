package features.in.java12;

public class RawStringLiterals_DroppedFromJDK12 {
	public static void main(String args[]) {

	    // traditional string
	    final String s1 = "test";
	    // traditional multiline string
	    final String s2 = "line1\nline2";

	    //0 raw string literals
//	    final String rs1 =`test`;
//	    final String rs2 =`
//	    		line1
//	    			line2
//	    				line3`;
//	    final String rs3 = ``backtick`inside``;
//	    final String rs4 = `\n`;
//
//	    System.out.println(rs1);
//	    
//	    System.out.println(rs2);
//	    System.out.println(rs2.align());
//	    System.out.println(rs3);

	    // String::unescape() is not implemented yet on jdk12+21
//	    System.out.println(rs4.length());
//	     System.out.println(rs4.unescape().length());

	  }

}
