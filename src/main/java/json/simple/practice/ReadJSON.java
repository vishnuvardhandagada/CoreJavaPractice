package json.simple.practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Ignore;
import org.junit.Test;

/**
 * class to read JSON using simple JSON
 * @author Avinash Babu Donthu
 *
 */
public class ReadJSON {

    /**
     * Method to read json file using simple json
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     */
    @Ignore
    @SuppressWarnings("unchecked")
    @Test
    public void readJSONFile() throws FileNotFoundException, IOException, ParseException {
	JSONParser jsonParser = new JSONParser();
	String filePath = System.getProperty("user.dir") + File.separator + "src\\main\\java\\json\\simple\\practice\\file1.json";
	try (FileReader fileReader = new FileReader(filePath);) {
	    Object object = jsonParser.parse(fileReader);
	    JSONObject jsonObject = (JSONObject) object;

	    String name = String.valueOf(jsonObject.get("name"));
	    System.out.println("ReadJSON -> readJSONFile() -> name: " + name);

	    String age = String.valueOf(jsonObject.get("age"));
	    System.out.println("ReadJSON -> readJSONFile() -> age: " + age);

	    JSONArray jsonArray = (JSONArray) jsonObject.get("messages");
	    Iterator<String> jsonArrayIterator = jsonArray.iterator();
	    for (;; jsonArrayIterator.hasNext()) {
		System.out.println("ReadJSON -> readJSONFile() -> message: " + jsonArrayIterator.next());
	    }
	}
    }
}
