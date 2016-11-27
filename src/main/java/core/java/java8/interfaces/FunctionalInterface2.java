package core.java.java8.interfaces;

/**
 * Interface with static, default and abstract method
 * 
 * @author Donthu Avinash Babu
 *
 */
@FunctionalInterface
public interface FunctionalInterface2 {

    /**
     * static method in interface
     * 
     * @return
     */
    public static String method1() {
	System.out.println("FunctionalInterface2.method1() called");
	return "method1()";
    }

    /**
     * default method in interface
     * 
     * @return
     */
    default String method2() {
	System.out.println("FunctionalInterface2.method2() called");
	return "method2()";
    }

    /**
     * abstract method
     * 
     * @return
     */
    public abstract String method3();
}
