package core.java.java8.constructor.references;

import org.junit.Ignore;
import org.junit.Test;

import core.java.java8.interfaces.FunctionalInterface1;
import core.java.java8.interfaces.FunctionalInterface3;
import core.java.java8.interfaces.FunctionalInterface4;
import core.java.java8.interfaces.FunctionalInterface5;

public class ConstructorReferencePractice {

	@Ignore
	@Test
	public void method1() {
		FunctionalInterface1 functionalInterface1 = ConstructorReferenceUtil1::new;
		functionalInterface1.method1();

		FunctionalInterface3 functionalInterface3 = ConstructorReferenceUtil1::new;
		functionalInterface3.method1("Ramesh", "Mahesh");
	}

	@Ignore
	@Test
	public void method2() {
		// functional interface is not generic but constructor class is generic
		FunctionalInterface1 obj1 = ConstructorReferenceUtil2<String>::new;
		obj1.method1();

		// functional interface is not generic but constructor class is generic
		FunctionalInterface1 obj2 = ConstructorReferenceUtil2::new;
		obj2.method1();

		// functional interface is generic but constructor class is generic
		FunctionalInterface4<String> obj3 = ConstructorReferenceUtil2<String>::new;
		obj3.method1();

		// functional interface is generic but constructor class is generic
		FunctionalInterface5<String> obj4 = ConstructorReferenceUtil2<String>::new;
		obj4.method1("Ramesh", "Mahesh");
	}
}
