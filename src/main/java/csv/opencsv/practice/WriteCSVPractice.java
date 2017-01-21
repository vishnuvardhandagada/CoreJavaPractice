package csv.opencsv.practice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

import com.opencsv.CSVWriter;

public class WriteCSVPractice {

    /**
     * Method to create CSV File
     * @throws IOException
     */
    @Ignore
    @Test
    public void createCSVFile() throws IOException {
	CSVWriter csvWriter = new CSVWriter(new FileWriter(
		"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\java\\csv\\practice\\opencsv\\model\\file1.csv"));
	String[] row1 = new String[] { "first", "second", "third" };
	String[] row2 = new String[] { "four", "five", "six" };

	csvWriter.writeNext(row1);
	csvWriter.writeNext(row2);

	csvWriter.close();
	System.out.println("OpenCSVPractice -> createCSVFile() -> CSV File creted");

	// using try-with-resource - CSVWriter implements java.io.Closeable, so we can use try-with-resource
	try (CSVWriter csvWriter2 = new CSVWriter(new FileWriter(
		"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\java\\csv\\practice\\opencsv\\model\\file2.csv"));) {
	    row1 = new String[] { "seven", "eight", "nine" };
	    row2 = new String[] { "ten", "elleven", "twelve" };
	    csvWriter2.writeNext(row1);
	    csvWriter2.writeNext(row2);
	}
	System.out.println("OpenCSVPractice -> createCSVFile() -> CSV File creted using try-with-resource");
    }

    @Ignore
    @Test
    public void createCSVFileWithCustomSeparator() throws IOException {
	// create CSV file with separator as ~
	try (CSVWriter csvWriter = new CSVWriter(new FileWriter(
		"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\java\\csv\\practice\\opencsv\\model\\file3.csv"), '~')) {
	    String[] row1 = new String[] { "first", "second", "third" };
	    String[] row2 = new String[] { "four", "five", "six" };

	    csvWriter.writeNext(row1);
	    csvWriter.writeNext(row2);

	    System.out.println("CSV File create with ~ separator");
	}
    }

    @Ignore
    @Test
    public void createCSVFileWithCustomSeparatorAndQuoteCharacter() throws IOException {
	// create CSV file with separator as ~ and enclose each value in single-quote
	try (CSVWriter csvWriter = new CSVWriter(new FileWriter(
		"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\java\\csv\\practice\\opencsv\\model\\file4.csv"), '~', '\'')) {
	    String[] row1 = new String[] { "first", "second", "third" };
	    String[] row2 = new String[] { "four", "five", "six" };

	    csvWriter.writeNext(row1);
	    csvWriter.writeNext(row2);

	    System.out.println("CSV File create with ~ separator and each value enclosed with single-quote");
	}
    }

    @Test
    public void createCSVFileWithCommaInColumn() {
	File file = new File("E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\java\\csv\\opencsv\\practice\\model\\file5.csv");
	try {
	    file.createNewFile();
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
	try (CSVWriter csvWriter = new CSVWriter(new FileWriter(file));) {
	    String s1 = "six";
	    String s2 = "seven";
	    String s3 = s1 + "," + s2;
	    String[] row2 = new String[] { s1.toString(), s2.toString(), s3.toString() };
	    csvWriter.writeNext(row2);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}