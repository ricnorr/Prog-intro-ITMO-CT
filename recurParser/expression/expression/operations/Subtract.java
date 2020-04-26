package expression.operations;

import expression.CommonExpression;

public class Subtract extends Arithmetic {

    public Subtract(CommonExpression leftOperand, CommonExpression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    protected String getStringOperation() {
        return "-";
    }

    @Override
    protected int calculateOperation(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }

    @Override
    protected double calculateOperation(double firstOperand, double secondOperand) {return firstOperand - secondOperand;}
}
