package core.java.java8.java.util.function.model;

public class Employee {

	private String firstName;
	private String lastName;
	private Long salary;
	private String gender;

	public Employee(String firstName, String lastName, Long salary, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.gender = gender;
	}

	public Employee(String firstName, String lastName, Long salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public Employee() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "{firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + ", gender="
				+ gender + "}";
	}
}