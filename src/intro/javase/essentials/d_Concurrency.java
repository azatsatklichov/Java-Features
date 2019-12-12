package intro.javase.essentials;

public class d_Concurrency {

    /**
     * 
     * Lesson: Concurrency
     * 
     * <pre>
     * Computer users take it for granted that their systems can do more than
     * one thing at a time. They assume that they can continue to work in a word
     * processor, while other applications download files, manage the print
     * queue, and stream audio. Even a single application is often expected to
     * do more than one thing at a time. For example, that streaming audio
     * application must simultaneously read the digital audio off the network,
     * decompress it, manage playback, and update its display. Even the word
     * processor should always be ready to respond to keyboard and mouse events,
     * no matter how busy it is reformatting text or updating the display.
     * Software that can do such things is known as concurrent software.
     * 
     * The Java platform is designed from the ground up to support concurrent
     * programming, with basic concurrency support in the Java programming
     * language and the Java class libraries. Since version 5.0, the Java
     * platform has also included high-level concurrency APIs. This lesson
     * introduces the platform's basic concurrency support and summarizes some
     * of the high-level APIs in the java.util.concurrent packages.
     * </pre>
     * 
     */
    public static void main(String[] args) {
        System.out
                .println("A process has a self-contained execution environment. A process generally has a complete, \n"
                        + "private set of basic run-time resources; in particular, each process has its own memory space.");
        System.out.println(
                "To facilitate communication between processes, most operating systems support Inter Process Communication (IPC) resources, \n"
                        + "such as pipes and sockets");

        System.out.println(
                "Most implementations of the Java virtual machine run as a single process. A Java application can create \n"
                        + "additional processes using a ProcessBuilder object. Multiprocess applications are beyond the scope of this lesson.");

        System.out.println();
        System.out.println(
                "Threads are sometimes called lightweight processes. Both processes and threads provide an execution \n"
                        + "environment, but creating a new thread requires fewer resources than creating a new process.");
        System.out.println("Threads exist within a process — every process has at least one. \n"
                + "Threads share the process's resources, including memory and open files. This makes for efficient, but potentially problematic, communication.");

        System.out.println();
        System.out.println(
                "Each thread is associated with an instance of the class Thread. There are two basic strategies for using Thread objects to create a concurrent application.");
        /**
         * •To directly control thread creation and management, simply
         * instantiate Thread each time the application needs to initiate an
         * asynchronous task.
         * 
         * •To abstract thread management from the rest of your application,
         * pass the application's tasks to an executor.
         * 
         */
        System.out.println(
                "-  instantiate Thread each time the application needs to initiate an  asynchronous task --> HelloThread");
        System.out.println("-  pass the application's tasks to an executor --> HelloRunnable");

        System.out.println();

        System.out.println(
                "Which of these idioms should you use? The first idiom, which employs a Runnable object, is more general, "
                        + "\nbecause the Runnable object can subclass a class other than Thread. The second idiom is easier to use in simple applications, \n"
                        + "but is limited by the fact that your task class must be a descendant of Thread. ");

    }
}

class HelloRunnable implements Runnable {

    // implements
    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String args[]) {
        (new Thread(new HelloRunnable())).start();
    }
}

class HelloThread extends Thread {

    // overrides
    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String args[]) {
        (new HelloThread()).start();
    }

}
