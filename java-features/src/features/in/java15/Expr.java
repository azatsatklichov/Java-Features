package features.in.java15;
public sealed interface Expr {
    int eval();
}

record Constant(int value) implements Expr {
    public int eval() {
        return value;
    }
}

record Add(Expr lval, Expr rval) implements Expr {
    public int eval() {
        return lval.eval() + rval.eval();
    }
}

record Mul(Expr lval, Expr rval) implements Expr {
    public int eval() {
        return lval.eval() * rval.eval();
    }
}