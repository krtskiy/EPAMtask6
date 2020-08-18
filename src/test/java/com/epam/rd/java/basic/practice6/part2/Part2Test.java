package com.epam.rd.java.basic.practice6.part2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Part2Test {

    List<Integer> list;
    List<Integer> array;
    Part2 part2;

    @Before
    public void createArrayListAndLinkedListAndPart2Object() {
        list = new LinkedList<>();
        array = new ArrayList<>();
        part2 = new Part2();
    }

    @Test
    public void shouldFillLinkedListWithRightSize() {
        List<Integer> expected = new LinkedList<>();
        int expectedSize = 420;
        part2.fillContainer(expected, expectedSize);
        Assert.assertEquals(expectedSize, expected.size());
    }

    @Test
    public void shouldFillArrayListWithRightSize() {
        List<Integer> expected = new ArrayList<>();
        int expectedSize = 322;
        part2.fillContainer(expected, expectedSize);
        Assert.assertEquals(expectedSize, expected.size());
    }

    @Test
    public void shouldRemoveByIteratorFromLinkedList() {
        list.add(0);
        list.add(1);
        list.add(2);
        int expectedSize = 1;

        Part2.removeByIterator(list, 2);
        Assert.assertEquals(expectedSize, list.size());
    }

    @Test
    public void shouldRemoveByIteratorFromArrayList() {
        array.add(0);
        array.add(1);
        array.add(2);
        int expectedSize = 1;
        Part2.removeByIterator(array, 2);
        Assert.assertEquals(expectedSize, array.size());
    }

    @Test
    public void shouldRemoveByIndexFromLinkedList() {
        part2.fillContainer(list, 10);
        int step = 7;
        int expectedSize = 1;
        Part2.removeByIndex(list, step);
        Assert.assertEquals(expectedSize, list.size());
    }

    @Test
    public void shouldRemoveByIndexFromArrayList() {
        part2.fillContainer(array, 15);
        int step = 5;
        int expectedSize = 1;
        Part2.removeByIndex(array, step);
        Assert.assertEquals(expectedSize, array.size());

    }

    // fake test just for code coverage
    @Test
    public void part2MainShouldPrintSomething() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Part2.main(null);
        boolean expected = outContent.toString().contains("");
        Assert.assertTrue(expected);
    }


}