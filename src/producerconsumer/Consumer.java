package producerconsumer;

public class Consumer implements Runnable {

	private EventStorage storage;

	public Consumer(EventStorage storage) {
		this.storage = storage;
	}

	@Override
	public void run() {
		System.out.println("Consumer has started");
		for (int i = 0; i < 6; i++) {
			storage.get();
		}
	}

}
