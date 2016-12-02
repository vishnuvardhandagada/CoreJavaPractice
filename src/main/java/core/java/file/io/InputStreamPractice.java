package core.java.file.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Ignore;
import org.junit.Test;

public class InputStreamPractice {

    @Ignore
    @Test
    public void stringToFileObject() {
	String filePath1 = "file1.txt";
	File file1 = new File(filePath1);
	System.out.println("file1: " + file1);

	String filePath2 = "E:/Backup/JavaPrep/practiceProjects/CoreJavaPractice/src/main/java/core/java/file/io/file1.txt";
	File file2 = new File(filePath2);
	System.out.println("file2: " + file2);
    }

    @Ignore
    @Test
    public void convertFileToInputstream() throws IOException {
	String filePath1 = "E:/Backup/JavaPrep/practiceProjects/CoreJavaPractice/src/main/java/core/java/file/io/file1.txt";
	File file = new File(filePath1);
	InputStream inputStream1 = new FileInputStream(file);
	System.out.println("inputStream1: " + inputStream1 + ", number of bytes:" + inputStream1.available());
	inputStream1.close();

	InputStream inputStream2 = new FileInputStream(
		"E:/Backup/JavaPrep/practiceProjects/CoreJavaPractice/src/main/java/core/java/file/io/file1.txt");
	System.out.println("inputStream2: " + inputStream2 + ", number of bytes:" + inputStream2.available());
	inputStream2.close();
    }

    @Ignore
    @Test
    public void readFile() {
	String filePath1 = "E:/Backup/JavaPrep/practiceProjects/CoreJavaPractice/src/main/java/core/java/file/io/file1.txt";
	File file = new File(filePath1);
	try (InputStream inputStream = new FileInputStream(file);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {
	    StringBuffer stringBuffer = new StringBuffer();
	    String line;
	    while ((line = bufferedReader.readLine()) != null) {
		stringBuffer.append(line);
	    }
	    System.out.println("stringBuffer: " + stringBuffer);
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }
}
