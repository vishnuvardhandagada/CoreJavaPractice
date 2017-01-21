package core.java.dynamic.proxies.model;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private Object object;

    public MyInvocationHandler(Object object) {
	this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	System.out.println(object.getClass().getName() + ": calling method: " + method.getName());
	Object obj = method.invoke(object, args);
	System.out.println(method.getName() + " execution completed");
	return obj;
    }

}
