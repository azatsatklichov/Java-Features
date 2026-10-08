package features.in.java9;

import java.awt.List;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.time.ZoneId;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Desc:   https://www.demo2s.com/java/java-get-process-information-from-processhandle-and-processhandle-info.html
 * 
 * In earlier versions, it was complex to manage and control operating system
 * processes by using Java programming. Now, new classes and interfaces are
 * added to perform this task.
 * 
 * 
 * 
 * <pre>
 * In Java 9 Process API which is responsible to control and manage operating
 * system processes has been improved considerably. 
 * 
 * ProcessHandle Class now
 * provides process's native process ID, start time, accumulated CPU time,
 * arguments, command, user, parent process, and descendants. ProcessHandle
 * class also provides method to check processes' liveness and to destroy
 * processes. 
 * 
 * It has onExit method, the CompletableFuture class can perform
 * action asynchronously when process exits.
 * 
 * Two new interface in Process API:

java.lang.ProcessHandle

java.lang.ProcessHandle.Info
 * </pre>
 * 
 * - Get PID of current JVM process, and any other processes spawned by the JVM
 * - Enumerate the proceses running in the system to get info such as PID, name,
 * and resource usage - Managing process trees - Managing sub processes
 * 
 */
public class ProcessApiImprovements_JEP102 {
	public static void main(String[] args) throws IOException {

		// ProcessBuilder pb = new ProcessBuilder("notepad.exe");
		ProcessBuilder pb = new ProcessBuilder("calc.exe");
		// ProcessBuilder pb = new ProcessBuilder("mspaint.exe");
		String np = "Not Present";
		Process p = pb.start();
		ProcessHandle.Info info = p.info();
		System.out.printf("Process ID : %s%n", p.pid());
		System.out.printf("Command name : %s%n", info.command().orElse(np));
		System.out.printf("Command line : %s%n", info.commandLine().orElse(np));

		System.out.printf("Start time: %s%n",
				info.startInstant().map(i -> i.atZone(ZoneId.systemDefault()).toLocalDateTime().toString()).orElse(np));

		System.out.printf("Arguments : %s%n",
				info.arguments().map(a -> Stream.of(a).collect(Collectors.joining(" "))).orElse(np));

		System.out.printf("User : %s%n", info.user().orElse(np));

		System.out.println();
		ProcessHandle currentProcess = ProcessHandle.current(); // Current processhandle
		System.out.println("Process Id: " + currentProcess.pid()); // Process id
		System.out.println("Direct children: " + currentProcess.children()); // Direct children of the process
		System.out.println("Class name: " + currentProcess.getClass()); // Class name
		System.out.println("All processes: " + ProcessHandle.allProcesses()); // All current processes
		System.out.println("Process info: " + currentProcess.info()); // Process info
		System.out.println("Is process alive: " + currentProcess.isAlive());
		System.out.println("Process's parent " + currentProcess.parent()); // Parent of the process

		System.out.println("\n how to get process id before" + "");
		// Before Java 8
		long pid = Long.parseLong(ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);
		System.out.println(pid);

		/**
		 * Returns a ProcessHandle for the current process. The ProcessHandle cannot be
		 * used to destroy the current process, use System.exit instead
		 * 
		 * 
		 * Killing a process forcibly terminates the process immediately, whereas a
		 * normal termination allows a process to shut down cleanly. Whether you can
		 * kill a process depends on operating system access control.
		 */
		ProcessHandle.current().destroyForcibly();
		
		
		///Java 9 Tools
		List awtL = new List();
		awtL.addItem("Aba");
		
		
	}
}

class ProcessHandleExample {
	public static void main(String[] args) throws Exception {
		ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe");
		Process process = processBuilder.start();

		System.out.println("-- process handle --");
		ProcessHandle processHandle = process.toHandle();
		System.out.printf("PID: %s%n", processHandle.pid());
		System.out.printf("isAlive: %s%n", processHandle.isAlive());

		System.out.println("-- process info --");
		ProcessHandle.Info info = processHandle.info();
		info.command().ifPresent(str -> System.out.printf("Command: %s%n", str));
		info.commandLine().ifPresent(str -> System.out.printf("CommandLine: %s%n", str));
		info.arguments().ifPresent(array -> System.out.printf("Arguments: %s%n", array));
		info.startInstant().ifPresent(instant -> System.out.printf("StartInstant: %s%n", instant));
		info.totalCpuDuration()
				.ifPresent(duration -> System.out.printf("CpuDuration: %s millis%n", duration.toMillis()));
		info.user().ifPresent(str -> System.out.printf("User: %s%n", str));

		System.out.println("-- destroying --");
		processHandle.destroy();
		// better use onExit to know when process exits (destroy() may not kill the
		// process immediately)
		CompletableFuture<ProcessHandle> future = processHandle.onExit();
		ProcessHandle ph = future.get();// blocks
		System.out.printf("isAlive: %s%n", ph.isAlive());
	}
}
