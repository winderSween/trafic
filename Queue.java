package project3;
/**
 * @author huangshengwei
 */
import java.util.Arrays;

public class Queue<T> {
	private Object[] datas;
	private int count;
	private int head;
	private int tail;
	
	/**
	 * 
	 * @return the size
	 */
	public int size(){
		return count;
	}
	public Queue() {
		this.datas = new Object[10];
		this.count = 0;
		this.head = 0;
		this.tail = 0;
	}

	/**
	 * 
	 * @param ele the element to put to the queue
	 * @return the ele
	 */
	public synchronized T enqueue(T ele) {
		if (tail >= datas.length) {
			expand();
		}
		count++;
		datas[tail] = ele;
		tail++;
		return ele;
	};

	/**
	 * 
	 * @return the element in front of queue
	 */
	public synchronized T dequeue() {
		T e = (T) datas[head];
		datas[head] = null;
		count--;
		head++;
		return e;
	};
	
	
	/**
	 * expand the queue when needed
	 */
	public synchronized void expand() {
		int size = datas.length * 2;
		datas = Arrays.copyOfRange(datas, head, datas.length);
		datas = Arrays.copyOf(datas, size);
		tail = count;
		head = 0;
	}
	
}