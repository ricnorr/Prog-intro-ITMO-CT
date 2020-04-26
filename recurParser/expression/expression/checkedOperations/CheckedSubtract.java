package expression.checkedOperations;

import expression.CommonExpression;
import expression.exceptions.OverflowException;

public class CheckedSubtract extends CheckedArithmetic {

    public CheckedSubtract(CommonExpression leftOperand, CommonExpression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    protected String getStringOperation() {
        return "-";
    }

    @Override
    protected int calculateOperation(int firstOperand, int secondOperand) {
        check(firstOperand, secondOperand);
        return firstOperand - secondOperand;
    }

    protected void check(int leftOperand, int rightOperand) {
        if (leftOperand * rightOperand < 0
                && (leftOperand > Integer.MAX_VALUE + rightOperand || leftOperand < Integer.MIN_VALUE + rightOperand)) {
            throw new OverflowException("overflow");
        }
    }
}
