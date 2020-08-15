package com.epam.rd.java.basic.practice6.part6;

import com.epam.rd.java.basic.practice6.Demo;

import java.util.*;
import java.util.stream.Collectors;

public class Part63 {

    private Part63() {
        throw new IllegalArgumentException("Utility class");
    }

    public static void duplicatesTask(String filePath) {
        List<String> inputList = Arrays.asList(Demo.readFileIntoStringArray(filePath));
        List<String> listOfDuplicates = inputList.stream()
                                        .filter(x -> Collections.frequency(inputList, x) > 1)
                                        .collect(Collectors.toList());

        for (int i = 0; i < 3; i++) {
            System.out.println(new StringBuilder(listOfDuplicates.get(i).toUpperCase()).reverse());
        }


    }
}
