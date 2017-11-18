package core.java.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import core.java.reflection.model.ReflectionModel1;
import core.java.reflection.model.ReflectionModel2;

public class ReflectionPractice {

	/**
	 * Create Class object if we know the class name at compile time
	 * 
	 * Output: classObject: class core.java.reflection.model.ReflectionModel
	 */
	@Test
	public void classObject() {
		Class<ReflectionModel1> classObject = ReflectionModel1.class;

		System.out.println("classObject: " + classObject);
	}

	/**
	 * Create Class object if we know fully packaged class name at run time
	 * 
	 * Output: classObject: class core.java.reflection.model.ReflectionModel1
	 */
	@Test
	public void classObject2() {
		try {
			Class<?> classObject = Class.forName("core.java.reflection.model.ReflectionModel1");
			System.out.println("classObject: " + classObject);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get Class object from actual object
	 * 
	 * Output: classObject: class core.java.reflection.model.ReflectionModel1
	 */
	@Test
	public void classObject3() {
		ReflectionModel1 reflectionModel1 = new ReflectionModel1();
		Class<?> classObject = reflectionModel1.getClass();
		System.out.println("classObject: " + classObject);
	}

	/**
	 * Create instance of a class where class has zero argument constructor
	 * 
	 * Output:
	 * classObject: class core.java.reflection.model.ReflectionModel1
	 * reflectionModel1: core.java.reflection.model.ReflectionModel1@6a41eaa2
	 */
	@Test
	public void createInstance() {
		try {
			Class<ReflectionModel1> classObject = ReflectionModel1.class;
			ReflectionModel1 reflectionModel1 = classObject.newInstance();
			System.out.println("classObject: " + classObject);
			System.out.println("reflectionModel1: " + reflectionModel1);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create instance of a class where class has argumented constructor
	 * 
	 * Output:
	 * classObject: class core.java.reflection.model.ReflectionModel2
	 * constructorObject: public core.java.reflection.model.ReflectionModel2(java.lang.String)
	 * reflectionModel2: core.java.reflection.model.ReflectionModel2@6a41eaa2, name: Jack
	 */
	@Test
	public void createInstance2() {
		try {
			Class<ReflectionModel2> classObject = ReflectionModel2.class;
			Constructor<ReflectionModel2> constructorObject = classObject.getConstructor(String.class);

			ReflectionModel2 reflectionModel2 = constructorObject.newInstance("Jack");

			System.out.println("classObject: " + classObject);
			System.out.println("constructorObject: " + constructorObject);
			System.out.println("reflectionModel2: " + reflectionModel2 + ", name: "
					+ reflectionModel2.getName());
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create instance of a class where class has argumented constructor and constructor is taking primitive int as argument
	 * 
	 * Output:
	 * classObject: class core.java.reflection.model.ReflectionModel2
	 * constructorObject: public core.java.reflection.model.ReflectionModel2(int)
	 * reflectionModel2: core.java.reflection.model.ReflectionModel2@6a41eaa2, number: 10
	 */
	@Test
	public void createInstance3() {
		try {
			Class<ReflectionModel2> classObject = ReflectionModel2.class;
			Constructor<ReflectionModel2> constructorObject = classObject.getConstructor(int.class);

			ReflectionModel2 reflectionModel2 = constructorObject.newInstance(10);

			System.out.println("classObject: " + classObject);
			System.out.println("constructorObject: " + constructorObject);
			System.out.println("reflectionModel2: " + reflectionModel2 + ", number: "
					+ reflectionModel2.getNumber());
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Calling a method with zero arguments
	 * 
	 * Output:
	 * ReflectionModel1.method1()
	 * klass: class core.java.reflection.model.ReflectionModel1
	 * reflectionModel1: core.java.reflection.model.ReflectionModel1@6a41eaa2
	 * methodObject: public void core.java.reflection.model.ReflectionModel1.method1()
	 */
	@Test
	public void callingMethodWithZeroArguments() {
		try {
			Class<ReflectionModel1> klass = ReflectionModel1.class;
			ReflectionModel1 reflectionModel1 = klass.newInstance();
			Method methodObject = klass.getMethod("method1");
			methodObject.invoke(reflectionModel1);

			System.out.println("klass: " + klass);
			System.out.println("reflectionModel1: " + reflectionModel1);
			System.out.println("methodObject: " + methodObject);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Calling method with String as argument
	 * 
	 * Output:
	 * Hello: Jack
	 * klass: class core.java.reflection.model.ReflectionModel1
	 * reflectionModel1: core.java.reflection.model.ReflectionModel1@6a41eaa2
	 * methodObject: public void core.java.reflection.model.ReflectionModel1.method2(java.lang.String)
	 */
	@Test
	public void callingMethodWithStringArgument() {
		try {
			Class<ReflectionModel1> klass = ReflectionModel1.class;
			ReflectionModel1 reflectionModel1 = klass.newInstance();
			Method methodObject = klass.getMethod("method2", String.class);
			methodObject.invoke(reflectionModel1, "Jack");

			System.out.println("klass: " + klass);
			System.out.println("reflectionModel1: " + reflectionModel1);
			System.out.println("methodObject: " + methodObject);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Call method with String array as argument
	 * 
	 * Output:
	 * Jack
	 * Jill
	 * John
	 * klass: class core.java.reflection.model.ReflectionModel1
	 * reflectionModel1: core.java.reflection.model.ReflectionModel1@1f36e637
	 * methodObject: public void core.java.reflection.model.ReflectionModel1.method3(java.lang.String[])
	 */
	@Test
	public void callingMethodWithStringArrayAsArgument() {
		try {
			Class<ReflectionModel1> klass = ReflectionModel1.class;
			ReflectionModel1 reflectionModel1 = klass.newInstance();
			Method methodObject = klass.getMethod("method3", Array.newInstance(String.class, 1).getClass());
			List<String> names = Arrays.asList("Jack", "Jill", "John");
			methodObject.invoke(reflectionModel1, new Object[] { names.toArray() });

			System.out.println("klass: " + klass);
			System.out.println("reflectionModel1: " + reflectionModel1);
			System.out.println("methodObject: " + methodObject);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get Super Class object of our class
	 * 
	 * Output:
	 * classObject: class core.java.reflection.model.ReflectionModel1
	 * superClassObject: class java.lang.Object
	 */
	@Test
	public void getSuperClass() {
		Class<ReflectionModel1> classObject = ReflectionModel1.class;
		Class<? super ReflectionModel1> superClassObject = classObject.getSuperclass();

		System.out.println("classObject: " + classObject);
		System.out.println("superClassObject: " + superClassObject);
	}

	/**
	 * Get interfaces implemented by class
	 */
	@Test
	public void getImplementedInterfaces() {
		Class<ReflectionModel1> classObject = ReflectionModel1.class;
		Class<?>[] interfaces = classObject.getInterfaces();

		Arrays.stream(interfaces).forEach(interfaceName -> {
			System.out.println(interfaceName.getName());
		});
	}

	/**
	 * Calling method whose argument List&lt;String&gt;
	 */
	@Test
	public void callingMethodWithStringListAsArgument() {
		try {
			Class<ReflectionModel1> klass = ReflectionModel1.class;
			ReflectionModel1 reflectionModel1 = klass.newInstance();
			Method method = klass.getMethod("method4", List.class);
			List<String> names = Arrays.asList("jack", "jill", "john");
			method.invoke(reflectionModel1, names);
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create String array instance
	 */
	@Test
	public void createStringArray() {
		try {
			Object stringArray = Array.newInstance(Class.forName("java.lang.String"), 3);
			Array.set(stringArray, 0, "jack");
			Array.set(stringArray, 1, "jill");
			Array.set(stringArray, 2, "john");

			System.out.println(Array.get(stringArray, 0));
			System.out.println(Array.get(stringArray, 1));
			System.out.println(Array.get(stringArray, 2));
		} catch (NegativeArraySizeException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}