package json.simple.practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Create JSON String/file using simple json
 * @author Avinash Babu Donthu
 *
 */
public class WriteJSON {

    @SuppressWarnings("unchecked")
    @Ignore
    @Test
    public void createJsonFile() throws IOException {
	JSONObject jsonObject = new JSONObject();

	jsonObject.put("name", "John");
	jsonObject.put("age", 25);

	JSONArray jsonArray = new JSONArray();
	jsonArray.add("message1");
	jsonArray.add("message2");
	jsonArray.add("message3");

	jsonObject.put("messages", jsonArray);

	String filePath = System.getProperty("user.dir") + File.separator + "src\\main\\java\\json\\simple\\practice\\file1.json";
	File file = new File(filePath);
	file.createNewFile();
	try (FileWriter fileWriter = new FileWriter(filePath); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
	    bufferedWriter.write(jsonObject.toJSONString());
	}

    }
}
