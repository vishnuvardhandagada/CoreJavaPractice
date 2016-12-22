package json.jackson.practice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonJsonCreator {

	private Long	id;
	private String	name;

	@JsonCreator public PersonJsonCreator(@JsonProperty(value = "id") Long id, @JsonProperty(value = "name") String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override public String toString() {
		return "{id: " + id + ", name: " + name + "}";
	}
}
