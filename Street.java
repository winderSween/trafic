package project3;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * 
 * @author huangshengwei
 *
 */
public class Street {
	private String name;

	public Street(String name) {
		this.name = name;
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int x = 0; x < 1000; x++) {
					Random random = new Random();
					int temp = random.nextInt(100);
					if (temp < 33) {
						Random random2 = new Random();
						int temp2 = random2.nextInt(100);
						if (temp2 < 25) {// turn left
							if (name.equals("SW") || name.equals("WN") || name.equals("NE") || name.equals("ES")) {
								Car car = new Car();
								car.setStartTime(System.currentTimeMillis());
								Main.cars.enqueue(car);
							}
						} else {
							if (name.equals("SW") || name.equals("WN") || name.equals("NE") || name.equals("ES")) {
								Car car = new Car();
								car.setStartTime(System.currentTimeMillis());
								Main.cars.enqueue(car);
							}
						}
					}
					
				}

			}

		}).start();
		
		ScheduledExecutorService carMoveTimer = Executors.newScheduledThreadPool(1);
		carMoveTimer.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				if (Main.cars.size() != 0) {
					if (Lights.getByName(Street.this.name).isOn()) {
						Car car = Main.cars.dequeue();
						car.setEndTime(System.currentTimeMillis());
						Main.out_cars.enqueue(car);
					}
				}

			}
		}, 0, 3, TimeUnit.MICROSECONDS);//3 is the time needed by a car to cross the street
	}

}