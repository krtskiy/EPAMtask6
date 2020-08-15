package com.epam.rd.java.basic.practice6;

import com.epam.rd.java.basic.practice6.part6.Part6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Demo {

	private static Logger logger = Logger.getLogger(Demo.class.getName());
	private static final String FNFE_MSG = "File not found!";
	public static final String FILE_PATH = "part6.txt";

	public static void main(String[] args) {
		System.out.println("~~~~~~~~~~~~~~~ PART6 ~~~~~~~~~~~~~~~\n");
		System.out.println("~~~~~ Frequency task ~~~~~");
		Part6.main(new String[] {"-i", FILE_PATH, "--task", "frequency"});
		System.out.println("~~~~~ Length task ~~~~~");
		Part6.main(new String[] {"--input", FILE_PATH, "--task", "length"});
		System.out.println("~~~~~ Duplicates task ~~~~~");
		Part6.main(new String[] {"--input", FILE_PATH, "-t", "duplicates"});
	}

	public static String[] readFileIntoStringArray(String path) {
		StringBuilder result = new StringBuilder();
		File file = new File(path);
		try {
			Scanner scan = new Scanner(file, "cp1251");
			while (scan.hasNextLine()) {
				result.append(scan.nextLine()).append(System.lineSeparator());
			}
			scan.close();
			return result.toString().trim().split("\\s{1,}");
		} catch (FileNotFoundException e) {
			logger.severe(FNFE_MSG);
		}
		return result.toString().split(" ");
	}

}
