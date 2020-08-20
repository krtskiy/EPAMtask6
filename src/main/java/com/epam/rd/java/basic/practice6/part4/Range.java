package com.epam.rd.java.basic.practice6.part4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer> {

    private int first;
    private int last;
    private boolean reverseOrder;

    public Range(int first, int last) {
        this.first = first;
        this.last = last;
    }

    public Range(int first, int last, boolean reversedOrder) {
        this.first = first;
        this.last = last;
        this.reverseOrder = reversedOrder;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IteratorImpl();
    }

    private final class IteratorImpl implements Iterator<Integer> {

        @Override
        public boolean hasNext() {
            return reverseOrder ? last > first - 1 : first < last + 1;
        }

        @Override
        public Integer next() {
            if (!reverseOrder) {
                if (first > last) throw new NoSuchElementException();
                if (!hasNext()) {
                    return null;
                } else {
                    return first++;
                }
            }

            if (first > last) throw new NoSuchElementException();
            if (!hasNext()) {
                return null;
            } else {
                return last--;
            }
        }

    }

}
