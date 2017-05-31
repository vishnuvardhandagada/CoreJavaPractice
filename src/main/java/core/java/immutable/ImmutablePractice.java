package core.java.immutable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import core.java.immutable.model.ImmutableModel;

public class ImmutablePractice {

	@Test
	public void immutable() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		ImmutableModel immutableModel = new ImmutableModel("testName", 23, Arrays.asList("1", "2"),
				new HashSet<>(Arrays.asList("1", "2")), map);
		System.out.println(immutableModel);
		List<String> list = immutableModel.getList();
		list.add("3"); // java.lang.UnsupportedOperationException
	}
}
