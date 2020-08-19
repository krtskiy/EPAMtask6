package com.epam.rd.java.basic.practice6.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WordContainer {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String userInput = reader.readLine();
                if ("stop".equals(userInput)) {
                    break;
                }
                String[] test = userInput.split(" ");
                words.addAll(Arrays.asList(test));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equals("stop")) {
                words = words.subList(0, i);
            }
        }

        Set<Word> wordsSet = new LinkedHashSet<>();
        for (int i = 0; i < words.size(); i++) {
            wordsSet.add(new Word(words.get(i), Collections.frequency(words, words.get(i))));
        }

        for (Word w : wordsSet) {
            System.out.println(w);
        }












//        words = new ArrayList<>();
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            reader.lines()
//                    .flatMap(x -> Arrays.stream(x.split("\\s")))
//                    .sorted()
//                    .distinct()
//                    .forEach(System.out::println);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        StringBuilder sb = new StringBuilder();
//        Scanner scan = new Scanner(System.in);
//        while (true) {
//            String userInput = scan.nextLine();
//            if (userInput.contains("stop ") || userInput.contains(" stop")) {
//                sb.append(userInput, 0, userInput.indexOf("stop"));
//            } else if ("stop".equals(userInput)) {
//                scan.close();
//
//                List<String> list = Arrays.asList(sb.toString().split(" "));
//                Set<Word> linkedSet = new LinkedHashSet<>();
//
//                for (int i = 0; i < list.size(); i++) {
//                    linkedSet.add(new Word(list.get(i), Collections.frequency(list, list.get(i))));
//                }
//
//                linkedSet.stream()
//                        .sorted(Comparator.comparing(Word::getFrequency).reversed())
//                        .forEachOrdered(System.out::println);
//
//                return;
//            } else {
//                sb.append(userInput.trim()).append(" ");
//            }
//        }

    }

}
