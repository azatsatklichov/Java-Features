package intro.javase.essentials;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * Lesson: Annotations
 * 
 * <pre>
 *  
 * Annotations, a form of metadata, provide data about a program that is not
 * part of the program itself. Annotations have no direct effect on the
 * operation of the code they annotate.
 * 
 * Annotations have a number of uses, among them: •Information for the compiler
 * — Annotations can be used by the compiler to detect errors or suppress
 * warnings. •Compile-time and deployment-time processing — Software tools can
 * process annotation information to generate code, XML files, and so forth.
 * •Runtime processing — Some annotations are available to be examined at
 * runtime.
 * 
 * This lesson explains where annotations can be used, how to apply annotations,
 * what predefined annotation types are available in the Java Platform, Standard
 * Edition (Java SE API), how type annnotations can be used in conjunction with
 * pluggable type systems to write code with stronger type checking, and how to
 * implement repeating annotations.
 * 
 * 
 * 
 * </pre>
 * 
 */
public class c_Annotations {

    public static void main(String[] args) {
        System.out.println(
                "Annotations, a form of metadata, provide data about a program that is not part of the program itself.");

        System.out.println("Annotations have a number of uses, among them:");
        System.out.println(
                "• Information for the compiler — Annotations can be used by the compiler to detect errors or suppress warnings.");
        System.out.println(
                "• Compile-time and deployment-time processing — Software tools can process annotation information to generate code, XML files, and so forth.");
        System.out.println("• Runtime processing — Some annotations are available to be examined at runtime.");

        /**
         * Desc:
         * 
         * <pre>
         As of the Java SE 8 release, annotations can also be applied to the use of types. 
         Here are some examples:
        
        • Class instance creation expression:     new @Interned MyObject();
        
        
        • Type cast:     myString = (@NonNull String) str;
        
        
        • implements clause:     class UnmodifiableList<T> implements
          &#64;Readonly List<@Readonly T> { ... }
        
        
        • Thrown exception declaration:     void monitorTemperature() throws
          &#64;Critical TemperatureException { ... }
         * 
         * 
         * 
         * </pre>
         * 
         */
        System.out.println("Predefined Annotation Types");
        System.out.println("@Deprecated, @Override, @SuppressWarnings, @SafeVarargs, @FunctionalInterface ");
        System.out.println(
                "@Retention, @Documented, @Target , @Inherited, @Repeatable, @Critical, @NonNull, ..@interface,  @Documented, @Schedule, @Alert  --> @Repeatable ");

    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    /**
     * If there is just one element named value, then the name can be omitted,
     * as in:
     */
    @SuppressWarnings(value = "unchecked")
    void myMethod() {
        // ...
    }

    @SafeVarargs // Not actually safe!
    static void m(List<String>... stringLists) {
        Object[] array = stringLists;
        List<Integer> tmpList = Arrays.asList(42);
        array[0] = tmpList; // Semantically invalid, but compiles without
                            // warnings
        String s = stringLists[0].get(0); // Oh no, ClassCastException at
                                          // runtime!
    }

    @FunctionalInterface
    interface FunIn {
        void doIt();
    }

}
