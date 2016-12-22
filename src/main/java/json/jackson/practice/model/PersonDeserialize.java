package json.jackson.practice.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class PersonDeserialize {

	private Long	                                                    id;
	private String	                                                    name;
	@JsonDeserialize(using = BooleanDeserializer.class) private Boolean	enabled;

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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override public String toString() {
		return "{id: " + id + ", name: " + name + ", enabled: " + enabled + "}";
	}

}
