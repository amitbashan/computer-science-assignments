package Q1;

public class Program {
    public static void main(String[] args) {
        LockableDoor lockableDoor = new LockableDoor();
        lockableDoor.show();
        lockableDoor.close();
        lockableDoor.show();
        lockableDoor.lock();
        lockableDoor.show();
        lockableDoor.open();
        lockableDoor.unlock();
        lockableDoor.open();
        lockableDoor.lock();
    }
}
