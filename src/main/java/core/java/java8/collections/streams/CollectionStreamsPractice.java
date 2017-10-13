package core.java.java8.collections.streams;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.junit.Ignore;
import org.junit.Test;

import core.java.collections.model.Employee;

/**
 * Java 8 collection streams practice
 * @author Avinash Babu Donthu
 *
 */
public class CollectionStreamsPractice {

	/**
	 * Prepare stream and print each element in the stream using method reference
	 */
	@Ignore
	@Test
	public void prepareStream() {
		Stream<String> srcStream = Stream.of("one", "two", "three", "four", "five");

		// print using method reference
		srcStream.forEach(System.out::println);

		// print using lambda expression - we can reiterate over collection that is already iterated
		// srcStream.forEach(e -> System.out.println(e));
	}

	/**
	 * Prepare stream of Employee objects
	 */
	@Ignore
	@Test
	public void prepareEmployeeStreams() {
		Stream<Employee> employeeStream = Stream.of(new Employee(21), new Employee(22), new Employee(23),
				new Employee(24));
		employeeStream.forEach(System.out::println);

		// print employee ages
		Stream<Employee> employeeStream2 = Stream.of(new Employee(21), new Employee(22), new Employee(23),
				new Employee(24));
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
		List<Employee> list = Arrays.asList(new Employee("mahesh"), new Employee("suresh"), new Employee(
				"jack"), new Employee("jill"));
		list.stream().filter(employee -> employee.getFirstName().startsWith("j"))
				.forEach(employee -> System.out.println(employee));
	}

	/**
	 * 1. list of employee object
	 * 2. filter list with name starts with j and prepare new list with filtered values
	 */
	@Ignore
	@Test
	public void filterListAndPrepareNewList() {
		List<Employee> list = Arrays.asList(new Employee("mahesh"), new Employee("suresh"), new Employee(
				"jack"), new Employee("jill"));
		List<Employee> filteredList = list.stream().filter(element -> element.getFirstName().startsWith("j"))
				.collect(Collectors.toList());

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
		List<Employee> list = Arrays.asList(new Employee("mahesh"), new Employee("suresh"), new Employee(
				"jack"), new Employee("jill"));

		System.out.println("----------upperCasedNamesList-------------");
		// method 1
		List<String> upperCasedNamesList = list.stream().map(Employee::getFirstName).map(String::toUpperCase)
				.collect(Collectors.toList());
		upperCasedNamesList.stream().forEach(firstName -> System.out.println(firstName));

		System.out.println("----------upperCasedNamesList2-------------");
		// method 2
		List<String> upperCasedNamesList2 = list.stream()
				.map(employee -> employee.getFirstName().toUpperCase()).collect(Collectors.toList());
		upperCasedNamesList2.forEach(System.out::println);

		System.out.println("----------upperCasedNamesList3-------------");
		// method 3
		Function<Employee, String> firstNamesFunction = (Employee e) -> e.getFirstName();
		Function<String, String> upperCasedFunction = (String str) -> str.toUpperCase();
		List<String> upperCasedNamesList3 = list.stream().map(firstNamesFunction.andThen(upperCasedFunction))
				.collect(Collectors.toList());
		upperCasedNamesList3.forEach(System.out::println);
	}

	/**
	 * 1. list of employee objects
	 * get all first names of employee whose name starting with j with all names converted to upper case and display names 
	 * in sorted order
	 */
	@Ignore
	@Test
	public void filteredCaseChangedSortedList() {
		List<Employee> list = Arrays.asList(new Employee("mahesh"), new Employee("suresh"), new Employee(
				"jack"), new Employee("jill"));

		// method 1
		List<String> targetList = list.stream().filter(employee -> employee.getFirstName().startsWith("j"))
				.map(employee -> employee.getFirstName()).map(String::toUpperCase).sorted()
				.collect(Collectors.toList());
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
		List<Employee> employeeList = Arrays.asList(new Employee(LocalDate.of(2017, 04, 12), "jack"),
				new Employee(LocalDate.of(2017, 04, 13), "jill"), new Employee(LocalDate.of(2017, 01, 01),
						"john"), new Employee(LocalDate.of(2017, 02, 10), "scott"),
				new Employee(LocalDate.of(2017, 03, 11), "amy"));

		List<Employee> sortedList = employeeList.stream()
				.sorted((e1, e2) -> e1.getJoiningDate().compareTo(e2.getJoiningDate()))
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
				new Employee(LocalDate.of(2017, 04, 13), "jack"), new Employee(LocalDate.of(2017, 01, 01),
						"jill"), new Employee(LocalDate.of(2017, 02, 10), "mahesh"),
				new Employee(LocalDate.of(2017, 03, 11), "suresh"));

		// using method reference
		List<String> namesList = employeeList.stream().map(Employee::getFirstName)
				.collect(Collectors.toList());
		System.out.println("namesList: " + namesList);

		// using lambda expression
		List<String> namesList2 = employeeList.stream().map(employee -> employee.getFirstName())
				.collect(Collectors.toList());
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
		Stream<Employee> employeeStream = Stream.of(new Employee(21), new Employee(22), new Employee(23),
				new Employee(24));
		int sumOfAges = employeeStream.mapToInt(Employee::getAge).sum();
		System.out.println("sumOfAges: " + sumOfAges);
	}

	/**
	 * Average age of all employees
	 */
	@Ignore
	@Test
	public void averageAge() {
		Stream<Employee> employeeStream = Stream.of(new Employee(21), new Employee(22), new Employee(23),
				new Employee(24));
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
		Stream<Employee> employeeStream = Stream.of(new Employee(21), new Employee(22), new Employee(23),
				new Employee(24));
		OptionalInt maxAge = employeeStream.mapToInt(Employee::getAge).max();
		System.out.println("maxAge: " + maxAge);
		System.out.println("maxAge: " + maxAge.getAsInt());
	}

	/**
	 * Max and Min value in a list
	 */
	@Ignore
	@Test
	public void maxMinValueInList() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 90);

		// maximum value
		System.out.println(list.stream().mapToInt(e -> e).max().getAsInt());

		// minimum value
		System.out.println(list.stream().mapToInt(e -> e).min().getAsInt());
	}

	/**
	 * Min age of all employees
	 */
	@Ignore
	@Test
	public void minAge() {
		Stream<Employee> employeeStream = Stream.of(new Employee(21), new Employee(22), new Employee(23),
				new Employee(24));
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
		List<Employee> employeeStream2 = intStream3.mapToObj(value -> new Employee(value)).collect(
				Collectors.toList());
		employeeStream2.forEach(System.out::println);
	}

	/**
	 * Group employees by age
	 */
	@Ignore
	@Test
	public void groupByAge() {
		List<Employee> employees = Arrays.asList(new Employee("mahesh", 21), new Employee("suresh", 21),
				new Employee("jack", 22), new Employee("jill", 22));

		Map<Integer, List<Employee>> employeesGroupByAge = employees.stream().collect(
				Collectors.groupingBy(Employee::getAge));
		System.out.println(employeesGroupByAge);
	}

	/**
	 * Group employees by age with summary statistics
	 */
	@Ignore
	@Test
	public void ageSummaryStatistics() {
		List<Employee> employees = Arrays.asList(new Employee("mahesh", 21), new Employee("suresh", 21),
				new Employee("jack", 22), new Employee("jill", 22));

		IntSummaryStatistics ageSummaryStatistics = employees.stream().collect(
				Collectors.summarizingInt(Employee::getAge));
		System.out.println(ageSummaryStatistics);
	}

	/**
	 * Joining the list of employee filters to phrase
	 */
	@Ignore
	@Test
	public void joining() {
		List<Employee> employees = Arrays.asList(new Employee("mahesh", 17), new Employee("suresh", 18),
				new Employee("jack", 22), new Employee("jill", 22));
		String phrase = employees.stream().filter(employee -> employee.getAge() > 18)
				.map(employee -> employee.getFirstName())
				.collect(Collectors.joining(" and ", "In India ", " are of legal age employees"));
		System.out.println(phrase);
	}

	/**
	 * Create map(age, firstName) with list of employee objects
	 */
	@Ignore
	@Test
	public void createMapWithEmployee() {
		List<Employee> employees = Arrays.asList(new Employee("mahesh", 17), new Employee("suresh", 17),
				new Employee("jack", 22), new Employee("jill", 22));

		// we are using age as key. If key is same for 2 employees we  will get IllegalStateException. So we need to pass 3rd argument to collect
		Map<Integer, String> employeesMap = employees.stream().collect(
				Collectors.toMap(Employee::getAge, Employee::getFirstName, (name1, name2) -> name1 + ","
						+ name2));
		System.out.println(employeesMap);
	}

	/**
	 * Sort of list of Employee objects
	 */
	@Ignore
	@Test
	public void sortList() {
		List<Employee> employees = Arrays.asList(new Employee("mahesh", 25), new Employee("suresh", 18),
				new Employee("jack", 22), new Employee("jill", 19));

		Comparator<Employee> firstNameComparator = (e1, e2) -> {
			return e1.getFirstName().compareTo(e2.getFirstName());
		};

		// collect entire object into a list
		List<Employee> sortedByFirstName = employees.stream().sorted(firstNameComparator)
				.collect(Collectors.toList());
		System.out.println("sortedByFirstName: " + sortedByFirstName);

		// collect only firstName from sorted list
		List<String> sortByFirstName2 = employees.stream().sorted(firstNameComparator)
				.map(Employee::getFirstName).collect(Collectors.toList());
		System.out.println("sortByFirstName2: " + sortByFirstName2);

		// in line lambda expression
		List<Employee> sortByAge = employees.stream().sorted((e1, e2) -> {
			return Integer.valueOf(e1.getAge()).compareTo(Integer.valueOf(e2.getAge()));
		}).collect(Collectors.toList());
		System.out.println("sortByAge: " + sortByAge);

		List<Employee> employees2 = Arrays.asList(new Employee("jack", "G"), new Employee("jack", "C"),
				new Employee("jack", "A"), new Employee("jack", "H"));
		Comparator<Employee> firstNameComparator2 = (e1, e2) -> {
			return e1.getFirstName().compareTo(e2.getFirstName());
		};
		Comparator<Employee> lastNameComparator = (e1, e2) -> {
			return e1.getLastName().compareTo(e2.getLastName());
		};

		// sort by first name first and then last name
		List<Employee> sortedByFirstNameThenLastName = employees2.stream()
				.sorted(firstNameComparator2.thenComparing(lastNameComparator)).collect(Collectors.toList());
		System.out.println("sortedByFirstNameThenLastName: " + sortedByFirstNameThenLastName);
	}

	/**
	 * If Stream contains Collection of data then operations like filter, sum, distinct, Collectors are not supported. So we need to use flatMap() for 
	 * following conversion:
	 * Stream<String[]>		-> flatMap ->	Stream<String>
	 * Stream<Set<String>>	-> flatMap ->	Stream<String>
	 * Stream<List<String>>	-> flatMap ->	Stream<String>
	 * Stream<List<Object>>	-> flatMap ->	Stream<Object>
	 * 
	 * collection of data after using flatMap():
	 * { {1,2}, {3,4}, {5,6} } -> flatMap -> {1,2,3,4,5,6}
	 * { {'a','b'}, {'c','d'}, {'e','f'} } -> flatMap -> {'a','b','c','d','e','f'}
	 */
	@Ignore
	@Test
	public void flatMapPractice() {
		// 2-D String array without flatMap()
		String[][] stringArray1 = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } };
		Stream<String[]> streamOfArray1 = Arrays.stream(stringArray1);
		Stream<String[]> filter1 = streamOfArray1.filter(e -> "a".equals(e));
		System.out.println("Result 1: ");
		filter1.forEach(System.out::println);

		// 2-D String array with flatMap()
		String[][] stringArray2 = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } };
		Stream<String[]> streamOfArray2 = Arrays.stream(stringArray2);
		Stream<String> streamOfArray2Flatted = streamOfArray2.flatMap(e -> Arrays.stream(e));
		Stream<String> filter2 = streamOfArray2Flatted.filter(e -> "a".equals(e));
		System.out.println("Result 2: ");
		filter2.forEach(System.out::println);

		// java.util.Set<String>
		Set<String> set1 = new HashSet<>(Arrays.asList("a", "b", "c", "d", "a", "e", "c"));
		Stream<Set<String>> streamOfSet = Stream.of(set1);
		List<String> list1 = streamOfSet.flatMap(e -> e.stream()).distinct().collect(Collectors.toList());
		System.out.println("Result 3: ");
		list1.forEach(System.out::println);

		// int[]
		int[] intArray = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		Stream<int[]> intArrayStream = Stream.of(intArray);
		IntStream intStream = intArrayStream.flatMapToInt(e -> Arrays.stream(e));
		System.out.println("Result 4: ");
		intStream.forEach(System.out::println);
	}

	/**
	 * Remove duplicates in a list
	 */
	@Ignore
	@Test
	public void removeDuplicatesInList() {
		List<String> list1 = Arrays.asList("a", "b", "c", "d", "a", "e", "c");
		List<String> list1Result = list1.stream().distinct().collect(Collectors.toList());
		System.out.print("list1Result: ");
		list1Result.forEach(System.out::print);
	}

	/**
	 * Print 10 random numbers
	 */
	@Ignore
	@Test
	public void printRandomNumbers() {
		Random random = new Random(10);

		// print 10 random numbers
		System.out.println("----- 10 random numbers ---------- ");
		random.ints().limit(10).forEach(System.out::println);

		// 10 random numbers where value > 10
		System.out.println("---------10 random numbers and number > 10 ---------------------------");
		random.ints().limit(10).filter(e -> e > 10).forEach(System.out::println);

		// 10 random numbers in sorted order
		System.out.println("----- 10 random numbers in sorted order ------------------");
		random.ints().limit(10).sorted().forEach(System.out::println);
	}

	/**
	 * Unique squares of numbers
	 */
	@Ignore
	@Test
	public void uniqueSquares() {
		List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 4, 4, 5, 6);
		// squares
		numbers.stream().map(number -> number * number).forEach(System.out::println);

		// distinct squares
		System.out.println("------- distinct numbers -----------");
		numbers.stream().map(num -> num * num).distinct().forEach(System.out::println);
	}

	/**
	 * print no.of empty strings
	 */
	@Ignore
	@Test
	public void countEmptyStrings() {
		List<String> strings = Arrays.asList("a", "", "b", "", "c", "", "d");
		System.out.println("number of empty strings: "
				+ strings.stream().filter(str -> str.isEmpty()).count());

		// using parallel stream
		System.out.println("number of empty string using parallel stream: "
				+ strings.parallelStream().filter(e -> e.isEmpty()).count());
	}

	/**
	 * print non empty strings
	 */
	@Ignore
	@Test
	public void printNonEmptyStrings() {
		List<String> strings = Arrays.asList("a", "", "b", "", "c", "", "d");
		System.out.println("non empty strings list: "
				+ strings.stream().filter(str -> !str.isEmpty()).collect(Collectors.toList()));
	}

	/**
	 * print non empty strings and limit the output to 2 strings
	 */
	@Ignore
	@Test
	public void printTwoNonEmptyStrings() {
		List<String> strings = Arrays.asList("a", "", "b", "", "c", "", "d");
		System.out.println("First two non empty strings: "
				+ strings.stream().filter(str -> !str.isEmpty()).limit(2).collect(Collectors.toList()));
	}

	@Test
	public void test() {
		List<String> list = Arrays.asList("dog", "over", "good");

		System.out.println(list.stream().reduce(new String(), (s1, s2) -> s1 + s2.charAt(0),
				(c1, c2) -> c1 += c2));
		list.stream().reduce((x1, x2) -> x1.length() > x2.length() ? x1 : x2).ifPresent(System.out::println);

		System.out.println(list.stream().reduce(new String(), (x1, x2) -> {
			if (x1.equals("dog"))
				return x1;
			return x2;
		}));
		list.stream().reduce((x1, x2) -> x1.length() == 3 ? x1 : x2).ifPresent(System.out::println);
	}

	@Test
	public void test2() {
		List<String> list = Arrays.asList("Jupitor", "Neptune", "Mars", "Earth");
		Map<Integer, List<String>> name_lengths = list.stream().collect(
				Collectors.groupingBy(p -> p.length()));
		name_lengths.forEach((l, s) -> System.out.print(l + "=" + s + " "));
	}
}