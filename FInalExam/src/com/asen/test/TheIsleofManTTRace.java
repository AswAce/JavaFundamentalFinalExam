package com.asen.test;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheIsleofManTTRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("([\"#$%*&])(?<name>[a-zA-z]+)(\\1)=(?<n>[0-9]+)(?<f>[!]{2}[\\S]+)$");
        String nameRacer = scanner.nextLine();
        boolean flag = false;
        while (!flag) {
            Matcher matcher = pattern.matcher(nameRacer);
            if (matcher.find()) {
                int size = Integer.parseInt(matcher.group("n"));
                String code = matcher.group("f");
                if (size + 2 != code.length()) {
                    System.out.println("Nothing found!");
                } else {
                    String cordinates = decruption(size, code);

                    System.out.println(String.format("Coordinates found! %s -> %s",
                            matcher.group("name"), cordinates));
                    flag = true;
                    break;
                }

            } else {
                System.out.println("Nothing found!");
            }
            nameRacer = scanner.nextLine();
        }

    }

    private static String decruption(int size, String code) {
        StringBuilder finalCode = new StringBuilder();
        for (int i = 2; i < code.length(); i++) {
            int current = code.charAt(i);
            char newChar = (char) (current + size);
            finalCode.append(newChar);
        }
        return finalCode.toString();
    }
}
