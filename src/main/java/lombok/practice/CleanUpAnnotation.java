package lombok.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import lombok.Cleanup;

public class CleanUpAnnotation {

	public void method1() throws FileNotFoundException, IOException {
		try (InputStream io = new FileInputStream("")) {

		}

		@Cleanup
		InputStream io = new FileInputStream("");
	}
}
