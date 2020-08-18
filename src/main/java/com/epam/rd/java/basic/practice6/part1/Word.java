package com.epam.rd.java.basic.practice6.part1;

import java.util.*;
import java.util.stream.Collectors;

public class Word implements Comparable<Word> {

    private String content;
    private int frequency;

    public Word(String content, int frequency) {
        this.content = content;
        this.frequency = frequency;
    }

    public String getContent() {
        return content;
    }

    public static void sortWords() {
        List<String> list = Arrays.asList(WordContainer.sb.toString().split(" "));
//        Map<String, Integer> map = new LinkedHashMap<>();

        List<Word> wordList = new LinkedList<>();

        for (int i = 0; i < list.size(); i++) {
            wordList.add(new Word(list.get(i), Collections.frequency(list, list.get(i))));
        }

        wordList.sort((o1, o2) -> {
            if (o1.frequency < o2.frequency) {
                return 1;
            } else if (o1.frequency > o2.frequency) {
                return -1;
            } else {
                return 0;
            }
        });

        wordList.stream()
                .collect(Collectors.toSet())
                .stream()
                .sorted()
                .forEach(x -> System.out.println(x.content + " : " + x.frequency));


//        map.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
//                .forEach(System.out::println);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        if (frequency != word.frequency) return false;
        return content != null ? content.equals(word.content) : word.content == null;
    }

    @Override
    public int hashCode() {
        int result = content != null ? content.hashCode() : 0;
        result = 31 * result + frequency;
        return result;
    }

    @Override
    public int compareTo(Word o) {
        if (this.frequency < o.frequency) {
            return 1;
        } else if (this.frequency > o.frequency) {
            return -1;
        } else {
            return 0;
        }
    }
}
