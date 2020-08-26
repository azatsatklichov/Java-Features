package features.in.java9;

import com.sun.management.HotSpotDiagnosticMXBean;

import javax.management.MBeanServer;
import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * Add More Diagnostic Commands Java 9 has added some new commands to improve
 * the diagnose issues. These diagnostic command are used to diagnose Hotspot
 * and JDK.
 * <p>
 * The Java jcmd utility can be used to send diagnostic command requests to a
 * running Java Virtual Machine (JVM).
 * <p>
 * You use the jcmd utility to send diagnostic command requests to a running
 * Java Virtual Machine (JVM).
 * <p>
 * The jcmd utility is used to send diagnostic command requests to the JVM. It
 * must be used on the same machine on which the JVM is running, and have the
 * same effective user and group identifiers that were used to launch the JVM.
 * <p>
 * https://docs.oracle.com/javase/9/tools/jcmd.htm#JSWOR743
 */
public class zDiagnosticCommandsJcmd {

    //Module jdk.jcmd
    //Tool Guides: 	jcmd, jinfo, jmap, jps, jstack, jstat

    //https://www.baeldung.com/java-heap-dump-capture

    //jmap is a tool to print statistics about memory in a running JVM
    //jmap -dump:live,format=b,file=/tmp/dump.hprof 12587


    //jcmd is a very complete tool that works by sending command requests to the JVM
    //jcmd 12587 GC.heap_dump /tmp/dump.hprof

    //JVisualVM is a tool with a graphical user interface that lets us monitor, troubleshoot, and profile Java applications.

    //JMX
    //The last approach that we'll cover in this article is using JMX. We'll use the HotSpotDiagnostic MBean that we briefly introduced in the previous section.
    //The easiest way to use the HotSpotDiagnostic MBean is by using a JMX client such as JConsole.


    //JConsole
    //>cmd

    //Programmatic Way
    //The other way to use the HotSpotDiagnostic MBean is by invoking it programmatically from Java code.

    public static void dumpHeap(String filePath, boolean live) throws IOException {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
//        HotSpotDiagnosticMXBean mxBean = ManagementFactory.newPlatformMXBeanProxy(
//                server, "com.sun.management:type=HotSpotDiagnostic", HotSpotDiagnosticMXBean.class);
//        mxBean.dumpHeap(filePath, live);
    }


}
