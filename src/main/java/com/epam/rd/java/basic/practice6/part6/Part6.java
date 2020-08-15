package com.epam.rd.java.basic.practice6.part6;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

    private static Logger logger = Logger.getLogger(Part6.class.getName());
    private static final String FNFE_MSG = "File not found!";
    private static final String IOE_MSG = "IO exception!";

    public static void main(String[] args) {
        String filePath = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-i") || args[i].equals("--input")) {
                filePath = args[i + 1];
            }
            if (args[i].equals("-t") || args[i].equals("--task")) {
                if (args[i + 1].equals("frequency")) {
                    Part61.frequencyTask(filePath);
                } else if (args[i + 1].equals("length")) {
                    Part62.lengthTask(filePath);
                } else if (args[i + 1].equals("duplicates")) {
                    Part63.duplicatesTask(filePath);
                }
            }
        }

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
