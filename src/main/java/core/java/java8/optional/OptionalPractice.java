package core.java.java8.optional;

import java.util.Optional;

public class OptionalPractice {

    public static void main(String[] args) {
	OptionalPractice optionalPractice = new OptionalPractice();
	optionalPractice.method1(null);
	optionalPractice.method1("Ramesh");
    }

    public void method1(String arg0) {
	Optional<String> fullName = Optional.ofNullable(arg0);
	boolean isNotNull = fullName.isPresent();
	String defaultValue = fullName.orElseGet(() -> "Default Value");
	String passedValue = fullName.map((i) -> "Hey " + i).orElse(" Null Value passed");

	System.out.println("isNotNull: " + isNotNull);
	System.out.println("defaultValue: " + defaultValue);
	System.out.println("passedValue: " + passedValue);
    }
}