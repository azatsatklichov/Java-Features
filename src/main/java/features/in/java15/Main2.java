package features.in.java15;
import java.util.Comparator;
import java.util.stream.Stream;

public class Main2 {
    public static void main(String... args) {
        Expr e = new Add(
                new Constant(1),
                new Mul(new Constant(7), new Constant(2))
        );
        System.out.println(e + " = " + e.eval());
    }
}

/*
// The following won't compile, because Expr is sealed:
record Negate(Expr value) implements Expr {
    public int eval() {
        return -value.eval();
    }
}
*/