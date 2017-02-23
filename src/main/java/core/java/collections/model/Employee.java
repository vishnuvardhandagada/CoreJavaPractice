package core.java.collections.model;

import java.time.LocalDate;

public class Employee {

    private LocalDate joiningDate;
    private String firstName;
    private String lastName;
    private int age;

    public Employee() {
    }

    public Employee(LocalDate joiningDate) {
	this.joiningDate = joiningDate;
    }

    public Employee(LocalDate joiningDate, String firstName) {
	this.joiningDate = joiningDate;
	this.firstName = firstName;
    }

    public Employee(String firstName, int age) {
	this.firstName = firstName;
	this.age = age;
    }

    public Employee(String firstName, String lastName) {
	this.firstName = firstName;
	this.lastName = lastName;
    }

    public Employee(String firstName) {
	this.firstName = firstName;
    }

    public Employee(int age) {
	this.age = age;
    }

    public LocalDate getJoiningDate() {
	return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
	this.joiningDate = joiningDate;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public int getAge() {
	return age;
    }

    public void setAge(int age) {
	this.age = age;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    @Override
    public String toString() {
	return "[firstName: " + firstName + ", lastName: " + lastName + ", age: " + age + "]";
    }
}