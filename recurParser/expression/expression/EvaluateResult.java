package expression;

public class EvaluateResult {
    private Number result;
    private String exception;

    public EvaluateResult(Number result, String exception) {
        this.result = result;
        this.exception = exception;
    }

    @Override
    public String toString() {
        if (exception == null) {
            return result.toString();
        } else {
            return exception;
        }
    }
}
