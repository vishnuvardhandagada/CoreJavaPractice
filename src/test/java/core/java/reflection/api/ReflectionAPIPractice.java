package core.java.reflection.api;

import java.lang.reflect.Array;
import java.lang.reflect.Method;

import org.junit.Test;

public class ReflectionAPIPractice {

	@Test
	public void method1() {
		try {
			Class<?> klass = Class.forName("core.java.reflection.api.model.ReflectionAPIModel1");
			System.out.println(klass);

			Method method1 = klass.getMethod("method1", String.class);
			System.out.println(method1);
			method1.invoke(klass.newInstance(), "Hello Reflection API");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void method2() {
		try {
			Class<?> klass = Class.forName("core.java.reflection.api.model.ReflectionAPIModel1");
			System.out.println(klass);

			Method method2 = klass.getMethod("method2", Array.newInstance(String.class, 1).getClass());
			System.out.println(method2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
