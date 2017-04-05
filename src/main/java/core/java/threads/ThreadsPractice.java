package core.java.threads;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;

import core.java.threads.model.Connection;
import core.java.threads.model.CountDownLatchThread;
import core.java.threads.model.Counter;
import core.java.threads.model.ProducerConsumer;
import core.java.threads.model.ProducerConsumer2;
import core.java.threads.model.ReentrantLockPracticeModel;
import core.java.threads.model.ReentrantLockWithCondition;
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
import core.java.threads.model.Thread16;
import core.java.threads.model.Thread17;
import core.java.threads.model.Thread18;
import core.java.threads.model.Thread19;
import core.java.threads.model.Thread2;
import core.java.threads.model.Thread20;
import core.java.threads.model.Thread21;
import core.java.threads.model.Thread22;
import core.java.threads.model.Thread23;
import core.java.threads.model.Thread24;
import core.java.threads.model.Thread25;
import core.java.threads.model.Thread26;
import core.java.threads.model.Thread3;
import core.java.threads.model.Thread4;
import core.java.threads.model.Thread5;
import core.java.threads.model.Thread6;
import core.java.threads.model.Thread7;
import core.java.threads.model.Thread8;
import core.java.threads.model.Thread9;
import core.java.threads.model.WaitNotify;

/**
 * Thread practice class
 * @author Avinash Babu Donthu
 *
 */
public class ThreadsPractice {

	/**
	 * Different methods to create threads
	 * 
	 * If we call start() method more than once - we will get IllegalStateException
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

		System.out.println("createThread()");
	}

	/**
	 * Set Name to thread
	 */
	@Ignore
	@Test
	public void threadName() {
		// extends Thread
		Thread thread = new Thread4("My Thread");
		thread.start();

		// implements Runnable
		Thread thread2 = new Thread(new Thread26(), "My Thread 26");
		thread2.start();
	}

	/**
	 * Set name to threads
	 */
	@Ignore
	@Test
	public void threadName2() {
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
		thread.setDaemon(true);
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
		System.out.println("list1.size(): " + synchronizedMethodProblem.getList1().size()
				+ ", list2.size(): " + synchronizedMethodProblem.getList2().size());
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
		System.out.println("list1.size(): " + synchronizedMethodProblem.getList1().size()
				+ ", list2.size(): " + synchronizedMethodProblem.getList2().size());
	}

	/**
	 * To solve above problem we need to get two separate locks for 2 methods
	 */
	@Ignore
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
		System.out.println("list1.size(): " + synchronizedMethodProblem.getList1().size()
				+ ", list2.size(): " + synchronizedMethodProblem.getList2().size());
	}

	/**
	 * Thread.sleep(milliSec) practice
	 * If we call sleep(0) with 0 milli seconds: What happens depends on platform
	 * Thread may not sleep at all or may sleep for less no.of time etc
	 * To make current thread sleep for certain milli seconds
	 */
	@Ignore
	@Test
	public void threadSleep() {
		LocalTime startTime = LocalTime.now(Clock.systemDefaultZone());

		try {
			Thread.sleep(1000 * 2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		LocalTime endTime = LocalTime.now(Clock.systemDefaultZone());

		Duration duration = Duration.between(startTime, endTime);
		System.out.println("time taken: " + duration.getSeconds());
	}

	/**
	 * To sleep the current thread we can use java.util.concurrent.TimeUnit as below
	 * To Time unit we need to pass unit value. sleep method on TimeUnit throws InterruptedExcepion
	 * @throws InterruptedException 
	 */
	@Ignore
	@Test
	public void threadSleepWithTimeUnit() throws InterruptedException {
		int value = 3;
		System.out.println("Sleeping for " + value + " micro seconds");
		TimeUnit.MICROSECONDS.sleep(value);

		System.out.println("Sleeping for " + value + " milli seconds");
		TimeUnit.MILLISECONDS.sleep(value);

		System.out.println("Sleeping for " + value + " seconds");
		TimeUnit.SECONDS.sleep(value);
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

	/**
	 * Thread pools practice using @see  java.util.concurrent.ExecutorService
	 * @throws InterruptedException
	 */
	@Ignore
	@Test
	public void threadPools() throws InterruptedException {
		// create thread pool with 2 threads
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		// give 5 tasks to 2 threads created above
		for (int i = 0; i < 5; i++) {
			executorService.submit(new Thread16(i));
		}

		// tell executor service to submit all tasks and do not accept any thread into pool after this point
		executorService.shutdown();

		System.out.println("----- All tasks submitted ----");

		// wait until all tasks are completed. This should be called only after executorService.shutdown()
		executorService.awaitTermination(3, TimeUnit.HOURS);

		System.out.println("---- All tasks completed ---");
	}

	/**
	 * wait-notify practice
	 * @throws InterruptedException
	 */
	@Ignore
	@Test
	public void waitNotify1() throws InterruptedException {
		WaitNotify waitNotify = new WaitNotify();
		Thread t1 = new Thread17("thread1", waitNotify);
		Thread t2 = new Thread18("thread2", waitNotify);

		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}

	/**
	 * volatile key word practice
	 * @throws InterruptedException
	 */
	@Ignore
	@Test
	public void volatilePractice() throws InterruptedException {
		Counter counter = new Counter();
		Thread t1 = new Thread19(counter);
		Thread t2 = new Thread19(counter);

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println(counter.getCount7());
	}

	/**
	 * @see java.util.concurrent.CountDownLatch practice
	 */
	@Ignore
	@Test
	public void countDownLatch() {
		// create count down latch with initial value of 3
		CountDownLatch countDownLatch = new CountDownLatch(3);

		// create thread pool with 3 worked threads
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		// assign 3 tasks to 3 threads in thread pool
		for (int i = 0; i < 3; i++) {
			executorService.submit(new CountDownLatchThread("thread" + i, countDownLatch));
		}

		// tell executor service not to accept new threads into pool after this point
		executorService.shutdown();

		try {
			// wait until count down latch reaches 0
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + " completed");
	}

	/**
	 * @see java.util.concurrent.CountDownLatch practice
	 */
	@Ignore
	@Test
	public void countDownLatch2() {
		// create count down latch with initial value of 3
		CountDownLatch countDownLatch = new CountDownLatch(3);

		// create thread pool with 3 worked threads
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		// assign 3 tasks to 3 threads in thread pool
		for (int i = 0; i < 5; i++) {
			executorService.submit(new CountDownLatchThread("thread" + i, countDownLatch));
		}

		// tell executor service not to accept new threads into pool after this point
		executorService.shutdown();

		try {
			// wait until count down latch reaches 0
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + " completed");
	}

	/**
	 * Producer Consume patter using @see  java.uti.concurrent.BlockingQueue
	 * @throws InterruptedException 
	 */
	@Ignore
	@Test
	public void producerConsumerUsingBlockingQueue() throws InterruptedException {
		ProducerConsumer producerConsumer = new ProducerConsumer();
		Thread threadA = new Thread(new Thread20(producerConsumer));
		Thread threadB = new Thread(new Thread21(producerConsumer));

		threadA.start();
		threadB.start();

		threadA.join();
		threadB.join();
	}

	/**
	 * Producer consumer implementation with thread synchronization, wait() and notify() methods
	 * @throws InterruptedException 
	 * 
	 */
	@Ignore
	@Test
	public void producerConsumerWithWaitNotify() throws InterruptedException {
		ProducerConsumer2 producerConsumer = new ProducerConsumer2();
		Thread threadA = new Thread(new Thread22(producerConsumer));
		Thread threadB = new Thread(new Thread23(producerConsumer));

		threadA.start();
		threadB.start();

		threadA.join();
		threadB.join();
	}

	/**
	 * executing synchronized and non-synchronized methods of same object in parallel by same thread 
	 */
	@Ignore
	@Test
	public void synchronizedAndNonSynchronizedMethodsParallelExecution() {

	}

	/**
	 * @see java.util.concurrent.locks.ReentrantLock practice
	 * Reentrant lock means: one thread can call one synchronized method from another synchronized method.
	 * Then same lock can be acquired by same thread again. If we use Reentrant Lock it will keeps count of
	 * how many times this lock is locked and we have to unlock it same number of times
	 * 
	 * @throws InterruptedException 
	 */
	@Ignore
	@Test
	public void reentrantLock() throws InterruptedException {
		final ReentrantLockPracticeModel reentrantLockPracticeModel = new ReentrantLockPracticeModel();
		Thread threadA = new Thread(() -> {
			reentrantLockPracticeModel.firstThread();
		});

		Thread threadB = new Thread(() -> {
			reentrantLockPracticeModel.secondThread();
		});

		threadA.start();
		threadB.start();

		threadA.join();
		threadB.join();

		System.out.println(reentrantLockPracticeModel.getCount());
	}

	/**
	 * @see java.util.concurrent.locks.ReentrantLock practice
	 * Reentrant lock means: one thread can call one synchronized method from another synchronized method.
	 * Then same lock can be acquired same thread again. If we use Reentrant Lock it will keeps count of
	 * how many times this lock is locked and we have to unlock it same number of times
	 * 
	 * @throws InterruptedException 
	 */
	@Ignore
	@Test
	public void reentrantLockWithCondition() throws InterruptedException {
		final ReentrantLockWithCondition reentrantLockPracticeModel = new ReentrantLockWithCondition();
		Thread threadA = new Thread(() -> {
			try {
				reentrantLockPracticeModel.firstThread();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		Thread threadB = new Thread(() -> {
			try {
				reentrantLockPracticeModel.secondThread();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		threadA.start();
		threadB.start();

		threadA.join();
		threadB.join();

		System.out.println(reentrantLockPracticeModel.getCount());
	}

	/**
	 * @see java.util.concurrent.Semaphore practice
	 * Semaphore will maintains count of available permits
	 * semaphone.acquire() will wait infinitely if no.of permits is 0.
	 * semaphores are used to control access to resources
	 * @throws InterruptedException 
	 */
	@Ignore
	@Test
	public void semaphore1() throws InterruptedException {
		Semaphore semaphore = new Semaphore(1);
		System.out.println("available permits: " + semaphore.availablePermits());

		// increment permits
		semaphore.release();
		System.out.println("available permits: " + semaphore.availablePermits());

		// decrement permits
		semaphore.acquire();
		System.out.println("available permits: " + semaphore.availablePermits());
	}

	/**
	 * Semaphores are used to control no.of resources. 
	 * For example in application servers we will say maximum connection on connection pool. How that is implemented?
	 * @throws InterruptedException
	 */
	@Ignore
	@Test
	public void semaphore2() throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i = 0; i < 200; i++) {
			executorService.submit(() -> {
				Connection.getInstance().connect();
			});
		}

		executorService.shutdown();

		executorService.awaitTermination(1, TimeUnit.DAYS);

	}

	/**
	 * @see java.util.concurrent.Callable practice
	 * @see java.util.concurrent.Future practice
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@Ignore
	@Test
	public void callableFutures() throws InterruptedException, ExecutionException {

		Callable<List<Integer>> callable = new Callable<List<Integer>>() {
			@Override
			public List<Integer> call() throws Exception {
				List<Integer> list = new ArrayList<>();
				for (int i = 0; i < 10; i++) {
					list.add(i + 1);
				}
				return list;
			}
		};

		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<List<Integer>> resultFutures = executorService.submit(callable);
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.DAYS);

		List<Integer> resultList = resultFutures.get();

		System.out.println(resultList);
	}

	/**
	 * Execute multiple callables at a time
	 * @throws InterruptedException 
	 * @throws ExecutionException 
	 */
	@Ignore
	@Test
	public void executeMultipleCallables() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		Set<Callable<List<Integer>>> callables = new HashSet<>();
		List<Integer> finalResult = new ArrayList<>();

		Callable<List<Integer>> callable1 = new Thread24(10, 20);
		Callable<List<Integer>> callable2 = new Thread24(30, 40);
		Callable<List<Integer>> callable3 = new Thread24(50, 60);

		callables.add(callable1);
		callables.add(callable2);
		callables.add(callable3);

		List<Future<List<Integer>>> resultFutures = executorService.invokeAll(callables);

		for (Future<List<Integer>> resultFuture : resultFutures) {
			finalResult.addAll(resultFuture.get());
		}

		System.out.println(finalResult);
	}

	/**
	 * @see java.util.concurrent.Callable practice
	 * @see java.util.concurrent.Future practice
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@Ignore
	@Test
	public void callableFuturesWithException() throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();

		Callable<List<Integer>> callable = new Callable<List<Integer>>() {
			@Override
			public List<Integer> call() throws Exception {
				throw new NullPointerException("callable Exception practice");
			}
		};

		Future<List<Integer>> resultFutures = executorService.submit(callable);
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.DAYS);

		try {
			List<Integer> resultList = resultFutures.get();
			System.out.println(resultList);
		} catch (ExecutionException e) {
			e.printStackTrace();

			NullPointerException ex = (NullPointerException) e.getCause();
			System.out.println(ex.getMessage());
		}

	}

	@Ignore
	@Test
	public void multipleCallablesWithException() {
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		Callable<Integer> callable1 = new Thread25();
		Callable<Integer> callable2 = new Thread25();
		Callable<Integer> callable3 = new Thread25();

		List<Callable<Integer>> callableList = new ArrayList<>();
		callableList.add(callable1);
		callableList.add(callable2);
		callableList.add(callable3);
		try {
			List<Future<Integer>> futureList = executorService.invokeAll(callableList);
			futureList.get(0).get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}