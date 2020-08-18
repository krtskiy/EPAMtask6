package com.epam.rd.java.basic.practice6.part5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TreeTest {

    Tree<Integer> tree;

    @Before
    public void createTreeOfIntegers() {
        tree = new Tree<>();
    }

    @Test
    public void shouldAddElementToTree() {
        Assert.assertTrue(tree.add(3));
    }

    @Test
    public void shouldNotAddIfElementAlreadyExists() {
        tree.add(7);
        Assert.assertFalse(tree.add(7));
    }

    @Test
    public void shouldNotAddSeveralElements() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        tree.add(3);
        tree.add(2);
        tree.add(2);
        tree.add(new Integer[]{4, 2});
        tree.print();

        String expected = "  2" + System.lineSeparator() +
                "3" + System.lineSeparator() +
                "  4" + System.lineSeparator();

        Assert.assertEquals(expected, outContent.toString());
    }

    @Test
    public void part5MainShouldPrintRightOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Part5.main(null);

        String expected = "  1" + System.lineSeparator() +
                "    2" + System.lineSeparator() +
                "3" + System.lineSeparator() +
                "      5" + System.lineSeparator() +
                "    6" + System.lineSeparator() +
                "  7" + System.lineSeparator() +
                "    8" + System.lineSeparator() +
                "        9" + System.lineSeparator() +
                "      10" + System.lineSeparator();

        Assert.assertEquals(expected, outContent.toString());
    }

    @Test
    public void shouldRemoveElementIfExists() {
        tree.add(3);
        Assert.assertTrue(tree.remove(3));
    }

    @Test
    public void removeMethodShouldReturnFalseIfElementDoesNotExists() {
        Assert.assertFalse(tree.remove(420));
    }

}
