package core.java.immutable.model;

/**
 * Immutable object - way 1
 * 1. Provide argumented constructor
 * 2. Do not provide setter method for instance variable
 * 
 * @author Avinash Babu Donthu
 */
public class ImmutableObject1 {

    private String name;

    public ImmutableObject1(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }
}