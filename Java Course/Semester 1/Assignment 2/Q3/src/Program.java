public class Program {
	public static void main(String[] args) {
		Car car1 = new Car("12345", 120);
		Car car2 = new Car("123456", 100);
		car1.speed_up(5);
		car2.speed_up();
		car1.show();
		car2.show();
		int rnd = (int)(Math.random() * 150 + 50);
		car2.speed_up(rnd);
		if (car2.get_speed() != 1) {
			if(car2.get_speed() > 30) {
				car2.slow_down(rnd - 29);
			}
			if(car2.get_speed() < 30) {
				car2.speed_up(rnd - 29);
			}
		}
		car2.show();
	}
}
