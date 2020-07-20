package com.asen.test;

import java.util.Scanner;

public class Nikulden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String encrypted = scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("Finish")) {
            String[] token = command.split("\\s+");
            switch (token[0]) {
                case "Replace":
                    char oldChar = token[1].charAt(0);
                    char newChar = token[2].charAt(0);
                    encrypted = encrypted.replace(oldChar, newChar);
                    System.out.println(encrypted);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(token[1]);
                    int endIndex = Integer.parseInt(token[2]);
                    encrypted = cut(encrypted, startIndex, endIndex);
                    break;
                case "Make":
                    encrypted = make(encrypted, token[1]);

                    break;
                case "Check":
                    String contains = token[1];
                    if (encrypted.contains(contains)) {
                        System.out.println(String.format("Message contains %s", contains));
                    } else {
                        System.out.println(String.format("Message doesn't contain %s", contains));
                    }
                    break;
                case "Sum":
                    startIndex = Integer.parseInt(token[1]);
                    endIndex = Integer.parseInt(token[2]);
                    String substring;
                    int sum = 0;
                    if (!isvalidIndex(startIndex, encrypted.length())) {
                        System.out.println("Invalid indexes!"
                        );

                    }
                    if (!isvalidIndex(endIndex, encrypted.length())) {
                        System.out.println("Invalid indexes!");
                    } else if (isvalidIndex(endIndex,encrypted.length())&&isvalidIndex(startIndex,encrypted.length())) {
                        substring = encrypted.substring(startIndex, endIndex+1);
                        for (int i = 0; i < substring.length(); i++) {
                            sum += substring.charAt(i);
                        }
                        System.out.println(sum);

                    }

                    break;

            }


            command = scanner.nextLine();
        }
    }

    private static String make(String encrypted, String s) {
        if (s.equals("Upper"))
            encrypted = encrypted.toUpperCase();
        else if (s.equals("Lower")) {
            encrypted = encrypted.toLowerCase();
        }
        System.out.println(encrypted);
        return encrypted;
    }

    private static String cut(String encrypted, int startIndex, int endIndex) {
        if (!isvalidIndex(startIndex, encrypted.length())) {
            System.out.println("Invalid indexes!");
            return encrypted;
        } else if (!isvalidIndex(endIndex, encrypted.length())) {
            System.out.println("Invalid indexes!");
            return encrypted;
        }
        String toRemove = encrypted.substring(startIndex, endIndex+1);

        String returnStr = encrypted.replaceAll(toRemove, "");
        System.out.println(returnStr);
        return returnStr;
    }

    private static boolean isvalidIndex(int index, int length) {
        if (index < 0 || index >= length) {
            return false;
        } else {
            return true;
        }
    }
}
