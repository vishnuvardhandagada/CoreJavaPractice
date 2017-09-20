package core.java.java8.optional;

import java.util.Optional;

public class OptionalPractice {

	public static void main(String[] args) {
		OptionalPractice optionalPractice = new OptionalPractice();

		System.out.println("--- calling method1 with String value: Jack");
		optionalPractice.method1("Jack");
		System.out.println("--- calling method1 with null value");
		optionalPractice.method1(null);
	}

	public void method1(String arg0) {
		// null value
		Optional<String> fullName = Optional.ofNullable(null);

		boolean isNotNull = fullName.isPresent();
		System.out.println("isNotNull: " + isNotNull);

		String defaultValue = fullName.orElseGet(() -> "Default Value");
		System.out.println("defaultValue: " + defaultValue);

		String passedValue = fullName.map((i) -> "Hey " + i).orElse(" Null Value passed");
		System.out.println("passedValue: " + passedValue);

		// non null value
		Optional<String> fullName2 = Optional.ofNullable(arg0);

		boolean isNotNull2 = fullName2.isPresent();
		System.out.println("isNotNull: " + isNotNull2);

		String defaultValue2 = fullName2.orElseGet(() -> "Default Value");
		System.out.println("defaultValue: " + defaultValue2);

		String passedValue2 = fullName2.map((i) -> "Hey " + i).orElse(" Null Value passed");
		System.out.println("passedValue: " + passedValue2);
	}
}