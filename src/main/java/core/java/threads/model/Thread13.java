package core.java.threads.model;

public class Thread13 extends Thread {

    private SynchronizedMethodProblemSolution1 synchronizedMethodProblemSolution1;

    public Thread13(SynchronizedMethodProblemSolution1 synchronizedMethodProblemSolution1) {
	this.synchronizedMethodProblemSolution1 = synchronizedMethodProblemSolution1;
    }

    @Override
    public void run() {
	for (int i = 0; i < 2000; i++) {
	    synchronizedMethodProblemSolution1.method2();
	}
    }
}
