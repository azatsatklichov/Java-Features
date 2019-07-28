package lambdasinaction.chap2;

import java.util.List;

public class AppleFromatterDemo {

    public static void main(String[] args) {

    }

    public static void prettyPrintApple(List<FilteringApples.Apple> inventory,
                                        AppleFormatter formatter) {
        for (FilteringApples.Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }
}


interface AppleFormatter {
    String accept(FilteringApples.Apple a);
}

class appleFancyFormatter implements AppleFormatter {

    @Override
    public String accept(FilteringApples.Apple a) {
        String character = a.getWeight() > 150 ? "heavy" : "light";
        return "A " + character + " " + a.getColor() + "  apple";
    }
}

class AppleSimpleFormatter implements AppleFormatter {

    @Override
    public String accept(FilteringApples.Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
    }
}
