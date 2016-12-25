package core.java.threads.model;

public class Thread4 extends Thread {

    public Thread4(String name) {
	super(name);
    }

    @Override
    public void run() {
	System.out.println("Thread Name: " + getName());
    }
}
