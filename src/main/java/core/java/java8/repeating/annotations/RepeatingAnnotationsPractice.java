package core.java.java8.repeating.annotations;

import java.lang.annotation.Annotation;

import org.junit.Test;

@Filter(value = "filter1")
@Filter(value = "filter2")
@Filter
@CustomAnnotation(value = "customAnnotationValue")
public class RepeatingAnnotationsPractice {

    @Test
    public void method1() {
	Annotation[] annotations = RepeatingAnnotationsPractice.class.getAnnotations();
	System.out.println("annotations.length: " + annotations.length);
	for (Annotation annotation : annotations) {
	    System.out.println("annotationType: " + annotation.annotationType());
	}
    }

    @Test
    public void method2() {
	Filter[] filters = RepeatingAnnotationsPractice.class.getAnnotationsByType(Filter.class);
	System.out.println("filters.length: " + filters.length);
	for (Filter filter : filters) {
	    System.out.println("filter.value(): " + filter.value());
	}
    }

    @Test
    public void method3() {
	CustomAnnotation customAnnotation = RepeatingAnnotationsPractice.class.getAnnotation(CustomAnnotation.class);
	System.out.println("customAnnotation.value(): " + customAnnotation.value());
    }

    @Test
    public void method4() {
	CustomAnnotation[] customAnnotations = RepeatingAnnotationsPractice.class.getAnnotationsByType(CustomAnnotation.class);
	System.out.println("customAnnotations.length: " + customAnnotations.length);
	for (CustomAnnotation annotation : customAnnotations) {
	    System.out.println("customAnnotation.value(): " + annotation.value());
	}
    }
}
