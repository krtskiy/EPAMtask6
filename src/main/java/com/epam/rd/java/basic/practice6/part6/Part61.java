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

        List<String> arrayList = new ArrayList<>();

        for (int i = 0; i < inputList.size(); i++) {
            StringBuilder str = new StringBuilder();
            if (Collections.frequency(inputList, inputList.get(i)) > 2) {
                arrayList.add(str.append(inputList.get(i)).append(" ==> ").append(Collections.frequency(inputList, inputList.get(i))).toString());
            }
            inputMap.put(inputList.get(i), Collections.frequency(inputList, inputList.get(i)));

        }

        Collections.sort(arrayList);
        Set<String> testSet = new LinkedHashSet<>();
        for (int i = 0; i < arrayList.size(); i++) {
            testSet.add(arrayList.get(i));
        }

        List<String> blablabla = new LinkedList<>(testSet);
        for (int i = 0; i < 3; i++) {
            System.out.println(blablabla.get(blablabla.size() - 1 - i));
        }

    }
}

