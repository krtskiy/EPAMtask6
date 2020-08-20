package com.epam.rd.java.basic.practice6.part6;

import com.epam.rd.java.basic.practice6.Demo;

import java.util.Arrays;

public class Part62 {

    private Part62() {
        throw new IllegalArgumentException("Utility class");
    }

    public static void lengthTask(String filePath) {
        String[] input = Demo.readFileIntoStringArray(filePath);

        Arrays.sort(input, (o1, o2) -> Integer.compare(o2.length(), o1.length()));

        Arrays.stream(input)
                .limit(3)
                .forEach(x -> System.out.println(x + " ==> " + x.length()));

    }

}
