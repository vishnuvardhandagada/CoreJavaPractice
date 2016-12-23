package core.java.enums;

import org.junit.Ignore;
import org.junit.Test;

import core.java.enums.model.DaysEnum;
import core.java.enums.model.DaysEnum2;

public class EnumsPractice {

    @Ignore
    @Test
    public void accessEnum() {
	DaysEnum monday = DaysEnum.MONDAY;
	System.out.println("EnumsPractice -> method1() -> monday: " + monday);
    }

    @Ignore
    @Test
    public void enumInIf() {
	DaysEnum monday = DaysEnum.MONDAY;
	DaysEnum tuesday = DaysEnum.TUESDAY;

	if (DaysEnum.MONDAY == monday) {
	    System.out.println("1. EnumsPractice -> enumInIfStatement() -> monday");
	} else {
	    System.out.println("1. EnumsPractice -> enumInIfStatement() -> tueday");
	}

	if (DaysEnum.MONDAY == tuesday) {
	    System.out.println("2. EnumsPractice -> enumInIfStatement() -> monday");
	} else {
	    System.out.println("2. EnumsPractice -> enumInIfStatement() -> tueday");
	}
    }

    @Ignore
    @Test
    public void enumInSwitch() {
	DaysEnum monday = DaysEnum.MONDAY;

	switch (monday) {
	case MONDAY:
	    System.out.println("monday");
	    break;
	case TUESDAY:
	    System.out.println("tuesday");
	    break;
	default:
	    System.out.println("other");
	    break;
	}
    }

    @Ignore
    @Test
    public void iterateEnum() {
	DaysEnum[] days = DaysEnum.values();
	for (DaysEnum day : days) {
	    System.out.println(day);
	}
    }

    @Ignore
    @Test
    public void iterateEnumWithArgumentedConstructor() {
	DaysEnum2[] days = DaysEnum2.values();
	for (DaysEnum2 day : days) {
	    System.out.println(day.getValue());
	}
    }
}
