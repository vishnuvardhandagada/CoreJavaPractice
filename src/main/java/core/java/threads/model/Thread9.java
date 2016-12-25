package core.java.threads.model;

public class Thread9 extends Thread {

    private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    private int value;

    public Thread9(Integer value, String name) {
	super(name);
	this.value = value;
    }

    @Override
    public void run() {
	threadLocal.set(this.value);

	try {
	    Thread.sleep(1000 * 2);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	System.out.println("getName(): " + getName() + ", threadLocal.get(): " + threadLocal.get());
    }

}
