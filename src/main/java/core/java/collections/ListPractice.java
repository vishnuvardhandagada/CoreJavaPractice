package core.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Ignore;
import org.junit.Test;

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
    @Ignore
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
}