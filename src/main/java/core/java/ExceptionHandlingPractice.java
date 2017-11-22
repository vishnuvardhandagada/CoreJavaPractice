package core.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.junit.Test;

import core.java.model.CustomCheckedException;
import core.java.model.CustomUnCheckedException;

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
	
	/**
	 * Handled runtime/unchecked exception with try-catch.
	 * catch with java.lang.Exception class
	 */
	@Test
	public void uncheckedWithTryCatch2() {
		try {
			throw new RuntimeException("ExceptionHandlingPractice.uncheckedWithTryCatch2 - RuntimeException thrown");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Handle checked exception with try-catch
	 */
	@Test
	public void checkedWithTryCatch() {
		try {
			throw new Exception("ExceptionHandlingPractice.checkedWithTryCatch- Exception thrown");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * unchecked exception with try-catch
	 * finally block always executes
	 */
	@Test
	public void tryCatchFinally(){
		try {
			throw new RuntimeException("ExceptionHandlingPractice.uuncheckedWithTryCatchFinally");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("ExceptionHandlingPractice.uncheckedWithTryCatchFinally");
		}
	}
	
	/**
	 * try with finally block without catch
	 */
	@Test
	public void tryFinally(){
		try {
			System.out.println("ExceptionHandlingPractice.tryFinally - try block");
		}finally {
			System.out.println("ExceptionHandlingPractice.tryFinally - finally block");
		}
	}
	
	/**
	 * try-finally
	 * finally will execute even though we have return in try block
	 */
	@Test
	public void tryWithReturnAndFinally() {
		try {
			System.out.println("ExceptionHandlingPractice.tryWithReturnAndFinally - try block");
			return;
		}finally {
			System.out.println("ExceptionHandlingPractice.tryWithReturnAndFinally - finally block");
		}
	}
	
	/**
	 * try-finally
	 * if we exit - finally block will not be executed
	 */
	@Test
	public void tryWithExitAndFinally() {
		try {
			System.out.println("ExceptionHandlingPractice.tryWithExitAndFinally - try block");
			System.exit(0);
		}finally {
			System.out.println("ExceptionHandlingPractice.tryWithExitAndFinally - finally block");
		}
	}
	
	/**
	 * close FileReader, BufferedReader in finally block 
	 */
	@Test
	public void tryFinallyResource() {
		URL url = ExceptionHandlingPractice.class.getClassLoader().getResource("file1.txt");
		File file = new File(url.getPath());
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			String line = "";
			
			while(null != (line = bufferedReader.readLine())){
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(null != fileReader)
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			if(null != bufferedReader)
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	/**
	 * close FileReader, BufferedReader using try-with-resource
	 */
	@Test
	public void tryWithResource() {
		URL url = ExceptionHandlingPractice.class.getClassLoader().getResource("file1.txt");
		File file = new File(url.getPath());
		try(FileReader fileReader = new FileReader(file); BufferedReader bufferedReader = new  BufferedReader(fileReader)){
			String line = "";
			
			while(null != (line = bufferedReader.readLine())) {
				System.out.println(line);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Handle custom checked exception and display our message
	 */
	@Test
	public void customCheckedException() {
		try {
			throw new CustomCheckedException("ExceptionHandlingPractice.customCheckedException");
		}catch(CustomCheckedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Handle custom checked exception and display default message
	 */
	@Test
	public void customCheckedException2() {
		try {
			throw new CustomCheckedException();
		}catch(CustomCheckedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Handle custom unchecked exception. Display our message
	 */
	@Test
	public void customUnCheckedException() {
		try {
			throw new CustomUnCheckedException("ExceptionHandlingPractice.customUnCheckedException");
		}catch(CustomUnCheckedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Handle custom unchecked exception. Display default message
	 */
	@Test
	public void customUnCheckedException2() {
		try {
			throw new CustomUnCheckedException();
		}catch(CustomUnCheckedException e) {
			e.printStackTrace();
		}
	}
}