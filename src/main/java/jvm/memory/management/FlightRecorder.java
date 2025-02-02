package jvm.memory.management;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.ValueDescriptor;
import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordingFile;

/**
 * Flight Recorder which earlier used to be a commercial add-on in Oracle JDK is
 * now open-sourced since Oracle JDK is itself not free anymore.
 * 
 * JFR is a profiling tool used to gather diagnostics and profiling data from a
 * running Java application. Its performance overhead is negligible and that�s
 * usually below 1%. Hence it can be used in production applications.
 *
 * https://www.baeldung.com/java-flight-recorder-monitoring
 * 
 *  java -XX:StartFlightRecording=duration=60s,settings=profile,filename=app.jfr FlightRecorder
 */
public class FlightRecorder {
	public static void main(String[] args) {
		/**
		 * https://www.youtube.com/watch?v=azshjd5Vsv0
		 * 
		 * https://docs.oracle.com/javacomponents/jmc-5-4/jfr-runtime-guide/run.htm#JFRUH176
		 */
		System.out.println(
				"Java is not only a programming language but also a very rich ecosystem with a lot of tools. ");
		/**
		 * The bin folder of a JDK distribution contains, among others, the following
		 * programs that can be used for profiling and monitoring:
		 * 
		 * Java VisualVM (jvisualvm.exe)
		 * 
		 * JConsole (jconsole.exe)
		 * 
		 * Java Mission Control (jmc.exe)
		 * 
		 * Diagnostic Command Tool (jcmd.exe)
		 */
		System.out.println(
				"JFR is a profiling tool used to gather diagnostics and profiling data from a running Java application");
		System.out.println(
				"JFR  - Its usage is closely related to two of the tools above � Java Mission Control and Diagnostic Command Tools.");
		/**
		 * Java Flight Recorder (JFR) is a monitoring tool that collects information
		 * about the events in a Java Virtual Machine (JVM) during the execution of a
		 * Java application. JFR is part of the JDK distribution, and it's integrated
		 * into the JVM.
		 * 
		 * JFR is designed to affect the performance of a running application as little
		 * as possible.
		 * 
		 * In order to use JFR, we should activate it. We may achieve this in two ways:
		 * 
		 * when starting a Java application passing diagnostic commands of the jcmd tool
		 * when a Java application is already running JFR doesn't have a standalone
		 * tool. We use Java Mission Control (JMC), which contains a plugin that allows
		 * us to visualize the data collected by JFR.
		 * 
		 * These three components � JFR, jcmd and JMC � form a complete suite for
		 * collecting low-level runtime information of a running Java program.
		 * 
		 * If we have various versions of Java installed on our computer, it's important
		 * to make sure that the Java compiler (javac), the Java launcher (java) and the
		 * above-mentioned tools (JFR, jcmd and JMC) are from the same Java
		 * distribution.
		 */
		System.out.println("JFR has two main concepts: events and dataflow");
		// https://www.baeldung.com/java-flight-recorder-monitoring

		/**
		 * <pre>
		 * java -XX:+UnlockCommercialFeatures -XX:+FlightRecorder 
		 * 
		-XX:StartFlightRecording=duration=200s,filename=flight.jfr path-to-class-file
		 * </pre>
		 */
		System.out.println("TRY: https://www.baeldung.com/java-flight-recorder-monitoring");
		

	}
}

//https://metebalci.com/blog/what-is-new-in-java-11/#jep-328-flight-recorder
class JEP328 extends Event {

	  @Label("message")
	  String message;

	  public static void main(String[] args) throws Exception {

	    if (args.length > 0) {

	      for (int i = 0; i < 100; i++) {

	        final JEP328 j = new JEP328();
	        j.message = String.valueOf(i);
	        j.commit();

	        Thread.sleep(1000);

	      }

	    } else {

	      Path p = Paths.get("1.out");
	      for (RecordedEvent e : RecordingFile.readAllEvents(p)) {
	        final List<ValueDescriptor> lvd = e.getFields();
	        System.out.println(e.getStartTime());
	        for (ValueDescriptor vd : lvd) {
	          System.out.println(vd.getLabel() + "=" + e.getValue(vd.getName()));
	        }
	        System.out.println("***");
	      }

	    }

	  }
	}
