package features.in.java9;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.time.Instant;
import java.util.Comparator;

public class JavaProcessDemo {

	public static void main(String... args) throws IOException {
		Process process = new ProcessBuilder("bash", "-c", "while true; do sleep 1; done").start();

		ProcessHandle handle = process.toHandle();
		handle.onExit().thenAccept(p -> System.out.println("Process " + p + " was killed"));

		System.out.println("Press enter to continue");
		System.in.read();

		if (handle.supportsNormalTermination()) {
			System.out.println("Killing process");
			handle.destroy();
		}

		System.out.println("Press enter to finish");
		System.in.read();

	}
}

class KillOtherProcess {

	public static void main(String... args) throws Exception {

		ProcessHandle textEditHandle = ProcessHandle.allProcesses()
				.filter(h -> h.info().commandLine().map(cmd -> cmd.contains("TextEdit")).orElse(false)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No matching handle found"));

		System.out.println(textEditHandle.info());

		textEditHandle.onExit().thenAccept(h -> System.out.println("TextEdit was killed by Java!"));

		boolean shutdown = textEditHandle.destroy();

		textEditHandle.onExit().join();
		System.out.println("Shutdown: " + shutdown);

	}

}

class ListProcesses {
	public static void main(String... args) {
		ProcessHandle.allProcesses().map(ProcessHandle::info)
				.sorted(Comparator.comparing(info -> info.startInstant().orElse(Instant.MAX)))
				.forEach(ListProcesses::printInfo);

	}

	private static void printInfo(ProcessHandle.Info info) {
		if (info.startInstant().isPresent() && info.command().isPresent()) {
			System.out.println("Started at: " + info.startInstant().get() + ", Command: " + info.command().get());
		}

	}
}


class ProcessId {
    public static void main(String... args) {
        // Before Java 9 :(
        long pidOld = Long.parseLong(ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);
        // With the new ProcessHandle API in Java 9:
        long pidNew = ProcessHandle.current().pid();
        long parentPid = ProcessHandle.current().parent().get().pid();

        System.out.println(String.format("{ pidOld: %s, pidNew: %s }\nparentPid (IDE): %s", pidOld, pidNew, parentPid));
    }
}