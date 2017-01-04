package core.java.threads.model;

public class Thread11 extends Thread {

    private SynchronizedMethodProblem synchronizedMethodProblem;

    public Thread11(SynchronizedMethodProblem synchronizedMethodProblem) {
	this.synchronizedMethodProblem = synchronizedMethodProblem;
    }

    @Override
    public void run() {
	for (int i = 0; i < 2000; i++) {
	    synchronizedMethodProblem.method2();
	}
    }
}
