package json.boon.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import json.boon.practice.model.Car;

import org.boon.json.JsonFactory;
import org.boon.json.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;

public class ReadJSON {

    public static void main(String[] args) {
	ReadJSON readJSON = new ReadJSON();
	readJSON.readJsonFromFile();
    }

    /**
     * Method to create object from json String using readValue() method
     */
    @Ignore
    @Test
    public void createObjectFromJson() {
	System.out.println("-- createObjectFromJson() --");
	ObjectMapper mapper = JsonFactory.create();
	String json = "{\"brand\":\"BMW\", \"doors\":4}";
	Car car = mapper.readValue(json, Car.class);
	System.out.println(car);
    }

    /**
     * Method to create object from JSON String using fromJson() method
     */
    @Ignore
    @Test
    public void createObjectFromJson2() {
	System.out.println("-- createObjectFromJson2() --");
	ObjectMapper mapper = JsonFactory.create();
	String json = "{\"brand\":\"BMW\", \"doors\":4}";
	Car car = mapper.fromJson(json, Car.class);
	System.out.println(car);
    }

    /**
     * Convert JSON String to java.util.Map
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Ignore
    @Test
    public void createMapFromJson() {
	System.out.println("-- createMapFromJson() -- ");
	ObjectMapper mapper = JsonFactory.create();
	String json = "{\"cars\": [{\"brand\": \"BMW\",\"doors\": 4}, {\"brand\": \"Benz\",\"doors\": 5}]}";
	Map cars = mapper.readValue(json, Map.class);
	System.out.println(cars);
	List<Map> carsList = (List<Map>) cars.get("cars");
	System.out.println(carsList);
	for (Map map : carsList) {
	    String brand = (String) map.get("brand");
	    Integer doors = (Integer) map.get("doors");
	    System.out.println(brand + " - " + doors);
	}
    }

    /**
     * Method to read JSON from file
     */
    @Ignore
    @Test
    public void readJsonFromFile() {
	try {
	    System.out.println("-- readJsonFromFile() -- ");
	    ObjectMapper mapper = JsonFactory.create();
	    Car car = mapper.readValue(new FileInputStream(
		    "E:/Backup/JavaPrep/practiceProjects/CoreJavaPractice/src/main/java/json/boon/practice/car.json"), Car.class);
	    System.out.println(car);
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
    }
}
