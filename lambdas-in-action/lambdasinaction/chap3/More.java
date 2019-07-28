package lambdasinaction.chap3;

import java.security.PrivilegedAction;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntBiFunction;

public class More {
    public static void main(String[] args) {

        Comparator<Appl> byWeight = new Comparator<Appl>() {
            public int compare(Appl a1, Appl a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        };

        Comparator<Appl> byWeight2 = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());

        Runnable r = () -> System.out.println("Ohho I am implemented by lambda");
        r.run();

        System.out.println(" following are t valid lambda expressions ?");
        /*() -> {
        };
        () -> "Raoul";

        () -> {
            return "Mario";

            (Integer i) -> {
            } return "Alan" + i;

            (String s) -> "Iron Man";
        };*/

            /*
            Because of the idea of target typing, the same lambda expression can be associated with
            different functional interfaces if they have a compatible abstract method signature. For example,
            both interfaces Callable and PrivilegedAction described earlier represent functions that accept
            nothing and return a generic type T. The following two assignments are therefore valid:

        In this case the first assignment has target type Callable<Integer> and the second assignment
        has target type PrivilegedAction<Integer>.*/
        Callable<Integer> c = () -> 42;
        PrivilegedAction<Integer> p = () -> 42;


        Comparator<Appl> c1 = (Appl a1, Appl a2) -> a1.getWeight().compareTo(a2.getWeight());
        ToIntBiFunction<Appl, Appl> c2 = (Appl a1, Appl a2) -> a1.getWeight().compareTo(a2.getWeight());
        BiFunction<Appl, Appl, Integer> c3 = (Appl a1, Appl a2) -> a1.getWeight().compareTo(a2.getWeight());


        /*Special void-compatibility rule
        If a lambda has a statement expression as its body, it’s compatible with a function descriptor
        that returns void (provided the parameter list is compatible too). For example, both of the
        following lines are legal even though the method add of a List returns a boolean and not void as
        expected in the Consumer context (T -> void):*/
// Predicate has a boolean return
   //     List<String> list = new Arrays.asList("green", "green", "red");
       // Predicate<String> p = s -> list.add(s);
// Consumer has a void return
       // Consumer<String> b = s -> list.add(s);
    }
}

class Appl {
    private int weight = 0;
    private String color = "";

    public Appl(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "Appl{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}

