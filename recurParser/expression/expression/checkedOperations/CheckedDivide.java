package expression.checkedOperations;

import expression.CommonExpression;
import expression.exceptions.DivisionByZeroException;

public class CheckedDivide extends CheckedArithmetic {

    public CheckedDivide(CommonExpression leftOperand, CommonExpression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    protected int calculateOperation(int leftOperand, int rightOperand) {
        check(leftOperand, rightOperand);
        return leftOperand / rightOperand;
    }

    //protected double calculateOperation(double leftOperand, double rightOperand) {
        //check(leftOperand, rightOperand);
        //return leftOperand / rightOperand;
    //}

    protected void check(int leftOperand, int rightOperand) {
        if (rightOperand == 0) {
            throw new DivisionByZeroException("division by zero");
        }
    }

    @Override
    protected String getStringOperation() {
        return "/";
    }

}
