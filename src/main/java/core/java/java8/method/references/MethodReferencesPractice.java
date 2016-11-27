package core.java.java8.method.references;

import org.junit.Ignore;
import org.junit.Test;

import core.java.java8.interfaces.FunctionalInterface2;

public class MethodReferencesPractice {

    @Ignore
    @Test
    public void method1() {
	FunctionalInterface2 functionalInterface2 = MethodReferenceUtil::utilMethod1;
	String result1 = functionalInterface2.method3();
	System.out.println("result1: " + result1);
    }

    @Test
    public void method2() {
	MethodReferenceUtil methodReferenceUtil = new MethodReferenceUtil();
	FunctionalInterface2 functionalInterface2 = methodReferenceUtil::utilMethod2;
	String result1 = functionalInterface2.method3();
	System.out.println("result1: " + result1);
    }
}
