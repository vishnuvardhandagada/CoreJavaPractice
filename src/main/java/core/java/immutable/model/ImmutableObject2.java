package core.java.immutable.model;

/**
 * 1. Has argumented constructor
 * 2. return new instance on any operation on this object
 * @author Avinash Babu Donthu
 *
 */
public class ImmutableObject2 {

    private int value;

    public ImmutableObject2(int value) {
	this.value = value;
    }

    public int getValue() {
	return value;
    }

    public ImmutableObject2 add(int value) {
	return new ImmutableObject2(this.value + value);
    }
}
