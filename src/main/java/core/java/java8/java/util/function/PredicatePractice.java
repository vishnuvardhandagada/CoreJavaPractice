package core.java.java8.java.util.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Ignore;
import org.junit.Test;

import core.java.java8.java.util.function.model.Employee;

/**
 * In mathematics, a predicate is commonly understood to be a Boolean-valued function P: X? {true, false}, called the predicate on X. 
 * Informally, a predicate is a statement that may be true or false depending on the values of its variables. 
 * It can be thought of as an operator or function that returns a value that is either true or false
 * 
 * @author Avinash Babu Donthu
 */
public class PredicatePractice {

	/**
	 * Display all Male employees
	 */
	@Ignore
	@Test
	public void allMaleEmployees() {
		List<Employee> employees = Arrays.asList(new Employee("firstName1", "lastName1", 20000L, "M"),
				new Employee("firstName2", "lastName2", 30000L, "F"));
		Predicate<Employee> maleEmployeesPredicate = (Employee e) -> {
			return "M".equals(e.getGender());
		};
		List<Employee> maleEmployees = employees.stream().filter(maleEmployeesPredicate)
				.collect(Collectors.toList());
		System.out.println("maleEmployees: " + maleEmployees);
	}
}
