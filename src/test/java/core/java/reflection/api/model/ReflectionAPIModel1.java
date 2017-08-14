package core.java.reflection.api.model;

import java.util.Arrays;

public class ReflectionAPIModel1 {

	public void method1(String arg1) {
		System.out.println("method1 argument: " + arg1);
	}

	public void method2(String[] arg1) {
		Arrays.stream(arg1).forEach(System.out::println);
	}
}