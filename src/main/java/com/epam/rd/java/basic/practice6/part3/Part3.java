package com.epam.rd.java.basic.practice6.part3;

public class Part3 {
    
    public static void main(String[] args) {
        Parking parkingFor4 = new Parking(4);

        parkingFor4.arrive(2);
        parkingFor4.arrive(0);
        parkingFor4.arrive();
        parkingFor4.depart(2);

        parkingFor4.print();

        
    }

}
