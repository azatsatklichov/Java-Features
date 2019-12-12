package intro.javase.essentials;

import java.time.LocalDate;

public class b_Method_References {

    public static void main(String[] args) {
        System.out.println(
                "You use lambda expressions to create anonymous methods. Sometimes, however, a lambda \n"
                + "expression does nothing but call an existing method. In those cases, it's often clearer to refer to the existing method by name.");
    }

}

class Person2 {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public void getAge() {
        // ...
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public static int compareByAge(Person2 a, Person2 b) {
        return a.birthday.compareTo(b.birthday);
    }
}