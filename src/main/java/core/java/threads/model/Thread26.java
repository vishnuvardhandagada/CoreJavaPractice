package core.java.threads.model;

public class Thread26 implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread26 -> run(): " + Thread.currentThread().getName());
	}
}
