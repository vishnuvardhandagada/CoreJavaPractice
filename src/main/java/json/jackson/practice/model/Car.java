package json.jackson.practice.model;

public class Car {

    private String brand;
    private String doors;

    public Car(String brand, String doors) {
	this.brand = brand;
	this.doors = doors;
    }

    public Car() {
    }

    public String getBrand() {
	return brand;
    }

    public void setBrand(String brand) {
	this.brand = brand;
    }

    public String getDoors() {
	return doors;
    }

    public void setDoors(String doors) {
	this.doors = doors;
    }

    @Override
    public String toString() {
	return "brand: " + brand + ", doors: " + doors;
    }
}