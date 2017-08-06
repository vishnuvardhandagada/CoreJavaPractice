package core.java.collections;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class SetPractice {

	/**
	 * Iterate set
	 */
	@Test
	public void iterateSet() {
		Set<String> set = new HashSet<>();

		for (int i = 0; i < 10; i++) {
			set.add("value" + i);
		}

		set.stream().forEach(System.out::println);
	}
}