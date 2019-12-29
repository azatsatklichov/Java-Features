package net.sahet.demo.intw;

import java.util.Arrays;

public class TryEpam {

    public static void main(String[] args) {
        int min1 = Arrays.stream(new int[] { 1, 2, 3, 4, 5 }).min().orElse(0);
        System.out.println(1 == min1);

        int min2 = Arrays.stream(new int[] {}).min().orElse(0);
        System.out.println(0 == min2);

        int sum = Arrays.stream(new int[] { 1, 2, 3 }).filter(i -> i >= 2).map(i -> i * 3).sum();
        System.out.println(sum);

        System.out.println("Stream without terminal operation");

        Arrays.stream(new int[] { 1, 2, 3 }).map(i -> {
            System.out.println("doubling " + i);
            return i * 2;
        });

        System.out.println("Stream with terminal operation");
        Arrays.stream(new int[] { 1, 2, 3 }).map(i -> {
            System.out.println("doubling " + i);
            return i * 2;
        }).sum();

        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("Hello World!");
            }
        });

        Thread thread2 = new Thread(() -> System.out.println(" ooo Epam sys"));

    }
}

interface Vehicle {
    public void move();

    default void hoot() {
        System.out.println("peep!");
    }
}

@FunctionalInterface
interface Function2<T, U, V> {
    public V apply(T t, U u);

    default void count() {
        // increment counter
    }
}
