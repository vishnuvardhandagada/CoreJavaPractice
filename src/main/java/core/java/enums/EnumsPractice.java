package core.java.enums;

import org.junit.Ignore;
import org.junit.Test;

import core.java.enums.model.DaysEnum;

public class EnumsPractice {

    @Ignore
    @Test
    public void accessEnum() {
	DaysEnum monday = DaysEnum.MONDAY;
	System.out.println("EnumsPractice -> method1() -> monday: " + monday);
    }

    //    @Ignore
    @Test
    public void enumInIfStatement() {
	DaysEnum monday = DaysEnum.MONDAY;
	DaysEnum tuesday = DaysEnum.TUESDAY;

	if (DaysEnum.MONDAY == monday) {
	    System.out.println("1. EnumsPractice -> enumInIfStatement() -> monday");
	} else if (DaysEnum.TUESDAY == tuesday) {
	    System.out.println("1. EnumsPractice -> enumInIfStatement() -> tueday");
	}

	if (DaysEnum.MONDAY == tuesday) {
	    System.out.println("2. EnumsPractice -> enumInIfStatement() -> monday");
	} else if (DaysEnum.TUESDAY == tuesday) {
	    System.out.println("2. EnumsPractice -> enumInIfStatement() -> tueday");
	}
    }
}
