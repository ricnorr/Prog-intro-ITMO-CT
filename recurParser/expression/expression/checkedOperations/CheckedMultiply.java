package expression.checkedOperations;

import expression.CommonExpression;
import expression.exceptions.OverflowException;

public class CheckedMultiply extends CheckedArithmetic {

    public CheckedMultiply(CommonExpression leftOperand, CommonExpression rightOperand) {
        super(leftOperand, rightOperand);
    }

    protected void check(int firstOperand, int secondOperand) throws OverflowException {
        if (secondOperand != 0 && firstOperand != firstOperand * secondOperand / secondOperand) {
            throw new OverflowException("overflow");
        }
    }

    @Override
    protected int calculateOperation(int firstOperand, int secondOperand)  {
        check(firstOperand, secondOperand);
        return firstOperand * secondOperand;
    }

    @Override
    protected String getStringOperation() {
        return "*";
    }

}