public class Program {
	public static void main(String[] args) {
		Clock myClock = new Clock();
		myClock.show();
		myClock.tick();
		myClock.tick();
		myClock.show();
		myClock.setMidday();
		myClock.tick();
		myClock.tick();
		myClock.tick();
		myClock.show();
		Clock yourClock = new Clock();
		yourClock.setMidnight();
		yourClock.show();
	}
}
