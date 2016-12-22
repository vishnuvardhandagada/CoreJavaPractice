package json.jackson.practice.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class BooleanDeserializer extends JsonDeserializer<Boolean> {

	@Override public Boolean deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException,
	        JsonProcessingException {
		String text = jsonParser.getText();
		Boolean value = true;
		if ("0".equals(text)) {
			value = false;
		}
		return value;
	}

}
