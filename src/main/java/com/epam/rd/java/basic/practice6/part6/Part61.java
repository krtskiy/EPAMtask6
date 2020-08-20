package com.epam.rd.java.basic.practice6.part6;

import com.epam.rd.java.basic.practice6.Demo;

import java.util.*;

public class Part61 {

    private Part61() {
        throw new IllegalArgumentException("Utility class");
    }

    public static void frequencyTask(String filePath) {
        List<String> inputList = Arrays.asList(Demo.readFileIntoStringArray(filePath));

        Map<String, Integer> inputMap = new LinkedHashMap<>();

        for (int i = 0; i < inputList.size(); i++) {
            inputMap.put(inputList.get(i), Collections.frequency(inputList, inputList.get(i)));
        }

        inputMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(3)
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEach(x -> System.out.println(x.getKey() + " ==> " + x.getValue()));

    }
}

