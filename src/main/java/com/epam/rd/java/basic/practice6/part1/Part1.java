package com.epam.rd.java.basic.practice6.part1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Part1 {

    public static final InputStream SYS_IN = System.in;

    public static void main(String[] args) throws IOException {
//        // set the mock input
//
//        System.setIn(new ByteArrayInputStream(
//                "asd 43 asdf asd 43^434 asdf^kasdf asdf stop asdf^stop"
//                        .replace("^", System.lineSeparator()).getBytes(StandardCharsets.UTF_8)));
//
//        WordContainer.main(args);
//
//        // restore the mock input
//
//        System.setIn(SYS_IN);

        WordContainer.main(null);
    }

}
