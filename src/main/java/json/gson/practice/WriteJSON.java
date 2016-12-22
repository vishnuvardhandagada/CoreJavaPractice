package json.gson.practice;

import json.gson.practice.model.Car;

import org.junit.Ignore;
import org.junit.Test;

import com.google.gson.Gson;

public class WriteJSON {

    public static void main(String[] args) {
	WriteJSON writeJSON = new WriteJSON();
	writeJSON.convertObjectToJson();
    }

    /**
     * Method to convert object to json String
     */
    @Ignore
    @Test
    public void convertObjectToJson() {
	Car car = new Car("Benz", 5);
	Gson gson = new Gson();
	String json = gson.toJson(car);
	System.out.println(json);
    }
}
