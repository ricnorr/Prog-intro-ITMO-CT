package expression.operations;

import expression.CommonExpression;

public class Multiply extends Arithmetic {

    public Multiply(CommonExpression leftOperand, CommonExpression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    protected int calculateOperation(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }
    @Override
    protected double calculateOperation(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }
    @Override
    protected String getStringOperation() {
        return "*";
    }
}
