package core.java.generics.model;

import java.util.List;

public class GenericModel1<T> {

	public void method1(T t) {
		System.out.println("GenericMode<" + t.getClass().getName() + ">.method1(" + t + ")");
	}

	public T method2(T t) {
		System.out.println("GenericModel.method2: " + (t instanceof Integer));
		return t;
	}

	public <S> S method3(S s, T t) {
		System.out.println("GenericModel.method3:s " + s + ", t: " + t);
		return s;
	}

	public static <T> T method4(T t) {
		System.out.println("GenericModel1.method4: " + t);
		return t;
	}

	public <S extends GenericSuperClass> S method5(S s) {
		System.out.println("GenericModel1.method5: " + s.getClass().getName());
		return s;
	}

	public void method6(List<?> list) {
		System.out.println(list);
	}
}