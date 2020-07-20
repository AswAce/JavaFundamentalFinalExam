package com.asen.test;

import java.util.Scanner;

public class StringManipulatorGroupTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("Done")) {
            String[] token = command.split("\\s+");
            switch (token[0]) {
                case "Change":
                    String replace = token[1];
                    String replacement = token[2];
                    text = text.replaceAll(replace, replacement);
                    System.out.println(text);
                    break;
                case "Includes":
                    if (text.contains(token[1])) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }


                    break;
                case "End":
                    if (text.endsWith(token[1])) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    text = text.toUpperCase();
                    System.out.println(text);
                    break;
                case "FindIndex":
                    System.out.println(text.indexOf(token[1]));

                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(token[1]);
                    int length = Integer.parseInt(token[2]);
                    text = text.substring(startIndex, startIndex + length );
                    System.out.println(text);

                    break;


            }

            command = scanner.nextLine();
        }
    }
}
