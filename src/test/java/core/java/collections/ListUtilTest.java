package core.java.collections;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ListUtilTest {

    @Test
    public void testSplitList() {
	List<Integer> srcList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	ListPractice collectionsUtil = new ListPractice();
	System.out.println(collectionsUtil.splitList(srcList, 2));
	System.out.println(collectionsUtil.splitList(srcList, 3));
	System.out.println(collectionsUtil.splitList(srcList, 4));
	System.out.println(collectionsUtil.splitList(srcList, 5));
	System.out.println(collectionsUtil.splitList(srcList, 10));
	System.out.println(collectionsUtil.splitList(srcList, 15));
    }
}
