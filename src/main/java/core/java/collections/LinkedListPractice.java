package core.java.collections;

import java.util.LinkedList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class LinkedListPractice {

    /**
     * Add elements to java.util.LinkedList
     */
    @Ignore
    @Test
    public void addElementsToLinkedList() {
	List<String> list = new LinkedList<>();
	list.add("a");
	list.add("b");
	list.add("c");
	list.add("d");
	list.add("e");

	System.out.println("list: " + list);
    }

    /**
     * Remove middle element in a java.util.LinkedList
     */
    @Ignore
    @Test
    public void removeMiddleElementFromLinkedList() {
	List<String> list = new LinkedList<>();
	list.add("a");
	list.add("b");
	list.add("c");
	list.add("d");
	list.add("e");

	System.out.println("1 -> list: " + list);

	list.remove(2);

	System.out.println("2 -> list: " + list);
    }
}
