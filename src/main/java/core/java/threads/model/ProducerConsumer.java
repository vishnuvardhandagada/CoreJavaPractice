package core.java.threads.model;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public void produce() {
	Random random = new Random();
	while (true) {
	    try {
		queue.put(random.nextInt(100));
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }

    public void consume() {
	while (true) {
	    try {
		Thread.sleep(1000 * 1);

		Integer value = queue.take();

		System.out.println("Taken Value: " + value + ", queue size: " + queue.size());
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }
}
