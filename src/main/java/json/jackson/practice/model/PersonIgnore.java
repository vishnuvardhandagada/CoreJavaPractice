package json.jackson.practice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PersonIgnore {

	@JsonIgnore private Long	id;
	private String	         name;

	public PersonIgnore(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public PersonIgnore() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
