package core.java.java8.type.references;

public class TypeReferenceValue<T> {

	public static <T> T method1(T t) {
		System.out.println("TypeReferenceValue.method1(): " + t);
		return t;
	}

	public T method2(T t) {
		System.out.println("TypeReferenceValue.method2(): " + t);
		return t;
	}
}