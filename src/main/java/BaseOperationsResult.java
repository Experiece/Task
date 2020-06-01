public class BaseOperationsResult {
    public final long derivative;
    public final double quotient;
    public final long sum;
    public final long residual;
    public final int mod;

    private BaseOperationsResult() {
        this(0, 0, 0, 0, 0);
    }


    private BaseOperationsResult(long derivative, double quotient, long sum, long residual, int mod) {
        this.derivative = derivative;
        this.quotient = quotient;
        this.sum = sum;
        this.residual = residual;
        this.mod = mod;
    }


    public static BaseOperationsResult calculateBaseOperations(int valueA, int valueB) {
        long derivative = (long) valueA * valueB;
        double quotient = (double) valueA / valueB;
        long sum = (long) valueA + valueB;
        long residual = valueA - valueB;
        int mod = valueA % valueB;
        BaseOperationsResult result;
        result = new BaseOperationsResult(derivative, quotient, sum, residual, mod);
        return result;
    }
}
