package expression;

public interface ExpressionSource {
    char nextChar();
    char backChar();
    boolean hasNext();
}
