package core.java.java8.interfaces;

/**
 * Interface with default and static methods
 * 
 * @author Donthu Avinash Babu
 *
 */
public interface DefaultStaticInterfaceMethods {

    /**
     * static method
     */
    public static String method1() {
	System.out.println("DefaultStaticInterfaceMethods.method1() called");
	return "method1()";
    }

    /**
     * default method
     * 
     * @return
     */
    default String method2() {
	System.out.println("DefaultStaticInterfaceMethods.method2() called");
	return "method2()";
    }

}
