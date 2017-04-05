package core.java.java8.base64;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.junit.Ignore;
import org.junit.Test;

/**
 * java.util.Base64 encoding/decoding practice
 * @author Avinash Babu Donthu
 *
 */
public class Base64EncodeDecodePractice {

	@Ignore
	@Test
	public void method1() {
		final String testSting = "Let's encode @ password";

		String encodedString1 = Base64.getEncoder().encodeToString(testSting.getBytes());
		System.out.println("encodedString1: " + encodedString1);

		String decodedString1 = new String(Base64.getDecoder().decode(encodedString1));
		System.out.println("decodedString1: " + decodedString1);

		String encodedString2 = Base64.getEncoder()
				.encodeToString(testSting.getBytes(StandardCharsets.UTF_8));
		System.out.println("encodedString2: " + encodedString2);

		String decodedString2 = new String(Base64.getDecoder().decode(encodedString2), StandardCharsets.UTF_8);
		System.out.println("decodedString2: " + decodedString2);
	}
}
