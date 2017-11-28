package core.java.collections;

import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Ignore;
import org.junit.Test;

import core.java.collections.model.Student;

public class ListPractice {

	public static void main(String[] args) {
		ListPractice listPractice = new ListPractice();
		List<Integer> srcList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println(listPractice.splitList(srcList, 2));
		System.out.println(listPractice.splitList(srcList, 3));
		System.out.println(listPractice.splitList(srcList, 4));
		System.out.println(listPractice.splitList(srcList, 5));
		System.out.println(listPractice.splitList(srcList, 10));
		System.out.println(listPractice.splitList(srcList, 15));
	}

	/**
	 * Method to split list into sub lists of required size
	 * 
	 * @param srcList
	 * @param lengthOfSubList
	 * @return
	 */
	public <T> List<List<T>> splitList(List<T> srcList, final int lengthOfSubList) {
		List<List<T>> splits = new ArrayList<>();
		final int size = srcList.size();
		for (int i = 0; i < size; i = i + lengthOfSubList) {
			splits.add(new ArrayList<T>(srcList.subList(i, Math.min(size, i + lengthOfSubList))));
		}
		return splits;
	}

	@Ignore
	@Test
	public void convertArrayToList() {
		String[] stringArray = new String[] { "A", "B", "C", "D" };

		// method 1
		List<String> stringList = Arrays.asList(stringArray);
		System.out.println("stringList: " + stringList);

		// method 2
		List<String> stringList2 = new ArrayList<>(Arrays.asList(stringArray));
		System.out.println("stringList2: " + stringList2);

		// method 3
		int[] numbersArray1 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		List<Integer> numbersList1 = new ArrayList<>();
		for (int number : numbersArray1) {
			numbersList1.add(number);
		}
		System.out.println("numbersList1: " + numbersList1);

		// from java 8
		int[] numbersArray2 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		List<Integer> numbersList2 = Arrays.stream(numbersArray2).boxed().collect(Collectors.toList());
		System.out.println("numbersList2: " + numbersList2);

		// method 4
		Integer[] numbersArray3 = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		List<Integer> numbersList3 = Arrays.asList(numbersArray3);
		System.out.println("numbersList3: " + numbersList3);

	}

	/**
	 * Method to convert list to array
	 */
	@Ignore
	@Test
	public void convertListToArray() {
		List<String> list1 = new ArrayList<>();
		list1.add("A");
		list1.add("B");
		list1.add("C");
		System.out.println("list1: " + list1);

		String[] list1Array = list1.toArray(new String[list1.size()]);
		for (String value : list1Array) {
			System.out.println(value);
		}
	}

	/**
	 * Method to prepare comma separated String from List values
	 */
	//	@Ignore
	@Test
	public void convertListToCommaSeparatedString() {
		List<String> list = Arrays.asList("A", "B", "C", "D", "E");

		//method 1
		StringBuffer listToString1 = new StringBuffer(list.toString());
		listToString1.deleteCharAt(0);
		listToString1.deleteCharAt(listToString1.length() - 1);
		String destString = listToString1.toString().replace(" ", "");
		System.out.println("listToString1: " + destString);

		// method 2
		Iterator<String> iterator = list.iterator();
		StringBuffer listToString2 = new StringBuffer();
		for (;;) {
			listToString2.append(iterator.next());
			if (!iterator.hasNext())
				break;
			listToString2.append(",");
		}
		System.out.println("listToString2: " + listToString2);

		// method 3
		StringBuffer listToString3 = new StringBuffer("[");
		for (Iterator<String> iterator2 = list.iterator(); iterator2.hasNext();) {
			listToString3.append(iterator2.next());
			if (iterator2.hasNext()) {
				listToString3.append(",");
			}
		}
		listToString3.append("]");
		System.out.println("listToString3: " + listToString3.toString());

		// method 4
		String listToString4 = String.join("-", list);
		System.out.println("listToString4: " + listToString4);
	}

	/**
	 * Remove all nulls from List
	 */
	@Ignore
	@Test
	public void removeAllNullsFromList() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add(null);
		list.add("b");
		list.add(null);
		list.add("c");
		list.add(null);

		System.out.println("list: " + list);

		// remove nulls
		list.removeAll(Collections.singleton(null));

		System.out.println("after remove: " + list);
	}

	@Ignore
	@Test
	public void list1MinusList2() {
		List<String> list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		list1.add("d");
		list1.add("e");

		List<String> list2 = new ArrayList<>();
		list2.add("a");
		list2.add("b");
		list2.add("c");

		System.out.println("list1: " + list1);
		System.out.println("list2: " + list2);

		list1.removeAll(list2);
		System.out.println("After removeAll -> list1: " + list1);
	}

	@Ignore
	@Test
	public void list1IntersectionList2() {
		List<String> list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		list1.add("d");
		list1.add("e");

		List<String> list2 = new ArrayList<>();
		list2.add("a");
		list2.add("b");
		list2.add("c");

		System.out.println("list1: " + list1);
		System.out.println("list2: " + list2);

		list1.retainAll(list2);
		System.out.println("After retainAll -> list1: " + list1);
	}

	/**
	 * list1 = {a,b,c,d,e}
	 * list2 = {a,b,c,f,g,h}
	 * output = {a,b,c,d,e,f,g,h}
	 */
	@Ignore
	@Test
	public void prepareNewListWithUniqueValues() {
		List<String> list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		list1.add("d");
		list1.add("e");

		List<String> list2 = new ArrayList<>();
		list2.add("a");
		list2.add("b");
		list2.add("c");
		list2.add("f");
		list2.add("g");
		list2.add("h");

		List<String> commonElementsList = new ArrayList<>(list2);
		commonElementsList.retainAll(list1);
		list2.removeAll(commonElementsList);
		list1.addAll(list2);
		System.out.println(list1);
	}

	/**
	 * Create immutable list
	 */
	@Ignore
	@Test
	public void immutableList() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");

		System.out.println("list: " + list);
		List<String> immutableList = Collections.unmodifiableList(list);
		System.out.println("immutableList: " + immutableList);

		try {
			immutableList.add("d");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Changes to sub list will reflect in main list
	 */
	@Ignore
	@Test
	public void subListChangesReflectToMainList() {
		List<String> mainList = new ArrayList<>();
		mainList.add("one");
		mainList.add("two");
		mainList.add("three");
		mainList.add("four");
		List<String> subList = mainList.subList(0, 2);

		System.out.println("---Before-----");
		System.out.println("mainList size: " + mainList.size() + ", mainList: " + mainList);
		System.out.println("subList size: " + subList.size() + ", subList: " + subList);

		subList.add("five");
		System.out.println("---Before-----");
		System.out.println("mainList size: " + mainList.size() + ", mainList: " + mainList);
		System.out.println("subList size: " + subList.size() + ", subList: " + subList);
	}

	/**
	 * Sort list by java.util.Date
	 */
	@Test
	@Ignore
	public void sortListByJavaUtilDate() {
		List<List<Object>> list = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();

		List<Object> row1 = new ArrayList<>();
		row1.add(1);
		row1.add(calendar.getTime());

		List<Object> row2 = new ArrayList<>();
		row2.add(1);
		calendar.add(Calendar.DAY_OF_MONTH, 3);
		row2.add(calendar.getTime());

		List<Object> row3 = new ArrayList<>();
		row3.add(1);
		calendar.add(Calendar.DAY_OF_MONTH, 3);
		row3.add(calendar.getTime());

		List<Object> row4 = new ArrayList<>();
		row4.add(1);
		calendar.add(Calendar.DAY_OF_MONTH, 3);
		row4.add(calendar.getTime());

		List<Object> row5 = new ArrayList<>();
		row5.add(1);
		calendar.add(Calendar.DAY_OF_MONTH, 3);
		row5.add(calendar.getTime());

		List<Object> row6 = new ArrayList<>();
		row6.add(1);
		calendar.add(Calendar.DAY_OF_MONTH, 3);
		row6.add(calendar.getTime());

		list.add(row6);
		list.add(row5);
		list.add(row4);
		list.add(row3);
		list.add(row2);
		list.add(row1);

		Comparator<List<Object>> dateComparator = (list1, list2) -> {
			Date date1 = (Date) list1.get(1);
			Date date2 = (Date) list2.get(1);

			return date1.compareTo(date2);
		};
		System.out.println("------------- Before -------------");
		System.out.println(list);

		list.sort(dateComparator);

		System.out.println("------------- After -------------");
		System.out.println(list);
	}

	/**
	 * Sort list by java.time.LocalDate
	 */
	@Test
	public void sortListByJavaTimeLocalDate() {
		List<List<Object>> list = new ArrayList<>();
		LocalDate localDate = LocalDate.now(Clock.systemDefaultZone());

		List<Object> row1 = new ArrayList<>();
		row1.add(1);
		row1.add(localDate);

		List<Object> row2 = new ArrayList<>();
		row2.add(2);
		row2.add(localDate.plusDays(1));

		List<Object> row3 = new ArrayList<>();
		row3.add(3);
		row3.add(localDate.plusDays(2));

		List<Object> row4 = new ArrayList<>();
		row4.add(4);
		row4.add(localDate.plusDays(3));

		List<Object> row5 = new ArrayList<>();
		row5.add(5);
		row5.add(localDate.plusDays(4));

		List<Object> row6 = new ArrayList<>();
		row6.add(6);
		row6.add(localDate.plusDays(5));

		list.add(row6);
		list.add(row5);
		list.add(row4);
		list.add(row3);
		list.add(row2);
		list.add(row1);

		Comparator<List<Object>> dateComparator = (list1, list2) -> {
			LocalDate date1 = (LocalDate) list1.get(1);
			LocalDate date2 = (LocalDate) list2.get(1);

			return date1.compareTo(date2);
		};
		System.out.println("------------- Before -------------");
		System.out.println(list);

		list.sort(dateComparator);

		System.out.println("------------- After -------------");
		System.out.println(list);
	}

	@Test
	public void sortList() {
		List<Student> students = new ArrayList<>();
		Student student1 = new Student(15, "g");
		Student student2 = new Student(57, "a");
		Student student3 = new Student(45, "d");

		students.add(student1);
		students.add(student2);
		students.add(student3);

		System.out.println("unsorted list: " + students);

		Collections.sort(students);
		System.out.println("default sort as per comparable: " + students);

		/*Comparator<Student> idComparator = new Comparator<Student>() {
		
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getId().compareTo(o2.getId());
			}
		};*/

		// using JDK 8 - Lambda Expression
		Comparator<Student> idComparator = (Student o1, Student o2) -> {
			return o1.getId().compareTo(o2.getId());
		};

		Collections.sort(students, idComparator);
		System.out.println("sort by id: " + students);
	}

	/**
	 * Remove elements from list while iteration
	 */
	@Test
	public void removeelementsFromList() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");

		// No Exception but not all elements will be removed - we will get unpredicted behavior
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			list.remove(i);
		}
		System.out.println(list);

		// ConcurrentModificationException
		/*System.out.println(list);
		for (String str : list) {
			list.remove(str);
		}
		System.out.println(list);*/

		// No Exception
		/*System.out.println(list);
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}
		System.out.println(list);*/

	}
}