package features.in.java14;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JPackagingTools {

	// JEP392

	/**
	 * read: https://www.baeldung.com/java14-jpackage
	 * https://docs.oracle.com/en/java/javase/14/jpackage/packaging-overview.html#GUID-C0AAEB7D-1FAB-4E20-B52C-E2401AC2BABE
	 * 
	 * 
	 * jpackage is a command-line tool to create native installers and packages for
	 * Java applications. This allows the distribution, installation, and
	 * uninstallation of the applications in a manner that's familiar to our end
	 * users.
	 * 
	 * jpackage allows developers to create such an installable package for their
	 * JAR files. The user doesn't have to explicitly copy the JAR file or even
	 * install Java to run the application. The installable package takes care of
	 * all of this.
	 * 
	 * The application JAR should be pre-built, and it will be used as an input to
	 * the jpackage tool.
	 * 
	 * <pre>
	  jpackage --input target/ \
	  --name JPackageDemoApp \
	  --main-jar JPackageDemoApp.jar \
	  --main-class com.baeldung.java14.jpackagedemoapp.JPackageDemoApp \
	  --type dmg \
	  --java-options '--enable-preview'
	 * 
	 * 
	 * 
	 * # compile
	>  javac JPackagingTools.java
	
	> jar cvf hello.jar JPackagingTools.class
	
	> C:\apps\Java\jdk-15\bin\jpackage  -i . -n JPackagingTools --main-jar hello.jar --main-class JPackagingTools
	 * 
	 * 
	 * 
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
