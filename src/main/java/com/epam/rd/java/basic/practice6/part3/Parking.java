package com.epam.rd.java.basic.practice6.part3;

public class Parking {
    private int capacity;
    private int numberOfCars;
    private StringBuilder stateOfParking;

    public Parking(int capacity) {
        this.capacity = capacity;
        stateOfParking = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            this.stateOfParking.append("0");
        }
    }

    public boolean arrive(int k) {
        if (k > capacity) {
            throw new IllegalArgumentException("Wrong argument!");
        } else if (numberOfCars == capacity) {
            return false;
        } else {
            for ( ; k <= capacity; k++) {
                if (k >= capacity) {
                    k = 0;
                }
                if (stateOfParking.charAt(k) == '0') {
                    stateOfParking.setCharAt(k, '1');
                    numberOfCars++;
                    return true;
                }
            }
            return false;
        }
    }

    public boolean arrive() {
        if (numberOfCars < capacity) {
            this.arrive(0);
            return true;
        } else {
            return false;
        }
    }

    public boolean depart(int k) {
        if (k > capacity) {
            throw new IllegalArgumentException("Wrong argument!");
        } else if (numberOfCars == 0) {
            return false;
        } else {
            if (stateOfParking.charAt(k) == '1') {
                stateOfParking.setCharAt(k, '0');
                numberOfCars--;
                return true;
            }
            return false;
        }
    }

    public boolean depart() {
        if (numberOfCars > 0) {
            this.depart(0);
            return true;
        } else {
            return false;
        }
    }

    public void print() {
        System.out.println(stateOfParking);
    }
}
