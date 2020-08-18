package com.epam.rd.java.basic.practice6.part1;

import java.util.Scanner;

public class WordContainer {

	static StringBuilder sb;

    public static void main(String[] args) {
        sb = new StringBuilder();
        Scanner scan = new Scanner(System.in);
        while (true) {
            String userInput = scan.nextLine();
            if (userInput.contains("stop")) {
				sb.append(userInput, 0, userInput.indexOf("stop"));
            } else {
                sb.append(userInput.trim()).append(" ");
            }
            if ("stop".equals(userInput)) {
                scan.close();
                Word.sortWords();
                return;
            }
        }


    }

}
