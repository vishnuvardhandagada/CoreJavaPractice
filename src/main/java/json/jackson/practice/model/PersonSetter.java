package json.jackson.practice.model;

import com.fasterxml.jackson.annotation.JsonSetter;

public class PersonSetter {

	private String	personId;
	private String	name;

	public String getPersonId() {
		return personId;
	}

	@JsonSetter(value = "id") public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override public String toString() {
		return "{persondID: " + personId + ", name: " + name + "}";
	}
}
