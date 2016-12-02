package core.java.collections;

import java.util.ArrayList;
import java.util.List;

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
}
