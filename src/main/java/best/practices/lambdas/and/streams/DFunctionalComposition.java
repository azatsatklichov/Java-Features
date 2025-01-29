package best.practices.lambdas.and.streams;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * You can compose individual lambdas into a single function yourself, but you do not need to do that,
 * Java comes with built-in support for functional composition that makes your job easy.
 */
public class DFunctionalComposition {

    public static void main(String[] args) {
        /**
         * You can compose individual lambdas into a single function yourself, here is an example of
         * math rule – if number is divisible by two and three, then it is divisible by six. Let’s do it:
         */
        Predicate<Integer> divisibleByTwo = (num) -> num % 2 == 0;
        Predicate<Integer> divisibleByThree = (num) -> num % 3 == 0;
        Predicate<Integer> divisbleBySix = (num) -> divisibleByTwo.test(num) && divisibleByThree.test(num);
        System.out.println(divisbleBySix.test(22));//false
        System.out.println(divisbleBySix.test(126));//true


        /**
         * However, you do not need to compose individual lambda expressions (functions) using logical operators;
         * Java brings built-in support for functional composition for you:
         */
        System.out.println("\nPredicate Composition - and()");
        Predicate<Integer> divisbleByTwoAndThree = divisibleByTwo.and(divisibleByThree);//divisible by six
        System.out.println(divisbleByTwoAndThree.test(22));//false
        System.out.println(divisbleByTwoAndThree.test(126));//true

        System.out.println("\nPredicate Composition - or()");
        Predicate<Integer> divisbleByTwoOrThree = divisibleByTwo.or(divisibleByThree);
        System.out.println(divisbleByTwoOrThree.test(22));//true
        System.out.println(divisbleByTwoOrThree.test(126));//true

        System.out.println("\nPredicate Composition - negate()");
        Predicate<Integer> numberNonDivisibleBySix = divisbleByTwoAndThree.negate();
        System.out.println(numberNonDivisibleBySix.test(22));//true


        // compose
        System.out.println("\nFunction Composition - compose()");
        /**
         * The Java Function compose() method composes a new Function instance from the
         * Function instance it is called on, and the Function instance passed as
         * parameter to the compose() method.

         */
        Function<Integer, Integer> duplicate = (value) -> 2 * value;
        Function<Integer, Integer> incrementBySeven = (value) -> value + 7;


        //compose() function will first call the incrementBySeven function and then invoke the duplicate function
        /**
         * compose()function is like f(g(x)), firstly process the input function y=g(x), and then use the result y as an
         * argument for the outer calling function f(y). In below sample, firstly incrementBySeven function is processed
         * [g(10) = 17], then the result is multiplied by two [f(17) = 2*17=34)] using duplicate function
         */
        Function<Integer, Integer> incrementBySevenThenDuplicate = duplicate.compose(incrementBySeven);
        Integer result = incrementBySevenThenDuplicate.apply(10); // (10+7)*2
        System.out.println(result); //34


        //andThen() function will first call the duplicate function and then invoke the incrementBySeven function
        /**
         * andThen()function is opposite of  compose()function, and refers to g(f(x)).  So, in below sample, firstly
         * duplicate function is processed [f(10) = 2*10=20)], then the result is incremented by seven [g(20) = 20+7=27],
         * using incrementBySeven function
         */
        System.out.println("\nandThen(), opposite of compose");
        Function<Integer, Integer> duplicateThenIncrementByseven = duplicate.andThen(incrementBySeven);
        result = duplicateThenIncrementByseven.apply(10); // (10*2)+7
        System.out.println(result); //27


        System.out.println("\nTransformation pipelines");
        /**
         * Using functional composition, you can now create various transformation pipelines, and apply it for your daily programming tasks
         */
        Country country = new Country("Czech Republic");
        Function<String, String> capital = Country::addCapital;
        Function<String, String> fifaChecker = capital.andThen(Country::addPhoneCode).andThen(Country::checkParticipation);
        System.out.println("Is Czech Republic qualified to FIFA's next tournament? " + fifaChecker.apply(country.name()));
    }

}


record Country(String name) {

    public static String addCapital(String country) {
        //todo just use some REST API to get the capital of given country
        return "Prague"; //just an example
    }

    public static String addPhoneCode(String country) {
        //todo just use some REST API to get the phone code of given country
        return "+420"; //just an example
    }

    public static String checkParticipation(String country) {
        //todo just use FIFA REST API to get the countries, and just check among that
        return "Yes";//just an example
    }
    //more handfull methods
}
