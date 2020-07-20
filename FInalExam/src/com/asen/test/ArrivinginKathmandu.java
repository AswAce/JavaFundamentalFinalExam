package com.asen.test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrivinginKathmandu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("^(?<peakName>[0-9a-zA-Z!?@?#?$?\\??]+)=(?<n>[0-9]+)<<(?<code>[\\S]+)$");
        while (!text.equals("Last note")) {
            Matcher matcher = pattern.matcher(text);

            if (matcher.find()) {
                String name = matcher.group("peakName");
                StringBuilder peak = new StringBuilder();
                for (int i = 0; i < name.length(); i++) {
                    char current = name.charAt(i);
                    if (Character.isLetterOrDigit(current)) {
                        peak.append(current);
                    }
                }
                int size = Integer.parseInt(matcher.group("n"));
                String coordinates = matcher.group("code");

                if (size == coordinates.length()) {
                    System.out.println(String.format("Coordinates found! %s -> %s", peak.toString(), coordinates));
                } else {
                    System.out.println("Nothing found!");
                }
            } else {
                System.out.println("Nothing found!");
            }

            text = scanner.nextLine();
        }
    }
}
