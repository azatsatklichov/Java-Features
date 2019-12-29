package net.sahet.demo.intw;

public class KhTest {

    public static void main(String[] args) {
        String s = "abc";
        met(s);
        System.out.println(s);

        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s3 == s4);
        System.out.println(s1 == s3);
    }

    public static void met(String s) {
        s = "defs";
    }

}
