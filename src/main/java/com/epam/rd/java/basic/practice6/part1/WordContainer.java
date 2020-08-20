package com.epam.rd.java.basic.practice6.part1;

import java.util.*;

public class WordContainer {

    public static void main(String[] args) {
        StringBuilder inputText = new StringBuilder();
        Scanner scan = new Scanner(System.in);
        while (true) {
            String userInput = scan.next();
            if (userInput.contains("stop ") || userInput.contains(" stop")) {
                inputText.append(userInput, 0, userInput.indexOf("stop"));
            } else if ("stop".equals(userInput)) {
                scan.close();
                displayWordsAndFrequency(inputText.toString());
                return;
            } else {
                inputText.append(userInput.trim()).append(" ");
            }
        }

    }

    private static void displayWordsAndFrequency(String text) {
        List<String> list = Arrays.asList(text.split("\\s"));
        Set<Word> linkedSet = new LinkedHashSet<>();

        for (int i = 0; i < list.size(); i++) {
            linkedSet.add(new Word(list.get(i), Collections.frequency(list, list.get(i))));
        }

        linkedSet.stream()
                .sorted(Comparator.comparing(Word::getFrequency).reversed())
                .forEach(System.out::println);
    }


}
