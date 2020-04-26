package expression;

import expression.exceptions.OverflowException;
import expression.operations.Const;
import expression.parser.BaseParser;
import expression.parser.StringSource;

import expression.parser.translateExpression;
public class Main {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE + 2);
    }
}
