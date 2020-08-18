package com.epam.rd.java.basic.practice6.part1;

import java.util.*;

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

    public int getFrequency() {
        return frequency;
    }

    public static void sortWords() {
        List<String> list = Arrays.asList(WordContainer.sb.toString().split(" "));
        System.out.println(list);

        Set<Word> linkedSet = new LinkedHashSet<>();

        for (int i = 0; i < list.size(); i++) {
            linkedSet.add(new Word(list.get(i), Collections.frequency(list, list.get(i))));
        }

        System.out.println(linkedSet);

        linkedSet.stream()
                .sorted(Comparator.comparing(Word::getFrequency))
                .forEachOrdered(x -> System.out.println(x.content + " : " + x.frequency));



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

    @Override
    public String toString() {
        return "Word{" +
                "content='" + content + '\'' +
                ", frequency=" + frequency +
                '}';
    }
}
