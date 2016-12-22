package json.boon.practice;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import json.boon.practice.model.Car;
import json.boon.practice.model.Employee;

import org.boon.json.JsonFactory;
import org.boon.json.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;

public class WriteJSON {

    public static void main(String[] args) {
	WriteJSON writeJSON = new WriteJSON();
	writeJSON.dateValueToJson();
    }

    /**
     * Method to covert object to JSON
     */
    @Ignore
    @Test
    public void convertObjectToJson() {
	Car car1 = new Car("BMW", 5);
	Car car2 = new Car("Benz", 5);
	Car car3 = new Car("Ferrari", 5);
	Car car4 = new Car("Jaguar", 5);
	ObjectMapper mapper = JsonFactory.create();
	String json = mapper.writeValueAsString(Arrays.asList(car1, car2, car3, car4));
	System.out.println(json);
    }

    /**
     * Method to generate json file from object
     */
    @Ignore
    @Test
    public void createJsonFileFromObject() {
	Car car1 = new Car("BMW", 5);
	Car car2 = new Car("Benz", 5);
	Car car3 = new Car("Ferrari", 5);
	Car car4 = new Car("Jaguar", 5);
	ObjectMapper mapper = JsonFactory.create();
	mapper.writeValue(new File("E:/Backup/JavaPrep/practiceProjects/CoreJavaPractice/src/main/java/json/boon/practice/cars.json"),
		Arrays.asList(car1, car2, car3, car4));
    }

    /**
     * Method to generate JSON from Map
     */
    @Ignore
    @Test
    public void generateJsonFromMap() {
	Map<String, String> car1 = new HashMap<>();
	car1.put("brand", "BMW");
	car1.put("doors", "5");

	Map<String, String> car2 = new HashMap<>();
	car2.put("brand", "Benz");
	car2.put("doors", "4");

	ObjectMapper mapper = JsonFactory.create();
	String json = mapper.writeValueAsString(Arrays.asList(car1, car2));
	System.out.println(json);
    }

    /**
     * Parsing java.util.Date to Json String
     */
    @Ignore
    @Test
    public void dateValueToJson() {
	Employee employee = new Employee("Ramesh", new Date());
	// ObjectMapper mapper = JsonFactory.create();
	ObjectMapper mapper = JsonFactory.createUseJSONDates();
	String json = mapper.writeValueAsString(employee);
	System.out.println("json: " + json);
    }
}
