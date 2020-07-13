public class UnequalMatricesDimensionException extends Exception {
    public UnequalMatricesDimensionException() {
        super("Cannot execute operation on matrices with different dimensions.");
    }
}
