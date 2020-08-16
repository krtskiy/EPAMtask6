package com.epam.rd.java.basic.practice6.part6;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Part6Test {

    private static final String FILE_PATH = "part6.txt";
    private static final String LINE_SEP = System.lineSeparator();


    @Test
    public void shouldPrintMessageIfInputIsWrong() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expected = "";
        Part6.main(new String[]{"-i", FILE_PATH, "--tsk", "frqnc"});
        Assert.assertEquals(expected, outContent.toString());
    }

    @Test
    public void frequencyTaskSHouldPrintCorrectOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expected = "whale ==> 3" + LINE_SEP +
                "cheetah ==> 4" + LINE_SEP +
                "bison ==> 3" + LINE_SEP;
        Part61.frequencyTask(FILE_PATH);
        Assert.assertEquals(expected, outContent.toString());

    }

    @Test
    public void lengthTaskSHouldPrintCorrectOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expected = "chimpanzee ==> 10" + LINE_SEP +
                "mongoose ==> 8" + LINE_SEP +
                "tortoise ==> 8" + LINE_SEP;
        Part62.lengthTask(FILE_PATH);
        Assert.assertEquals(expected, outContent.toString());


    }

    @Test
    public void duplicateTaskSHouldPrintCorrectOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expected = "RAUGAJ" + LINE_SEP +
                "NOSIB" + LINE_SEP +
                "ELAHW" + LINE_SEP;
        Part63.duplicatesTask(FILE_PATH);
        Assert.assertEquals(expected, outContent.toString());

    }

}
