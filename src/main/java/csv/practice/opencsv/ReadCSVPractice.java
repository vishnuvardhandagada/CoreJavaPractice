package csv.practice.opencsv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.opencsv.CSVReader;

public class ReadCSVPractice {

    @Ignore
    @Test
    public void readCSVFile() throws IOException {
	String[] nextLine;

	CSVReader csvReader = new CSVReader(new FileReader(new File(
		"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\java\\csv\\practice\\opencsv\\model\\file1.csv")));
	while ((nextLine = csvReader.readNext()) != null) {
	    System.out.println(nextLine[0] + ", " + nextLine[1] + ", " + nextLine[2]);
	}
	csvReader.close();

	// using try-with-resource
	try (CSVReader csvReader2 = new CSVReader(new FileReader(new File(
		"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\java\\csv\\practice\\opencsv\\model\\file2.csv")));) {
	    while ((nextLine = csvReader2.readNext()) != null) {
		System.out.println(nextLine[0] + ", " + nextLine[1] + ", " + nextLine[2]);
	    }
	}

	// reading to List<String[]>
	try (CSVReader csvReader2 = new CSVReader(new FileReader(new File(
		"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\java\\csv\\practice\\opencsv\\model\\file1.csv")));) {
	    List<String[]> allRows = csvReader2.readAll();
	    for (String[] row : allRows) {
		System.out.println(row[0] + ", " + row[1] + ", " + row[2]);
	    }
	}
    }

    /**
     * Method to read CSV file with separator as ~. 
     * Run {@link WriteCSVPractice#createCSVFileWithCustomSeparator()} before. This will generate file3.csv with separator ~ 
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Ignore
    @Test
    public void readCSVFileWithCustomSeparator() throws FileNotFoundException, IOException {
	System.out.println("ReadCSVPractice -> readCSVFileWithCustomSeparator()");
	try (CSVReader csvReader2 = new CSVReader(new FileReader(new File(
		"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\java\\csv\\practice\\opencsv\\model\\file3.csv")), '~');) {
	    List<String[]> allRows = csvReader2.readAll();
	    for (String[] row : allRows) {
		System.out.println(row[0] + ", " + row[1] + ", " + row[2]);
	    }
	}
    }

    /**
     * Method to read CSV file with separator as ~. 
     * Run {@link WriteCSVPractice#createCSVFileWithCustomSeparatorAndQuoteCharacter()} before. This will generate file4.csv with separator ~ 
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Ignore
    @Test
    public void readCSVFileWithCustomSeparatorAndQuoteCharacter() throws FileNotFoundException, IOException {
	System.out.println("ReadCSVPractice -> readCSVFileWithCustomSeparatorAndQuoteCharacter()");
	try (CSVReader csvReader2 = new CSVReader(new FileReader(new File(
		"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\java\\csv\\practice\\opencsv\\model\\file4.csv")), '~', '\'');) {
	    List<String[]> allRows = csvReader2.readAll();
	    for (String[] row : allRows) {
		System.out.println(row[0] + ", " + row[1] + ", " + row[2]);
	    }
	}
    }

    /**
     * Method to read CSV file by skipping the number of lines specified while create com.opencsv.CSVReader object
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Ignore
    @Test
    public void readCSVFileBySkippingFirstLine() throws FileNotFoundException, IOException {
	System.out.println("ReadCSVPractice -> readCSVFileBySkippingFirstLine()");
	try (CSVReader csvReader2 = new CSVReader(new FileReader(new File(
		"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\java\\csv\\practice\\opencsv\\model\\file4.csv")), '~', '\'', 1);) {
	    List<String[]> allRows = csvReader2.readAll();
	    for (String[] row : allRows) {
		System.out.println(row[0] + ", " + row[1] + ", " + row[2]);
	    }
	}
    }
}
