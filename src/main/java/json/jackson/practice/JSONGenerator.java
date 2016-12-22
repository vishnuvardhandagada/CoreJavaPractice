package json.jackson.practice;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

public class JSONGenerator {

    public static void main(String[] args) {
	JSONGenerator jsonGeneratorPractice = new JSONGenerator();
	jsonGeneratorPractice.generateJSONUsingJsonGenerator();
    }

    /**
     * Method to generate json file using JSONGenerator
     */
    public void generateJSONUsingJsonGenerator() {
	try {
	    JsonFactory jsonFactory = new JsonFactory();
	    JsonGenerator jsonGenerator = jsonFactory.createGenerator(new File(
		    "E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\java\\json\\jackson\\practice\\car3.json"),
		    JsonEncoding.UTF8);

	    jsonGenerator.writeStartObject();
	    jsonGenerator.writeStringField("brand", "BMW");
	    jsonGenerator.writeNumberField("doors", 4);
	    jsonGenerator.writeEndObject();

	    jsonGenerator.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
