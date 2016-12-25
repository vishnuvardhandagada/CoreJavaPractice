package core.java.threads.model;

/**
 * Class to practice synchronized (race conditions and critical sections)
 * @author Avinash Babu Donthu
 *
 */
public class Counter {

    private int count1 = 0;
    private int count2 = 0;

    /**
     * non-synchronized increment method
     */
    public void increment1() {
	count1++;
    }

    /**
     * synchronized increment method
     */
    public synchronized void increment2() {
	count2++;
    }

    /**
     * get count1 value
     * @return
     */
    public int getCount1() {
	return count1;
    }

    /**
     * get count2 value
     * @return
     */
    public int getCount2() {
	return count2;
    }
}
