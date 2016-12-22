package json.boon.practice.model;

import java.util.Date;

public class Employee {

    private String name;
    private Date joiningDate;

    public Employee(String name, Date joiningDate) {
	this.name = name;
	this.joiningDate = joiningDate;
    }

    public Employee() {
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Date getJoiningDate() {
	return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
	this.joiningDate = joiningDate;
    }

}
