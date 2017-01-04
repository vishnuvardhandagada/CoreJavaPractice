package core.java.threads.model;

public class Thread15 extends Thread {

    private SynchronizedMethodProblemSolution2 synchronizedMethodProblemSolution2;

    public Thread15(SynchronizedMethodProblemSolution2 synchronizedMethodProblemSolution2) {
	this.synchronizedMethodProblemSolution2 = synchronizedMethodProblemSolution2;
    }

    @Override
    public void run() {
	for (int i = 0; i < 2000; i++) {
	    synchronizedMethodProblemSolution2.method2();
	}
    }
}
