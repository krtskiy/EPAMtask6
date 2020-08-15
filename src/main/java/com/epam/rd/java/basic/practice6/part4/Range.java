package com.epam.rd.java.basic.practice6.part4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer> {

    private int first;
    private int second;
    private boolean reverseOrder;

    Range(int first, int second) {
        this.first = first;
        this.second = second;
    }

    Range(int first, int second, boolean reversedOrder) {
        this.first = first;
        this.second = second;
        this.reverseOrder = reversedOrder;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IteratorImpl();
    }

    private final class IteratorImpl implements Iterator<Integer> {

        @Override
        public boolean hasNext() {
            return reverseOrder ? second > first - 1 : first < second + 1;
        }

        @Override
        public Integer next() {
            if (!reverseOrder) {
                if (first > second) throw new NoSuchElementException();
                if (!hasNext()) {
                    return null;
                } else {
                    return first++;
                }
            }

            if (second < first) throw new NoSuchElementException();
            if (!hasNext()) {
                return null;
            } else {
                return second--;
            }
        }

    }

}
