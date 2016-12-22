package json.jackson.practice;

import java.io.File;
import java.io.IOException;

import json.jackson.practice.model.Address;
import json.jackson.practice.model.PersonAnySetter;
import json.jackson.practice.model.PersonAutoDetect;
import json.jackson.practice.model.PersonDeserialize;
import json.jackson.practice.model.PersonIgnore;
import json.jackson.practice.model.PersonIgnoreProperties;
import json.jackson.practice.model.PersonIgnoreType;
import json.jackson.practice.model.PersonInject;
import json.jackson.practice.model.PersonJsonCreator;
import json.jackson.practice.model.PersonSetter;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONAnnotations {

    public static void main(String[] args) {
	JSONAnnotations object = new JSONAnnotations();
	object.jsonIgnoreTypeDemo();
    }

    /**
     * JsonIgnore annotation demo
     */
    public void jsonIgnoreAnnotation() {
	try {
	    ObjectMapper mapper = new ObjectMapper();

	    // JSON to Person object
	    String json = "{\"id\":1,\"name\":\"Jack\"}";
	    PersonIgnore person = mapper.readValue(json, PersonIgnore.class);
	    System.out.println("Person: " + person);

	    // Person object to JSON
	    PersonIgnore person2 = new PersonIgnore(2L, "Ramesh");
	    String person2Json = mapper.writeValueAsString(person2);
	    System.out.println("person2 JSON: " + person2Json);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * JsonIgnoreProperties demo
     */
    public void jsonIgnorePropertiesDemo() {
	try {
	    ObjectMapper mapper = new ObjectMapper();

	    // Json to PersonIgnoreProperties object
	    String json = "{\"id\":1,\"firstName\":\"Jack\",\"middleName\":\"N\",\"lastName\":\"Jill\",\"age\":25}";
	    PersonIgnoreProperties personIgnoreProperties = mapper.readValue(json, PersonIgnoreProperties.class);
	    System.out.println("personIgnoreProperties: " + personIgnoreProperties);

	    // object to json
	    PersonIgnoreProperties personIgnoreProperties2 = new PersonIgnoreProperties(1L, "firstName", "lastName", "middleName", 27);
	    String jsonString = mapper.writeValueAsString(personIgnoreProperties2);
	    System.out.println("jsonString: " + jsonString);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * com.fasterxml.jackson.annotation.JsonIgnoreType demo
     */
    public void jsonIgnoreTypeDemo() {
	try {
	    ObjectMapper mapper = new ObjectMapper();

	    // object to JSON
	    PersonIgnoreType personIgnoreType = new PersonIgnoreType(1, "Jack");
	    Address address = new Address();
	    address.setStreetName("parkLane");
	    address.setCity("Newyork");
	    personIgnoreType.setAddress(address);
	    String json = mapper.writeValueAsString(personIgnoreType);
	    System.out.println("json: " + json);

	    // JSON to object
	    String json2 = "{\"id\":1,\"name\":\"Jill\", \"address\":{\"streetName\":\"lane120\", \"city\":\"Atlanta\"}}";
	    PersonIgnoreType personIgnoreType2 = mapper.readValue(json2, PersonIgnoreType.class);
	    System.out.println("personIgnoreType2: " + personIgnoreType2);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * JsonAutoDetect demo
     */
    public void jsonAutodetectDemo() {
	try {
	    ObjectMapper mapper = new ObjectMapper();

	    // object to JSON
	    PersonAutoDetect personAutoDetect = new PersonAutoDetect();
	    personAutoDetect.setName("Jill");
	    String json = mapper.writeValueAsString(personAutoDetect);
	    System.out.println("Json: " + json);

	    // JSON to object
	    String json2 = "{\"name\":\"Jill\"}";
	    PersonAutoDetect personAutoDetect2 = mapper.readValue(json2, PersonAutoDetect.class);
	    System.out.println(personAutoDetect2);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * JsonSetter demo
     */
    public void jsonSetterDemo() {
	try {
	    ObjectMapper mapper = new ObjectMapper();
	    String json = "{\"id\":\"123\", \"name\":\"Jack\"}";
	    PersonSetter personSetter = mapper.readValue(json, PersonSetter.class);
	    System.out.println("personSetter: " + personSetter);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * JsonAnySetter demo
     */
    public void jsonAnySetterDemo() {
	try {
	    ObjectMapper mapper = new ObjectMapper();
	    String json = "{\"id\":\"123\", \"name\":\"Jack\"}";
	    PersonAnySetter personAnySetter = mapper.readValue(json, PersonAnySetter.class);
	    System.out.println("personAnySetter: " + personAnySetter);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * JsonCreator demo
     */
    public void jsonCreateDemo() {
	try {
	    ObjectMapper mapper = new ObjectMapper();
	    String json = "{\"id\":\"123\", \"name\":\"Jack\"}";
	    PersonJsonCreator personJsonCreator = mapper.readValue(json, PersonJsonCreator.class);
	    System.out.println("personJsonCreator: " + personJsonCreator);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * @see JacksonInject demo
     */
    public void jacksonInjectDemo() {
	try {
	    String filePathWithName = "E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\java\\json\\jackson\\practice\\person.json";
	    InjectableValues injectableValues = new InjectableValues.Std().addValue(String.class, "myJsonPractice");
	    PersonInject personInject = new ObjectMapper().reader(injectableValues).forType(PersonInject.class).readValue(new File(filePathWithName));
	    System.out.println("personInject: " + personInject);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * jsonDeserializeDemo demo
     */
    public void jsonDeserializeDemo() {
	try {
	    ObjectMapper mapper = new ObjectMapper();
	    String json1 = "{\"id\":1, \"name\":\"Suresh\", \"enabled\":\"0\"}";
	    String json2 = "{\"id\":1, \"name\":\"Suresh\", \"enabled\":\"1\"}";
	    PersonDeserialize personDeserialize1 = mapper.reader(PersonDeserialize.class).readValue(json1);
	    PersonDeserialize personDeserialize2 = mapper.reader(PersonDeserialize.class).readValue(json2);
	    System.out.println("personDeserialize: " + personDeserialize1);
	    System.out.println("personDeserialize: " + personDeserialize2);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}