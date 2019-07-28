package features.in.java9;

/**
 * Diamond operator was introduced in java 7 to make code more readable but it
 * could not be used with Anonymous inner classes. In java 9, it can be used
 * with annonymous class as well to simplify code and improves readability.
 * 
 * Consider the following code prior to Java 9.
 */

public class InnerClassDiamondOperator {
    public static void main(String[] args) {
    	
        Handler<Integer> intHandler = new Handler<Integer>(1) {
            @Override
            public void handle() {
                System.out.println(content);
            }
        };
        intHandler.handle();
        
        Handler<? extends Number> intHandler1 = new Handler<Number>(2) {
            @Override
            public void handle() {
                System.out.println(content);
            }
        };
        intHandler1.handle();
        
        Handler<?> handler = new Handler<Object>("test") {
            @Override
            public void handle() {
                System.out.println(content);
            }
        };
        handler.handle();

        // JAVA 9
        Handler<Integer> intHandlerz = new Handler<>(1) {
            @Override
            public void handle() {
                System.out.println(content);
            }
        };
        intHandlerz.handle();
        Handler<? extends Number> intHandler1z = new Handler<>(2) {
            @Override
            public void handle() {
                System.out.println(content);
            }
        };
        intHandler1z.handle();
        Handler<?> handlerz = new Handler<>("test") {
            @Override
            public void handle() {
                System.out.println(content);
            }
        };

        handlerz.handle();
    }
}

abstract class Handler<T> {
    public T content;

    public Handler(T content) {
        this.content = content;
    }

    abstract void handle();
}