public class Car {
	private int current_speed; // in kilometer per hour
	private String plate_num;
	private int max_speed;

	public Car(String plate, int maxspeed) {
		plate_num = plate;
		max_speed = maxspeed;
		current_speed = 0;
	}
	
	public void speed_up() {
		current_speed += (1 - current_speed / max_speed);
	}

	public void speed_up(int num) {
		if(!(num < 0) && num + current_speed <= max_speed) {
			current_speed += (num - current_speed / max_speed);
		}
	}
	
	public void slow_down() {
		current_speed = current_speed - 1 % ++current_speed;
	}

	public void slow_down(int num) {
		if(!(num < 0) && num <= current_speed) {
			current_speed = current_speed - num % ++current_speed;
		}
	}
	
	public void stop() {
		current_speed = 0;
	}

	public int get_speed() {
		return current_speed;
	}
	
	public void show() {
		System.out.println(plate_num + "," + max_speed + "," + current_speed);
	}
}
