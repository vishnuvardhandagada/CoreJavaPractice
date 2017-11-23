package core.java;

import java.rmi.server.UID;
import java.util.Random;
import java.util.UUID;

import org.junit.Test;

public class RandomNumberPractice {

	/**
	 * Using Math class
	 */
	@Test
	public void method1() {
		double value1 = Math.random() * 7;
		System.out.println(value1);

		int value2 = (int) value1;
		System.out.println(value2);
	}

	/**
	 * Using Random class
	 */
	@Test
	public void method2() {
		Random random = new Random();

		int randomInt = random.nextInt(50);
		float randomFloat = random.nextFloat() * 7;
		double randomDouble = random.nextDouble() * 7.5;

		System.out.println("randomInt: " + randomInt + ", randomFloat: " + randomFloat + ", randomDouble: "
				+ randomDouble);
	}

	/**
	 * Using Random class - JDK 8
	 */
	@Test
	public void method3() {
		Random random = new Random();

		// ints(min, max-exclusive) 
		int randomInt = random.ints(10, 25).findFirst().getAsInt();
		System.out.println(randomInt);
	}

	/**
	 * Generates random integers in a range between 15 (inclusive) and 35 (exclusive), with stream size of 10. 
	 * And print out the items with forEach
	 */
	@Test
	public void method4() {
		new Random().ints(10, 15, 35).forEach(System.out::println);
	}

	/**
	 * from Java 5 onwards - using {@link UUID} class
	 */
	@Test
	public void method5() {
		UUID uuid1 = UUID.randomUUID();
		UUID uuid2 = UUID.randomUUID();

		System.out.println(uuid1);
		System.out.println(uuid2);
	}

	/**
	 * using {@link UID} class
	 */
	@Test
	public void method6() {
		UID uid = new UID();
		System.out.println(uid);
	}
}