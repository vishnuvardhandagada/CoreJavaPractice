package json.jackson.practice;

import java.io.IOException;

import json.jackson.practice.model.Car;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class JSONParser {

	public static void main(String[] args) {
		JSONParser jsonParserPractice = new JSONParser();
		jsonParserPractice.prepareObjecFromJSONUsingJSONParser();
	}

	public void parsingJSONWithJsonParser() {
		try {
			String json = "{\"brand\":\"mercede\",\"doors\": \"4\"}";
			JsonFactory jsonFactory = new JsonFactory();
			JsonParser jsonParser = jsonFactory.createParser(json);

			while (!jsonParser.isClosed()) {
				JsonToken jsonToken = jsonParser.nextToken();
				System.out.println("jsonToken: " + jsonToken);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to create Car object by reading Json using com.fasterxml.jackson.core.JsonParser
	 * 
	 * The getCurrentName() method of the JsonParser returns the current field name, if the token pointed to is a field name.
	 *	The getValueAsString() returns the current token value as a string, if the token pointed to is a string field value. 
	 *The getValueAsInt() returns the current token value as an int if the token pointed to is an integer field value. 
	 *The JsonParser has more similar methods for obtaining the current token value as different types (e.g. boolean, short, long, float, double etc.).
	 */
	public void prepareObjecFromJSONUsingJSONParser() {
		try {
			String json = "{\"brand\":\"mercede\",\"doors\": \"4\"}";
			JsonFactory jsonFactory = new JsonFactory();
			JsonParser jsonParser = jsonFactory.createParser(json);

			Car car = new Car();
			while (!jsonParser.isClosed()) {
				JsonToken jsonToken = jsonParser.nextToken();

				if (JsonToken.FIELD_NAME.equals(jsonToken)) {
					String fieldName = jsonParser.getCurrentName();
					System.out.println("fieldName: " + fieldName);

					jsonToken = jsonParser.nextToken();

					if ("brand".equals(fieldName)) {
						car.setBrand(jsonParser.getValueAsString());
					} else if ("doors".equals(fieldName)) {
						car.setDoors(jsonParser.getValueAsString());
					}
				}
			}

			System.out.println("Car:: brand:" + car.getBrand() + ", doors: " + car.getDoors());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
