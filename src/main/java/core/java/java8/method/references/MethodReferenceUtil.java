package core.java.java8.method.references;

public class MethodReferenceUtil {

    public static String utilMethod1() {
	System.out.println("MethodReferenceUtil.utilMethod1()");
	return "utilMethod1()";
    }

    public String utilMethod2() {
	System.out.println("MethodReferenceUtil.utilMethod2()");
	return "utilMethod2()";
    }

    public String utilMethod3(String value1, String value2) {
	System.out.println("value1: " + value1 + ", value2: " + value2);
	return value1 + value2;
    }
}
