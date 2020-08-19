package com.epam.rd.java.basic.practice6.part1;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class WordContainerTest {

    private static final String LINE_SEP = System.lineSeparator();

    @Test
    public void shouldCreateWordObject() {
        Word word = new Word("word", 1);
        Assert.assertNotNull(word);
    }

    @Test
    public void shouldIgnoreWordsAfterStop() {
        String expected = "asd : 1" + LINE_SEP;
        System.setIn(new ByteArrayInputStream("asd stop asdf asd".getBytes(StandardCharsets.UTF_8)));
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        WordContainer.main(null);
        Assert.assertEquals(expected, outContent.toString());
    }

    @Test
    public void shouldPrintCorrectResult() {
        String expected = "asdf : 3" + LINE_SEP +
                "asd : 2" + LINE_SEP +
                "43 : 2" + LINE_SEP +
                "434 : 1" + LINE_SEP +
                "kasdf : 1" + LINE_SEP;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Part1.main(null);
        Assert.assertEquals(expected, outContent.toString());
    }

    @Test
    public void frequencyGetterShouldGetFrequency() {
        Word word = new Word("word", 1);
        int expected = 1;
        Assert.assertEquals(expected, word.getFrequency());
    }

}
