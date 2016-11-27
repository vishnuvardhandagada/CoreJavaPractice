package core.java.java8.paramter.names;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.junit.Ignore;
import org.junit.Test;

public class ParameterNamesPractice {

    public static void main(String[] args) {
	ParameterNamesPractice parameterNamesPractice = new ParameterNamesPractice();
	parameterNamesPractice.method1();
	parameterNamesPractice.method2();
    }

    @Ignore
    @Test
    public void method1() {
	try {
	    Method method = ParameterNamesUtil.class.getMethod("method1");
	    Parameter[] parameters = method.getParameters();
	    System.out.println("parameters.length: " + parameters.length);
	    for (Parameter parameter : parameters) {
		System.out.println(parameter.getName());
	    }
	} catch (NoSuchMethodException | SecurityException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void method2() {
	try {
	    Method method = ParameterNamesUtil.class.getMethod("method2", String.class, String.class);
	    Parameter[] parameters = method.getParameters();
	    System.out.println("parameters.length: " + parameters.length);
	    for (Parameter parameter : parameters) {
		System.out.println("parameter.isNamePresent(): " + parameter.isNamePresent() + ", parameter.getName: " + parameter.getName());
	    }
	} catch (NoSuchMethodException | SecurityException e) {
	    e.printStackTrace();
	}
    }
}