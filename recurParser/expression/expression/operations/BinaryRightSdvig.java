package expression.operations;


import expression.CommonExpression;

public class BinaryRightSdvig implements CommonExpression {
    CommonExpression leftOperand;
    CommonExpression rightOperand;

    public BinaryRightSdvig(CommonExpression leftOperand, CommonExpression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public int evaluate(int x, int y, int z) {
        return (leftOperand.evaluate(x,y,z) >> rightOperand.evaluate(x,y,z));
    }
}
