package expression.operations;

import expression.CommonExpression;

public class Const implements CommonExpression {

    private final Number value;
    //private final boolean isDouble;

    public Const(Number value) {
        this.value =  value;
        //isDouble = false;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return value.intValue();
    }


    public boolean equals(Object x) {
        if (x != null && this.getClass() == x.getClass() && this.value.equals(((Const) x).value)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        //if (isDouble) {
        return value.toString();
        //} else {
        //return Integer.toString((int) value);
        //}
    }
}
