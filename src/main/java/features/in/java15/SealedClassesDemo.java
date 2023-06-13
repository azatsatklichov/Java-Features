package features.in.java15;

class TestExprzessions {
	public static void main(String[] args) {
		// (6 + 7) * -8 = 13*(-8)=-104
		System.out.println(
				new TimesExprz(new PlusExprz(new ConstantExprz(6), new ConstantExprz(7)), new NegExprz(new ConstantExprz(8)))
						.eval());
	}
}

sealed interface Exprz permits ConstantExprz,PlusExprz,TimesExprz,NegExprz {
	public int eval();
}

final class ConstantExprz implements Exprz {
	int i;

	ConstantExprz(int i) {
		this.i = i;
	}

	public int eval() {
		return i;
	}
}

final class PlusExprz implements Exprz {
	Exprz a, b;

	PlusExprz(Exprz a, Exprz b) {
		this.a = a;
		this.b = b;
	}

	public int eval() {
		return a.eval() + b.eval();
	}
}

final class TimesExprz implements Exprz {
	Exprz a, b;

	TimesExprz(Exprz a, Exprz b) {
		this.a = a;
		this.b = b;
	}

	public int eval() {
		return a.eval() * b.eval();
	}
}

final class NegExprz implements Exprz {
	Exprz e;

	NegExprz(Exprz e) {
		this.e = e;
	}

	public int eval() {
		return -e.eval();
	}
}
