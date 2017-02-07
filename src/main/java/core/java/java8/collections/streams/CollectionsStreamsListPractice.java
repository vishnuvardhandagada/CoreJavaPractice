package core.java.java8.collections.streams;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.junit.Ignore;
import org.junit.Test;

import core.java.collections.model.Employee;

public class CollectionsStreamsListPractice {

    /**
     * Prepare stream and print each element in the stream using method reference
     */
    @Ignore
    @Test
    public void prepareStream() {
	Stream<String> srcStream = Stream.of("one", "two", "three", "four", "five");
	srcStream.forEach(System.out::println);
    }

    /**
     * Prepare stream of Employee objects
     */
    @Ignore
    @Test
    public void prepareEmployeeStreams() {
	Stream<Employee> employeeStream = Stream.of(new Employee(21), new Employee(22), new Employee(23), new Employee(24));
	employeeStream.forEach(System.out::println);

	Stream<Employee> employeeStream2 = Stream.of(new Employee(21), new Employee(22), new Employee(23), new Employee(24));
	employeeStream2.map(Employee::getAge).forEach(System.out::println);
    }

    /**
     * Prepare stream with primitive int
     */
    @Ignore
    @Test
    public void preparePrimitiveIntStream() {
	IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
	intStream.forEach(System.out::println);

	IntStream intStream2 = Arrays.stream(new int[] { 16, 17, 18, 19, 20 });
	intStream2.forEach(System.out::println);
    }

    /**
     * Prepare stream with primitive long
     */
    @Ignore
    @Test
    public void preparePrimitiveLongStream() {
	LongStream longStream = LongStream.of(11, 12, 13, 14, 15);
	longStream.forEach(System.out::println);

	LongStream longStream2 = Arrays.stream(new long[] { 21, 22, 23, 24, 25 });
	longStream2.forEach(System.out::println);
    }

    /**
     * Prepare stream with primitive double
     */
    @Ignore
    @Test
    public void preparePrimitiveDoubleStream() {
	DoubleStream doubleStream = DoubleStream.of(6, 7, 8, 9, 10);
	doubleStream.forEach(System.out::println);

	DoubleStream doubleStream2 = Arrays.stream(new double[] { 26, 27, 28, 29, 30 });
	doubleStream2.forEach(System.out::println);
    }

    /**
     * iterate and print elements in list
     */
    @Ignore
    @Test
    public void printList() {
	List<String> list = Arrays.asList("a", "b", "c", "d", "e");

	// method 1 - using lambda expression
	list.stream().forEach(element -> {
	    System.out.print(element);
	});

	// method 2 - using method references
	list.stream().forEach(System.out::println);
    }

    /**
     * iterate list and prepare new list with all elements in source list
     */
    @Ignore
    @Test
    public void prepareNewList() {
	List<String> sourceList = Arrays.asList("a", "b", "c", "d", "e");
	List<String> targetList = sourceList.stream().collect(Collectors.toList());

	targetList.stream().forEach(element -> System.out.print(element));
    }

    /**
     * 1. list of employee object
     * 2. filter list with name starts with j
     */
    @Ignore
    @Test
    public void filterList() {
	List<Employee> list = Arrays.asList(new Employee("mahesh"), new Employee("suresh"), new Employee("jack"), new Employee("jill"));
	list.stream().filter(employee -> employee.getFirstName().startsWith("j")).forEach(employee -> System.out.println(employee));
    }

    /**
     * 1. list of employee object
     * 2. filter list with name starts with j and prepare new list with filtered values
     */
    @Ignore
    @Test
    public void filterListAndPrepareNewList() {
	List<Employee> list = Arrays.asList(new Employee("mahesh"), new Employee("suresh"), new Employee("jack"), new Employee("jill"));
	List<Employee> filteredList = list.stream().filter(element -> element.getFirstName().startsWith("j")).collect(Collectors.toList());

	filteredList.stream().forEach(employee -> System.out.println(employee.getFirstName()));
    }

    /**
     * 1. list of employee objects
     * 2. convert all firstNames to upper case
     * 3. prepare new list with upper cased firstName values
     */
    @Ignore
    @Test
    public void upperCase() {
	List<Employee> list = Arrays.asList(new Employee("mahesh"), new Employee("suresh"), new Employee("jack"), new Employee("jill"));
	List<String> upperCasedNamesList = list.stream().map(Employee::getFirstName).map(String::toUpperCase).collect(Collectors.toList());

	upperCasedNamesList.stream().forEach(firstName -> System.out.println(firstName));
    }

    /**
     * 1. list of employee objects
     * get all first names of employee whose name starting with j with all names converted to upper case and display names in sorted order
     */
    @Ignore
    @Test
    public void filteredCaseChangedSortedList() {
	List<Employee> list = Arrays.asList(new Employee("mahesh"), new Employee("suresh"), new Employee("jack"), new Employee("jill"));

	List<String> targetList = list.stream().filter(employee -> employee.getFirstName().startsWith("j")).map(employee -> employee.getFirstName())
		.map(String::toUpperCase).sorted().collect(Collectors.toList());
	System.out.println(targetList);
    }

    /**
     * print first element in the list
     */
    @Ignore
    @Test
    public void printFirstElement() {
	List<String> srcList = Arrays.asList("first", "second", "third");
	srcList.stream().findFirst().ifPresent(System.out::println);
    }

    /**
     * 1. List of Employee objects
     * 2. Sort list by employee joiningDate using Java 8 collection streams
     */
    @Ignore
    @Test
    public void sortListByDate() {
	List<Employee> employeeList = Arrays.asList(new Employee(LocalDate.of(2017, 04, 12)), new Employee(LocalDate.of(2017, 04, 13)), new Employee(
		LocalDate.of(2017, 01, 01)), new Employee(LocalDate.of(2017, 02, 10)), new Employee(LocalDate.of(2017, 03, 11)));

	List<Employee> sortedList = employeeList.stream().sorted((e1, e2) -> e1.getJoiningDate().compareTo(e2.getJoiningDate()))
		.collect(Collectors.toList());

	System.out.println("employeeList: " + employeeList);
	System.out.println("sortedList: " + sortedList);
    }

    /**
     * 1. List of employee objects
     * 2. Prepare new list with employee's firstName using Java 8 collection streams
     */
    @Ignore
    @Test
    public void getFirstNameListFromEmployee() {
	List<Employee> employeeList = Arrays.asList(new Employee(LocalDate.of(2017, 04, 12), "john"),
		new Employee(LocalDate.of(2017, 04, 13), "jack"), new Employee(LocalDate.of(2017, 01, 01), "jill"),
		new Employee(LocalDate.of(2017, 02, 10), "mahesh"), new Employee(LocalDate.of(2017, 03, 11), "suresh"));

	// using method reference
	List<String> namesList = employeeList.stream().map(Employee::getFirstName).collect(Collectors.toList());
	System.out.println("namesList: " + namesList);

	// using lambda expression
	List<String> namesList2 = employeeList.stream().map(employee -> employee.getFirstName()).collect(Collectors.toList());
	System.out.println("namesList2: " + namesList2);
    }

    /**
     * Sum all int values
     */
    @Ignore
    @Test
    public void sumAllElements() {
	IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
	int sum = intStream.sum();
	System.out.println(sum);
    }

    /**
     * Sum of all employee ages
     */
    @Ignore
    @Test
    public void sumAges() {
	Stream<Employee> employeeStream = Stream.of(new Employee(21), new Employee(22), new Employee(23), new Employee(24));
	int sumOfAges = employeeStream.mapToInt(Employee::getAge).sum();
	System.out.println("sumOfAges: " + sumOfAges);
    }

    /**
     * Average age of all employees
     */
    @Ignore
    @Test
    public void averageAge() {
	Stream<Employee> employeeStream = Stream.of(new Employee(21), new Employee(22), new Employee(23), new Employee(24));
	OptionalDouble averageAge = employeeStream.mapToInt(Employee::getAge).average();
	System.out.println("averageAge: " + averageAge);
	System.out.println("averageAge: " + averageAge.getAsDouble());
    }

    /**
     * Max age of all employees
     */
    @Ignore
    @Test
    public void maxAge() {
	Stream<Employee> employeeStream = Stream.of(new Employee(21), new Employee(22), new Employee(23), new Employee(24));
	OptionalInt maxAge = employeeStream.mapToInt(Employee::getAge).max();
	System.out.println("maxAge: " + maxAge);
	System.out.println("maxAge: " + maxAge.getAsInt());
    }

    /**
     * Min age of all employees
     */
    @Ignore
    @Test
    public void minAge() {
	Stream<Employee> employeeStream = Stream.of(new Employee(21), new Employee(22), new Employee(23), new Employee(24));
	OptionalInt minAge = employeeStream.mapToInt(Employee::getAge).min();
	System.out.println("minAge: " + minAge);
	System.out.println("minAge: " + minAge.getAsInt());
    }

    /**
     * Convert stream of int to employee objects
     */
    @Ignore
    @Test
    public void mapToObject() {
	IntStream intStream = IntStream.of(26, 27, 28, 29, 30);
	intStream.mapToObj(value -> new Employee(value)).forEach(System.out::println);

	// using constructor reference
	System.out.println("-------------------------------------------------------");
	IntStream intStream2 = IntStream.of(26, 27, 28, 29, 30);
	List<Object> employeeStream = intStream2.mapToObj(Employee::new).collect(Collectors.toList());
	employeeStream.forEach(System.out::println);

	// using lambda expression
	System.out.println("-------------------------------------------------------");
	IntStream intStream3 = IntStream.of(26, 27, 28, 29, 30);
	List<Employee> employeeStream2 = intStream3.mapToObj(value -> new Employee(value)).collect(Collectors.toList());
	employeeStream2.forEach(System.out::println);
    }

    /**
     * Group employees by age
     */
    @Ignore
    @Test
    public void groupByAge() {
	List<Employee> employees = Arrays.asList(new Employee("mahesh", 21), new Employee("suresh", 21), new Employee("jack", 22), new Employee(
		"jill", 22));

	Map<Integer, List<Employee>> employeesGroupByAge = employees.stream().collect(Collectors.groupingBy(Employee::getAge));
	System.out.println(employeesGroupByAge);
    }

    /**
     * Group employees by age
     */
    @Ignore
    @Test
    public void ageSummaryStatistics() {
	List<Employee> employees = Arrays.asList(new Employee("mahesh", 21), new Employee("suresh", 21), new Employee("jack", 22), new Employee(
		"jill", 22));

	IntSummaryStatistics ageSummaryStatistics = employees.stream().collect(Collectors.summarizingInt(Employee::getAge));
	System.out.println(ageSummaryStatistics);
    }

    /**
     * Joining the list of employee filters to phrase
     */
    @Ignore
    @Test
    public void joining() {
	List<Employee> employees = Arrays.asList(new Employee("mahesh", 17), new Employee("suresh", 18), new Employee("jack", 22), new Employee(
		"jill", 22));
	String phrase = employees.stream().filter(employee -> employee.getAge() > 18).map(employee -> employee.getFirstName())
		.collect(Collectors.joining(" and ", "In India ", " are of legal age employees"));
	System.out.println(phrase);
    }

    /**
     * Create map(age, firstName) with list of employee objects
     */
    @Ignore
    @Test
    public void createMapWithEmployee() {
	List<Employee> employees = Arrays.asList(new Employee("mahesh", 17), new Employee("suresh", 17), new Employee("jack", 22), new Employee(
		"jill", 22));

	// we are using age as key. If key is same for 2 employees we  will get IllegalStateException. So we need to pass 3rd argument to collect
	Map<Integer, String> employeesMap = employees.stream().collect(
		Collectors.toMap(Employee::getAge, Employee::getFirstName, (name1, name2) -> name1 + "," + name2));
	System.out.println(employeesMap);
    }
}