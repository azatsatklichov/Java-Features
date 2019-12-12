package intro.javase.tutorials;

public class e_InterfaceStaticMethods {

    public static void main(String args[]) {
        Vehiclez vehicle = new Carz();
        System.out.println("DEFAULT method is called like POLYMORPHICALLY");
        vehicle.print();
        Vehiclez.blowHorn();

        System.out.println();
        Bir bir = new BirImpl();
        bir.print();

    }
}

interface Vehiclez {

    default void print() {
        System.out.println("I am default-m in vehicle!");
    }

    static void blowHorn() {
        System.out.println("static Blowing horn!!!");
    }
}

interface FourWheelerz {

    default void print() {
        System.out.println("I am a default-m in  four wheeler!");
    }
}

class Carz implements Vehiclez, FourWheelerz {

    public void print() {
        Vehiclez.super.print();
        // Vehiclez.print();
        Vehiclez.blowHorn();
        System.out.println();

        FourWheelerz.super.print();
        Vehiclez.blowHorn();
        System.out.println("I am a car!");
    }
}

interface Bir {
    default void print() {
        System.out.println("I am a default-m in  Bir");
    }
}

class BirImpl implements Bir {

}