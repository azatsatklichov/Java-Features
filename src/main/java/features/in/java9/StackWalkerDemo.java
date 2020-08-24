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
