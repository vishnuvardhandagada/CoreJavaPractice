package core.java.collections.model;

import java.time.LocalDate;

public class Employee {

    private LocalDate localDate;
    private String firstName;

    public Employee() {
    }

    public Employee(LocalDate localDate) {
	this.localDate = localDate;
    }

    public Employee(LocalDate localDate, String firstName) {
	this.localDate = localDate;
	this.firstName = firstName;
    }

    public LocalDate getLocalDate() {
	return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
	this.localDate = localDate;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    @Override
    public String toString() {
	return "[localDate=" + localDate + "]";
    }
}