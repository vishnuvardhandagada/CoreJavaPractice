package json.boon.practice.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Car {

    private String brand;
    private Integer doors;

    public Car() {
    }

    public Car(String brand, Integer doors) {
	this.brand = brand;
	this.doors = doors;
    }

    public String getBrand() {
	return brand;
    }

    public void setBrand(String brand) {
	this.brand = brand;
    }

    public Integer getDoors() {
	return doors;
    }

    public void setDoors(Integer doors) {
	this.doors = doors;
    }

    @Override
    public String toString() {
	return "Car [brand=" + brand + ", doors=" + doors + "]";
    }

}