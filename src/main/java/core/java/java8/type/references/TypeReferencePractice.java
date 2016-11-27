package core.java.java8.type.references;

import org.junit.Test;

public class TypeReferencePractice {

    @Test
    public void method1() {
	// from java 8
	String result1 = TypeReferenceValue.method1("value1");
	// until java 7
	String result2 = TypeReferenceValue.<String> method1("value2");

	TypeReferenceValue<String> obj1 = new TypeReferenceValue<>();
	String result3 = obj1.method1("value3");
	String result4 = obj1.method2("value4");

	System.out.println("result1: " + result1 + ", result2: " + result2 + ", result3: " + result3 + ", result4: " + result4);
    }
}
