package core.java.threads.model;

import java.util.concurrent.Semaphore;

public class Connection {

    private static Connection connection = new Connection();
    private int connectionsCount = 0;
    private Semaphore semaphore = new Semaphore(10);

    private Connection() {
    }

    public static Connection getInstance() {
	return connection;
    }

    public void connect() {

	try {
	    semaphore.acquire();

	    synchronized (this) {
		connectionsCount++;
		System.out.println("current connections: " + connectionsCount);
	    }

	    try {
		Thread.sleep(1000);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }

	    synchronized (this) {
		connectionsCount--;
	    }

	} catch (InterruptedException e1) {
	    e1.printStackTrace();
	} finally {
	    semaphore.release();
	}

    }
}
