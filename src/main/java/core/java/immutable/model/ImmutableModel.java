package core.java.immutable.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 1. Instantiate object using constructor. Do not provide any setters that can change object values
 * 2. If class contains collections, return immutable collection on calling getter so that collection cannot be modified
 * @author Avinash Babu Donthu
 *
 */
public class ImmutableModel {

	private String name;
	private Integer age;
	private List<String> list;
	private Set<String> set;
	private Map<Integer, String> map;

	public ImmutableModel(String name, Integer age, List<String> list, Set<String> set,
			Map<Integer, String> map) {
		this.name = name;
		this.age = age;
		this.list = list;
		this.set = set;
		this.map = map;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public List<String> getList() {
		return Collections.unmodifiableList(list);
	}

	public Set<String> getSet() {
		return Collections.unmodifiableSet(set);
	}

	public Map<Integer, String> getMap() {
		return Collections.unmodifiableMap(map);
	}

}