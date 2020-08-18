package com.epam.rd.java.basic.practice6.part4;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class RangeTest {

    @Test
    public void shouldReturnInNaturalOrder() {
        Range range = new Range(6, 9);
        String expected = "6789";
        StringBuilder actual = new StringBuilder();
        for (Integer el : range) actual.append(el);
        Assert.assertEquals(expected, actual.toString());
    }

    @Test
    public void shouldReturnInReverseOrder() {
        Range range = new Range(4, 20, true);
        String expected = "2019181716151413121110987654";
        StringBuilder actual = new StringBuilder();
        for (Integer el : range) actual.append(el);
        Assert.assertEquals(expected, actual.toString());
    }

    @Test
    public void part4MainShouldPrintRightOutput() {
        String expected = "3 4 5 6 7 8 9 10 " + System.lineSeparator() +
                "10 9 8 7 6 5 4 3 " + System.lineSeparator();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Part4.main(null);
        Assert.assertEquals(expected, outContent.toString());
    }

}
