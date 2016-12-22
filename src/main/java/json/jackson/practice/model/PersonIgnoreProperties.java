package json.jackson.practice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "id", "middleName", "age" }) public class PersonIgnoreProperties {

	private Long	id;
	private String	firstName;
	private String	lastName;
	private String	middleName;
	private Integer	age;

	public PersonIgnoreProperties() {
	}

	public PersonIgnoreProperties(Long id, String firstName, String lastName, String middleName, Integer age) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override public String toString() {
		return "{id: " + id + ", firstName: " + firstName + ", lastName: " + lastName + ", age: " + age + "}";
	}
}
