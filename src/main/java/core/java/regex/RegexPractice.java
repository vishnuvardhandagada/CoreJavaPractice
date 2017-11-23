package core.java.regex;

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
	public void fetchTenantIdFromDn() {
		String dn = "CN%3Dmanju%40o1connect4.com%2COU%3Do1connect4%2COU%3DQANetworks%2CDC%3Doperativeone%2CDC%3Dcom";
		String ou = null;
		Pattern pattern = Pattern.compile("ou=(.*?),");
		Matcher matcher = pattern.matcher(dn.toLowerCase());

		if (matcher.find()) {
			ou = matcher.group();
		}
		String result = ou.substring(3, ou.length() - 1);
		System.out.println(result);
	}
}
