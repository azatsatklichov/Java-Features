package features.in.java8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.List;

/**
 * https://docs.oracle.com/javase/tutorial/java/annotations/repeating.html
 * https://www.infoq.com/articles/Type-Annotations-in-Java-8/
 * https://www.mscharhag.com/java/java-8-type-annotations
 * 
 * 
 * Java 8 has included two new features repeating and type annotations in its
 * prior annotations topic.
 * 
 * In early Java versions, you can apply annotations only to declarations.
 * 
 * After releasing of Java SE 8 , annotations can be applied to any type use. It
 * means that annotations can be used anywhere you use a type. For example, if
 * you want to avoid NullPointerException in your code.
 *
 */
public class TypeAnnotationsAndRepeatingAnnotations {

	@Encrypted
	String data;

	@NonNull
	String str;

	List<@NonNull String> strList;

}

@Target({ ElementType.TYPE_PARAMETER, ElementType.TYPE_USE })
@interface Encrypted {
}

@Target({ ElementType.TYPE_PARAMETER, ElementType.TYPE_USE })
@interface NonNull {
}

@interface Color {
	String name();
}

/*
 * @Color(name = "red")
 * 
 * @Color(name = "blue")
 */
@Color(name = "green")
class Shirt {
}

@Schedules({ @Schedule(dayOfMonth = "Tenth", dayOfWeek = "Wed"), @Schedule(dayOfMonth = "Seventh", dayOfWeek = "Fri") })
class ScheduledCamp {
//code goes in here
}

@Schedule(dayOfMonth = "Tenth", dayOfWeek = "Wed")
@Schedule(dayOfMonth = "Seventh", dayOfWeek = "Fri")
class ScheduledCamp2 {
//code goes in here
}






class  RepeatingAnnotations {

    public static void main(String[] args) {
        System.out
                .println("Repeating annotations. For example, you are writing code to use a timer service that enables "
                        + "\nyou to run a method at a given time or on a certain schedule, similar to the UNIX cron service.");

    }

    @Schedule()
    @Schedule(dayOfMonth = "last")
    @Schedule(dayOfWeek = "Fri", dayOfMonth = "23")
    public void doPeriodicCleanup() {
    }

    /*
    @Alert(role = "Manager")
    @Alert(role = "Administrator")
    public class UnauthorizedAccessException extends SecurityException {
    }*/

}
/*
@Repeatable(Schedules.class)
@interface Schedule {
    String dayOfMonth()

    default "first";

    String dayOfWeek()

    default "Mon";

    int hour() default 12;
}

@interface Schedules {
    Schedule[] value();
}

@Repeatable(@Alert.class)
@interface @Alert {
    String role() default "first"; 
}*/
