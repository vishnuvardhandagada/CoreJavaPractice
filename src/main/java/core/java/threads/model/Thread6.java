package core.java.threads.model;

public class Thread6 extends Thread {

    public Thread6(String name) {
	super(name);
    }

    @Override
    public void run() {
	Thread currentThread = currentThread();
	System.out.println("Thread6 -> run() -> start");
	System.out.println("Current Thread: " + currentThread);
	System.out.println("currentThread.getId() :" + currentThread.getId());
	System.out.println("currentThread.getName(): " + currentThread.getName());
	System.out.println("currentThread.getPriority(): " + currentThread.getPriority());
	System.out.println("currentThread.isAlive(): " + currentThread.isAlive());
	System.out.println("currentThread.isDaemon(): " + currentThread.isDaemon());
	System.out.println("currentThread.isInterrupted(): " + currentThread.isInterrupted());
	System.out.println("currentThread.getStackTrace(): " + currentThread.getStackTrace());

	State state = currentThread.getState();
	System.out.println("currentThread.getState(): " + state);

	ThreadGroup threadGroup = currentThread.getThreadGroup();
	System.out.println("currentThread.getThreadGroup(): " + threadGroup);
	System.out.println("currentThread.getThreadGroup().getName(): " + threadGroup.getName());
	System.out.println("currentThread.getThreadGroup().getMaxPriority(): " + threadGroup.getMaxPriority());
	System.out.println("currentThread.getThreadGroup().getParent(): " + threadGroup.getParent());

	System.out.println("currentThread.getUncaughtExceptionHandler(): " + currentThread.getUncaughtExceptionHandler());
	System.out.println("Thread6 -> run() -> end");
    }
}
