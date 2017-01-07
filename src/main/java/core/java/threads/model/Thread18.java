package core.java.threads.model;

public class Thread18 extends Thread {

    private WaitNotify waitNotify;

    public Thread18(String name, WaitNotify waitNotify) {
	super(name);
	this.waitNotify = waitNotify;
    }

    @Override
    public void run() {
	waitNotify.consume();
    }

}
