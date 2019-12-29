package cx55.and.cx65.ch7.collections.generics;

import java.util.ArrayList;
import java.util.List;

abstract class Animal {
    public abstract void checkup();
}

class Dog extends Animal {
    public void checkup() { // implement Dog-specific code
        System.out.println("Dog checkup");
    }
}

class Cat extends Animal {
    public void checkup() { // implement Cat-specific code
        System.out.println("Cat checkup");
    }
}

class Bird extends Animal {
    public void checkup() { // implement Bird-specific code
        System.out.println("Bird checkup");
    }
}

class AnimalDoctor {
    // method takes an array of any animal subtype
    public void checkAnimals(Animal[] animals) {
        for (Animal a : animals) {
            a.checkup();
        }
    }

    public static void main(String[] args) {
        // test it
        Dog[] dogs = { new Dog(), new Dog() };
        Cat[] cats = { new Cat(), new Cat(), new Cat() };
        Bird[] birds = { new Bird() };
        AnimalDoctor doc = new AnimalDoctor();
        doc.checkAnimals(dogs); // pass the Dog[]
        doc.checkAnimals(cats); // pass the Cat[]
        doc.checkAnimals(birds); // pass the Bird[]
    }
}

class AnimalDoctorGeneric {
    // change the argument from Animal[] to ArrayList<Animal>
    public void checkAnimals(ArrayList<Animal> animals) {
        for (Animal a : animals) {
            a.checkup();
        }
    }

    public void addAnimal(List<? super Dog> animals) {

    }

    public static void main(String[] args) {
        // make ArrayLists instead of arrays for Dog, Cat, Bird
        List<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        List<Cat> cats = new ArrayList<Cat>();
        cats.add(new Cat());
        cats.add(new Cat());
        List<Bird> birds = new ArrayList<Bird>();
        birds.add(new Bird());
        // this code is the same as the Array version
        AnimalDoctorGeneric doc = new AnimalDoctorGeneric();
        // this worked when we used arrays instead of ArrayLists
        //doc.checkAnimals(dogs); // send a List<Dog>
        //doc.checkAnimals(cats); // send a List<Cat>
        //doc.checkAnimals(birds); // send a List<Bird>
    }
}
