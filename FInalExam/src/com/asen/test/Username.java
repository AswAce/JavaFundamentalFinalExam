package com.asen.test;

import java.util.Scanner;

public class Username {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("Sign up")) {
            String[] token = command.split("\\s+");
            switch (token[0]) {
                case "Case":
                    if (token[1].equals("lower")) {
                        userName = userName.toLowerCase();
                        System.out.println(userName);
                    } else if (token[1].equals("upper")) {
                        userName = userName.toUpperCase();
                        System.out.println(userName);
                    }
                    break;
                case "Reverse":
                    int startIndex = Integer.parseInt(token[1]);
                    int endIndex = Integer.parseInt(token[2]);
                    if (startIndex >= 0 && startIndex < userName.length() && endIndex < userName.length() && endIndex >= 0) {
                        StringBuilder print = new StringBuilder(userName.substring(startIndex, endIndex + 1));
                        System.out.println(print.reverse());

                    }
                    break;
                case "Cut":
                    String string = token[1];
                    if (userName.contains(string)) {
                        userName = userName.replace(string, "");
                        System.out.println(userName);
                    } else {
                        System.out.println(String.format("The word %s doesn't contain %s.", userName, string));
                    }
                    break;
                case "Replace":
                    userName = userName.replace(token[1], "*");
                    System.out.println(userName);
                    break;
                case "Check":
                    String let = token[1];
                    if (userName.contains(let)) {
                        System.out.println("Valid");
                    } else {
                        System.out.println(String.format("Your username must contain %s.", let));
                    }
                    break;


            }


            command = scanner.nextLine();
        }

    }
}
