package features.in.java7;

public class ChainedInvocation {
	public static void main(String[] args) {
		//Construction with setters 
		DrinkBuilder margarita = new DrinkBuilder(); 
		margarita.add(“tequila”); 
		margarita.add(“orange liqueur”); 
		margarita.add(“lime juice”); 
		margarita.withRocks(); 
		margarita.withSalt(); 
		Drink drink = margarita.drink(); 

		// Construction with chained invocation 
		Drink margarita = new DrinkBuilder() 
		   .add(“tequila”) 
		   .add(“orange liqueur”) 
		   .add(“lime juice”) 
		   .withRocks() 
		   .withSalt() 
		   .drink(); 
	}

}


