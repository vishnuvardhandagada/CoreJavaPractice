package core.java.threads.model;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchThread implements Runnable {

    private CountDownLatch countDownLatch;
    private String name;

    public CountDownLatchThread(String name, CountDownLatch countDownLatch) {
	this.countDownLatch = countDownLatch;
	this.name = name;
    }

    @Override
    public void run() {
	System.out.println(this.name + " started");

	try {
	    Thread.sleep(1000 * 2);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	countDownLatch.countDown();
    }
}