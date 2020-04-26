package expression;

import expression.parser.translateExpression;

public class ExpressionParser {
    CommonExpression parse(String source) {
        return translateExpression.parse(source);
    }
}
