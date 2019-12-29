package cx55.and.cx65.ch7.collections.generics;

import java.util.ArrayList;
import java.util.List;

public class Test_WildcardSuperAddsForBothInterfaceAndClass {
    public static void addAnimal(List<? super Dog> animals) {
        animals.add(new Dog());
        animals.add(new Dog()); // adding is sometimes OK with super
    }

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Dog());
        animals.add(new Dog());

        System.out.println(animals);
        
        //AnimalDoctorGeneric doc = new AnimalDoctorGeneric();
        //doc.addAnimal(animals); // passing an Animal List
        addAnimal(animals);
        
        System.out.println(animals);
        System.out.println("done");
    }
}
