package expression.operations;

import expression.CommonExpression;
import expression.ExpressionException;

public class Divide extends Arithmetic {

    public Divide(CommonExpression leftOperand, CommonExpression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    protected int calculateOperation(int leftOperand, int rightOperand) {
        return leftOperand / rightOperand;
    }

    protected double calculateOperation(double leftOperand, double rightOperand) {
        if (rightOperand == 0) {
            throw new ExpressionException("DVZ");
        }
        return leftOperand / rightOperand;
    }
    @Override
    protected String getStringOperation() {
        return "/";
    }

}
