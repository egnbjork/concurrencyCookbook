package producerconsumer;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EventStorage {
	private int maxSize;
	private List<Date> storage;

	public EventStorage() {
		maxSize = 3;
		storage = new LinkedList<>();
	}

	public synchronized void set() {
		while (storage.size() == maxSize) {
			try {
				System.out.println("set() start waiting");
				wait();
				System.out.println("set() finished waiting");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		((LinkedList<Date>) storage).offer(new Date());
		System.out.println("Set: " + storage.size());
		notifyAll();
	}

	public synchronized void get() {
		while (storage.size() == 0) {
			try {
				System.out.println("get() start waiting");
				wait();
				System.out.println("get() finished waiting");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Get: " + storage.size() + ": " + ((LinkedList<Date>) storage).poll());
		notifyAll();
	}
}
