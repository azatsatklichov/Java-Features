package tasks.programmaing.paradigms;

public class Test2_ArraysIssuesTypeCollection {
	public static void main(String[] args) {

	}

	public void foo() {
		Dog[] dogs = { new Dog(), new Dog() };
		addAnimal(dogs); // no problem, send the Dog[] to the method
	}

	public void addAnimal(Animal[] animals) {
		animals[0] = new Dog(); // ok, any Animal subtype works
	}

	public void foo2() {
		Cat[] cats = { new Cat(), new Cat() };
		addAnimal(cats); // no problem, send the Cat[] to the method //\ArayStoreException
	}

	public void addAnimal2(Animal[] animals) {
		animals[0] = new Dog(); // Eeek! We just put a Dog
								// in a Cat array!
	}
}
