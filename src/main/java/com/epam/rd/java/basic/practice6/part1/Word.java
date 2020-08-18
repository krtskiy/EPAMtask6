package com.epam.rd.java.basic.practice6.part1;

import java.util.*;

public class Word {

    private String content;
    private int frequency;

    public Word(String content, int frequency) {
        this.content = content;
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        if (frequency != word.frequency) return false;
        return Objects.equals(content, word.content);
    }

    @Override
    public int hashCode() {
        int result = content != null ? content.hashCode() : 0;
        result = 31 * result + frequency;
        return result;
    }

    @Override
    public String toString() {
        return content + " : " + frequency;
    }
}
