package tasks.programmaing.paradigms;

import java.io.Serializable;
import java.util.List;

public class Test_WildcardReadOnlyKeywordForBothInterfaceAndClass {
    public void addAnimal(List<? extends Animal> animals) {
        // ONLY to READ
        // not add
        // animals.add(new Dog()); // NO! Can't add if we
        // use <? extends Animal>
    }

    void foo2(List<? extends Serializable> list) { // odd, but correct
        // to use "extends"
    }
}
