package intro.javase.tutorials;

/**
 * The finalize( ) Method
 * 
 * <pre>
 * 
 * 
 * It is possible to define a method that will be called just before an object's
 * final destruction by the garbage collector. This method is called finalize(
 * ), and it can be used to ensure that an object terminates cleanly.
 * 
 * For example, you might use finalize( ) to make sure that an open file owned
 * by that object is closed.
 * 
 * To add a finalizer to a class, you simply define the finalize( ) method. The
 * Java runtime calls that method whenever it is about to recycle an object of
 * that class.
 * 
 * Inside the finalize( ) method, you will specify those actions that must be
 * performed before an object is destroyed.
 * 
 * The finalize( ) method has this general form − protected void finalize( ) {
 * // finalization code here }
 * 
 * 
 * Here, the keyword protected is a specifier that prevents access to finalize(
 * ) by code defined outside its class.
 * 
 * This means that you cannot know when or even if finalize( ) will be executed.
 * For example, if your program ends before garbage collection occurs, finalize(
 * ) will not execute.
 * 
 * 
 * </pre>
 * 
 */
public class Finalize {

    public static void main(String[] args) {
        System.out.println("Test finalize");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Some removal of resources - e.g. release cownections");
        System.out.println("But NOT good idea to implement this method, REASON is "
                + "NO GUARANTEE to be called of this method, because OBJECT may not be REALASED for "
                + "GARBAGE  COLLECTION");
        System.out.println("Instead USE try-catch-final BLOCK for code-GUARD");

        super.finalize();
    }

}
