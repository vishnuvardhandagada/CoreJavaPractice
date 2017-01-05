package core.java.threads.model;

public class Thread16 implements Runnable {

    private int id;

    public Thread16(int id) {
	this.id = id;
    }

    @Override
    public void run() {
	try {
	    System.out.println("Stating: " + id);
	    Thread.sleep(1000 * 2);
	    System.out.println("Completed: " + id);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }

}
