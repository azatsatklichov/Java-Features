package features.in.java9;

import java.lang.StackWalker.StackFrame;
import java.util.List;
import java.util.stream.Collectors;

public class StackWalkerDemo {

	public static void main(String[] args) {
		StackWalker stackWalker = StackWalker.getInstance();
		List<Integer> walk = stackWalker.walk(stackStream -> stackStream.filter(f -> f.getMethodName().startsWith("g"))
				.map(StackFrame::getLineNumber).collect(Collectors.toList()));
		System.out.println(walk);
	}

}

class StackWalkerDemo2 {
	public static void main(String... args) {
		method1();
	}

	public static void method1() {
		method2();
	}

	public static void method2() {
		method3();
	}

	public static void method3() {
		method4();
	}

	public static void method4() {
		StackWalker walker = StackWalker.getInstance();

		walker.forEach(System.out::println);

		List<Integer> lines = walker.walk(stackStream -> stackStream.filter(f -> f.getMethodName().startsWith("m"))
				.map(StackFrame::getLineNumber).collect(Collectors.toList()));

		lines.forEach(System.out::println);
	}

}