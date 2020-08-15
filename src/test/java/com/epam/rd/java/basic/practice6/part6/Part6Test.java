package com.epam.rd.java.basic.practice6.part6;

import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Part6Test {

    @Test
    public void shouldPrintMessageIfInputIsWrong() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expected = "";
        Part6.main(new String[] {"-i", "part6.txt", "--tsk", "frqnc"});
        Assert.assertEquals(expected, outContent.toString());
    }
    
}
