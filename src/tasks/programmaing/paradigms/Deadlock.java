package net.sahet.demo.intw;

//https://www.baeldung.com/java-common-concurrency-pitfalls
public class Deadlock {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String args[])   {
        Thread threadA = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("ThreadA: Holding lock 1...");
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("ThreadA: Waiting for lock 2...");

                synchronized (lock2) {
                    System.out.println("ThreadA: Holding lock 1 & 2...");
                }
            }
        });
        Thread threadB = new Thread(() -> {
            synchronized (lock2) { //solution synchronized (lock1) {
                System.out.println("ThreadB: Holding lock 2...");
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("ThreadB: Waiting for lock 1...");

                synchronized (lock1) { //solution  synchronized (lock2) {
                    System.out.println("ThreadB: Holding lock 1 & 2...");
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}
