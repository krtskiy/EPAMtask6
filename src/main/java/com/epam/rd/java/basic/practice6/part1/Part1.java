package com.epam.rd.java.basic.practice6.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Part1 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                if ("stop".equals(bf.readLine())) {
                	break;
				}
                sb.append(bf.readLine());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(sb);

    }

}
