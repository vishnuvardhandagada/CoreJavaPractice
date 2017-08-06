package core.java.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Ignore;
import org.junit.Test;

public class MapPractice {

	@Ignore
	@Test
	public void sortMapByKeyMethod1() {
		Map<String, String> unsortedMap = new HashMap<>();
		unsortedMap.put("Z", "z");
		unsortedMap.put("Y", "y");
		unsortedMap.put("X", "x");
		unsortedMap.put("W", "w");
		unsortedMap.put("V", "v");
		unsortedMap.put("U", "u");
		unsortedMap.put("T", "t");
		unsortedMap.put("S", "s");
		unsortedMap.put("R", "r");
		System.out.println("unsortedMap: " + unsortedMap);

		Map<String, String> sortedMap = new TreeMap<>(unsortedMap);
		System.out.println("sortedMap: " + sortedMap);
	}

	@Ignore
	@Test
	public void sortMapByKeyWithComparator() {
		Map<Integer, String> unsortedMap = new HashMap<>();
		unsortedMap.put(31, "thirty one");
		unsortedMap.put(42, "forty two");
		unsortedMap.put(27, "twenty-seven");
		unsortedMap.put(20, "twenty");
		unsortedMap.put(5, "five");
		unsortedMap.put(100, "hundred");
		unsortedMap.put(10, "ten");
		System.out.println("unsortedMap: " + unsortedMap);

		// ascending order
		Map<Integer, String> ascendingSortedMap1 = new TreeMap<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return arg0.compareTo(arg1);
			}
		});
		ascendingSortedMap1.putAll(unsortedMap);
		System.out.println("sortMapByKeyWithComparator-> ascendingSortedMap1: " + ascendingSortedMap1);

		//ascending order from java 8
		Map<Integer, String> ascendingSortedMap2 = new TreeMap<>((arg0, arg1) -> {
			return arg0.compareTo(arg1);
		});
		ascendingSortedMap2.putAll(unsortedMap);
		System.out.println("sortMapByKeyWithComparator -> ascendingSortedMap2: " + ascendingSortedMap2);

		// descending order
		Map<Integer, String> descendingSortedMap1 = new TreeMap<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return arg1.compareTo(arg0);
			}
		});
		descendingSortedMap1.putAll(unsortedMap);
		System.out.println("sortMapByKeyWithComparator -> descendingSortedMap1: " + descendingSortedMap1);

		//descending order from java 8
		Map<Integer, String> descendingSortedMap2 = new TreeMap<>((arg0, arg1) -> {
			return arg1.compareTo(arg0);
		});
		descendingSortedMap2.putAll(unsortedMap);
		System.out.println("sortMapByKeyWithComparator -> descendingSortedMap2: " + descendingSortedMap2);
	}

	@Ignore
	@Test
	public void sortMapByValue() {
		Map<String, Integer> unsortedMap = new HashMap<>();
		unsortedMap.put("j", 65);
		unsortedMap.put("a", 24);
		unsortedMap.put("l", 32);
		unsortedMap.put("s", 27);
		unsortedMap.put("w", 15);
		unsortedMap.put("f", 20);
		System.out.println("sortMapByValue -> unsortedMap: " + unsortedMap);

		List<Map.Entry<String, Integer>> list1 = new ArrayList<>(unsortedMap.entrySet());
		Collections.sort(list1, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Map.Entry<String, Integer> arg0, Map.Entry<String, Integer> arg1) {
				return arg0.getValue().compareTo(arg1.getValue());
			}
		});

		Map<String, Integer> sortedMap1ByValue = new LinkedHashMap<>();
		for (Map.Entry<String, Integer> entry : list1) {
			sortedMap1ByValue.put(entry.getKey(), entry.getValue());
		}
		System.out.println("sortMapByValue -> sortedMap1ByValue: " + sortedMap1ByValue);

		// from java 8
		List<Map.Entry<String, Integer>> list2 = new ArrayList<>(unsortedMap.entrySet());
		Collections.sort(list2, (arg0, arg1) -> {
			return arg0.getValue().compareTo(arg1.getValue());
		});

		Map<String, Integer> sortedMap2ByValue = new LinkedHashMap<>();
		for (Map.Entry<String, Integer> entry : list1) {
			sortedMap2ByValue.put(entry.getKey(), entry.getValue());
		}
		System.out.println("sortMapByValue -> sortedMap2ByValue: " + sortedMap2ByValue);
	}

	/**
	 * Method to iterate map
	 */
	@Ignore
	@Test
	public void iterateMap() {
		Map<String, String> map = new HashMap<>();
		map.put("Z", "z");
		map.put("Y", "y");
		map.put("X", "x");

		//method 1
		System.out.println("--------- method1------------");
		Set<Map.Entry<String, String>> entries = map.entrySet();
		for (Map.Entry<String, String> entry : entries) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

		//method 2 from java 8
		System.out.println("------method 2 from java 8--------");
		map.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
	}

	/**
	 * Method to check whether key present in the map or not
	 */
	@Ignore
	@Test
	public void checkIfKeyExistsInMap() {
		Map<String, String> map = new HashMap<>();
		map.put("Z", "z");
		map.put("Y", "y");
		map.put("X", "x");

		System.out.println("map: " + map);

		System.out.println("checkIfKeyExistsInMap -> map.containsKey(\"Z\"): " + map.containsKey("Z"));
		System.out.println("checkIfKeyExistsInMap -> map.containsKey(\"z\"): " + map.containsKey("z"));
		System.out.println("checkIfKeyExistsInMap -> map.containsKey(\"A\"): " + map.containsKey("A"));
		System.out.println("checkIfKeyExistsInMap -> map.containsKey(\"a\"): " + map.containsKey("a"));
	}

	/**
	 * From JDK 8
	 */
	@Test
	public void getDefault() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "one");

		System.out.println(map.get(1));

		System.out.println(map.getOrDefault(0, "No mapping Found"));
	}

	/**
	 * Create HashMap
	 */
	@Test
	public void createHashMap() {
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			map.put("" + i, "value" + i);
		}
		System.out.println("map: " + map);
	}

	/**
	 * Get All Keys
	 */
	@Test
	public void getAllKeys() {
		Map<Integer, String> map = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			map.put(i, "value" + i);
		}
		Set<Integer> keys = map.keySet();
		System.out.println("keys: " + keys);
	}

	/**
	 * Get All Values
	 */
	@Test
	public void getAllValues() {
		Map<Integer, String> map = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			map.put(i, "value" + i);
		}
		Collection<String> values = map.values();
		System.out.println("values: " + values);
	}
}