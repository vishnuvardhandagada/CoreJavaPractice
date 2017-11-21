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

	/**
	 * RuntimeException/unchecked exception
	 */
	@Test
	public void uncheckedException() {
		throw new RuntimeException("RuntimeException thrown");
	}

	/**
	 * Exception/checked exception
	 */
	@Test
	public void checkedException() throws Exception {
		throw new Exception("Exception object created and thrown");
	}

	/**
	 * Handle runtime/unchecked exception using try-catch
	 */
	@Test
	public void uncheckedWithTryCatch() {
		try {
			throw new RuntimeException("RuntimeException thrown");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
}