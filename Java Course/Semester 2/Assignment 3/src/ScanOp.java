public interface ScanOp {
    void reset();
    boolean forward();
    boolean backward();
    Object getCurrent();
}
