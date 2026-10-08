package features.in.java15;

//SEALED CLASSES 
//via interface
sealed interface Fruitzz permits Applezz,Orangezz, Uzum {
}

record Applezz() implements Fruitzz {
}

enum Uzum implements Fruitzz {
	GELINBARMAK, HUSEYNI;
}

record Orangezz() implements Fruitzz {
}

//via classes
sealed class Doctor permits Oculist,Cardiology {

}

/**
 * The class Oculist with a sealed direct superclass or a sealed direct
 * superinterface Doctor should be declared either final, sealed, or non-sealed
 *
 * 
 */
final class Oculist extends Doctor {

}

final class Cardiology extends Doctor {

}

//other way - defining SEALED classes
//via interface
sealed interface Fruit2 {

	record Apple2() implements Fruit2 {
	}

	record Orange2() implements Fruit2 {
	}
}

//by classes
sealed class Doctor2 {

	final class Oculist2 extends Doctor2 {

	}

	final class Cardiology2 extends Doctor2 {

	}

}

//https://docs.oracle.com/en/java/javase/15/language/sealed-classes-and-interfaces.html

sealed class Shape permits Circle,Square,Rectangle {
}

//final: Cannot be extended further
final class Circle extends Shape {
	public float radius;
}

//non-sealed: Can be extended by unknown subclasses; a sealed class cannot prevent its permitted subclasses from doing this
non-sealed class Square extends Shape {
	public double side;
}

//sealed: Can only be extended by its permitted subclasses
sealed class Rectangle extends Shape permits FilledRectangle {
	public double length, width;
}

final class FilledRectangle extends Rectangle {
	public int red, green, blue;
}

//extended by unknown subclasses
class NonFilledSquare extends Square {
	public int aleale;
}

//permit  omitted 
sealed class Figure2
// The permits clause has been omitted
// as its permitted classes have been
// defined in the same file.
{
}

final class Circle2 extends Figure2 {
	float radius;
}

non-sealed class Square2 extends Figure2 {
	float side;
}

sealed class Rectangle2 extends Figure2 {
	float length, width;
}

final class FilledRectangle2 extends Rectangle2 {
	int red, green, blue;
}