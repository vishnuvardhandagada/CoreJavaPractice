package core.java.enums.model;

public enum DaysEnum2 {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6);

    private final int value;

    private DaysEnum2(int value) {
	this.value = value;
    }

    public int getValue() {
	return value;
    }
}
