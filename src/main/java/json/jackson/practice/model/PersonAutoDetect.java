package json.jackson.practice.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY) public class PersonAutoDetect {

	private Long	id	= 123L;
	private String	name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override public String toString() {
		return "{id: " + id + ", name: " + name + "}";
	}
}
