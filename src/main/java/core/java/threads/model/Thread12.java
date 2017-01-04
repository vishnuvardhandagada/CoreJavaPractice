package core.java.threads.model;

public class Thread12 extends Thread {

    private SynchronizedMethodProblemSolution1 synchronizedMethodProblemSolution1;

    public Thread12(SynchronizedMethodProblemSolution1 synchronizedMethodProblemSolution1) {
	this.synchronizedMethodProblemSolution1 = synchronizedMethodProblemSolution1;
    }

    @Override
    public void run() {
	for (int i = 0; i < 2000; i++) {
	    synchronizedMethodProblemSolution1.method1();
	}
    }
}
