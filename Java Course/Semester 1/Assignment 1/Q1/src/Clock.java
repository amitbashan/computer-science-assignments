public class Clock {
	private int hours, minutes, seconds, milliseconds;
	
	public void tick() {
		milliseconds++;
		seconds += milliseconds / 1000;
		minutes += seconds / 60;
		hours += minutes / 60;
		seconds %= 60;
		minutes %= 60;
		hours %= 24;
		milliseconds %= 1000;
	}
	
	public void show() {
		System.out.println("The current time is: " + Integer.toString(hours) + ':' + Integer.toString(minutes) + ':' + Integer.toString(seconds) + ':' + Integer.toString(milliseconds));
	}
	
	public void setMidnight() {
		hours = minutes = seconds = milliseconds = 0;
	}
	
	public void setMidday() {
		hours = 12;
		minutes = seconds = milliseconds = 0;
	}
}
