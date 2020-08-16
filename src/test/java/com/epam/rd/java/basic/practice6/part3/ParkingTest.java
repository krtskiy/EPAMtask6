package com.epam.rd.java.basic.practice6.part3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ParkingTest {

    private Parking testParking;

    @Before
    public void createParkingWith4Places() {
        testParking = new Parking(4);
    }

    @Test
    public void shouldArriveSuccessfullyIfPlaceIsOccupied() {
        testParking.arrive(1);
        Assert.assertTrue(testParking.arrive(1));
    }

//    @Test
//    public void shouldArriveSuccessfullyWithoutParam() {
//        Assert.assertTrue(testParking.arrive());
//    }

    @Test
    public void shouldDepartSuccessfullyFromOccupiedPlace() {
        testParking.arrive(3);
        Assert.assertTrue(testParking.depart(3));
    }

//    @Test
//    public void shouldDepartSuccessfullyWithoutParam() {
//        testParking.arrive();
//        Assert.assertTrue(testParking.depart());
//    }

    @Test
    public void shouldPrintRightStateOfParking() {
        testParking.arrive(1);
        testParking.arrive(2);
        testParking.arrive(3);
        testParking.depart(2);
        String expected = "0101" + System.lineSeparator();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        testParking.print();
        Assert.assertEquals(expected, outContent.toString());
    }

    @Test
    public void part3MainShouldPrintRightState() {
        String expected = "1100" + System.lineSeparator();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Part3.main(null);
        Assert.assertEquals(expected, outContent.toString());

    }


}