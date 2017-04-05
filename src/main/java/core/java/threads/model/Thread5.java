package core.java.threads.model;

public class Thread5 extends Thread {

	public Thread5(String name) {
		super(name);
	}

	@Override
	public void run() {
		// currentThread() method is present in Thread class
		// we cannot directly call this method if we implement Runnable interface
		Thread currentThread = currentThread();
		System.out.println("Current Thread: " + currentThread + ", Thread Name: " + currentThread.getName());
	}

}
