package core.java.threads.model;

/**
 * Thread for non static synchronized practice
 * @author Avinash Babu Donthu
 *
 */
public class Thread3 implements Runnable {

	private Counter counter;

	public Thread3(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			counter.increment1();
		}

		for (int i = 0; i < 10000; i++) {
			try {
				counter.increment2();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
