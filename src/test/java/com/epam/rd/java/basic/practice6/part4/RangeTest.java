package com.epam.rd.java.basic.practice6.part4;

import org.junit.Assert;
import org.junit.Test;

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

}
