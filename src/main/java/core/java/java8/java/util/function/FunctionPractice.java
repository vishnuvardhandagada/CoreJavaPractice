package core.java.java8.java.util.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Ignore;
import org.junit.Test;

import core.java.java8.java.util.function.model.Employee;
import core.java.java8.java.util.function.model.Job;

/**
 * java.util.function.Function<T, R> => T -> R
 * determines output values based on input value. 
 * Common use case is converting map to list or where we want to convert one object type to another object
 * Since this is functional interface we can use lambda expressions
 * @author Avinash Babu Donthu
 *
 */
public class FunctionPractice {

	/**
	 * Using java.util.function.Function to convert Employee object Job object
	 */
	@Ignore
	@Test
	public void convertEmployeeToJob() {
		List<Employee> employees = Arrays.asList(new Employee("firstName1", "lastName1", 30000L),
				new Employee("firstName2", "lastName2", 40000L), new Employee("firstName3", "lastName3",
						50000L));

		Function<Employee, Job> mapEmployeeToJob = (Employee e) -> {
			Job job = new Job(e.getFirstName(), "description1");
			return job;
		};

		// mapEmployeeToJob is instance of java.util.function.Function which will be applied to each object in Stream
		List<Job> jobs = employees.stream().map(mapEmployeeToJob).collect(Collectors.toList());
		System.out.println("jobs: " + jobs);
	}

	/**
	 * Using java.util.function.Function.apply() method to convert one object to another object
	 */
	@Ignore
	@Test
	public void convertOneObject() {
		Employee employee = new Employee("firstName1", "lastName1", 30000L);

		Function<Employee, Job> employeeToJob = (Employee e) -> {
			return new Job(e.getFirstName(), "description1");
		};

		Job job = employeeToJob.apply(employee);
		System.out.println("job: " + job);
	}

	/**
	 * Using java.util.function.Function.apply() method to convert list of objects
	 */
	@Ignore
	@Test
	public void getEmployeeNames() {
		List<Employee> employees = Arrays.asList(new Employee("firstName1", "lastName1", 30000L),
				new Employee("firstName2", "lastName2", 40000L), new Employee("firstName3", "lastName3",
						50000L));

		Function<Employee, String> employeeNameFunction = (Employee e) -> {
			return e.getFirstName();
		};

		List<String> names = new ArrayList<>();
		for (Employee employee : employees) {
			names.add(employeeNameFunction.apply(employee));
		}

		System.out.println("names: " + names);
	}

	/**
	 * andThen() is a default method in Function interface.
	 * This default method combines the current Function instance with another one and 
	 * returns a combined Function instance which applies the two functions in sequence with the function passed 
	 * as parameter to andThen() being invoked after the current function.
	 * 
	 * function1.andThen(function2) -> first function1 will be executed then function2 will be executed in sequence
	 */
	@Ignore
	@Test
	public void andThenPractice() {
		List<Employee> employees = Arrays.asList(new Employee("john", "lastName1", 30000L), new Employee(
				"jack", "lastName2", 40000L), new Employee("tom", "lastName3", 50000L));

		Function<Employee, String> employeeNameFunction = (Employee e) -> {
			System.out.println("employeeNameFunction");
			return e.getFirstName();
		};

		Function<String, String> capitalizeName = (String s) -> {
			System.out.println("capitalizeName");
			return s.toUpperCase();
		};

		Function<String, String> reverseName = (String s) -> {
			System.out.println("reverseName");
			return new StringBuffer(s).reverse().toString();
		};

		List<String> reverseNames = new ArrayList<>();
		for (Employee employee : employees) {
			reverseNames.add(employeeNameFunction.andThen(capitalizeName).andThen(reverseName)
					.apply(employee));
		}

		System.out.println("reverseNames: " + reverseNames);
	}

	/**
	 * compose() is a default method in Function interface.
	 * compose() default method combines the current Function instance with another one and 
	 * returns a combined Function instance which applies the two functions in sequence with the parameter function 
	 * to compose() being invoked before the current function
	 * 
	 * function1.compose(function2).compose(function3): execution sequence: function3 -&gt; function2 -&gt; function1
	 */
	@Ignore
	@Test
	public void composePractice() {
		List<Employee> employees = Arrays.asList(new Employee("john", "lastName1", 30000L), new Employee(
				"jack", "lastName2", 40000L), new Employee("tom", "lastName3", 50000L));

		Function<Employee, String> employeeNameFunction = (Employee e) -> {
			System.out.println("employeeNameFunction");
			return e.getFirstName();
		};

		Function<String, String> capitalizeName = (String s) -> {
			System.out.println("capitalizeName");
			return s.toUpperCase();
		};

		Function<String, String> reverseName = (String s) -> {
			System.out.println("reverseName");
			return new StringBuffer(s).reverse().toString();
		};

		List<String> reverseNames = new ArrayList<>();
		for (Employee employee : employees) {
			reverseNames.add(reverseName.compose(capitalizeName).compose(employeeNameFunction)
					.apply(employee));
		}

		System.out.println("reverseNames: " + reverseNames);
	}
}