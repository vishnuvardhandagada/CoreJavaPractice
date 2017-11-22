package core.java.generics.model;

public class GenericModel1<T> {

	public void method1(T t) {
		System.out.println("GenericMode<" + t.getClass() + ">.method1(" + t + ")");
	}

	public T method2(T t) {
		System.out.println("GenericModel.method2: " + (t instanceof Integer));
		return t;
	}
}
