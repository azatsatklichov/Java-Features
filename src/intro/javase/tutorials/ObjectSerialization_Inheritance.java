package intro.javase.tutorials;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Desc:
 * 
 * <pre>
 * 
 * </pre>
 * 
 */
class ParentNotSerializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Dogy d = new Dogy();
        d.i = 888;
        d.j = 999;
        FileOutputStream fos = new FileOutputStream("inheritance.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        System.out.println("Serializing");
        oos.writeObject(d);
        FileInputStream fis = new FileInputStream("inheritance.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        System.out.println("Deserializing");
        Dogy d2 = (Dogy) ois.readObject();
        System.out.println(d2.i + "-----" + d2.j); // x?

    }
}

class Animall { /* implements Serializable */
    int i = 10;

    Animall() {
        System.out.println("Parent class cons");
    }
}

class Dogy extends Animall implements Serializable {

    int j = 20;

    // Thread t = new Thread();
    Dogy() {
        System.out.println("Child class constructor");
    }

}
