package producerconsumer;

public class Producer implements Runnable {

	private EventStorage storage;

	public Producer(EventStorage storage) {
		this.storage = storage;
	}

	@Override
	public void run() {
		System.out.println("Producer has started");
		for (int i = 0; i < 6; i++) {
			storage.set();
		}
	}

}
