package core.java.java8.interfaces.impl;

import org.junit.Test;

import core.java.java8.interfaces.DefaultStaticInterfaceMethods;

public class DefaultStaticInterfaceMethodsImpl implements DefaultStaticInterfaceMethods {

	public static void main(String[] args) {
		DefaultStaticInterfaceMethods defaultStaticInterfaceMethods = new DefaultStaticInterfaceMethodsImpl();

		String method1 = DefaultStaticInterfaceMethods.method1();
		String method2 = defaultStaticInterfaceMethods.method2();

		System.out.println("method1: " + method1);
		System.out.println("method2: " + method2);
	}

	@Test
	public void test() {
		String method2WithSuper = DefaultStaticInterfaceMethods.super.method2();
		System.out.println("method2WithSuper: " + method2WithSuper);
	}

}