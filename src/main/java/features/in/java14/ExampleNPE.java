package features.in.java14;
// Examples used in the slides for helpful NullPointerExceptions
public class ExampleNPE {

  public static void main(String... args) {
    a().b().c.doSomething();

    var a = new Object[][] { null };
    a[0][1] = new Object();
  }


  private static A a() {
    return new A();
  }

  static class A {
    public B b() {
      return new B();
    }
  }

  static class B {
    public C c;
  }

  static class C {
    public void doSomething() {}
  }
}
