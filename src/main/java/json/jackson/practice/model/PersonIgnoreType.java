package json.jackson.practice.model;

public class PersonIgnoreType {

	private Integer	id;
	private String	name;

	public PersonIgnoreType() {
	}

	public PersonIgnoreType(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	private Address	address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override public String toString() {
		return "{ id: " + id + ", name: " + name + ", address: " + address + "}";
	}
}
