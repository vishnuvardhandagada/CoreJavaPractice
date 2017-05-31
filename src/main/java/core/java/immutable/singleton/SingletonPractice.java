package core.java.immutable.singleton;

import org.junit.Test;

import core.java.immutable.singleton.model.SingletonClass;
import core.java.immutable.singleton.model.SingletonClass2;

public class SingletonPractice {

	@Test
	public void method1() {
		SingletonClass obj1 = SingletonClass.getInstnace();
		System.out.println(obj1);

		SingletonClass obj2 = SingletonClass.getInstnace();
		System.out.println(obj2);
	}

	@Test
	public void method2() {
		SingletonClass2 obj1 = SingletonClass2.getInstance();
		System.out.println(obj1);

		SingletonClass2 obj2 = SingletonClass2.getInstance();
		System.out.println(obj2);
	}
}
