package core.java;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @see String class practice
 * @author Avinash Babu Donthu
 *
 */
public class StringPractice {

	/**
	 * Method to get byte array from String
	 */
	@Ignore
	@Test
	public void getbyteArrayFromString() {
		String string = "Hello World";

		// method 1
		byte[] byteArray1 = string.getBytes();
		System.out.println("byteArray1: " + byteArray1);
		System.out.println("Arrays.toString(byteArray1): " + Arrays.toString(byteArray1));

		//method 2
		byte[] byteArray2 = string.getBytes(Charset.forName("UTF-8"));
		System.out.println("byteArray2: " + byteArray2);
		System.out.println("Arrays.toString(byteArray2): " + Arrays.toString(byteArray2));

		// method 3 - from java 7
		byte[] byteArray3 = string.getBytes(StandardCharsets.UTF_8);
		System.out.println("byteArray3: " + byteArray3);
		System.out.println("Arrays.toString(byteArray3): " + Arrays.toString(byteArray3));
	}

	/**
	 * Method to get asci value of each character in a String
	 */
	@Ignore
	@Test
	public void getAsciValueOfCharsInString() {
		String str = "abcdefghijklmnopqrstuvwxyz";
		byte[] strByteArray = str.getBytes(StandardCharsets.UTF_8);
		System.out.println("asciValues: " + Arrays.toString(strByteArray));
	}

	/**
	 * convert byte array back to string
	 */
	@Ignore
	@Test
	public void convertByteArrayToString() {
		String str = "Hello World";
		byte[] byteArray = str.getBytes();
		System.out.println("str: " + str);
		System.out.println("byteArray: " + byteArray);

		String strFromByteArray = new String(byteArray);
		System.out.println("strFromByteArray: " + strFromByteArray);
	}

	/**
	 * convert String to byte array and get each character from that byte array
	 */
	//    @Ignore
	@Test
	public void convertStringToCharArray() {
		String str = "Hello World";
		byte[] byteArray = str.getBytes();
		String byteString = Arrays.toString(byteArray);
		System.out.println(byteString);

		byteString = byteString.substring(1, byteString.length() - 1);
		System.out.println(byteString);

		String[] asciValues = byteString.split(",");

		List<String> charsList = new ArrayList<>();

		for (String asciValue : asciValues) {
			String c = String.valueOf((char) Integer.parseInt(asciValue.trim()));
			charsList.add(c);
		}

		System.out.println(charsList);
	}

	/**
	 * divide string based on delimeter
	 */
	@Test
	public void divideString() {
		String str = "Hello-Java-World-Welcome-to-Java";
		String[] strs = str.split("-");

		for (String s : strs) {
			System.out.println(s);
		}

		// using StringTokenizer
		System.out.println("------- Using StringTokenizer -------- ");
		StringTokenizer stringTokenizer = new StringTokenizer(str, "-");
		for (;; stringTokenizer.hasMoreTokens()) {
			System.out.println(stringTokenizer.nextToken());
		}
	}

	@Test
	public void stringSubString() {
		String str = "Hello World";

		String substr1 = str.substring(6);
		String substr2 = str.substring(0, 6);

		System.out.println("substr1: " + substr1 + ", substr2: " + substr2);
	}

	@Test
	public void convertCase() {
		String str = "hello world";
		String capitalStr = str.toUpperCase();
		System.out.println("capitalStr: " + capitalStr);

		String lowerStr = capitalStr.toLowerCase();
		System.out.println("lowerStr: " + lowerStr);
	}

	@Ignore
	@Test
	public void capitalizeFirstChar() {
		String hello = "hello";

		String result = hello.substring(0, 1).toUpperCase() + hello.substring(1, hello.length());
		System.out.println(result);
	}

	@Ignore
	@Test
	public void stringShift() {
		String s = "abcd";
		if (s.isEmpty()) {
			return;
		}
		int leftShift = 1;
		while (leftShift > s.length()) {
			leftShift = leftShift - s.length();
		}
		String leftShiftResult = s.substring(leftShift) + s.substring(0, leftShift);
		System.out.println(leftShiftResult);

		int rightShift = 3;
		int length = 0;
		if (leftShiftResult.length() > rightShift)
			length = leftShiftResult.length() - rightShift;
		else
			length = rightShift - leftShiftResult.length();

		String rightShiftResult = leftShiftResult.substring(length) + leftShiftResult.substring(0, length);
		System.out.println(rightShiftResult);

	}

	@Ignore
	@Test
	public void printAllSubStringsOfSpecifiedLength() {
		String s = "welcometojava";

		// substring of length 3
		List<String> subStrings = new ArrayList<>();
		for (int i = 0; i <= s.length() - 3; i++) {
			subStrings.add(s.substring(i, i + 3));
		}
		System.out.println(subStrings);

		// substring of length 4
		List<String> subStrings2 = new ArrayList<>();
		for (int i = 0; i <= s.length() - 4; i++) {
			subStrings2.add(s.substring(i, i + 4));
		}
		System.out.println(subStrings2);

		// substring of length 5
		List<String> subStrings3 = new ArrayList<>();
		for (int i = 0; i <= s.length() - 5; i++) {
			subStrings3.add(s.substring(i, i + 5));
		}
		System.out.println(subStrings3);
	}

	@Test
	public void test() {
		String s = "He is a very very good boy, isn't he?";
		s = s.replaceAll("!", " ");
		System.out.println(s);
		s = s.replaceAll(",", " ");
		System.out.println(s);
		s = s.replaceAll("\\?", " ");
		System.out.println(s);
		s = s.replaceAll("\\.", " ");
		System.out.println(s);
		s = s.replaceAll("_", " ");
		s = s.replaceAll("'", " ");
		System.out.println(s);
		s = s.replaceAll("@", " ");

		System.out.println(s);
		StringTokenizer str = new StringTokenizer(s, " ");

		System.out.println("str.countTokens(): " + str.countTokens());
		while (str.hasMoreTokens()) {
			System.out.println(str.nextToken());
		}
	}

	@Test
	public void sortStringsInSentnceByLength() {
		String str = "Welcome to hacker rank test";
		String[] strs = str.split(" ");

		List<String> strList = Arrays.asList(strs);

		System.out.println("strList: " + strList);

		Comparator<String> lengthComparator = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return Integer.valueOf(o1.length()).compareTo(Integer.valueOf(o2.length()));
			}
		};

		Collections.sort(strList, lengthComparator);
		System.out.println("sort by length: " + strList);
	}

}