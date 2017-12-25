package core.java.file.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import org.junit.Ignore;
import org.junit.Test;

public class FileIOPractice {

	public static void main(String[] args) {
		/*FileIOPractice fileUtil = new FileIOPractice();
		fileUtil.listFilesAndDirectories(new File("E:/Backup/JavaPrep/practiceProjects/images"));*/

		try {
			readFileWithRelativePathFromStaticMethod();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	 * Prepare java.io.File object using string path
	 */
	@Ignore
	@Test
	public void stringToFileObject() {
		String filePath1 = "file1.txt";
		File file1 = new File(filePath1);
		System.out.println("file1: " + file1);

		String filePath2 = "E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\file1.txt";
		File file2 = new File(filePath2);
		System.out.println("file2: " + file2);
	}

	/**
	 * Read file using absolute path
	 */
	@Ignore
	@Test
	public void readFileWithRelativePath() throws IOException {
		URL url = getClass().getClassLoader().getResource("file1.txt");
		File file = new File(url.getPath());
		System.out.println("readFileWithRelativePath() -> file.getAbsolutePath(): " + file.getAbsolutePath());

		System.out.println("-----------------method 1 - reading content--------------------------");
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		}

		System.out.println("-----------------method 2 - reading content--------------------------");
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("file1.txt");
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		}
	}

	/**
	 * Read file with relative path from static method
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void readFileWithRelativePathFromStaticMethod() throws FileNotFoundException, IOException {

		URL url = FileIOPractice.class.getClassLoader().getResource("file1.txt");
		File file = new File(url.getPath());
		System.out.println("readFileWithRelativePathFromStaticMethod() -> file.getAbsolutePath(): "
				+ file.getAbsolutePath());

		System.out.println("-----------------method 1 - reading content--------------------------");
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		}

		System.out.println("-----------------method 2 - reading content--------------------------");
		try (InputStream inputStream = FileIOPractice.class.getClassLoader().getResourceAsStream("file1.txt");
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		}

	}

	/**
	 * convert file to java.io.InputStream
	 * @throws IOException
	 */
	@Ignore
	@Test
	public void convertFileToInputstream() throws IOException {
		String filePath1 = "E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\file1.txt";
		File file = new File(filePath1);
		InputStream inputStream1 = new FileInputStream(file);
		System.out.println("inputStream1: " + inputStream1 + ", number of bytes:" + inputStream1.available());
		inputStream1.close();

		InputStream inputStream2 = getClass().getClassLoader().getResourceAsStream("file1.txt");
		System.out.println("inputStream2: " + inputStream2 + ", number of bytes:" + inputStream2.available());
		inputStream2.close();

		// from java 7 
		try (InputStream inputStream3 = getClass().getClassLoader().getResourceAsStream("file1.txt")) {
			System.out.println(
					"inputStream3: " + inputStream3 + ", number of bytes:" + inputStream3.available());
		}
	}

	/**
	 * Read contents of the file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Test
	public void readContentsOfFile() throws FileNotFoundException, IOException {
		System.out.println(
				"-------------method 1 using java.io.BufferedReader with relative path--------------------------");
		URL url = getClass().getClassLoader().getResource("file1.txt");
		File file = new File(url.getPath());
		System.out.println("readContentsOfFile() -> file.getAbsolutePath(): " + file.getAbsolutePath());
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		}

		System.out.println(
				"----------------method 2 java.io.BufferedReader with absolute path-----------------------");
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
				"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\file1.txt"))) {
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		}

		System.out
				.println("-----------------method 3 read file using java.util.Scanner----------------------");
		URL url2 = getClass().getClassLoader().getResource("file1.txt");
		File file2 = new File(url2.getPath());
		System.out.println("readContentsOfFile() -> file2.getAbsolutePath(): " + file2.getAbsolutePath());
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
		}

		System.out.println("----------method 4 - read file using java.io.InputStream --------------");
		File file3 = new File(getClass().getClassLoader().getResource("file1.txt").getPath());
		try (InputStream inputStream = new FileInputStream(file3);
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line).append("\n");
			}
			System.out.println("stringBuffer: " + stringBuffer);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("---------- method 5 using JDK 8 Collection streams ------------");
		final Path path = new File(getClass().getClassLoader().getResource("file1.txt").getPath()).toPath();
		try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
			lines.onClose(() -> System.out.println("Done")).forEach(System.out::println);
		}
	}

	/**
	 * Delete file
	 */
	@Ignore
	@Test
	public void deleteFile() {
		URL url = getClass().getClassLoader().getResource("file2.txt");
		File file = new File(url.getPath());
		File parentDirectory = new File(file.getParent());

		// before file delete
		System.out.println("--- before delete-----");
		String[] filesList = parentDirectory.list();
		for (String fileName : filesList) {
			System.out.println("fileName: " + fileName);
		}

		file.delete();

		//after file delete
		System.out.println("--- after delete-----");
		filesList = parentDirectory.list();
		for (String fileName : filesList) {
			System.out.println("fileName: " + fileName);
		}
	}

	/**
	 * Copy file
	 * @throws IOException
	 */
	@Ignore
	@Test
	public void copyFile() throws IOException {
		// method 1
		System.out.println("------ using java.io.InputStream ------------");
		File outputFile = new File(
				"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\file1-copy1.txt");
		byte[] buffer = new byte[1024];
		int length = 0;

		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("file1.txt");
				OutputStream outputStream = new FileOutputStream(outputFile);) {
			while ((length = inputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, length);
			}
		}
		System.out.println("java.io.InputStream -> file copied");

		// method 2
		System.out.println("--------using java.nio.channels.FileChannel ----------");
		URL url = getClass().getClassLoader().getResource("file1.txt");
		File source = new File(url.getPath());
		File destination = new File(
				"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\file1-copy2.txt");

		try (FileInputStream sourceInputStream = new FileInputStream(source);
				FileChannel sourceChannel = sourceInputStream.getChannel();
				FileOutputStream destOutputStream = new FileOutputStream(destination);
				FileChannel destChannel = destOutputStream.getChannel();) {
			destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
		}

		System.out.println("java.nio.channels.FileChannel -> file copied");

		// method 3 - from java 7
		System.out.println("----- using java.nio.file.Files ----------");
		URL url2 = getClass().getClassLoader().getResource("file1.txt");
		File source2 = new File(url2.getPath());
		File destination2 = new File(
				"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\file1-copy3.txt");
		Files.copy(source2.toPath(), destination2.toPath());
		System.out.println("java.nio.file.Files -> file copied");
	}

	/**
	 * Create file
	 * @throws IOException
	 */
	@Ignore
	@Test
	public void createFile() throws IOException {
		File file1 = new File(
				"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\new-file.txt");
		boolean isFile1Created = file1.createNewFile();
		System.out.println("isFile1Created: " + isFile1Created);
		System.out.println("FileIOPractice -> createFile() -> writing file1 using BufferedWriter");
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1));) {
			bufferedWriter.write("Hello new-file.txt");
		}

		File file2 = new File(
				"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\new-file2.txt");
		boolean isFile2Created = file2.createNewFile();
		System.out.println("isFile2Created: " + isFile2Created);
		System.out.println("FileIOPractice -> createFile() -> writing file2 using OutputStream");
		String fileData = "New file created. Let's write some data";
		byte[] fileDataAsByteArray = fileData.getBytes(StandardCharsets.UTF_8);
		try (OutputStream outputStream = new FileOutputStream(file2);) {
			outputStream.write(fileDataAsByteArray, 0, fileDataAsByteArray.length);
		}

		System.out.println("files creation completed");
	}

	/**
	 * Reading Zip file
	 * @throws IOException 
	 */
	@Ignore
	@Test
	public void readZipFile() throws IOException {
		URL url = getClass().getClassLoader().getResource("my-zip-file.zip");
		try (ZipFile zipFile = new ZipFile(url.getPath());) {

			// reading all files in a zip file
			Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();
			while (zipEntries.hasMoreElements()) {
				ZipEntry zipEntry = zipEntries.nextElement();
				if (zipEntry.isDirectory()) {
					System.out.println("Dir -> " + zipEntry.getName());
				} else {
					System.out.println("File -> " + zipEntry.getName());
				}
			}

			System.out.println("-----------------------------------------");

			// getting specific file in zip file
			ZipEntry file1Entry = zipFile.getEntry("my-zip-file/file1.txt");
			InputStream file1InputStream = zipFile.getInputStream(file1Entry);
			try (BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(file1InputStream));) {
				StringBuffer content = new StringBuffer();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					content.append(line).append("\n");
				}
				System.out.println("file1 content: " + content);
			}

			System.out.println("-----------------------------------------");

			// getting specific file in sub-folder in zip file
			ZipEntry file4Entry = zipFile.getEntry("my-zip-file/sub-folder/file4.txt");
			InputStream file4InputStream = zipFile.getInputStream(file4Entry);
			try (BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(file4InputStream));) {
				StringBuffer content = new StringBuffer();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					content.append(line).append("\n");
				}
				System.out.println("file4 content: " + content);
			}

		}

	}

	/**
	 * Create Zip file with single file
	 */
	@Ignore
	@Test
	public void createZipFileWithOneFile() {
		byte[] buffer = new byte[1024];

		// we are using try-with-resource, so closing of resources will be done automatically
		try (FileOutputStream fos = new FileOutputStream(
				"E:/Backup/JavaPrep/practiceProjects/CoreJavaPractice/src/main/resources/myZip.zip");
				ZipOutputStream zos = new ZipOutputStream(fos);
				InputStream is = getClass().getClassLoader().getResourceAsStream("file1.txt");) {

			System.out.println("fos: " + fos);
			System.out.println("zos: " + zos);
			System.out.println("is: " + is);

			ZipEntry zipEntry = new ZipEntry("file1.log");
			zos.putNextEntry(zipEntry);

			int length;
			while ((length = is.read(buffer)) > 0) {
				zos.write(buffer, 0, length);
			}

			zos.closeEntry();

			System.out.println("Zip file created");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create zip file with files present in a folder
	 * @throws IOException 
	 */
	@Ignore
	@Test
	public void createZipWithFilesInFolder() throws IOException {
		List<String> sourceFileNamesList = new ArrayList<>();
		String sourceFolder = "E:/Backup/JavaPrep/practiceProjects/CoreJavaPractice/src/main/resources/folder1";
		String outputZipFile = "E:/Backup/JavaPrep/practiceProjects/CoreJavaPractice/src/main/resources/myZip2.zip";

		//get all files names in a source folder
		//if this directory contains sub-directories, iterate recursively to get all file names
		//refer listFilesAndDirectories(File directory) method in this class
		File sourceDirectory = new File(sourceFolder);
		String[] sourceFileNames = sourceDirectory.list();
		for (String sourceFileName : sourceFileNames) {
			int startIndex = Integer.parseInt(String.valueOf(sourceDirectory.length()));
			int endIndex = sourceFileName.length();
			sourceFileNamesList.add(sourceFileName.substring(startIndex, endIndex));
		}

		System.out.println("sourceFileNamesList: " + sourceFileNamesList);

		// create zip file
		byte[] buffer = new byte[1024];

		try (FileOutputStream fos = new FileOutputStream(outputZipFile);
				ZipOutputStream zos = new ZipOutputStream(fos);) {
			for (String file : sourceFileNamesList) {

				// to read file using class loader that file should be in class path else we need to complete path of file and create input stream
				try (InputStream is = getClass().getClassLoader().getResourceAsStream(file);) {
					ZipEntry zipEntry = new ZipEntry(file);
					zos.putNextEntry(zipEntry);

					int length;
					while ((length = is.read(buffer)) > 0) {
						zos.write(buffer, 0, length);
					}

					System.out.println("File Added: " + file);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Zip file created");
	}

	/**
	 * Method to get current project directory
	 */
	@Test
	public void getCurrentProjectDirectory() {
		// method 1
		String projectDirectory1 = System.getProperty("user.dir");
		System.out.println(
				"FileIOPractice -> getCurrentDirectory() -> projectDirectory1: " + projectDirectory1);

		// method 2
		String projectDirectory2 = Paths.get("").toAbsolutePath().toString();
		System.out.println(
				"FileIOPractice -> getCurrentDirectory() -> projectDirectory2: " + projectDirectory2);

		// method 3
		String projectDirectory3 = Paths.get(".").toAbsolutePath().normalize().toString();
		System.out.println(
				"FileIOPractice -> getCurrentDirectory() -> projectDirectory3: " + projectDirectory3);

		// method 4
		URL projectDirectory4 = getClass().getProtectionDomain().getCodeSource().getLocation();
		System.out.println(
				"FileIOPractice -> getCurrentDirectory() -> projectDirectory4: " + projectDirectory4);

		// method 5
		String myCurrentDir = System.getProperty("user.dir") + File.separator
				+ System.getProperty("sun.java.command")
						.substring(0, System.getProperty("sun.java.command").lastIndexOf("."))
						.replace(".", File.separator);
		System.out.println("FileIOPractice -> getCurrentDirectory() -> myCurrentDir: " + myCurrentDir);
	}

	@Test
	public void lineNumberReader() throws IOException {
		URL url = getClass().getClassLoader().getResource("file1.txt");
		File file = new File(url.getPath());

		Reader reader = new FileReader(file);
		try (LineNumberReader lineNumberReader = new LineNumberReader(reader)) {

			String line;
			while (null != (line = lineNumberReader.readLine()))
				System.out.println(lineNumberReader.getLineNumber() + ": " + line);
		}
	}

	/**
	 * method to get line separator based on underlying operating system instead of hard coding
	 */
	@Test
	public void lineSeparator() {
		String lineSeparator = System.getProperty("line.separator").toString();
		System.out.println("abc" + lineSeparator + "def");

		String lineSeparator2 = File.separator;
		System.out.println("lineSeperator2: " + lineSeparator2);
	}

	@Test
	public void createDirectory() {
		boolean isTestFolderCreated = new File("E:\\Backup\\testFolder").mkdir();
		System.out.println("isTestFolderCreated: " + isTestFolderCreated);

		boolean isFolderStructureCreated = new File("E:\\Backup\\folder1\\folder2").mkdirs();
		System.out.println("isFolderStructureCreated: " + isFolderStructureCreated);

		// from JDK 7 - using java.nio.file package
		try {
			Path path = Paths.get("E:\\Backup\\folder3\\folder4");
			System.out.println("Files.exists(path) : " + Files.exists(path));
			Files.createDirectories(path);
			System.out.println("Files.exists(path) : " + Files.exists(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}