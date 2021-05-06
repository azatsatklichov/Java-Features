package features.in.java14;
public class HelpfulNPEDemo {

  public static void main(String... args) {
    Object myObject = null;
    myObject.toString().hashCode();

  }

}
