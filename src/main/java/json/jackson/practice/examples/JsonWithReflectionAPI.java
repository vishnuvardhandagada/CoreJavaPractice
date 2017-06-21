package json.jackson.practice.examples;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonWithReflectionAPI {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"val1\":\"abc\", \"val2\":\"12\", \"val3\": \"23\", \"val4\":\"234\", \"val5\": \"1.23\"}";

		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String> map = objectMapper.readValue(json, Map.class);
		System.out.println(map);

		Class<SourceModel> sourceClass = SourceModel.class;
		Class<DestinationModel> destinationClass = DestinationModel.class;
		DestinationModel destinationModel = new DestinationModel();
		Set<String> keySet = map.keySet();

		keySet.forEach(key -> {
			// convert key to camelCase method name: val1 to getVal1 (or) setVal1
			String firstChar = key.substring(0, 1);
			String capitalFirstChar = firstChar.toUpperCase();
			String getMethodName = "get" + capitalFirstChar + key.substring(1, key.length());
			String setMethodName = "set" + capitalFirstChar + key.substring(1, key.length());

			try {
				// source class get method name based on above getMethodName
				Method getMethod = sourceClass.getDeclaredMethod(getMethodName);
				Method setMethod = null;
				System.out.println("setMethodName: " + setMethodName + ", argType: "
						+ getMethod.getReturnType().getName());

				// based on getMethod return type we need to call set method
				switch (getMethod.getReturnType().getName()) {
				case "java.lang.String":
					setMethod = destinationClass.getMethod(setMethodName, String.class);
					setMethod.invoke(destinationModel, map.get(key));
					break;
				case "java.lang.Short":
					setMethod = destinationClass.getMethod(setMethodName, Short.class);
					Short shortValue = Short.parseShort(map.get(key));
					setMethod.invoke(destinationModel, shortValue);
					break;
				case "java.lang.Integer":
					setMethod = destinationClass.getMethod(setMethodName, Integer.class);
					Integer integerValue = Integer.parseInt(map.get(key));
					setMethod.invoke(destinationModel, integerValue);
					break;
				case "java.lang.Long":
					setMethod = destinationClass.getMethod(setMethodName, Long.class);
					Long longValue = Long.parseLong(map.get(key));
					setMethod.invoke(destinationModel, longValue);
					break;
				case "java.lang.Double":
					setMethod = destinationClass.getMethod(setMethodName, Double.class);
					Double doubleValue = Double.parseDouble(map.get(key));
					setMethod.invoke(destinationModel, doubleValue);
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		System.out.println("destinationModel: " + destinationModel);
	}
}
