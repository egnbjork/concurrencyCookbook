package syncronization;

public class Account {
	private double balance;
	private final Object lock = new Object();

	public void addAmount(double amount) {
		synchronized (lock) {
			double tmp = balance;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tmp += amount;
			balance = tmp;
		}
	}

	public void subtractAmount(double amount) {
		synchronized (lock) {
			double tmp = balance;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tmp -= amount;
			balance = tmp;
		}
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
