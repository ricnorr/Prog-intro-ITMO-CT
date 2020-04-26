package expression.exceptions;

public class DivisionByZeroException extends CalculatingException {

    public DivisionByZeroException(String message) {
        super(message);
    }
}
