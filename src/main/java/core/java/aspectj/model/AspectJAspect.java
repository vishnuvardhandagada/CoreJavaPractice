package core.java.aspectj.model;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectJAspect {

    @Before("execution(void method1())")
    public void method1Advice() {
	System.out.println("AspectJAdvice -> method1Advice()");
    }
}
