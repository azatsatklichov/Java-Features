package features.in.java11;

/**
 * Shebang files - that can be executed directly on the Unix systems by
 * providing the executor using the
 * 
 * syntax #!/path/to/executable as the first line of the file.
 *
 */
public class ShebangFiles {

	public static void main(String[] args) {
		// $ ./single-shebang-file 1000 20 2

		// ways to run SHELL in Windows 1. cygwin 2.git-bash client 3. docker bash
		// images
		// cd C:\apps\Git
		// run git-bash
		//./single-shebang-file.sh


		// Gotcha #4 — File name, not class name!
		// https://medium.com/the-java-report/new-java-11-feature-launch-single-file-source-code-programs-fadd698abf54
		// Gotcha #6 — No limits on public files in a source file , see shebang-file,
		// now 2-public classes
	}

}