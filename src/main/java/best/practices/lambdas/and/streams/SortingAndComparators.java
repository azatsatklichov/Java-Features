package best.practices.lambdas.and.streams;


import java.io.File;
import java.io.FileFilter;
import java.util.*;
import java.util.function.Consumer;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

class Sorting {

    public static void main(String... args) {
        // 1
        List<Vehicle> inventory = new ArrayList<>();
        inventory.addAll(
                Arrays.asList(new Vehicle(23323, Color.GRAY, 45678), new Vehicle(123278, Color.WHITE, 35674),
                        new Vehicle(897652, Color.RED, 67521), new Vehicle(983211, Color.GREEN, 87623)));

        inventory.sort(new Comparator<Vehicle>() {
            public int compare(Vehicle a1, Vehicle a2) {
                Integer i1 = a1.getPrice();
                return i1.compareTo(a2.getPrice());//autoboxing
            }
        });


        inventory.sort(new VehicleComparator());
        System.out.println(inventory);

        // reshuffling things a little
        inventory.set(1, new Vehicle(23367, Color.GREEN, 82341));

        inventory.sort(new Comparator<Vehicle>() {

            @Override
            public int compare(Vehicle a1, Vehicle a2) {
                return a1.getPrice() - a2.getPrice();
            }
        });
        System.out.println(inventory);

        // reshuffling things a little
        inventory.set(1, new Vehicle(20, Color.RED));

        // 3
        inventory.sort((a1, a2) -> a1.getPrice() - a2.getPrice());
        System.out.println(inventory);

        // reshuffling things a little
        inventory.set(1, new Vehicle(10, Color.RED));

        // 4
        inventory.sort(comparing(Vehicle::getPrice));
        System.out.println(inventory);


        /// comparator
        // more examples - pass Lambda function as Parameter
        FileFilter ff = (File f) -> f.getName().endsWith(".java");
        File dir = new File("C:\\workspace_ext\\Java-Features\\src\\features\\in\\java8");
        File[] fArr = dir.listFiles(ff);
        Arrays.asList(fArr).forEach(System.out::println);

        // Type of Lambda ? It is a type of Functional interface, which it implements
        // Assign Lambda to a Variable
        Consumer<String> c1 = s -> System.out.println(s);
        Consumer<String> c2 = System.out::println;

        Comparator<String> cmp1 = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());
        Comparator<String> cmp2 = (s1, s2) -> Integer.compare(s1.length(), s2.length());

        Comparator<Integer> cmp3 = (i1, i2) -> Integer.compare(i1, i2);
        Comparator<Integer> cmp4 = Integer::compare;

        List<String> l = List.of("A", "L", "C", "Z");
        l.forEach(s -> System.out.print(s));
        System.out.println();
        l.forEach(System.out::print);
        System.out.println();
        l.stream().sorted().forEach(System.out::print);
    }

    static class VehicleComparator implements Comparator<Vehicle> {

        @Override
        public int compare(Vehicle a1, Vehicle a2) {
            return a1.getPrice() - a2.getPrice();
        }

    }


    interface GreetingService {
        void hi(String message);
    }

    interface GreetingService2 {
        String msg(String message);
    }

    private static String buildString(String parameter) {
        String result = "Something " + parameter;
        // many lines of code
        return result;
    }

    // sort using java 7
    private void sortUsingJava7(List<String> names) {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    private void sortIt(List<String> list) {
        Collections.sort(list, (l1, l2) -> l1.compareTo(l2));
    }

    // sort using java 8
    private void sortUsingJava8(List<String> names) {
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }

}

enum Color {
    WHITE, GREEN, GRAY, RED
}


class PassLambdaFunctionAsParameter {

    final static String salutation = "Hello! ";

    public static void main(String args[]) {

        // more examples - pass Lambda function as Parameter
        FileFilter ff = (File f) -> f.getName().endsWith(".java");
        File dir = new File("C:\\workspace_ext\\Java-Features\\src\\features\\in\\java8");
        File[] fArr = dir.listFiles(ff);
        Arrays.asList(fArr).forEach(System.out::println);

        // Type of Lambda ? It is a type of Functional interface, which it implements
        // Assign Lambda to a Variable
        Consumer<String> c1 = s -> System.out.println(s);
        Consumer<String> c2 = System.out::println;

        Comparator<String> cmp1 = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());
        Comparator<String> cmp2 = (s1, s2) -> Integer.compare(s1.length(), s2.length());

        Comparator<Integer> cmp3 = (i1, i2) -> Integer.compare(i1, i2);
        Comparator<Integer> cmp4 = Integer::compare;

        List<String> l = List.of("A", "L", "C", "Z");
        l.forEach(s -> System.out.print(s));
        System.out.println();
        l.forEach(System.out::print);
        System.out.println();
        l.stream().sorted().forEach(System.out::print);

    }


}


class Vehicle {

    private int serialNumber = 0;
    private Color color;
    private int price = 0;

    public Vehicle(int serialNumber, Color color, Integer price) {
        this.serialNumber = serialNumber;
        this.color = color;
        this.price = price;
    }

    public Vehicle(int serialNumber, Color color) {
        this(serialNumber, color, 0);
    }

    public Vehicle(Color color) {
        this(45762332, color);
    }

    public Vehicle() {
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return STR."Vehicle [serialNumber = \{this.serialNumber},  color = \{this.color}, price = \{this.price}";
    }
}


// Sorting with function objects (Pages 193-4)
class SortingFourWays {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(args);

        // Anonymous class instance as a function object - obsolete! (Page 193)
        Collections.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        System.out.println(words);
        Collections.shuffle(words);

        // Lambda expression as function object (replaces anonymous class) (Page 194)
        Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println(words);
        Collections.shuffle(words);

        // Comparator construction method (with method reference) in place of lambda
        // (Page 194)
        Collections.sort(words, comparingInt(String::length));
        System.out.println(words);
        Collections.shuffle(words);

        // Default method List.sort in conjunction with comparator construction method
        // (Page 194)
        words.sort(comparingInt(String::length));
        System.out.println(words);
    }

}

class SortingAndComparators {

    public static void main(String[] args) {

        // immutable
        List<String> l = Arrays.asList("Alma", "Zemmer", "Mollatorgay", "Makul", "akgyz", "Calasyn");
        // mutable list
        List<Auto> list = new ArrayList<>(
                Arrays.asList(new Auto("Skoda Fabia", "8P0 8257", 5), new Auto("Skoda Fabia", "8P0 8257", 5),
                        new Auto("Citroen C1", "ABC 164521", 5), new Auto("Toyota RAV4", "9AD 6998", 5),
                        new Auto("Volvo V40", "XYZ 201845", 5), new Auto("Citroen C1", "ABC 164521", 4),
                        new Auto("Dodge", "KLM 845990", 2), new Auto("Dodge Ram", "KLM 845990", 3)));

        System.out.println(
                "\nNatural comparator - to use natural one, Object must implement Comparable #compareTo(T otherObj)");
        l.sort(Comparator.naturalOrder());// String - implements comparable comprateTo(string anotherStr) - by Alphabet
        // Consumer as a Parameter
        // l.stream().forEach(System.out::print);
        System.out.println(l);
        Collections.sort(list, Comparator.naturalOrder());// Auto - implements comparable comprateTo(Auto otherAuto) -
        // by Plate
        System.out.println(list);

        System.out.println("\nReverse comparator - still uses natural comparator here");
        l.sort(Comparator.reverseOrder());
        System.out.println(l);
        list.sort(Comparator.reverseOrder());
        System.out.println(list);

        System.out.println(
                "\nReverse Ordering - Returns a comparator that imposes the reverse of the naturalordering(sorting). ");
        String[] s = {"B", "C", "A"};
        System.out.println(Arrays.toString(s));
        Arrays.sort(s, Comparator.reverseOrder());
        System.out.println(Arrays.toString(s));

        Collections.sort(l, Comparator.reverseOrder());
        System.out.println(l);
        Collections.sort(list, Comparator.reverseOrder());
        System.out.println(list);

        System.out.println("\nComparator - classic custom implementation of Comparator#compare(o1, o2)");
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                boolean comp = o1.length() > o2.length();
                return comp ? 1 : o1.length() == o2.length() ? 0 : -1;
            }
        };
        // sort by length
        l.sort(cmp);
        System.out.println(l);
        // reverser order by length
        l.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                boolean comp = o1.length() > o2.length();
                return comp ? -1 : o1.length() == o2.length() ? 0 : 1;
            }
        });
        System.out.println(l);

        System.out.println("\nComparator - Java 8 lambda way - via Comparator interface#compare()");
        Comparator<String> cmp2 = Comparator.comparingInt(String::length);
        l.sort(cmp2);
        System.out.println(l);
        Comparator<Auto> comparatorByBrand = Comparator.comparing(Auto::getBrand);
        Collections.sort(list, comparatorByBrand);
        System.out.println(list);

        System.out.println("\nReverse comparator - uses comparator reversed() method here");
        l.sort(cmp.reversed());
        System.out.println(l);

        l.sort(cmp2.reversed());
        System.out.println(l);

        Collections.sort(list, comparatorByBrand.reversed());
        System.out.println(list);

        System.out.println(
                "\nChained Comparator - sort like SQL way[order by col1, col2 desc|asc]: length, then last index ");
        // chained Comparator (in CGI 2013 tried by old way)
        Comparator<String> compareByLengthAndLastIndex = Comparator.comparingInt(String::length)
                .thenComparing(String::lastIndexOf);
        l.sort(compareByLengthAndLastIndex);
        System.out.println(l);
        // reversed order
        l.sort(compareByLengthAndLastIndex.reversed());
        System.out.println(l);

        Comparator<Auto> comparatorByBrandAndDoors = Comparator.comparing(Auto::getBrand)
                .thenComparing(Auto::getNoOfDoors);
        Collections.sort(list, comparatorByBrandAndDoors);
        System.out.println(list);
        // reversed order
        Comparator<Auto> comparatorByBrandAndDoorsReversed = comparatorByBrandAndDoors.reversed();
        Collections.sort(list, comparatorByBrandAndDoorsReversed);
        System.out.println(list);

        System.out.println("\nComparator nulls First");
        Comparator<String> nullsFirstCmp = Comparator.nullsFirst(Comparator.naturalOrder());
        l = Arrays.asList("A", null, "Z", "C", null, null); // List.of not allow nulls
        Collections.sort(l, nullsFirstCmp);
        System.out.println(l);
        // reverse ordered
        nullsFirstCmp = Comparator.nullsFirst(Comparator.reverseOrder());
        Collections.sort(l, nullsFirstCmp);
        System.out.println(l);

        Comparator<Auto> nullsFirstAuto = Comparator.nullsFirst(Comparator.naturalOrder());
        // immutable list
        list = Arrays.asList(null, new Auto("Skoda Fabia", "8P0 8257", 5), new Auto("Skoda Fabia", "8P0 8257", 5),
                new Auto("Citroen C1", "ABC 164521", 5), new Auto("Toyota RAV4", "9AD 6998", 5),
                new Auto("Volvo V40", "XYZ 201845", 5), new Auto("Citroen C1", "ABC 164521", 4), null, null,
                new Auto("Dodge", "KLM 845990", 2), new Auto("Dodge Ram", "KLM 845990", 3));

        Collections.sort(list, nullsFirstAuto);
        System.out.println(list);

        System.out.println("\nComparator nulls Last");
        Comparator<String> nullsLastCmp = Comparator.nullsLast(Comparator.naturalOrder());
        Comparator<Auto> nullsLastAuto = Comparator.nullsLast(Comparator.naturalOrder());
        Collections.sort(l, nullsLastCmp);
        System.out.println(l);
        Collections.sort(list, nullsLastAuto);
        System.out.println(list);

        /*
         * Below code throws below exception
         *
         *
         * Exception in thread "main" java.lang.NullPointerException: Cannot read field
         * "numberPlate" because "o" is null
         *
         * TimSort complain & throw
         */
        // Collections.sort(l, Comparator.reverseOrder());
        // NullPointerException
        // System.out.println(l);
        // Collections.sort(list, Comparator.reverseOrder());
        // System.out.println(list);

        System.out.println(
                "\nComparator.reverseOrder() on above code will throw a NullPointerException because specified list contains null value");
        System.out.println("You can easily modify the compare() method to handle nulls, as below");
        /*
         * Exception in thread "main" java.lang.NullPointerException: Cannot read field
         * "value" because "anotherString" is null
         *
         *
         *
         * The above custom implementation will throw a NullPointerException if the
         * specified array contains any null value. We can easily modify the compare()
         * method to handle nulls.
         */
        CustomComparator<String> customStrNonNullComparator = new CustomComparator<>();
        nullsFirstCmp = Comparator.nullsFirst(customStrNonNullComparator);
        Collections.sort(l, nullsFirstCmp);
        System.out.println(l);
        Collections.sort(l, nullsFirstCmp.reversed());
        System.out.println(l);

        CustomComparator<Auto> customAutoNonNullComparator = new CustomComparator<>();
        nullsFirstAuto = Comparator.nullsFirst(customAutoNonNullComparator);
        Collections.sort(list, nullsFirstAuto);
        System.out.println(list);
        Collections.sort(list, nullsFirstAuto.reversed());
        System.out.println(list);

        System.out.println("\nUsing Guava Library");
    }

}

class CustomComparator<T extends Comparable<T>> implements Comparator<T> {

    /**
     * To return a comparator that considers null to be less than non-null values (
     * null to be less than non-null values)
     * <p>
     * Or for reverse order, just replace -1 with 1, and wise versa if you want To
     * return a comparator that considers null to be greater than non-null values:
     */
    @Override
    public int compare(T a, T b) {
        if (a == null && b == null) {
            return 0;
        }

        if (a == null) {
            return -1; // 1
        }

        if (b == null) {
            return 1;// -1
        }

        return b.compareTo(a);
    }
}



class Auto implements Comparable<Auto> {
    public String brand;
    public String numberPlate;
    public int noOfDoors;

    public Auto(String brand, String numberPlate, int noOfDoors) {
        this.brand = brand;
        this.numberPlate = numberPlate;
        this.noOfDoors = noOfDoors;
    }

    @Override
    public String toString() {
        return "Auto [brand=" + brand + ", numberPlate=" + numberPlate + ", noOfDoors=" + noOfDoors + "]";
    }

    public String getBrand() {
        return brand;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public int getNoOfDoors() {
        return noOfDoors;
    }

    @Override
    public int compareTo(Auto o) {
        return numberPlate.compareTo(o.numberPlate);
    }

}
