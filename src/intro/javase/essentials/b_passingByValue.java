package intro.javase.essentials;

class PassPrimitiveByValue {

    public static void main(String[] args) {

        System.out.println();
        System.out.println(
                "Primitive arguments, such as an int or a double, are passed into methods by value (COPY OF VALUE). "
                        + "\nThis means that any changes to the values of the parameters exist only within the scope of the method. "
                        + "\nWhen the method returns, the parameters are gone and any changes to them are lost.");

        int x = 3;

        // invoke passMethod() with
        // x as argument
        passMethod(x);

        // print x to see if its
        // value has changed
        System.out.println("After invoking passMethod, x = " + x);

    }

    // change parameter in passMethod()
    public static void passMethod(int p) {
        System.out.println(p);
        p = 10;
        System.out.println(p);
    }

}

/**
 * 
 * Passing Reference Data Type Arguments
 * 
 * 
 * <pre>
Reference data type parameters, such as objects, are also passed into methods by value. 
This means that when the method returns, the passed-in reference still references the same object as before. 
However, the values of the object's fields can be changed in the method, if they have the proper access level.

For example, consider a method in an arbitrary class that moves Circle objects:
 * 
 * 
 * </pre>
 */
class PassReferenceByValue {
    public static void main(String[] args) {
        System.out.println();
        System.out.println(
                "Reference data type parameters, such as objects, are also passed into methods by value(COPY of REFERENCE, NOT OBJECT).\n"
                        + "This means that when the method returns, the passed-in reference still references the same object "
                        + "\nas before. However, the values of the object's fields can be changed in the method, if they have the proper access level.");

    }

    void moveCircle(Circle circle, int deltaX, int deltaY) {
        // code to move origin of circle to x+deltaX, y+deltaY
        circle.setX(circle.getY() + deltaX);
        circle.setY(circle.getY() + deltaY);

        // code to assign a new reference to circle
        circle = new Circle(0, 0);
    }

}

class Circle {

    public Circle(int i, int j) {
        // TODO Auto-generated constructor stub
    }

    public void setY(int i) {
        // TODO Auto-generated method stub

    }

    public void setX(int i) {
        // TODO Auto-generated method stub

    }

    public int getY() {
        // TODO Auto-generated method stub
        return 0;
    }

}
