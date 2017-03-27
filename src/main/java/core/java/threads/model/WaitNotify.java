package core.java.threads.model;

public class WaitNotify {

    public void produce() {
	synchronized (this) {
	    try {
		System.out.println("produce() method running");
		wait();
		System.out.println("produce() method completed");
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }

    public void consume() {
	try {
	    Thread.sleep(1000 * 2);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	synchronized (this) {
	    System.out.println("consume() method running");
	    System.out.println("consume() method completed");
	    notify();
	}
    }
}
