package core.java.threads.model;

/**
 * Thread to call method with synchronized block
 * @author Avinash Babu Donthu
 *
 */
public class Thread8 extends Thread {

    private Counter counter;

    public Thread8(Counter counter) {
	this.counter = counter;
    }

    @Override
    public void run() {
	for (int i = 0; i < 1000; i++) {
	    counter.increment5();
	}

	for (int i = 0; i < 1000; i++) {
	    counter.increment6();
	}
    }
}
