package core.java.java8.interfaces.impl;

import core.java.java8.interfaces.FunctionalInterface2;

public class FunctionalInterface2Impl2 implements FunctionalInterface2 {

    @Override
    public String method3() {
	System.out.println("FunctionalInterface2Impl2.method3() called");
	return "method3()";
    }

    @Override
    public String method2() {
	System.out.println("FunctionalInterface2Impl2.method2() called");
	return "method2()";
    }

    public static void main(String[] args) {
	FunctionalInterface2 functionalInterface2 = new FunctionalInterface2Impl2();

	String method1 = FunctionalInterface2.method1();
	String method2 = functionalInterface2.method2();
	String method3 = functionalInterface2.method3();

	System.out.println("method1: " + method1 + ", method2: " + method2 + ", method3: " + method3);
    }
}
