package json.jackson.practice.model;

import com.fasterxml.jackson.annotation.JacksonInject;

public class PersonInject {

	private Long	              id;
	private String	              name;
	@JacksonInject private String	source;

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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override public String toString() {
		return "{id: " + id + ", name: " + name + ", source: " + source + "}";
	}
}
