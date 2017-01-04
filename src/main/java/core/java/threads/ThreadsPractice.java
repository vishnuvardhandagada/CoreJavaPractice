package core.java.threads;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Ignore;
import org.junit.Test;

import core.java.threads.model.Counter;
import core.java.threads.model.SynchronizedMethodProblem;
import core.java.threads.model.SynchronizedMethodProblemSolution1;
import core.java.threads.model.SynchronizedMethodProblemSolution2;
import core.java.threads.model.Thread1;
import core.java.threads.model.Thread10;
import core.java.threads.model.Thread11;
import core.java.threads.model.Thread12;
import core.java.threads.model.Thread13;
import core.java.threads.model.Thread14;
import core.java.threads.model.Thread15;
import core.java.threads.model.Thread2;
import core.java.threads.model.Thread3;
import core.java.threads.model.Thread4;
import core.java.threads.model.Thread5;
import core.java.threads.model.Thread6;
import core.java.threads.model.Thread7;
import core.java.threads.model.Thread8;
import core.java.threads.model.Thread9;

/**
 * Thread practice class
 * @author Avinash Babu Donthu
 *
 */
public class ThreadsPractice {

    /**
     * Different methods to create threads
     */
    @Ignore
    @Test
    public void createThread() {
	// method 1 - create sub class of java.lang.Thread class and override run() method
	Thread thread = new Thread1();
	thread.start();

	// method 2 - create class implementing java.lang.Runnable interface and implement run() method
	Thread thread2 = new Thread(new Thread2());
	thread2.start();

	// method 3 - using anonymous inner class
	Thread thread3 = new Thread(new Runnable() {
	    @Override
	    public void run() {
		for (int i = 20; i < 30; i++) {
		    System.out.println("Anonymous inner class: " + i);
		}
	    }
	});
	thread3.start();

	// method 3 - from java 8 using Lambda expressions
	Thread thread4 = new Thread(() -> {
	    for (int i = 30; i < 40; i++) {
		System.out.println("Java 8 -> Labmda expression: " + i);
	    }
	});
	thread4.start();
    }

    /**
     * Set Name to thread
     */
    @Ignore
    @Test
    public void threadName() {
	Thread thread = new Thread4("My Thread");
	thread.start();
    }

    /**
     * Set name to threads
     */
    @Ignore
    @Test
    public void threadNames2() {
	for (int i = 0; i < 10; i++) {
	    Thread thread = new Thread4("Thread" + i);
	    thread.start();
	}
    }

    /**
     * Getting currently executing thread info
     */
    @Ignore
    @Test
    public void currentThread() {
	Thread thread = new Thread5("My Thread5");
	thread.start();

    }

    /**
     * Getting currently executing thread info
     */
    @Ignore
    @Test
    public void currentThread2() {
	for (int i = 0; i < 10; i++) {
	    Thread thread = new Thread5("Thread" + i);
	    thread.start();
	}
    }

    /**
     * Different methods in java.lang.Thread class
     */
    @Ignore
    @Test
    public void threadClassMethods() {
	Thread thread = new Thread6("My Thread6");
	//	thread.setDaemon(true);
	thread.start();
    }

    /**
     * What is Race Conditions and Critical Sections?<br>
     * A race condition is a special condition that may occur inside a critical section.<br> 
     * A critical section is a section of code that is executed by multiple threads and where the sequence of 
     * execution for the threads makes a difference in the result of the concurrent execution of the critical section.<br>
     *When the result of multiple threads executing a critical section may differ depending on the 
     *sequence in which the threads execute, the critical section is said to contain a race condition. <br>
     *The term race condition stems from the metaphor that the threads are racing through the critical section, 
     *and that the result of that race impacts the result of executing the critical section.<br>
     *
     * Synchronized testing<br>
     * 1. Counter class has 2 variables - count1, count2<br>
     * 2. count1 will be incremented using non-synchronized method<br>
     * 3 count2 will be incremented using synchronized method<br><br>
     * 
     * <a href="http://tutorials.jenkov.com/java-concurrency/race-conditions-and-critical-sections.html" target="_blank">Reference</a>
     * @throws InterruptedException
     */
    @Ignore
    @Test
    public void raceConditionCriticalSectionProblem() throws InterruptedException {
	Counter counter = new Counter();

	Thread thread1 = new Thread(new Thread3(counter));
	Thread thread2 = new Thread(new Thread3(counter));
	Thread thread3 = new Thread(new Thread3(counter));

	thread1.start();
	thread2.start();
	thread3.start();

	thread1.join();
	thread2.join();
	thread3.join();

	System.out.println(counter.getCount1());
	System.out.println(counter.getCount2());
    }

    /**
     * synchronized static method<br>
     * Synchronized static methods are synchronized on the class object of the class the synchronized static method belongs to.<br>
     * Since only one class object exists in the Java VM per class, only one thread can execute inside a static synchronized method in the same class.<br>
     * If the static synchronized methods are located in different classes, 
     * then one thread can execute inside the static synchronized methods of each class. <br>
     * One thread per class regardless of which static synchronized method it calls<br><br>
     * @throws InterruptedException
     */
    @Ignore
    @Test
    public void synchronizedStaticMethod() throws InterruptedException {
	Thread thread1 = new Thread7();
	Thread thread2 = new Thread7();
	Thread thread3 = new Thread7();

	thread1.start();
	thread2.start();
	thread3.start();

	thread1.join();
	thread2.join();
	thread3.join();

	System.out.println(Counter.getCount4());
	System.out.println(Counter.getCount4());
    }

    /**
     * Calling method with synchronized block<br>
     * The Java synchronized block construct takes an object in parentheses.<br>
     * In the example "this" is used, which is the instance the add method is called on.<br>
     * The object taken in the parentheses by the synchronized construct is called a monitor object.<br>
     * The code is said to be synchronized on the monitor object.<br>
     * A synchronized instance method uses the object it belongs to as monitor object<br>
     * Only one thread can execute inside a Java code block synchronized on the same monitor object.<br><br>
     * @throws InterruptedException
     */
    @Ignore
    @Test
    public void synchronizedBlock() throws InterruptedException {
	Counter counter = new Counter();

	Thread thread1 = new Thread8(counter);
	Thread thread2 = new Thread8(counter);
	Thread thread3 = new Thread8(counter);

	thread1.start();
	thread2.start();
	thread3.start();

	thread1.join();
	thread2.join();
	thread3.join();

	System.out.println(counter.getCount5());
	System.out.println(counter.getCount6());
    }

    /**
     * 1. Two threads are operating on 2 separate variables in a common object in 2 different methods.
     * 2.  If we declare both methods synchronized then 2 threads will execute in a sequence instead of parallel
     * @throws InterruptedException 
     */
    @Ignore
    @Test
    public void synchronizedMethodProblem() throws InterruptedException {
	SynchronizedMethodProblem synchronizedMethodProblem = new SynchronizedMethodProblem();
	Thread threadA = new Thread10(synchronizedMethodProblem);
	Thread threadB = new Thread11(synchronizedMethodProblem);

	LocalTime startTime = LocalTime.now(Clock.systemDefaultZone());

	threadA.start();
	threadB.start();

	threadA.join();
	threadB.join();

	LocalTime endTime = LocalTime.now(Clock.systemDefaultZone());

	System.out.println("duration: " + Duration.between(startTime, endTime).getSeconds());
	System.out.println("list1.size(): " + synchronizedMethodProblem.getList1().size() + ", list2.size(): "
		+ synchronizedMethodProblem.getList2().size());
    }

    /**
     * To solve above problem we need to get two separate locks for 2 methods
     */
    @Ignore
    @Test
    public void synchronizedMethodProblemSolution1() throws InterruptedException {
	SynchronizedMethodProblemSolution1 synchronizedMethodProblem = new SynchronizedMethodProblemSolution1();
	Thread threadA = new Thread12(synchronizedMethodProblem);
	Thread threadB = new Thread13(synchronizedMethodProblem);

	LocalTime startTime = LocalTime.now(Clock.systemDefaultZone());

	threadA.start();
	threadB.start();

	threadA.join();
	threadB.join();

	LocalTime endTime = LocalTime.now(Clock.systemDefaultZone());

	System.out.println("duration: " + Duration.between(startTime, endTime).getSeconds());
	System.out.println("list1.size(): " + synchronizedMethodProblem.getList1().size() + ", list2.size(): "
		+ synchronizedMethodProblem.getList2().size());
    }

    /**
     * To solve above problem we need to get two separate locks for 2 methods
     */
    //    @Ignore
    @Test
    public void synchronizedMethodProblemSolution2() throws InterruptedException {
	SynchronizedMethodProblemSolution2 synchronizedMethodProblem = new SynchronizedMethodProblemSolution2();
	Thread threadA = new Thread14(synchronizedMethodProblem);
	Thread threadB = new Thread15(synchronizedMethodProblem);

	LocalTime startTime = LocalTime.now(Clock.systemDefaultZone());

	threadA.start();
	threadB.start();

	threadA.join();
	threadB.join();

	LocalTime endTime = LocalTime.now(Clock.systemDefaultZone());

	System.out.println("duration: " + Duration.between(startTime, endTime).getSeconds());
	System.out.println("list1.size(): " + synchronizedMethodProblem.getList1().size() + ", list2.size(): "
		+ synchronizedMethodProblem.getList2().size());
    }

    /**
     * @throws InterruptedException 
     * @see ThreadLocal practice
     */
    @Ignore
    @Test
    public void threadLocal() throws InterruptedException {
	Thread thread1 = new Thread9(1, "Thread1");
	Thread thread2 = new Thread9(2, "Thread2");
	Thread thread3 = new Thread9(3, "Thread3");

	thread1.start();
	thread2.start();
	thread3.start();

	thread1.join();
	thread2.join();
	thread3.join();

	System.out.println("ThreadsPractice -> threadLocal()");
    }
}