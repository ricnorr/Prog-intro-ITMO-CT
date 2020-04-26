package expression.operations;

import expression.CommonExpression;

public class Variable implements CommonExpression {

    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        switch (name) {
            case "x":
                return x;
            case "y":
                return y;
            case "z":
                return z;
            default:
                return 0;
        }
    }

    public double evaluate(double x, double y, double z) {
        switch (name) {
            case "x":
                return x;
            case "y":
                return y;
            case "z":
                return z;
            default:
                return 0.0;
        }
    }


    public String toString() {
        return name;
    }

    public boolean equals(Object x) {
        return (x instanceof Variable && this.name.equals(((Variable) x).name));
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
