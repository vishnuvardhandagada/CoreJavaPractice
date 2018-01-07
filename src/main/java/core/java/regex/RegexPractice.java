package core.java.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegexPractice {

	/**
	 * ^[a-zA-Z0-9]*$ <br/> Regular expression for Alpha numeric<br/><br/>
	 * 
	 * ^ -&gt; Start of string <br/>
	 * [a-zA-Z0-9]* -&gt; multiple characters to include <br/>
	 * $ -&gt; End of string
	 */
	@Test
	public void isAlphaNumeric() {
		String pattern = "^[a-zA-Z0-9]*$";

		System.out.println("pattern: " + pattern);
		System.out.println("\"abc\".matches(pattern): " + "abc".matches(pattern));
		System.out.println("\"abc123\".matches(pattern): " + "abc123".matches(pattern));
		System.out.println("\"abc@12#def&\".matches(pattern): " + "abc@12#def&".matches(pattern));
		System.out.println("\"abc def\".matches(pattern): " + "abc def".matches(pattern));
	}

	@Test
	public void singleCharacter() {
		// method 1
		Pattern pattern = Pattern.compile(".s"); // .(dot) represents single character
		Matcher m = pattern.matcher("as");
		boolean value1 = m.matches();
		System.out.println("value1: " + value1); // value1: true

		// method 2
		boolean value2 = Pattern.compile(".s").matcher("as").matches();
		System.out.println("value2: " + value2); // value2: true

		// method 3
		boolean value3 = Pattern.matches(".s", "as");
		System.out.println("value3: " + value3); // value3: true

		boolean value4 = Pattern.matches(".s", "abs");
		System.out.println("value4: " + value4); // value4: false
	}

	@Test
	public void method1() {
		System.out.println(Pattern.matches("[adf]", "a")); // true
		System.out.println(Pattern.matches("[adf]", "abc")); // false
	}

	@Test
	public void quantifiers() {
		System.out.println("? quantifier");
		System.out.println(Pattern.matches("[abc]?", "a")); // true
		System.out.println(Pattern.matches("[abc]?", "aa")); // false
		System.out.println(Pattern.matches("[abc]?", "abcabc")); // false
		System.out.println(Pattern.matches("[abc]?", "abc")); // false. a or b or c must occur only once

		System.out.println("+ quantifier");
		System.out.println(Pattern.matches("[abc]+", "a")); // true
		System.out.println(Pattern.matches("[abc]+", "abc")); // true
		System.out.println(Pattern.matches("[abc]+", "abde")); // false. d and e are not matching pattern

		System.out.println("* quantifier");
		System.out.println(Pattern.matches("[abc]*", "a")); // true
		System.out.println(Pattern.matches("[abc]*", "abc")); // true
		System.out.println(Pattern.matches("[abc]*", "abcabc")); // true
	}

	@Test
	public void regexMetaCharacters() {
		System.out.println("d metacharacter");
		System.out.println(Pattern.matches("\\d", "1")); // true
		System.out.println(Pattern.matches("\\d", "a")); // false
		System.out.println(Pattern.matches("\\d", "abc")); // false
		System.out.println(Pattern.matches("\\d", "123")); // false
		System.out.println(Pattern.matches("\\d", "123abc")); // false

		System.out.println("D metacharacter");
		System.out.println(Pattern.matches("\\D", "1")); // false
		System.out.println(Pattern.matches("\\D", "a")); // true
		System.out.println(Pattern.matches("\\D", "abc")); // false
		System.out.println(Pattern.matches("\\D", "123")); // false
		System.out.println(Pattern.matches("\\D", "123abc")); // false
		System.out.println(Pattern.matches("\\D*", "abc")); // true - non-digit 0 or more times
	}

	@Test
	public void finder() {
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				System.out.println("Enter regex pattern: ");
				Pattern pattern = Pattern.compile(scanner.nextLine());
				System.out.println("Enter text: ");
				Matcher matcher = pattern.matcher(scanner.nextLine());
				boolean found = false;
				while (matcher.find()) {
					System.out.println("Found the text \"" + matcher.group() + "\" starting at index: "
							+ matcher.start() + " and ending at index: " + matcher.end());
					found = true;
				}

				if (!found) {
					System.out.println("No match found");
				}
			}
		}
	}
}