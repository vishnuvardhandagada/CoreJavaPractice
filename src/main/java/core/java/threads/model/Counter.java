package core.java.threads.model;

/**
 * Class to practice synchronized (race conditions and critical sections)
 * @author Avinash Babu Donthu
 *
 */
public class Counter {

    private int count1 = 0;
    private int count2 = 0;
    private static int count3 = 0;
    private static int count4 = 0;
    private int count5 = 0;
    private int count6 = 0;

    /**
     * non-synchronized non static increment method
     */
    public void increment1() {
	count1++;
    }

    /**
     * synchronized non static increment method
     */
    public synchronized void increment2() {
	count2++;
    }

    /**
     * non synchronized static increment method
     */
    public static void increment3() {
	count3++;
    }

    /**
     * synchronized static increment method
     */
    public static synchronized void increment4() {
	count4++;
    }

    /**
     * increment without synchronized block
     */
    public void increment5() {
	count5++;
    }

    /**
     * increment with synchronized block
     */
    public void increment6() {
	synchronized (this) {
	    count6++;
	}
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

    /**
     * get count3 value
     * @return
     */
    public static int getCount3() {
	return count3;
    }

    /**
     * get count4 value
     */
    public static int getCount4() {
	return count4;
    }

    /**
     * get count5
     * @return
     */
    public int getCount5() {
	return count5;
    }

    /**
     * get count6
     * @return
     */
    public int getCount6() {
	return count6;
    }

}