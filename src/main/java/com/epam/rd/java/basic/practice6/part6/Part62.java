package com.epam.rd.java.basic.practice6.part6;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Part62 {

    public static void lengthTask(String filePath) {
        List<String> list = new LinkedList<>();
        String[] input = Part6.readFileIntoStringArray(filePath);
        for (int i = 0; i < input.length; i++) {
            list.add(input[i]);
        }


        Collections.sort(list, (o1, o2) -> Integer.compare(o2.length(), o1.length()));

        for (int i = 0; i < 3; i++) {
            System.out.println(list.get(i) + " ==> " + list.get(i).length());
        }

    }

}
