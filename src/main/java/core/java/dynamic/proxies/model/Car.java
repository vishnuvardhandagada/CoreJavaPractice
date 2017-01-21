package core.java.dynamic.proxies.model;

public class Car implements IVehicle {

    private String name;

    public Car(String name) {
	this.name = name;
    }

    @Override
    public void start() {
	System.out.println("Car -> start()");
    }

    @Override
    public void stop() {
	System.out.println("Car -> stop()");
    }

    @Override
    public void forward() {
	System.out.println("Car -> forward()");
    }

    @Override
    public void reverse() {
	System.out.println("Car -> reverse()");
    }

    @Override
    public String getName() {
	System.out.println("Car -> getName(): " + name);
	return name;
    }

}