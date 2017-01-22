package core.java.java8.method.references;

import org.junit.Ignore;
import org.junit.Test;

import core.java.java8.interfaces.FunctionalInterface2;
import core.java.java8.interfaces.FunctionalInterface6;

public class MethodReferencesPractice {

    @Ignore
    @Test
    public void method1() {
	FunctionalInterface2 functionalInterface2 = MethodReferenceUtil::utilMethod1;
	String result1 = functionalInterface2.method3();
	System.out.println("result1: " + result1);
    }

    @Ignore
    @Test
    public void method2() {
	MethodReferenceUtil methodReferenceUtil = new MethodReferenceUtil();
	FunctionalInterface2 functionalInterface2 = methodReferenceUtil::utilMethod2;
	String result1 = functionalInterface2.method3();
	System.out.println("result1: " + result1);
    }

    @Ignore
    @Test
    public void method3() {
	MethodReferenceUtil methodReferenceUtil = new MethodReferenceUtil();
	FunctionalInterface6 functionalInterface6 = methodReferenceUtil::utilMethod3;
	String returnedValue = functionalInterface6.method1("Method", "Reference");
	System.out.println("returnedValue: " + returnedValue);
    }

}
