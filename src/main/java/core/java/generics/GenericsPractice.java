package core.java.generics;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import core.java.generics.model.GenericModel1;
import core.java.generics.model.GenericSubClass;
import core.java.generics.model.GenericSuperClass;

public class GenericsPractice {

	/**
	 * Create object of a class which has generic
	 */
	@Test
	public void method1() {
		// String as generic type
		GenericModel1<String> stringGenericModel = new GenericModel1<String>();
		stringGenericModel.method1("jack");
		stringGenericModel.method2("jack");

		// String as generic type - from JDK 7 - right side no need to declare generic
		GenericModel1<String> stringGenericModel2 = new GenericModel1<>();
		stringGenericModel2.method1("jill");
		stringGenericModel2.method2("jill");

		// Integer as generic type
		GenericModel1<Integer> integerGenricModel = new GenericModel1<>();
		integerGenricModel.method1(10);
		integerGenricModel.method2(20);
	}

	/**
	 * calling method which has generic
	 */
	@Test
	public void method3() {
		GenericModel1<String> genericModel1 = new GenericModel1<>();

		genericModel1.method3(10, "jack");
		genericModel1.method3("jill", "john");
	}

	/**
	 * calling static method which has generic
	 */
	@Test
	public void method4() {
		// until JDK 7
		String result1 = GenericModel1.<String> method4("jack");
		System.out.println("result: " + result1);

		// until JDK 8
		String result2 = GenericModel1.method4("jill");
		System.out.println("result2: " + result2);
	}

	/**
	 * Bounded wild cards
	 */
	@Test
	public void method5() {
		GenericModel1<String> genericModel1 = new GenericModel1<>();

		GenericSuperClass genericSuperClass = new GenericSuperClass();
		GenericSuperClass genericSuperClass2 = genericModel1.method5(genericSuperClass);
		System.out.println("genericSuperClass: " + genericSuperClass + ", genericSuperClass2: " + genericSuperClass2);

		GenericSubClass genericSubClass = new GenericSubClass();
		GenericSubClass genericSubClass2 = genericModel1.method5(genericSubClass);
		System.out.println("genericSubClass: " + genericSubClass + ", genericSubClass2: " + genericSubClass2);
	}

	/**
	 * wild cards
	 */
	@Test
	public void method6() {
		GenericModel1<String> genericModel1 = new GenericModel1<>();

		List<String> names = Arrays.asList("jack", "jill", "john", "sam", "kom", "mill", "scott", "matt");
		genericModel1.method6(names);

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		genericModel1.method6(numbers);
	}

}