package core.java.threads.model;

public class Thread17 extends Thread {

    private WaitNotify waitNotify;

    public Thread17(WaitNotify waitNotify) {
	this.waitNotify = waitNotify;
    }

    @Override
    public void run() {
	waitNotify.produce();
    }
}
