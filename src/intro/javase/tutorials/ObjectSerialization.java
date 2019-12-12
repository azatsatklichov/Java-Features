package intro.javase.tutorials;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Desc:
 * 
 * <pre>
 *  
 * Java provides a mechanism, called object serialization where an object can be
 * represented as a sequence of bytes that includes the object's data as well as
 * information about the object's type and the types of data stored in the
 * object.
 * 
 * After a serialized object has been written into a file, it can be read from
 * the file and deserialized that is, the type information and bytes that
 * represent the object and its data can be used to recreate the object in
 * memory.
 * 
 * Most impressive is that the entire process is JVM independent, meaning an
 * object can be serialized on one platform and deserialized on an entirely
 * different platform.
 * 
 * Classes ObjectInputStream and ObjectOutputStream are high-level streams that
 * contain the methods for serializing and deserializing an object.
 * 
 * The ObjectOutputStream class contains many write methods for writing various
 * data types, but one method in particular stands out − public final void
 * writeObject(Object x) throws IOException
 * 
 * 
 * The above method serializes an Object and sends it to the output stream.
 * Similarly, the ObjectInputStream class contains the following method for
 * deserializing an object − public final Object readObject() throws
 * IOException, ClassNotFoundException
 * 
 * 
 * This method retrieves the next Object out of the stream and deserializes it.
 * The return value is Object, so you will need to cast it to its appropriate
 * data type.
 * 
 * To demonstrate how serialization works in Java, I am going to use the
 * Employee class that we discussed early on in the book. Suppose that we have
 * the following Employee class, which implements the Serializable interface −
 * 
 * 
 * </pre>
 * 
 * *
 */
public class ObjectSerialization {

}

class Employeez implements java.io.Serializable {
    public String name;
    public String address;
    public transient int SSN;
    public int number;

    public void mailCheck() {
        System.out.println("Mailing a check to " + name + " " + address);
    }
}

class SerializeDemo {

    public static void main(String[] args) {
        Employeez e = new Employeez();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.SSN = 11122333;
        e.number = 101;

        try {
            FileOutputStream fileOut = new FileOutputStream("employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in  employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}

class DeserializeDemo {

    public static void main(String[] args) {
        Employeez e = null;
        try (FileInputStream fileIn = new FileInputStream("employee.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);) {

            e = (Employeez) in.readObject();
            // in.close();
            // fileIn.close();
        } catch (IOException  | ClassNotFoundException c) { 
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + e.name);
        System.out.println("Address: " + e.address);
        System.out.println("SSN: " + e.SSN);
        System.out.println("Number: " + e.number);
    }
}
