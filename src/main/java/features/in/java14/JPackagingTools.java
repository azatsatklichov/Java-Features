package features.in.java14;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JPackagingTools {

	// JEP392

	/**
	 * <pre>
	 * # compile
	>  javac JPackagingTools.java
	
	> jar cvf hello.jar JPackagingTools.class
	
	> C:\apps\Java\jdk-15\bin\jpackage  -i . -n JPackagingTools --main-jar hello.jar --main-class JPackagingTools
	
	
	
	# create a jar file
	$ jar cvf JPackagingTools.jar JPackagingTools.class
	
	# package the jar file into platform-specific package
	$ /opt/jdk-16/bin/jpackage -i . -n JPackagingTools --main-jar JPackagingTools.jar --main-class JPackagingTools
	
	# The jpackage created this jep392_1.0-1_amd64.deb
	$ ls -lsah
	4.0K -rw-rw-r--  1 mkyong mkyong  994 Mac  15 13:52 hello.jar
	30M -rw-r--r--  1 mkyong mkyong  30M Mac  15 14:01 jep392_1.0-1_amd64.deb
	 * </pre>
	 */
	public static void main(String[] args) {

		//https://mkyong.com/java/what-is-new-in-java-16/#jep-392-packaging-tool
		
		JFrame frame = new JFrame("Hello World Java Swing");
		// display frame site
		frame.setMinimumSize(new Dimension(800, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// center the JLabel
		JLabel lblText = new JLabel("Hello World!", SwingConstants.CENTER);
		// add JLabel to JFrame
		frame.getContentPane().add(lblText);

		// display it
		frame.pack();
		frame.setVisible(true);

	}

}
