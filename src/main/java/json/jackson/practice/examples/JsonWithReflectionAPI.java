package json.jackson.practice.examples;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonWithReflectionAPI {

	private Map<String, List<Object>> instances = new HashMap<>();

	//	private DestinationModel destinationModel = new DestinationModel();

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		String json = "{\"javaClass\": \"json.jackson.practice.examples.DestinationModel\",\"val1\": \"abc\",\"val2\": \"12\",\"val3\": \"23\",\"val4\": \"234\",\"val5\": \"1.23\",\"info1\": {\"javaClass\": \"json.jackson.practice.examples.InnerClass1\",\"val6\": \"val6Value\",\"setMethod\": \"setInnerClass1\"},\"info2\": {\"javaClass\": \"json.jackson.practice.examples.InnerClass2\",\"val7\": \"val7Val\",\"setMethod\": \"setInnerClass2\"}}";

		//		String json = "{\"javaClass\": \"json.jackson.practice.examples.DestinationModel\",\"val1\": \"abc\",\"val2\": \"12\",\"val3\": \"23\",\"val4\": \"234\",\"val5\": \"1.23\",\"info1\": [{\"javaClass\": \"json.jackson.practice.examples.InnerClass1\",\"val6\": \"val6Value\",\"setMethod\": \"setInnerClass1\"},{\"javaClass\": \"json.jackson.practice.examples.InnerClass1\",\"val6\": \"val6Value2\",\"setMethod\": \"setInnerClass1\"}],\"info2\": {\"javaClass\": \"json.jackson.practice.examples.InnerClass2\",\"val7\": \"val7Val\",\"setMethod\": \"setInnerClass2\"}}";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> jsonMap = objectMapper.readValue(json, Map.class);
		JsonWithReflectionAPI jsonWithReflectionAPI = new JsonWithReflectionAPI();
		jsonWithReflectionAPI.convertJson(jsonMap);

		System.out.println("jsonWithReflectionAPI.instances: " + jsonWithReflectionAPI.instances);

		// {main=[destinationModel], setInnerClass1=[InnerClass1], setInnerClass2=[InnerClass2]}
		Object destinationModelObject = jsonWithReflectionAPI.instances.get("main").get(0);
		Class<?> klass = destinationModelObject.getClass();
		Set<String> keys = jsonWithReflectionAPI.instances.keySet();
		for (String key : keys) {
			if ("main".equals(key)) {
				continue;
			}

			List<Object> list = jsonWithReflectionAPI.instances.get(key);

			if (list.size() > 1) {
				Method method = klass.getMethod(key,
						(Class[]) Array.newInstance(list.get(0).getClass(), list.size()));
				method.invoke(destinationModelObject, list.toArray());
			} else {
				Object object = list.get(0);
				Method method = klass.getMethod(key, object.getClass());
				method.invoke(destinationModelObject, object);
			}
		}

		System.out.println(((DestinationModel) destinationModelObject).getInnerClass1().getVal6());
		System.out.println(((DestinationModel) destinationModelObject).getInnerClass2().getVal7());

		//		System.out.println(((DestinationModel) destinationModelObject).getInnerClasses1()[0].getVal6());
		//		System.out.println(((DestinationModel) destinationModelObject).getInnerClasses2()[0].getVal7());
	}

	public void convertJson(Map<String, Object> jsonMap) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {

		System.out.println(jsonMap);

		Class<SourceModel> sourceClass = SourceModel.class;

		Object destinationModel = Class.forName(String.valueOf(jsonMap.get("javaClass"))).newInstance();

		if (null == jsonMap.get("setMethod")) {
			instances.put("main", Arrays.asList(destinationModel));
		} else {
			List<Object> list = instances.get(jsonMap.get("setMethod"));
			if (null == list) {
				list = new ArrayList<>();
				list.add(destinationModel);
				instances.put(String.valueOf(jsonMap.get("setMethod")), list);
			} else {
				list.add(destinationModel);
			}
		}

		Class<?> destinationClass = destinationModel.getClass();

		Set<String> keySet = jsonMap.keySet();

		for (String key : keySet) {

			if ("javaClass".equals(key) || "setMethod".equals(key)) {
				continue;
			}

			if (jsonMap.get(key) instanceof Map) {
				convertJson((Map<String, Object>) jsonMap.get(key));
				continue;
			}

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
					setMethod.invoke(destinationModel, jsonMap.get(key));
					break;
				case "java.lang.Short":
					setMethod = destinationClass.getMethod(setMethodName, Short.class);
					Short shortValue = Short.parseShort(String.valueOf(jsonMap.get(key)));
					setMethod.invoke(destinationModel, shortValue);
					break;
				case "java.lang.Integer":
					setMethod = destinationClass.getMethod(setMethodName, Integer.class);
					Integer integerValue = Integer.parseInt(String.valueOf(jsonMap.get(key)));
					setMethod.invoke(destinationModel, integerValue);
					break;
				case "java.lang.Long":
					setMethod = destinationClass.getMethod(setMethodName, Long.class);
					Long longValue = Long.parseLong(String.valueOf(jsonMap.get(key)));
					setMethod.invoke(destinationModel, longValue);
					break;
				case "java.lang.Double":
					setMethod = destinationClass.getMethod(setMethodName, Double.class);
					Double doubleValue = Double.parseDouble(String.valueOf(jsonMap.get(key)));
					setMethod.invoke(destinationModel, doubleValue);
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		System.out.println("destinationModel: " + destinationModel);

	}
}
