package core.java;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

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

}
