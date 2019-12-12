package features.in.java10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * * https://www.journaldev.com/19871/java-10-local-variable-type-inference
 * 
 * <pre>
 *
 * In this article we would take a deep dive at the new feature of
 * Local-Variable Type Inference introduced in Java 10. We will go through scope
 * and limitations of using the local variable type inference.
 * 
 * This feature was proposed as part of JEP (JDK Enhancement Proposal): 286. The
 * proposal was for enhancing the language to support the type inference to
 * local variable declaration and initialization.
 * 
 * </pre>
 */
public class A_LocalVarTypeInference {

    public static void main(String[] args) {
        var list = new ArrayList<String>(); // infers ArrayList<String>
        var stream = list.stream(); // infers Stream<String>

        // prior to Java 10:

        List<Actor> actors = List.of(new Actor()); // Pre Java 10
        var actors10 = List.of(new Actor()); // Java 10 onwards

        var map1 = new HashMap(); // Inferred as HashMap
        var map2 = new HashMap<>(); // Inferred as HashMap<Object, Object>

        var runnable = new Runnable() {
            @Override
            public void run() {
                var numbers = List.of(5, 4, 3, 2, 1);
                for (var number : numbers) {
                    System.out.println(number);
                }
            }
        };
        // runThread(runnable);

    }

    /**
     *
     * <pre>
     *How does Local Variable Type Inference work?
    Parsing a var statement, the compiler looks at the right hand side of the declaration, aka initializer, 
    and it infers the type from the right hand side (RHS) expression.
    
    Ok fine enough, does this mean that now Java is a dynamically typed language? Not really, it’s 
    still a statically typed language. Let’s take a code snippet for reading a file.
     * 
     * 
     * </pre>
     */
    private static void readFileJ10() throws IOException {
        var fileName = "Sample.txt";
        var line = "";
        var fileReader = new FileReader(fileName);
        var bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }

    // Now, let’s look at the decompiled code taken from IntelliJ IDEA decompiler.
    private static void readFile() throws IOException {
        String fileName = "Sample.txt";
        String line = "";
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }

}

class LegalLocalVarInferenceDemo {

    // in a static/instance initialization block
    static {
        var anotherName = "Sanaulla";
        System.out.println("Hello, " + anotherName);
    }

    public static void main(String[] args) {

        // as a local variable
        var name = "Mohamed Sanualla";
        System.out.println("Hello " + name);

        var data = new ArrayList<Map>();
        data.add(Map.of("key1", "value1", "key2", "value2"));
        data.add(Map.of("key11", "value11", "key22", "value22"));
        System.out.println(data);

        System.out.println("********** As iteration variable in enhanced for-loop ***************");
        for (var object : data) {
            System.out.println(String.format("%s of type %s", object, object.getClass().getName()));
        }

        System.out.println("********** As looping index in for-loop ***************");
        for (var i = 0; i < data.size(); i++) {
            var object = data.get(i);
            System.out.println(String.format("%s of type %s", object, object.getClass().getName()));
        }

        System.out.println("********** As a return value from another method ***************");
        var anInteger = someAnotherMethod();
        System.out.println("someAnotherMethod returned " + anInteger);

    }

    // As a return value in a method
    public static Integer someAnotherMethod() {
        System.out.println("someAnotherMethod called");
        var returnObj = 12;
        return returnObj;
    }

}


class IllegalLocalVarInferenceDemo{
    //Not permitted in class fields
    //var someProperty;
 
    //Not allowed as parameter for constructor
    // public LocalVarInferenceDemo(var param1){
 
    // }
 
    public static void main(String[] args){
 
        //Not allowed in catch parameter
        // try{
        //     //some operations
        // }catch(var ex){
 
        // }
    }
 
    //Not permitted below
    //public static void someMethod(var param1, var param2){
    //   System.out.println("Some method called");
    //}
 
    //Not permitted in method return type
    // public static var someAnotherMethod2(){
    //     System.out.println("someAnotherMethod called");
    //     var returnObj = 12;
    //     return returnObj;
    // }
}
