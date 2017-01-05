package core.java.threads.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProducerConsumer2 {

    private List<Integer> list = new ArrayList<>();
    private int MAX_SIZE = 10;
    private Random random = new Random();
    private Object lock = new Object();

    public void produce() {

	while (true) {
	    synchronized (lock) {

		while (MAX_SIZE == list.size()) {
		    try {
			lock.wait();
		    } catch (InterruptedException e) {
			e.printStackTrace();
		    }
		}

		list.add(random.nextInt(100));
		lock.notify();

	    }

	}
    }

    public void consume() {

	while (true) {

	    try {
		Thread.sleep(1000);
	    } catch (InterruptedException e1) {
		e1.printStackTrace();
	    }

	    synchronized (lock) {

		while (list.isEmpty()) {
		    try {
			lock.wait();
		    } catch (InterruptedException e) {
			e.printStackTrace();
		    }
		}

		Integer value = list.remove(0);
		System.out.println("value: " + value + ", list size: " + list.size());
		lock.notify();
	    }

	}
    }
}
