package best.practices.lambdas.and.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class Sorting {

    public static void main(String... args) {
        // 1
        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(
                Arrays.asList(new Apple(80, Color.GREEN), new Apple(155, Color.GREEN), new Apple(120, Color.RED)));

        inventory.sort(new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2) {
                Integer i1 = a1.getWeight();
                return i1.compareTo(a2.getWeight());//autoboxing
            }
        });

        // [Apple{color=GREEN, weight=80}, Apple{color=RED, weight=120},
        // Apple{color=GREEN, weight=155}]
        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        // reshuffling things a little
        inventory.set(1, new Apple(30, Color.GREEN));

        // 2
        // [Apple{color=GREEN, weight=30}, Apple{color=GREEN, weight=80},
        // Apple{color=GREEN, weight=155}]
        inventory.sort(new Comparator<Apple>() {

            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight() - a2.getWeight();
            }
        });
        System.out.println(inventory);

        // reshuffling things a little
        inventory.set(1, new Apple(20, Color.RED));

        // 3
        // [Apple{color=RED, weight=20}, Apple{color=GREEN, weight=30},
        // Apple{color=GREEN, weight=155}]
        inventory.sort((a1, a2) -> a1.getWeight() - a2.getWeight());
        System.out.println(inventory);

        // reshuffling things a little
        inventory.set(1, new Apple(10, Color.RED));

        // 4
        // [Apple{color=RED, weight=10}, Apple{color=RED, weight=20}, Apple{color=GREEN,
        // weight=155}]
        inventory.sort(comparing(Apple::getWeight));
        System.out.println(inventory);
    }

    static class AppleComparator implements Comparator<Apple> {

        @Override
        public int compare(Apple a1, Apple a2) {
            return a1.getWeight() - a2.getWeight();
        }

    }

}

enum Color {
    RED, GREEN
}

class Apple {

    private int weight = 0;
    private Color color;

    public Apple(int weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @SuppressWarnings("boxing")
    @Override
    public String toString() {
        return String.format("Apple{color=%s, weight=%d}", color, weight);
    }

}
