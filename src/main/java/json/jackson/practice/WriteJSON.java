package json.jackson.practice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import json.jackson.practice.model.Car;

import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WriteJSON {

    public static void main(String[] args) {
	WriteJSON writeJSONPractice = new WriteJSON();
	writeJSONPractice.printJSONWithPrettyPrint();
    }

    /**
     * create JSON String from object
     */
    public void createJSONStringFromObject() {
	try {
	    ObjectMapper mapper = new ObjectMapper();
	    Car car = new Car("Mercedes", "4");
	    String json = mapper.writeValueAsString(car);
	    System.out.println("json:: " + json);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * Prepare JSON file from Object
     */
    public void prepareJSONFromObject() {
	try {
	    ObjectMapper mapper = new ObjectMapper();
	    Car car = new Car("Mercedes", "4");
	    mapper.writeValue(new FileOutputStream(
		    "E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\java\\json\\jackson\\practice\\car2.json"), car);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * Prepare byte[] array from Object
     */
    public void prepareByteArrayFromJSONObjct() {
	try {
	    ObjectMapper mapper = new ObjectMapper();
	    Car car = new Car("Mercedes", "4");
	    byte[] byteArray = mapper.writeValueAsBytes(car);
	    System.out.println("byteArray: " + byteArray);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public void printJSONWithPrettyPrint() {
	try {
	    ObjectMapper mapper = new ObjectMapper();
	    Car car = new Car("Mercedes", "4");
	    String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(car);
	    System.out.println("car json: " + json);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    @Ignore
    @Test
    public void convertMapToJSON() throws JsonProcessingException {
	ObjectMapper objectMapper = new ObjectMapper();

	Map<String, Object> map = new HashMap<>();
	map.put("brand", "BMW");
	map.put("doors", 4);

	String jsonString1 = objectMapper.writeValueAsString(map);
	System.out.println("jsonStirng1: " + jsonString1);

	String jsonString2 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
	System.out.println("jsonString2: " + jsonString2);
    }

    //    @Ignore
    @Test
    public void convertMapToJsonFile() throws JsonGenerationException, JsonMappingException, IOException {
	File file = new File("E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\java\\json\\jackson\\practice\\car4.json");
	ObjectMapper objectMapper = new ObjectMapper();

	Map<String, Object> map = new HashMap<>();
	map.put("brand", "BMW");
	map.put("doors", 4);

	objectMapper.writeValue(file, map);
    }
}
