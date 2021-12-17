package features.in.java14;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JPackagingTools {

	// JEP392

	/**
	 * read: https://www.baeldung.com/java14-jpackage
	 * 
	 * <pre>
	 * # compile
	>  javac JPackagingTools.java
	
	> jar cvf hello.jar JPackagingTools.class
	
	> C:\apps\Java\jdk-15\bin\jpackage  -i . -n JPackagingTools --main-jar hello.jar --main-class JPackagingTools
	
	
	  
	 * </pre>
	 */
	public static void main(String[] args) {

		// https://mkyong.com/java/what-is-new-in-java-16/#jep-392-packaging-tool

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
