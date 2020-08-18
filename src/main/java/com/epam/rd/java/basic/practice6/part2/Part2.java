package com.epam.rd.java.basic.practice6.part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Part2 {

    List<Integer> list;

    public static void main(String[] args) {
        Part2 part2Obj = new Part2();
        List<Integer> list = part2Obj.createLinkedList(7);
        List<Integer> array = part2Obj.createArrayList(7);

        System.out.println("ArrayList#Index: " + removeByIndex(array, 3) + " ms");
        System.out.println("LinkedList#Index: " + removeByIndex(list, 3) + " ms");
        System.out.println("ArrayList#Iterator: " + removeByIterator(array, 3) + " ms");
        System.out.println("LinkedList#Iterator: " + removeByIterator(list, 3) + " ms");

    }

    public List<Integer> createLinkedList(int size) {
        list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }

    public List<Integer> createArrayList(int size) {
        list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;

    }

    public static long removeByIndex(final List<Integer> list, final int k) {
        long before = System.currentTimeMillis();

        while (list.size() != 1) {

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
