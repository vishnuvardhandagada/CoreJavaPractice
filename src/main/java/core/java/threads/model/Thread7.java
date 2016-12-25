package core.java.threads.model;

/**
 * Thread class for static synchronized method
 * @author Admin
 *
 */
public class Thread7 extends Thread {

    @Override
    public void run() {
	for (int i = 0; i < 1000; i++) {
	    Counter.increment3();
	}

	for (int i = 0; i < 1000; i++) {
	    Counter.increment4();
	}
    }
}
