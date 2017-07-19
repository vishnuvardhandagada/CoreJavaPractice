package core.java.regex;

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
}
