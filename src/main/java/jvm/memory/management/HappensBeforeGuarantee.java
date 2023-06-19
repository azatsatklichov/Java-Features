package jvm.memory.management;

/**
 * https://www.geeksforgeeks.org/happens-before-relationship-in-java/
 * 
 * <pre>
 * Instruction Reordering

During compilation or during processing, the compiler or the CPU might reorder the instructions to run them in parallel to increase throughput and performance. For example, we have 3 instructions:

FullName = FirstName + LastName        // Statement 1
UniqueId = FullName + TokenNo         // Statement 2
 
Age = CurrentYear - BirthYear        // Statement 3
The compiler cannot run 1 and 2 in parallel because 2 needs the output of 1, but 1 and 3 can run in parallel because they are independent of each other. So the compiler or the CPU can reorder these instructions in this way:

FullName = FirstName + LastName      // Statement 1
Age = CurrentYear - BirthYear       // Statement 3

UniqueId = FullName + TokenNo        // Statement 2
However, if reordering is performed in a multi-threaded application where threads share some variables then it may cost us the correctness of our program.

Now recall the two problems we talked about in the previous section, the race condition, and the updated visibility. Java provides us with some solutions to handle these types of situations. We are gonna learn what they are, and finally happens-before will be introduced in that section.



Volatile 

For a field/variable declared as volatile, 

private volatile count;
Every write to the field will be written/flushed directly to the main memory (i.e. bypassing the cache.)
Every read of that field is read directly from the main memory.
This means that the shared variable count, whenever written-to or read-by a thread, it will always correspond to its most recently written value. This will prevent race condition because now the threads will always use the correct value of a shared variable. Also, the updates to the shared variable will also be visible to all the threads reading it, thus preventing the update visibility problem.

There are some more important points that the volatile dictates:

At the time you write to a volatile variable, all the non-volatile variables that are visible to that thread will also get written/flushed to the main memory, i.e. their most recent values will be stored in the RAM along with the volatile variable.
At the time you read a volatile variable, all the non-volatile variables that are visible to that thread will also get refreshed from the main memory, i.e. their most recent values will be assigned to them.
This is called the visibility guarantee of a volatile variable.

All of this looks and works fine, unless the CPU decides to reorder your instructions, resulting in incorrect execution of your application. Lets understand what we mean. Consider this piece of a program:

Implementation:

The below code in the illustration depicts as conveyed in simpler words is as follows:

Inputs a fresh assignment submitted by a student
And then collects that fresh assignment.


 * </pre>
 */
public class HappensBeforeGuarantee {

}


