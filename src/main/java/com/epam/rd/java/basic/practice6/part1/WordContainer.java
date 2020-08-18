package com.epam.rd.java.basic.practice6.part1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WordContainer {

//    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner scan = new Scanner(System.in);
        while (true) {
            String userInput = br.readLine();
            if (userInput.contains("stop")) {
                sb.append(userInput, 0, userInput.indexOf("stop"));
            } else {
                sb.append(userInput.trim()).append(" ");
            }
            if ("stop".equals(userInput)) {
                br.close();

                List<String> list = Arrays.asList(sb.toString().split(" "));
                Set<Word> linkedSet = new LinkedHashSet<>();

                for (int i = 0; i < list.size(); i++) {
                    linkedSet.add(new Word(list.get(i), Collections.frequency(list, list.get(i))));
                }

                linkedSet.stream()
						.sorted(Comparator.comparing(Word::getFrequency).reversed())
						.forEachOrdered(System.out::println);

                linkedSet.clear();
                return;
            }
        }


    }

}
