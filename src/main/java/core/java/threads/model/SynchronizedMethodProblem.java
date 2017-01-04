package core.java.threads.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SynchronizedMethodProblem {

    private Random random = new Random();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public synchronized void method1() {
	try {
	    Thread.sleep(1);

	    list1.add(random.nextInt());
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }

    public synchronized void method2() {
	try {
	    Thread.sleep(1);

	    list2.add(random.nextInt());
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }

    public List<Integer> getList1() {
	return list1;
    }

    public List<Integer> getList2() {
	return list2;
    }
}