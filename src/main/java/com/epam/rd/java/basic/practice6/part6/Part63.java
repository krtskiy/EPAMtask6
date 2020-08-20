package com.epam.rd.java.basic.practice6.part6;

import com.epam.rd.java.basic.practice6.Demo;

import java.util.*;

public class Part63 {

    private Part63() {
        throw new IllegalArgumentException("Utility class");
    }

    public static void duplicatesTask(String filePath) {
        List<String> inputList = Arrays.asList(Demo.readFileIntoStringArray(filePath));

        inputList.stream()
                .filter(x -> Collections.frequency(inputList, x) > 1)
                .limit(3)
                .forEach(x -> System.out.println(new StringBuilder(x.toUpperCase()).reverse()));

    }
}
