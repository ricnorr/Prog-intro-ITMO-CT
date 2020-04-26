package expression.operations;

import expression.CommonExpression;

public class Negate implements CommonExpression {
    private TripleExpression operand;

    public Negate(TripleExpression operand) {
        this.operand = operand;
    }

    public int evaluate(int x, int y, int z) {
        return -1 * operand.evaluate(x,y,z);
    }

    public String toString() {
        return "(-" + operand.toString() + ")";
    }
}
