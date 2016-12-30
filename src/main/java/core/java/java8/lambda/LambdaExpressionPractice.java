package core.java.java8.lambda;

import org.junit.Ignore;
import org.junit.Test;

import core.java.java8.interfaces.FunctionalInterface1;
import core.java.java8.interfaces.FunctionalInterface2;
import core.java.java8.interfaces.FunctionalInterface3;

public class LambdaExpressionPractice {

    @Ignore
    @Test
    public void functionalInterface1() {
	FunctionalInterface1 functionalInterface1 = () -> {
	    System.out.println("LambdaExpressionPractice.method1()");
	};
	functionalInterface1.method1();
    }

    @Ignore
    @Test
    public void functionalInterface2() {
	FunctionalInterface2 functionalInterface2 = () -> {
	    System.out.println("LambdaExpressionPractice.functionalInterfac2()");
	    return "FunctionalInterface2.method3() implementation";
	};

	String method1 = FunctionalInterface2.method1();
	String method2 = functionalInterface2.method2();
	String method3 = functionalInterface2.method3();

	System.out.println("method1: " + method1 + ", method2: " + method2 + ", method3: " + method3);
    }

    @Ignore
    @Test
    public void functionalInterface3() {
	// syntax 1
	FunctionalInterface3 obj1 = (name1, name2) -> {
	    System.out.println("name1: " + name1 + ", name2: " + name2);
	};
	obj1.method1("Ramesh", "Mahesh");

	// syntax 2
	FunctionalInterface3 obj2 = (String name1, String name2) -> {
	    System.out.println("name1: " + name1 + ", name2: " + name2);
	};
	obj2.method1("Naresh", "Suresh");
    }
}