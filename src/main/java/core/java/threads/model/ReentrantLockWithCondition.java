package core.java.threads.model;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockWithCondition {

    private int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private void increment() {
	for (int i = 0; i < 10000; i++) {
	    count++;
	}
    }

    public void firstThread() throws InterruptedException {
	lock.lock();

	System.out.println("Waiting");

	// like wait() method in synchronized method/block
	condition.await();

	try {
	    increment();
	} finally {
	    lock.unlock();
	}
    }

    @SuppressWarnings("resource")
    public void secondThread() throws InterruptedException {

	Thread.sleep(1000);
	lock.lock();

	System.out.println("Press Enter key");
	new Scanner(System.in).nextLine();
	System.out.println("Enter pressed");

	// like notify() method in synchronized method/block
	condition.signal();

	try {
	    increment();
	} finally {
	    lock.unlock();
	}
    }

    public int getCount() {
	return count;
    }
}