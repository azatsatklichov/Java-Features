package intro.javase.tutorials;

interface MyData {

    void method1(String str);

    default void log(String str) {
        System.out.println("I1 logging::" + str);
    }

    default void print(String str) {
        if (!isNull(str))
            System.out.println("MyData Print::" + str);
    }

    /**
     * Java Interface Static Method
     * 
     * Java interface static method is similar to default method except that we
     * can’t override them in the implementation classes. This feature helps us
     * in avoiding undesired results incase of poor implementation in
     * implementation classes. Let’s look into this with a simple example.
     * 
     * @param str
     * @return
     */
    static boolean isNull(String str) {
        System.out.println("Interface Null Check");

        return str == null ? true : "".equals(str) ? true : false;
    }

    public int add(int a, int b);

    default int addd(int a, int b) {
        return a + b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }
}

class MyDataImpl implements MyData {

    // just shadowing, nothing related with overrides
    public boolean isNull(String str) {
        System.out.println("Impl Null Check");

        return str == null ? true : false;
    }

    public static void main(String args[]) {

        System.out.println(
                "\n Java interface static method is similar to default method except that we can’t override them in the implementation classes. \n");
        MyDataImpl obj = new MyDataImpl();
        obj.print("IFace");
        obj.isNull("abc");

        // direct IFace static method call
        int result = MyData.multiply(2, 3);
        System.out.println(result);
        int x = obj.addd(4, 7);
        System.out.println(x);

        obj.log("sdsds");

    }

    @Override
    public void method1(String str) {
        // TODO Auto-generated method stub

    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }

}
