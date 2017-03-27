package json.jackson.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import json.jackson.practice.model.Car;

import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJSON {

    public static void main(String[] args) {
	ReadJSON readJSONPractice = new ReadJSON();
	readJSONPractice.readJSONFromURL();
    }

    /**
     * Method to create object by reading JSON String
     */
    @Ignore
    @Test
    public void prepareObjectFromJSONString() {
	try {
	    ObjectMapper mapper = new ObjectMapper();
	    String json = "{\"brand\":\"mercede\",\"doors\": \"4\"}";
	    Car car = mapper.readValue(json, Car.class);
	    System.out.println("Car: " + car);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * Method to prepare json node tree model
     */
    @Ignore
    @Test
    public void prepareTreeModelFromJSONString() {
	try {
	    ObjectMapper mapper = new ObjectMapper();
	    String json = "{\"brand\":\"mercede\",\"doors\": \"4\"}";
	    JsonNode jsonNode = mapper.readValue(json, JsonNode.class);
	    System.out.println("jsonNode: " + jsonNode);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * Parse JSON using JsonNode
     */
    public void parseJSONStringUsingJsonNode() {
	try {
	    ObjectMapper mapper = new ObjectMapper();
	    String json = "{ \"brand\" : \"Mercedes\", \"doors\" : 5," + "  \"owners\" : [\"Ramesh\", \"Suresh\", \"Mahesh\",\"Jack\",\"Jill\"],"
		    + "  \"nestedObject\" : { \"key1\" : \"value1\" } }";
	    JsonNode jsonNode = mapper.readValue(json, JsonNode.class);

	    JsonNode brand = jsonNode.get("brand");
	    String brandValue = brand.asText();
	    System.out.println("brandValue: " + brandValue);

	    JsonNode doors = jsonNode.get("doors");
	    String doorsValue = doors.asText();
	    System.out.println("doorsValue: " + doorsValue);

	    JsonNode owners = jsonNode.get("owners");
	    JsonNode firstOwner = owners.get(0);
	    String firstOwnerValue = firstOwner.asText();
	    System.out.println("firstOwnerValue: " + firstOwnerValue);

	    if (owners.isArray()) {
		Iterator<JsonNode> iterator = owners.iterator();
		while (iterator.hasNext()) {
		    JsonNode owner = iterator.next();
		    System.out.println("owner: " + owner.asText());
		}
	    }

	    JsonNode nestedObject = jsonNode.get("nestedObject");
	    JsonNode key1 = nestedObject.get("key1");
	    String value1 = key1.asText();
	    System.out.println(key1 + ", value1: " + value1);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * Prepare Object from JSON read from java.io.Reader
     */
    public void readingJSONFromReader() {
	try {
	    ObjectMapper mapper = new ObjectMapper();
	    String json = "{\"brand\":\"mercede\",\"doors\": \"4\"}";
	    Reader reader = new StringReader(json);
	    System.out.println("reader: " + reader);

	    Car car = mapper.readValue(reader, Car.class);
	    System.out.println("Car:: " + car);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * Reading JSON from file
     */
    @Ignore
    @Test
    public void readJSONFromFile() {
	try {
	    ObjectMapper mapper = new ObjectMapper();
	    /*File jsonFile = new File("E:/Backup/JavaPrep/practiceProjects/CoreJavaPractice/src/main/java/json/jackson/practice/car.json");
	    Car car = mapper.readValue(jsonFile, Car.class);
	    System.out.println("Car:: " + car);*/

	    File jsonFile = new File("C:\\Users\\Admin\\Desktop\\file1.json");
	    String jsonString = mapper.readValue(jsonFile, String.class);
	    System.out.println(jsonString);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * Read JSON from URL If we don't give file: in URL constructor, we will get
     * {@link java.net.MalformedURLException}
     */
    public void readJSONFromURL() {
	try {
	    ObjectMapper mapper = new ObjectMapper();
	    URL url = ReadJSON.class.getClassLoader().getResource("json/jackson/practice/car.json");
	    Car car = mapper.readValue(url, Car.class);
	    System.out.println("Car:: " + car);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * Reading JSON from {@link java.io.InputStream}
     */
    public void readJSONFromInputStream() {
	try {
	    ObjectMapper mapper = new ObjectMapper();
	    FileInputStream jsonFile = new FileInputStream(
		    "E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\java\\json\\jackson\\practice\\car.json");
	    Car car = mapper.readValue(jsonFile, Car.class);
	    System.out.println("Car:: " + car);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * Read JSON from byte[] array
     */
    public void readJSONFromByteArray() {
	try {
	    ObjectMapper mapper = new ObjectMapper();
	    String json = "{\"brand\":\"mercede\",\"doors\": \"4\"}";
	    byte[] jsonByteArray = json.getBytes("UTF-8");
	    Car car = mapper.readValue(jsonByteArray, Car.class);
	    System.out.println("Car:: " + car);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * Method to convert JSON String to java.util.Map
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    @Ignore
    @Test
    public void covertJSONStringToMap() throws JsonParseException, JsonMappingException, IOException {
	ObjectMapper objectMapper = new ObjectMapper();
	String json = "{\"brand\":\"mercede\",\"doors\": \"4\"}";

	Map<String, String> map1 = objectMapper.readValue(json, Map.class);
	System.out.println("covertJSONToMap() -> map1: " + map1);

	Map<String, String> map2 = objectMapper.readValue(json, new TypeReference<Map<String, String>>() {
	});
	System.out.println("covertJSONToMap() -> map2: " + map2);
    }

    /**
     * Method to read JSON from file and convert that JSON to java.util.Map
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    @Ignore
    @Test
    public void convertJsonFileToMap() throws JsonParseException, JsonMappingException, IOException {
	File file = new File("E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\java\\json\\jackson\\practice\\car4.json");
	ObjectMapper objectMapper = new ObjectMapper();

	Map<String, String> map1 = objectMapper.readValue(file, Map.class);
	System.out.println("convertJsonFileToMap() -> map1: " + map1);

	Map<String, String> map2 = objectMapper.readValue(file, new TypeReference<Map<String, String>>() {
	});
	System.out.println("convertJsonFileToMap() -> map2: " + map2);
    }
}
