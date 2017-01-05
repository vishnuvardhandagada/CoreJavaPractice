package core.java.threads.model;

public class Thread19 extends Thread {
    private Counter counter;

    public Thread19(Counter counter) {
	this.counter = counter;
    }

    @Override
    public void run() {
	for (int i = 0; i < 10000; i++) {
	    counter.increment7();
	}
    }

}
