package features.in.java9;
 

import java.util.Optional;

public class OptionalIfPresentOrElse {

    public static void main(String... args) {
    	
    	Optional<Integer> i = Optional.empty();
    	i.map(n -> n + 1); 
    	System.out.println("? = "+i);
    	
        Optional<Book2> full = Optional.of(new Book2("Oka", 4.4)); //Book2.getBook()

        // Before ifPresentOrElse
        full.ifPresent(System.out::println);

        if (full.isPresent()) {
            System.out.println(full.get());
        } else {
            System.out.println("Nothing here");
        }

        full.ifPresentOrElse(System.out::println,
                () -> System.out.println("Nothing here!"));
        Optional.empty().ifPresentOrElse(System.out::println,
                () -> System.out.println("Nothing here!"));

    }

}
