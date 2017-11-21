package core.java.reflection.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ReflectionModel1 extends Object implements Serializable, IReflection3 {

	private static final long serialVersionUID = -2693156947838409146L;

	public void method1() {
		System.out.println("ReflectionModel1.method1()");
	}

	public void method2(String name) {
		System.out.println("Hello: " + name);
	}

	public void method3(String[] names) {
		Arrays.stream(names).forEach(System.out::println);
	}

	public void method4(List<String> names) {
		names.stream().forEach(System.out::println);
	}

	public void method5(Integer arg0, String arg1, List<String> list, Map<String, String> map) {
		System.out.println("ReflecitonModel1.method5");
	}

}