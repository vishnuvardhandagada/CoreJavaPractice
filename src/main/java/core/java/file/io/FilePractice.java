package core.java.file.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

import org.junit.Ignore;
import org.junit.Test;

public class FilePractice {

    public static void main(String[] args) {
	FilePractice fileUtil = new FilePractice();
	fileUtil.listFilesAndDirectories(new File("E:/Backup/JavaPrep/practiceProjects/images"));
    }

    /**
     * Method to iterate list of files in directories and sub directories
     * @param directory
     */
    public void listFilesAndDirectories(File directory) {
	File[] listOfFiles = directory.listFiles();
	for (File file : listOfFiles) {
	    if (file.isDirectory())
		listFilesAndDirectories(file);
	    System.out.println(file.getPath() + "\\" + file.getName());
	}
    }

    /**
     * Read file using absolute path
     */
    //    @Ignore
    @Test
    public void readFileWithRelativePath() throws IOException {
	URL url = getClass().getResource("file1.txt");
	File file = new File(url.getPath());
	System.out.println("readFileWithRelativePath() -> file.getAbsolutePath(): " + file.getAbsolutePath());

	try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {
	    String line = "";
	    while ((line = bufferedReader.readLine()) != null) {
		System.out.println(line);
	    }
	}
	System.out.println("-------------------------------------------");

	//method 2
	try (InputStream inputStream = getClass().getResourceAsStream("file1.txt");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
	    String line = "";
	    while ((line = bufferedReader.readLine()) != null) {
		System.out.println(line);
	    }
	}
    }

    @Ignore
    @Test
    public void readContentsOfFile() throws FileNotFoundException, IOException {
	URL url = getClass().getResource("file1.txt");
	File file = new File(url.getPath());
	System.out.println("readContentsOfFile() -> file.getAbsolutePath(): " + file.getAbsolutePath());

	//method 1 using java.io.BufferedReader with relative path
	try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {
	    String line = "";
	    while ((line = bufferedReader.readLine()) != null) {
		System.out.println(line);
	    }
	}
	System.out.println("---------------------------------------");

	//method 2 java.io.BufferedReader with absolute path
	try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
		"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\java\\core\\java\\file\\io\\file1.txt"))) {
	    String line = "";
	    while ((line = bufferedReader.readLine()) != null) {
		System.out.println(line);
	    }
	}
	System.out.println("---------------------------------------");

	//method 3
	try (Scanner scanner = new Scanner(file)) {
	    while (scanner.hasNextLine()) {
		System.out.println(scanner.nextLine());
	    }
	}
    }
}
