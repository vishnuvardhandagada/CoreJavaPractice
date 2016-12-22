package json.gson.practice;

import json.boon.practice.model.Car;

import org.junit.Ignore;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReadJSON {

    public static void main(String[] args) {
	ReadJSON readJSON = new ReadJSON();
	readJSON.printJsonWithPrettyPrinting();
    }

    /**
     * Method to create Gson object
     */
    @Ignore
    @Test
    public void createGsonObject() {
	// method 1
	Gson gson1 = new Gson();
	System.out.println("gson1: " + gson1);
	// method 2
	GsonBuilder gsonBuilder = new GsonBuilder();
	Gson gson2 = gsonBuilder.create();
	System.out.println("gson2: " + gson2);
    }

    /**
     * Method to convert JSON String to object
     */
    @Ignore
    @Test
    public void converJsonToObject() {
	String json = "{\"brand\":\"BMW\",\"doors\":4}";
	Gson gson = new Gson();
	Car car = gson.fromJson(json, Car.class);
	System.out.println(car);
    }

    /**
     * Method to print json with pretty printing
     */
    @Ignore
    @Test
    public void printJsonWithPrettyPrinting() {
	String json = "{\"brand\":\"BMW\",\"doors\":4}";
	GsonBuilder gsonBuilder = new GsonBuilder();
	gsonBuilder.setPrettyPrinting();
	Gson gson = gsonBuilder.create();
	String prettyJson = gson.toJson(json);
	System.out.println(json);
	System.out.println(prettyJson);
    }
}
