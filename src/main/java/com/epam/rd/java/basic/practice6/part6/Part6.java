package com.epam.rd.java.basic.practice6.part6;

public class Part6 {

    public static void main(String[] args) { //NOSONAR
        String filePath = "";
        for (int i = 0; i < args.length; i++) {

            if (args[i].equals("-i") || args[i].equals("--input")) {
                filePath = args[i + 1];
            }

            if (args[i].equals("-t") || args[i].equals("--task")) {
                switch (args[i + 1]) {
                    case "frequency":
                        Part61.frequencyTask(filePath);
                        break;
                    case "length":
                        Part62.lengthTask(filePath);
                        break;
                    case "duplicates":
                        Part63.duplicatesTask(filePath);
                        break;
                    default:
                        break;
                }
            }

        }

    }


}
