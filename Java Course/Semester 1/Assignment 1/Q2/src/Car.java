public class Car {
	private int current_speed; // in kilometer per hour
	
	public void speed_up() {
		current_speed += (1 - current_speed / 10);
	}
	
	public void slow_down() {
		current_speed = current_speed - 1 % ++current_speed;
	}
	
	public void stop() {
		current_speed = 0;
	}
	
	public void show() {
		System.out.println(current_speed);
	}
}
