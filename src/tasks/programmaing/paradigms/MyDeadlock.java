package tasks.programmaing.paradigms;

/**
 * 
 * Program: Write a program to create deadlock between two threads.
 * 
 * 
 * <pre>
 * Description:
 * 
 * Deadlock describes a situation where two or more threads are blocked forever, waiting for each other. 
 * 
 * Deadlocks can occur in Java when the synchronized keyword causes the executing thread to block while 
 * waiting to get the lock, associated with the specified object. Since the thread might already hold 
 * locks associated with other objects, two threads could each be waiting for the other to release a lock. 
 * 
 * In such case, they will end up waiting forever.
 * </pre>
 * 
 */
public class MyDeadlock {

	String str1 = "Java";
	String str2 = "UNIX";

	Thread trd1 = new Thread("My Thread 1") {
		public void run() {
			while (true) {
				synchronized (str1) {
					synchronized (str2) {
						System.out.println(str1 + str2);
					}
				}
			}
		}
	};

	Thread trd2 = new Thread("My Thread 2") {
		public void run() {
			while (true) {
				synchronized (str2) { //fix str1
					synchronized (str1) {  //fix str2
						System.out.println(str2 + str1);
					}
				}
			}
		}
	};

	public static void main(String a[]) {
		MyDeadlock mdl = new MyDeadlock();
		mdl.trd1.start();
		mdl.trd2.start();
		
		//Solution: Use Successive ORDER in Thread2 synchronized (str1) { synchronized (str1) {
	}
}