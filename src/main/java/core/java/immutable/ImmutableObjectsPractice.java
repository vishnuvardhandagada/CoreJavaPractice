package core.java.immutable;

import org.junit.Ignore;
import org.junit.Test;

import core.java.immutable.model.ImmutableObject1;
import core.java.immutable.model.ImmutableObject2;

/**
 * Different ways to create immutable objects 
 * @author Avinash Babu Donthu
 *
 */
public class ImmutableObjectsPractice {

    /**
     * way 1 to create immutable object
     */
    @Ignore
    @Test
    public void method1() {
	ImmutableObject1 object1 = new ImmutableObject1("name1");
	ImmutableObject1 object2 = new ImmutableObject1("name2");
	ImmutableObject1 object3 = new ImmutableObject1("name3");

	System.out.println("ImmutableObjectsPractice -> immutableObject1() -> object1: " + object1);
	System.out.println("ImmutableObjectsPractice -> immutableObject1() -> object1.getName(): " + object1.getName());
	System.out.println("ImmutableObjectsPractice -> immutableObject1() -> object2: " + object2);
	System.out.println("ImmutableObjectsPractice -> immutableObject1() -> object2.getName(): " + object2.getName());
	System.out.println("ImmutableObjectsPractice -> immutableObject1() -> object3: " + object3);
	System.out.println("ImmutableObjectsPractice -> immutableObject1() -> object3.getName(): " + object3.getName());
    }

    /**
     * way 2 to create immutable object
     */
    @Ignore
    @Test
    public void method2() {
	ImmutableObject2 object = new ImmutableObject2(10);
	System.out.println("object: " + object);
	System.out.println("object.getValue(): " + object.getValue());

	object = object.add(20);
	System.out.println("object: " + object);
	System.out.println("object.getValue(): " + object.getValue());
    }
}
