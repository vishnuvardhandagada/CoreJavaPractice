package core.java.collections;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;

public class LinkedHashMapPractice {

    /**
     * Add elements to java.util.LinkedHashMap
     */
    @Ignore
    @Test
    public void addElementToLinkedHashMap() {
	Map<String, String> linkedHashMap = new LinkedHashMap<>();
	linkedHashMap.put("one", "1");
	linkedHashMap.put("two", "2");
	linkedHashMap.put("three", "3");
	linkedHashMap.put("four", "4");
	linkedHashMap.put("five", "5");

	System.out.println("linkedHashMap: " + linkedHashMap);
    }

    /**
     * Remove elements from java.util.LinkedHashMap
     */
    @Ignore
    @Test
    public void removeElementToLinkedHashMap() {
	Map<String, String> linkedHashMap = new LinkedHashMap<>();
	linkedHashMap.put("one", "1");
	linkedHashMap.put("two", "2");
	linkedHashMap.put("three", "3");
	linkedHashMap.put("four", "4");
	linkedHashMap.put("five", "5");

	System.out.println("1 -> linkedHashMap: " + linkedHashMap);

	// delete first element
	linkedHashMap.remove("one");
	System.out.println("2 -> linkedHashMap: " + linkedHashMap);

	// delete middle element
	linkedHashMap.remove("three");
	System.out.println("3 -> linkedHashMap: " + linkedHashMap);
    }

    /**
     * Iterate java.util.LinkedHashMap
     */
    @Ignore
    @Test
    public void iterateLinkedHashMap() {
	Map<String, String> linkedHashMap = new LinkedHashMap<>();
	linkedHashMap.put("one", "1");
	linkedHashMap.put("two", "2");
	linkedHashMap.put("three", "3");
	linkedHashMap.put("four", "4");
	linkedHashMap.put("five", "5");

	// method 1 - using entrySet
	Set<Map.Entry<String, String>> entries = linkedHashMap.entrySet();
	for (Map.Entry<String, String> entry : entries) {
	    System.out.println(entry.getKey() + ", " + entry.getValue());
	}

	//method 2 from java 8
	System.out.println("----------------------------");
	linkedHashMap.forEach((key, value) -> {
	    System.out.println(key + " : " + value);
	});
    }
}
