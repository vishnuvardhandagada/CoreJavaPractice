package core.java.annotations.model;

@ClassLevelAnnotation(intValue = 20)
public class ClassWithAnnotations {

    @FieldLevelAnnotation(longValue = 30L, stringValues = { "value1", "value2" })
    public String fieldWithAnnotation;

    @MethodLevelAnnotation(stringValue = "method level annotation string vlaue", doubleValue = 10.25)
    public void methodWithAnnotation() {

    }

    public void parametersWithAnnotation(
	    @ParameterLevelAnnotation(stringValue = "parameter level annotation string value", floatValue = 1.23f) String argument1) {

    }

}