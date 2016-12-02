package core.java.file.io;

import java.io.File;

public class FilePractice {

    public static void main(String[] args) {
	FilePractice fileUtil = new FilePractice();
	fileUtil.listFilesAndDirectories(new File("E:/Backup/JavaPrep/practiceProjects/images"));
    }

    public void listFilesAndDirectories(File directory) {
	File[] listOfFiles = directory.listFiles();
	for (File file : listOfFiles) {
	    if (file.isDirectory())
		listFilesAndDirectories(file);
	    System.out.println(file.getPath() + "\\" + file.getName());
	}
    }
}
