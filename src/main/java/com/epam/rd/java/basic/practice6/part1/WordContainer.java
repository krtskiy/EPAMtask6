package com.epam.rd.java.basic.practice6.part1;

import java.util.*;

public class WordContainer {

    private static StringBuilder sb;

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
//                scan.close();

                List<String> list = Arrays.asList(WordContainer.sb.toString().split(" "));
                Set<Word> linkedSet = new LinkedHashSet<>();

                for (int i = 0; i < list.size(); i++) {
                    linkedSet.add(new Word(list.get(i), Collections.frequency(list, list.get(i))));
                }

                linkedSet.stream()
						.sorted(Comparator.comparing(Word::getFrequency).reversed())
						.forEachOrdered(System.out::println);


                return;
            }
        }


    }

}
