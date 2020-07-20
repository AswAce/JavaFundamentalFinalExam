package com.asen.test;

import java.util.Arrays;
import java.util.Scanner;

public class StringManipulatorGroup1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("End")) {

            String[] token = command.split("\\s+");
            switch (token[0]) {
                case "Translate":
                    char charToRemove = token[1].charAt(0);
                    char newChar = token[2].charAt(0);
                    text = text.replace(charToRemove, newChar);
                    System.out.println(text);
                    break;
                case "Includes":
                    String includes = token[1];
                    if (text.contains(includes)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Start":
                    String start = token[1];
                    if (text.startsWith(start)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Lowercase":
                    text = text.toLowerCase();
                    System.out.println(text);
                    break;
                case "FindIndex":
                    char charIndex = token[1].charAt(0);
                    System.out.println(text.lastIndexOf(charIndex));

                    break;
                case "Remove":
                    int startIndex = Integer.parseInt(token[1]);
                    int count = Integer.parseInt(token[2]);
                    String toRemove = text.substring(startIndex, startIndex + count);
                    text = text.replaceAll(toRemove, "");
                    System.out.println(text);

            }
            command = scanner.nextLine();
        }
    }
}
