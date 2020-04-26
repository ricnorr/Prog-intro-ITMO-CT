package expression.checkedOperations;

import expression.CommonExpression;
import expression.exceptions.OverflowException;
import expression.operations.TripleExpression;

public class CheckedNegate implements CommonExpression {
    private TripleExpression operand;

    public CheckedNegate(TripleExpression operand) {
        this.operand = operand;
    }

    public int evaluate(int x, int y, int z) {
        int temp = operand.evaluate(x,y,z);
        check(temp);
        return -1 * temp;
    }

    public String toString() {
        return "(-" + operand.toString() + ")";
    }

    public void check(int operand) {
        if (operand == Integer.MIN_VALUE) {
            throw new OverflowException("overflow");
        }
    }
}
