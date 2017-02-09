package project3;
/**
 * 
 * @author huangshengwei
 *
 */
public class Main {
	public static Queue<Car> cars = new Queue<Car>();
	public static Queue<Car> out_cars = new Queue<Car>();
	public static void main(String[] args) {
		String[] roadNames = { "SN", "SW", "EW", "ES", "NS", "NE", "WE", "WN", "SE", "EN", "NW", "WS" };
		for (int x = 0; x < 12; x++) {
			new Street(roadNames[x]);
		}
		new Scheduler();
		try {
			Thread.sleep(500);//500 time unit
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int total = 0;
		int size = Main.out_cars.size();
		while(Main.out_cars.size()>0){
			Car car = Main.out_cars.dequeue();
			total +=(car.getEndTime()-car.getStartTime());
		}
		System.out.println("Total wait time : "+total);
		System.out.println("Total cars : "+size);

	}
}