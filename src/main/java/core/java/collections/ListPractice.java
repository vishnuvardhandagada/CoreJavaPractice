package core.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Ignore;
import org.junit.Test;

public class ListPractice {

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
	List<String> stringList = Arrays.asList(stringArray);
	System.out.println("stringList: " + stringList);

	List<String> stringList2 = new ArrayList<>(Arrays.asList(stringArray));
	System.out.println("stringList2: " + stringList2);

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

	Integer[] numbersArray3 = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	List<Integer> numbersList3 = Arrays.asList(numbersArray3);
	System.out.println("numbersList3: " + numbersList3);

    }

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
	    System.out.print(value + ",");
	}
    }
}
