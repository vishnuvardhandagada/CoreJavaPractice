package core.java.dynamic.proxies;

import java.lang.reflect.Proxy;

import org.junit.Ignore;
import org.junit.Test;

import core.java.dynamic.proxies.model.Car;
import core.java.dynamic.proxies.model.Circle;
import core.java.dynamic.proxies.model.IShape;
import core.java.dynamic.proxies.model.IVehicle;
import core.java.dynamic.proxies.model.MyInvocationHandler;

public class DynamicProxyPractice {

    @Ignore
    @Test
    public void carProxy() {
	Car car = new Car("BMW");
	IVehicle iVehicleProxy = (IVehicle) Proxy.newProxyInstance(IVehicle.class.getClassLoader(), new Class[] { IVehicle.class },
		new MyInvocationHandler(car));
	iVehicleProxy.start();
	iVehicleProxy.forward();
	iVehicleProxy.reverse();
	iVehicleProxy.stop();
	String carName = iVehicleProxy.getName();
	System.out.println("carName: " + carName);
	System.out.println("Proxy interface: " + iVehicleProxy.getClass().getInterfaces()[0]);
	System.out.println("Proxy invocation handler: " + Proxy.getInvocationHandler(iVehicleProxy));
    }

    @Test
    public void circleProxy() {
	Circle circle = new Circle();
	IShape iShapeProxy = (IShape) Proxy.newProxyInstance(IShape.class.getClassLoader(), new Class[] { IShape.class }, new MyInvocationHandler(
		circle));
	iShapeProxy.draw(10, 20);
	iShapeProxy.move();
	iShapeProxy.resize();
    }
}
