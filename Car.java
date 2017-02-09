package project3;
/**
 * 
 * @author huangshengwei
 * 
 * This class represents the cars
 */
public class Car {
	private long startTime;
	private long endTime;

	public Car() {

	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public Car(long startTime, long endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}

}