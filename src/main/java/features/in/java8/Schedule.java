package features.in.java8;

import java.lang.annotation.Repeatable;

/**
 * How to Define Repeating Annotations in Java 8 Defining a repeating annotation
 * involves two steps
 * 
 * 
 * - Annotate Repeating Annotation with @Repeatable: Mark the annotation which
 * can be repeated with @Repeatable annotation. This is a meta-annotation as it
 * annotates an annotation.
 * 
 * - Create a container annotation: Create an annotation which has an attribute
 * which is an array of the Repeating Annotation type.
 * 
 *
 */
@Repeatable(Schedules.class)
public @interface Schedule {
	String dayOfMonth() default "first";

	String dayOfWeek() default "Mon";

	int hour() default 12;
}