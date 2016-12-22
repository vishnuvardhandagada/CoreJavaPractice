package json.jackson.practice.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

public class PersonAnySetter {

	private Map<String, String>	properties	= new HashMap<>();

	@JsonAnySetter public void set(String fieldName, String fieldValue) {
		properties.put(fieldName, fieldValue);
	}

	public Map<String, String> get() {
		return properties;
	}

	@Override public String toString() {
		return properties.toString();
	}
}
