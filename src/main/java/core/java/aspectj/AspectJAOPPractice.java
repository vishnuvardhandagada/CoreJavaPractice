package core.java.aspectj;

import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import core.java.aspectj.model.AspectJAspect;
import core.java.aspectj.model.AspectJService;

public class AspectJAOPPractice {

    @Test
    public void method1() {
	AspectJAspect aspectJAspect = new AspectJAspect();
	AspectJService aspectJService = new AspectJService();

	AspectJProxyFactory proxyFactory = new AspectJProxyFactory(aspectJService);
	proxyFactory.addAspect(aspectJAspect);

	AspectJService service = proxyFactory.getProxy();
	service.method1();

    }
}
