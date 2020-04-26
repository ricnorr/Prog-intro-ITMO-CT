package expression.parser;

import expression.ExpressionSource;

public class BaseParser {
    private ExpressionSource source;
    protected char ch;

    protected BaseParser(ExpressionSource source) {
        this.source = source;
    }

    protected void nextChar() {
        ch = source.hasNext() ? source.nextChar() : '\0';
    }
    protected void backChar() {ch = source.backChar();}

    protected boolean test(char expected) {
        if (ch == expected) {
            nextChar();
            return true;
        }
        return false;
    }
    protected boolean nextIsDigit(char ch) {
        if (Character.isDigit(ch)) {
            return true;
        }
        return false;
    }

    protected void expect(final char c) {
        if (ch != c) {
            throw new IllegalStateException();
        }
        nextChar();
    }

    protected boolean between(final char from, final char to) {
        return from <= ch && ch <= to;
    }

}
