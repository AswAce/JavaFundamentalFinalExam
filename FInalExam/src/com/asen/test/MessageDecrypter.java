package com.asen.test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecrypter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("\\B([$%]?)(?<tag>[A-Z][a-z]{2,})(\\1): \\[(?<z>[0-9]+)\\]\\|\\[(?<x>[0-9]+)\\]\\|\\[(?<c>[0-9]+)\\]\\|\\B");
        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            Matcher matcher = pattern.matcher(text);
            int count = 0;
            boolean flag = true;
            for (int j = 0; j < text.length(); j++) {
                char current = text.charAt(j);
                if (current == '|') {
                    count++;
                }

            }
            if (count > 3) {
                System.out.println("Valid message not found!");
                flag = false;
            }
            if (matcher.find() && count == 3) {
                String tag = matcher.group("tag");
                char first = (char) Integer.parseInt(matcher.group("z"));
                char second = (char) Integer.parseInt(matcher.group("x"));
                char third = (char) Integer.parseInt(matcher.group("c"));

                System.out.println(String.format("%s: %s%s%s", tag, first, second, third));

            } else if (flag) {
                System.out.println("Valid message not found!");
            }


        }
    }
}
