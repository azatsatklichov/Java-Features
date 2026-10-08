package features.in.java9;

import java.io.IOException;
import java.time.ZoneId;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Desc
 * 
 * <pre>
 * In Java 9 Process API which is responsible to control and manage operating
 * system processes has been improved considerably. ProcessHandle Class now
 * provides process's native process ID, start time, accumulated CPU time,
 * arguments, command, user, parent process, and descendants. ProcessHandle
 * class also provides method to check processes' liveness and to destroy
 * processes. It has onExit method, the CompletableFuture class can perform
 * action asynchronously when process exits.
 * </pre>
 * 
 */
public class D_ProcessApiImprovements {
    public static void main(String[] args) throws IOException { 
        //ProcessBuilder pb = new ProcessBuilder("notepad.exe");
        ProcessBuilder pb = new ProcessBuilder("calc.exe");
        String np = "Not Present";
        Process p = pb.start();
        ProcessHandle.Info info = p.info();
        System.out.printf("Process ID : %s%n", p.pid());
        System.out.printf("Command name : %s%n", info.command().orElse(np));
        System.out.printf("Command line : %s%n", info.commandLine().orElse(np));
        
        System.out.println();
        pb = new ProcessBuilder("eclipse.exe");
        np = "Not Present";
        p = pb.start();
        info = p.info();
        System.out.printf("Process ID : %s%n", p.pid());
        System.out.printf("Command name : %s%n", info.command().orElse(np));
        System.out.printf("Command line : %s%n", info.commandLine().orElse(np));

        System.out.printf("Start time: %s%n",
                info.startInstant().map(i -> i.atZone(ZoneId.systemDefault()).toLocalDateTime().toString()).orElse(np));

        System.out.printf("Arguments : %s%n",
                info.arguments().map(a -> Stream.of(a).collect(Collectors.joining(" "))).orElse(np));

        System.out.printf("User : %s%n", info.user().orElse(np));
    }
}
