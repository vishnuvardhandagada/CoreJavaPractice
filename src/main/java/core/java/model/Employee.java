package core.java.model;

public class Employee {

    private String firstName;

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    @Override
    public int hashCode() {
	return firstName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
	Employee that = null;
	if (obj instanceof Employee)
	    that = (Employee) obj;
	return this.firstName.equals(that.firstName);
    }
}
