package core.java.java8.constructor.references;

/**
 * Constructor reference practice with generics
 * @author Donthu Avinash Babu
 *
 * @param <T>
 */
public class ConstructorReferenceUtil2<T> {

    public ConstructorReferenceUtil2() {
	System.out.println("ConstructorReferenceUtil2() constructor");
    }

    public ConstructorReferenceUtil2(T arg0, T arg1) {
	System.out.println("ConstructorReferenceUtil2() constructor" + ", arg0: " + arg0 + ", arg1: " + arg1);
    }
}
