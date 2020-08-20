package com.epam.rd.java.basic.practice6.part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Part2 {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        List<Integer> array = new ArrayList<>();
        fillContainer(list, 10_000);
        fillContainer(array, 10_000);

        System.out.println("ArrayList#Index: " + removeByIndex(array, 4) + " ms");
        System.out.println("LinkedList#Index: " + removeByIndex(list, 4) + " ms");

        fillContainer(list, 10_000);
        fillContainer(array, 10_000);

        System.out.println("ArrayList#Iterator: " + removeByIterator(array, 4) + " ms");
        System.out.println("LinkedList#Iterator: " + removeByIterator(list, 4) + " ms");
    }

    public static void fillContainer(List<Integer> list, int size) {
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
    }

    public static long removeByIndex(final List<Integer> list, final int k) {
        long before = System.currentTimeMillis();

        int index = k - 1;
        while (list.size() != 1) {
            if (index < list.size()) {
                list.remove(index);
                index += k - 1;
            }
            while (index >= list.size()) {
                index = index - list.size();
            }
            list.remove(index);
            index += k - 1;
        }

        long after = System.currentTimeMillis();
        return after - before;
    }

    public static long removeByIterator(final List<Integer> list, int k) {
        long before = System.currentTimeMillis();

        int index = 0;
        while (list.size() != 1) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                index++;
                it.next();
                if (index == k) {
                    it.remove();
                    index = 0;
                }
            }
        }

        long after = System.currentTimeMillis();
        return after - before;
    }

}
