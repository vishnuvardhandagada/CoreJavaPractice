package core.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    //    @Ignore
    @Test
    public void convertArrayToList() {
	int[] numbersArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	List<Integer> numbersList = Arrays.stream(numbersArray).boxed().collect(Collectors.toList());
	System.out.println(numbersList);
    }
}
