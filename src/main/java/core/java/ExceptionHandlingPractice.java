package core.java;

import org.junit.Test;

public class ExceptionHandlingPractice {

    @Test
    public void exceptionInForLoop() {
	try {
	    for (int i = 0; i < 10; i++) {
		if (i == 5)
		    throw new NullPointerException("Exception thrown");
	    }
	} catch (NullPointerException e) {
	    e.printStackTrace();
	}

    }
}
