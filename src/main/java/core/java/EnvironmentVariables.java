package core.java;

import java.util.Map;
import java.util.Properties;

public class EnvironmentVariables {

	public static void main(String[] args) {
		// give VM arguments: -Dvalue1=hello
		String value1 = System.getProperty("value1");
		System.out.println("value1: " + value1);

		// gets PATH information
		Map<String, String> envMap = System.getenv();
		System.out.println(envMap);

		// get all properties
		Properties properties = System.getProperties();
		System.out.println(properties);
	}
}