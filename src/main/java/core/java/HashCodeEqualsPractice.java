package core.java;

import core.java.model.Employee;

public class HashCodeEqualsPractice {

    public static void main(String[] args) {
	Employee employee1 = new Employee();
	employee1.setFirstName("jack");

	Employee employee2 = new Employee();
	employee2.setFirstName("jack");

	System.out.println(employee1.hashCode() == employee2.hashCode());
    }
}
