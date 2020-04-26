package expression.operations;

import expression.CommonExpression;

public abstract class Arithmetic implements CommonExpression {

    private CommonExpression operand1;
    private CommonExpression operand2;

    public Arithmetic(CommonExpression operand1, CommonExpression operand2) {
       this.operand1 = operand1;
       this.operand2 = operand2;
   }

   protected abstract int calculateOperation(int operand1, int operand2);
   protected abstract double calculateOperation(double operand1, double operand2);
   protected abstract String getStringOperation();

   public int evaluate(int x, int y, int z) {
       return calculateOperation(operand1.evaluate(x,y,z), operand2.evaluate(x,y,z));
   }

   public String toString() {
       return "(" + operand1.toString() + " " + getStringOperation() + " " + operand2.toString() + ")";
   }

   public boolean equals(Object x) {
       if (x != null && this.getClass() == x.getClass()) {
           Arithmetic temp = (Arithmetic) x;
           return operand1.equals(temp.operand1) && operand2.equals(temp.operand2);
       }
       return false;
   }

   public int hashCode() {
       int result = 31 * operand1.hashCode();
       result = 31 * result + operand2.hashCode();
       return 31 * result + getStringOperation().hashCode();
   }
}
