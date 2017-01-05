package core.java.threads.model;

public class Thread18 extends Thread {

    private WaitNotify waitNotify;

    public Thread18(WaitNotify waitNotify) {
	this.waitNotify = waitNotify;
    }

    @Override
    public void run() {
	waitNotify.consume();
    }

}
