package com.epam.rd.java.basic.practice6.part1;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Part1 {

    private static final InputStream SYS_IN = System.in;

    public static void main(String[] args) {
        // set the mock input

        System.setIn(new ByteArrayInputStream(
                "kek 420 keklul kek 322^420 kek ^kappa keklul 69 stop kek^stop"
                        .replace("^", System.lineSeparator()).getBytes(StandardCharsets.UTF_8)));

        WordContainer.main(args);

        // restore the mock input

        System.setIn(SYS_IN);
    }

}
