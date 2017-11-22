package core.java.annotations;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.junit.Test;

import core.java.annotations.model.ClassLevelAnnotation;
import core.java.annotations.model.ClassWithAnnotations;
import core.java.annotations.model.FieldLevelAnnotation;
import core.java.annotations.model.MethodLevelAnnotation;
import core.java.annotations.model.ParameterLevelAnnotation;

public class AnnotationsPractice {

	@Test
	public void classLevelAnnotation() {
		Class<ClassWithAnnotations> classObject = ClassWithAnnotations.class;
		ClassLevelAnnotation[] classLevelAnnotations = (ClassLevelAnnotation[]) classObject
				.getAnnotationsByType(ClassLevelAnnotation.class);

		for (ClassLevelAnnotation classLevelAnnotation : classLevelAnnotations) {
			System.out.println(classLevelAnnotation.stringValue());
			System.out.println(classLevelAnnotation.intValue());
		}

	}

	@Test
	public void fieldLevelAnnotation() throws NoSuchFieldException, SecurityException {
		Class<ClassWithAnnotations> classObject = ClassWithAnnotations.class;
		Field field = classObject.getField("fieldWithAnnotation");
		FieldLevelAnnotation[] fieldLevelAnnotations = (FieldLevelAnnotation[]) field
				.getAnnotationsByType(FieldLevelAnnotation.class);

		for (FieldLevelAnnotation annotation : fieldLevelAnnotations) {
			System.out.println(annotation.stringValue());
			System.out.println(annotation.longValue());
			String[] stringValues = annotation.stringValues();
			System.out.println(stringValues[0] + ", " + stringValues[1]);
		}
	}

	@Test
	public void methodLevelAnnotation() throws NoSuchMethodException, SecurityException {
		Class<ClassWithAnnotations> classObject = ClassWithAnnotations.class;
		Method method = classObject.getMethod("methodWithAnnotation");

		MethodLevelAnnotation[] methodLevelAnnotations = (MethodLevelAnnotation[]) method
				.getAnnotationsByType(MethodLevelAnnotation.class);

		for (MethodLevelAnnotation annotation : methodLevelAnnotations) {
			System.out.println(annotation.stringValue());
			System.out.println(annotation.doubleValue());
		}
	}

	@Test
	public void parameterAnnotations() throws NoSuchMethodException, SecurityException {
		Class<ClassWithAnnotations> classObject = ClassWithAnnotations.class;
		Method method = classObject.getMethod("parametersWithAnnotation", new Class[] { String.class });
		Parameter[] parameters = method.getParameters();

		System.out.println(parameters[0].getName());

		Parameter parameter = parameters[0];
		ParameterLevelAnnotation[] parameterLevelAnnotations = (ParameterLevelAnnotation[]) parameter
				.getAnnotationsByType(ParameterLevelAnnotation.class);

		for (ParameterLevelAnnotation annotation : parameterLevelAnnotations) {
			System.out.println(annotation.stringValue());
			System.out.println(annotation.floatValue());
		}
	}

}