#!/c/apps/Java/jdk-11/bin/java --source 11
 

public class ShebangFiles {
  //./single-shebang-file.sh 3 4 5
	public static void main(String[] args)
	} {
		if (args == null || args.length < 3) {
			System.err.println("Three arguments required: principal, rate, period");
			System.exit(1);
		}
		int principal = Integer.parseInt(args[0]);
		int rate = Integer.parseInt(args[1]);
		int period = Integer.parseInt(args[2]);
		double interest = Maths.simpleInterest(principal, rate, period);
		System.out.print("Simple Interest is: " + interest);
	}
}

public class Maths {
	public static double simpleInterest(int principal, int rate, int period) {
		if (rate > 100) {
			System.err.println("Rate of interest should be <= 100. But given values is " + rate);
			System.exit(1);
		}
		return (principal * rate * period * 1.0) / 100;
	}
}
