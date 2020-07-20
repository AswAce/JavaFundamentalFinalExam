package com.asen.test;

import java.util.Scanner;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Complete")) {
            String[] token = command.split("\\s+");
            switch (token[0]) {
                case "Make":
                    if (token[1].equals("Upper")) {
                        email = email.toUpperCase();
                        System.out.println(email);

                    } else if (token[1].equals("Lower")) {
                        email = email.toLowerCase();
                        System.out.println(email);
                    }
                    break;
                case "GetDomain":
                    int countLastChars = Integer.parseInt(token[1]);
                    System.out.println(email.substring(email.length() - countLastChars));

                    break;
                case "GetUsername":
                    if (!email.contains("@")) {
                        System.out.println(String.format("The email %s doesn't contain the @ symbol.", email));
                    } else if (email.contains("@")) {
                        System.out.println(email.substring(0, email.indexOf('@')));

                    }
                    break;
                case "Replace":
                    String replacement = token[1];
                    email = email.replaceAll(replacement, "-");
                    System.out.println(email);
                    break;
                case "Encrypt":
                    for (int i = 0; i < email.length() - 1; i++) {
                        int currrent = email.charAt(i);
                        System.out.print(currrent + " ");
                    }
                    System.out.print((int) email.charAt(email.length() - 1));
                    System.out.println();
                    break;


            }
            command = scanner.nextLine();
        }
    }
}
